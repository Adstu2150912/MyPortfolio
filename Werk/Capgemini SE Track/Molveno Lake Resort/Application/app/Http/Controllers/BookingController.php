<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Http\RedirectResponse;
use Illuminate\Support\Facades\DB;
use App\Models\Room;
use App\Models\Booking;
use App\Models\RegisteredUser;
use App\Models\User;
use Carbon\Carbon;
use Illuminate\Support\Facades\Auth;
use App\Http\Controllers\PriceController;

class BookingController extends Controller
{
    public function create(Request $request): RedirectResponse
    {
        try {
            // Prepare validation rule
            $validated = $request->validate([
                'user' => 'required|exists:registered_users,user_account_id',
                'view' => ['required', 'string', 'in:Standard,Lake,Mountain'],
                'capacity' => ['required', 'numeric', 'in:2,4'],
                'babybed' => ['required', 'boolean'],
                'for_disabled' => ['required', 'boolean'],
                'price' => ['required', 'numeric'],
                'includes_breakfast' => ['required', 'boolean'],
                'start_date' => 'required|date_format:d/m/Y',
                'end_date' => 'required|date_format:d/m/Y|after:start_date',
                'adults' => 'required|integer|min:1',
                'children' => 'nullable|integer|min:0',
                'toddlers' => 'nullable|integer|min:0',
                'has_disability' => 'boolean',
                'payment_option' => ['required', 'string', 'in:now,hotel'],
            ]);

        } catch (\Illuminate\Validation\ValidationException $e) {
            $start = now()->addDays(1)->format('d/m/Y');
            $end = now()->addDays(8)->format('d/m/Y');

            // Log the validation errors for debugging
            \Log::error('Booking validation error: ' . json_encode($e->errors()));

            // Check if payment_option is missing
            if (isset($e->errors()['payment_option'])) {
                // If the request is coming from the guest form via RegisteredUserController
                if ($request->has('name') && $request->has('email')) {
                    // Set a default payment option if it's missing
                    $request->merge(['payment_option' => 'now']);
                    // Try again with the updated request
                    return $this->create($request);
                }
            }


            return redirect()->route('room.index', [
                'start_date' => $start,
                'end_date'   => $end
            ])->with('error', [
                'title'  => __('There was an issue with your booking information. Please try again.'),
                'number' => null
            ]);
        }

        $room = $this->getRoom($request);
        if (!$room) {
            $tempUser = \App\Models\RegisteredUser::where('user_account_id', $validated['user'])->first();
            if ($tempUser && $tempUser->temp_account) {
                $hasBookings = \App\Models\Booking::where('main_guest_id', $validated['user'])->exists();
                if (!$hasBookings) {
                    \App\Models\User::where('id', $validated['user'])->delete();
                    $tempUser->delete();
                }
            }
            $start = now()->addDays(1)->format('d/m/Y');
            $end = now()->addDays(8)->format('d/m/Y');
            return redirect()->route('room.index', [
                'start_date' => $start,
                'end_date'   => $end
            ])->with('error', [
                'title'  => __('The selected room is no longer available, please choose another one.'),
                'number' => null
            ]);
        }
        $totalGroupSize = $validated['adults'] + ($validated['children'] ?? 0) + ($validated['toddlers'] ?? 0);
        try {
            // Calculate the total price
            $duration = Carbon::createFromFormat('d/m/Y', $validated['start_date'])
                ->diffInDays(Carbon::createFromFormat('d/m/Y', $validated['end_date']));
            $roomPriceCents = $validated['price'];
            $roomPrice = $roomPriceCents / 100; // Convert to decimal for price controller

            $priceController = new PriceController();
            $priceData = $priceController->calculatePrices(
                $roomPrice,
                $duration,
                $validated['adults'],
                $validated['children'] ?? 0
            );

            $includesBreakfast = (bool)($validated['includes_breakfast'] ?? false);
            $totalCostCents = $includesBreakfast ? $priceData['totalPrice'] : ($roomPriceCents * $duration);

            $paidAmount = ($validated['payment_option'] === 'now') ? $totalCostCents : 0;

            $booking = DB::transaction(function () use ($validated, $room, $totalCostCents, $paidAmount) {
                return Booking::create([
                    'room_number'          => $room->room_number,
                    'main_guest_id'        => $validated['user'],
                    'total_group_size'     => $validated['adults'] + ($validated['children'] ?? 0) + ($validated['toddlers'] ?? 0),
                    'children_below_10'    => $validated['children'] ?? 0,
                    'children_below_4'     => $validated['toddlers'] ?? 0,
                    'start_date'           => Carbon::createFromFormat('d/m/Y', $validated['start_date']),
                    'end_date'             => Carbon::createFromFormat('d/m/Y', $validated['end_date']),
                    'total_cost_cents'     => $totalCostCents,
                    'total_cost_paid_cents'=> $paidAmount,
                    'includes_breakfast'   => $validated['includes_breakfast'] ?? false,
                    'has_disability'       => isset($validated['has_disability']) ? (bool)$validated['has_disability'] : false,
                ]);
            });
        } catch (\Exception $e) {
            return redirect()
                ->route('room.index')
                ->with('error', [
                    'title'   => __('Failed to create booking'),
                    'number'  => null
                ]);
        }

        return redirect()
            ->route('home')
            ->with('success', [
                'title'   => __('Your booking has been placed!'),
                'number'  => $booking->booking_number
            ]);
    }

    private function getRoom(Request $request): ?Room
    {
        $roomQuery = Room::where('view', $request->view)
            ->where('capacity', $request->capacity)
            ->where('babybed', $request->babybed)
            ->where('for_disabled', $request->for_disabled)
            ->where('price_cents', $request->price);

        $bedTypeInputs = array_filter($request->all(), function ($key) {
            return strpos($key, 'bed_type_') === 0;
        }, ARRAY_FILTER_USE_KEY);

        foreach ($bedTypeInputs as $key => $value) {
            $bedTypeId = substr($key, strlen('bed_type_'));
            if (is_numeric($bedTypeId)) {
                $roomQuery->whereHas('bedTypes', function ($q) use ($bedTypeId, $value) {
                    $q->where('bed_types.id', $bedTypeId)
                      ->where('bed_type_room.amount', $value);
                });
            }
        }

        if ($request->start_date && $request->end_date) {
            $startDate = Carbon::createFromFormat('d/m/Y', $request->start_date)->toDateString();
            $endDate = Carbon::createFromFormat('d/m/Y', $request->end_date)->toDateString();

            $roomQuery->whereDoesntHave('booking', function ($q) use ($startDate, $endDate) {
                $q->where(function ($q2) use ($startDate, $endDate) {
                    $q2->where('start_date', '<', $endDate)
                       ->where('end_date', '>', $startDate);
                });
            });
        }
        return $roomQuery->first();
    }


    /**
     * Display a listing of the authenticated guest's active bookings.
     */
    public function index()
    {
        $userId = Auth::id();

        $bookings = Booking::where('main_guest_id', $userId)
            ->whereDate('end_date', '>=', now())
            ->orderBy('start_date')
            ->with('room')
            ->get();

        $roomNumbers = $bookings->pluck('room_number')->unique()->toArray();

        $rooms = Room::with(['booking', 'type', 'bedTypes' => function ($query) {
                $query->withPivot('bed_type_id', 'amount');
            }])
            ->whereIn('room_number', $roomNumbers)
            ->get();

        foreach ($bookings as $booking) {
            $booking->formatted_start_date = Carbon::parse($booking->start_date)->format('d/m/Y');
            $booking->formatted_end_date = Carbon::parse($booking->end_date)->format('d/m/Y');
        }

        $roomsLookup = [];
        foreach ($rooms as $room) {
            $roomsLookup[$room->room_number] = $this->prepareRoomParameters($room);
        }

        return view('dashboard', compact('bookings', 'rooms', 'roomsLookup'));
    }

    /**
     * Prepare room parameters for links in the view
     */
    private function prepareRoomParameters(Room $room)
    {
        $params = [
            'type' => $room->type->id,
            'view' => $room->view,
            'capacity' => $room->capacity,
            'babybed' => $room->babybed,
            'for_disabled' => $room->for_disabled,
            'price' => preg_replace('/[^\d]/', '', $room->price_cents)
        ];

        // Add bed type parameters
        foreach ($room->bedTypes as $bedType) {
            $params['bed_type_' . $bedType->id] = $bedType->pivot->amount;
        }

        return $params;
    }
}
