<?php

namespace App\Http\Controllers;
use App\Services\RoomSelectionService;
use Illuminate\Http\RedirectResponse;
use Illuminate\Http\Request;
use App\Models\Room;
use Carbon\Carbon;
use App\Http\Controllers\PriceController;

class RoomController extends Controller
{
    public function index(Request $request)
    {

        $startDateRaw = $request->query('start_date') ?? Carbon::now()->addDays(1)->format('d/m/Y');
        $endDateRaw = $request->query('end_date') ?? Carbon::now()->addDays(8)->format('d/m/Y');

        $startDate = Carbon::createFromFormat('d/m/Y', $startDateRaw)->toDateString();
        $endDate = Carbon::createFromFormat('d/m/Y', $endDateRaw)->toDateString();

        $capacity = ($request->query('adults') ?? 2) + ($request->query('children') ?? 0);

        $rooms = Room::select('room_number', 'capacity', 'view', 'babybed', 'for_disabled', 'price_cents', 'room_type_id')
            ->with(['booking', 'type', 'bedTypes' => function ($query) {
                $query->withPivot('bed_type_id', 'amount');
            }])
            ->when($startDate && $endDate, function ($query) use ($startDate, $endDate) {
                $query->whereDoesntHave('booking', function ($q) use ($startDate, $endDate) {
                    $q->where(function ($q2) use ($startDate, $endDate) {
                        $q2->where('start_date', '<', $endDate)
                        ->where('end_date', '>', $startDate);
                    });
                });
            })
            ->when($capacity, function ($query) use ($capacity) {
                $query->where('capacity', '>=', $capacity);
            })
            ->when($request->filled('room_type') && $request->room_type != 0, function ($query) use ($request) {
                $query->where('room_type_id', $request->room_type);
            })
            ->when($request->filled('view') && $request->view != '0', function ($query) use ($request) {
                $query->where('view', $request->view);
            })
            ->when($request->single || $request->double, function ($query) use ($request) {
                $query->whereHas('bedTypes', function ($q) use ($request) {
                    $single = $request->query('single') === 'true';
                    $double = $request->query('double') === 'true';

                    if ($single && $double) {
                        $q->where(function($subquery) {
                            $subquery->where('bed_type_id', 1)
                                ->orWhere('bed_type_id', 2);
                        })
                        ->havingRaw('COUNT(DISTINCT bed_type_id) = 2');
                    }
                    else if ($single) {
                        $q->Where('bed_type_id', 1);
                    }
                    else if ($double) {
                        $q->Where('bed_type_id', 2);
                    }
                });
            })
            ->when(!is_null($request->accessible), function ($query) use ($request) {
                if (filter_var($request->accessible, FILTER_VALIDATE_BOOLEAN)) {
                    $query->where('for_disabled', 1);
                }
            })
            ->when($request->query('toddlers') > 0, function ($query) {
                $query->where('babybed', 1);
            })
            ->get();

        $uniqueRooms = [];

        foreach ($rooms as $room) {
            $room->price_cents = number_format($room->price_cents / 100, 2);
            foreach ($room->bedTypes as $bedType) {
                $bedType->amount = $bedType->pivot->amount;
            }
            if (!$this->isRoomDuplicate($room, $uniqueRooms)) {
                $uniqueRooms[] = $room;
            }
        }

        $startFormatted = Carbon::createFromFormat('d/m/Y', $startDateRaw)->format('d/m/Y');
        $endFormatted = Carbon::createFromFormat('d/m/Y', $endDateRaw)->format('d/m/Y');

        return view('roomsoverview', [
            'rooms' => $uniqueRooms,
            'start_date' => $startFormatted,
            'end_date' => $endFormatted,
            'adults' => $request->query('adults') ?? 2,
            'children' => $request->query('children') ?? 0,
            'toddlers' => $request->query('toddlers') ?? 0,
        ]);
    }

    private function isRoomDuplicate($room, $uniqueRooms)
    {
        foreach ($uniqueRooms as $uniqueRoom) {
            if (
                $room->capacity == $uniqueRoom->capacity &&
                $room->view == $uniqueRoom->view &&
                $room->babybed == $uniqueRoom->babybed &&
                $room->for_disabled == $uniqueRoom->for_disabled &&
                $room->price_cents == $uniqueRoom->price_cents &&
                $room->room_type_id == $uniqueRoom->room_type_id &&
                $this->areBedTypesEqual($room->bedTypes, $uniqueRoom->bedTypes)
            ) {
                return true;
            }
        }
        return false;
    }

    private function areBedTypesEqual($bedTypes1, $bedTypes2)
    {
        if (count($bedTypes1) != count($bedTypes2)) {
            return false;
        }

        foreach ($bedTypes1 as $bedType1) {
            $foundMatch = false;
            foreach ($bedTypes2 as $bedType2) {
                if ($bedType1->id == $bedType2->id && $bedType1->pivot->amount == $bedType2->pivot->amount) {
                    $foundMatch = true;
                    break;
                }
            }
            if (!$foundMatch) {
                return false;
            }
        }
        return true;
    }

    public function show(Request $request)
    {
        $startDate = $request->query('start_date', null);
        $endDate = $request->query('end_date', null);
        $room = (new RoomSelectionService())->findRoomByCriteria($request);
        $room->price_cents = number_format($room->price_cents / 100, 2);
        $priceController = new PriceController();
        $duration = Carbon::createFromFormat('d/m/Y', $startDate)->diffInDays(Carbon::createFromFormat('d/m/Y', $endDate));
        $adults = $request->query('adults', 2);
        $children = $request->query('children', 0);
        $priceData = $priceController->calculatePrices($room->price_cents, $duration, $adults, $children);
        return view('detail', [
            'room' => $room,
            'start_date' => Carbon::createFromFormat('d/m/Y', $startDate)->format('d F Y'),
            'end_date' => Carbon::createFromFormat('d/m/Y', $endDate)->format('d F Y'),
            'duration' => $duration,
            'adults' => $request->adults ?? 2,
            'children' => $request->children ?? 0,
            'toddlers' => $request->toddlers ?? 0,
        ], $priceData);
    }

    public function initiateBooking(Request $request): RedirectResponse
    {
        return redirect()->route('booking.create', $request->all());
    }

    public function getAllRoom()
    {
        $roomNumbers = Room::select('room_number')->orderBy('room_number')->get();
        return view('management.room-edit', ['roomNumbers' => $roomNumbers]);
    }

    public function getRoomData($room_number)
    {
        $room = Room::select('room_number', 'capacity', 'view', 'babybed', 'for_disabled', 'price_cents', 'room_type_id', 'comments')
            ->with([
                'booking' => function ($query) {
                    $query->select('room_number', 'total_cost_paid_cents')
                          ->latest(); // Get the most recent booking
                },
                'type',
                'bedTypes' => function ($query) {
                    $query->withPivot('bed_type_id', 'amount');
                }
            ])
            ->where('room_number', $room_number)
            ->first();

        if (!$room) {
            return response()->json([
                'success' => false,
                'message' => 'Room not found'
            ], 404);
        }

        return response()->json([
            'success' => true,
            'room' => $room
        ]);
    }

    public function updateRoom(Request $request, $room_number)
    {
        // Validate the request
        $request->validate([
            'price' => 'nullable|numeric|min:0',
            'comments' => 'nullable|string|max:1000',
        ]);

        try {
            $room = Room::with(['booking', 'type', 'bedTypes' => function ($query) {
                $query->withPivot('bed_type_id', 'amount');
            }])->where('room_number', $room_number)->first();

            if (!$room) {
                return response()->json([
                    'success' => false,
                    'message' => 'Room not found'
                ], 404);
            }

            // Update only the fields that are provided
            if ($request->has('capacity')) {
                $room->capacity = $request->capacity;
            }
            if ($request->has('view')) {
                $room->view = $request->view;
            }
            if ($request->has('babybed')) {
                $room->babybed = $request->boolean('babybed');
            }
            if ($request->has('for_disabled')) {
                $room->for_disabled = $request->boolean('for_disabled');
            }
            if ($request->has('price')) {
                $priceInput = $request->price;
                $priceCents = $priceInput * 100;
                \Log::info('Price debugging', [
                    'original_price' => $priceInput,
                    'price_cents' => $priceCents,
                    'price_type' => gettype($priceInput)
                ]);
                $room->price_cents = $priceCents; // Convert euros to cents
            }
            if ($request->has('room_type_id')) {
                $room->room_type_id = $request->room_type_id;
            }
            if ($request->has('comments')) {
                $room->comments = $request->comments;
            }

            if ($request->has('bed_types')) {
                $room->bedTypes()->detach();
                $room->bedTypes()->attach($request->bed_types);
            }


            $room->save();

            // Reload the room with fresh data
            $updatedRoom = $room->fresh()->load(['type', 'bedTypes' => function ($query) {
                $query->withPivot('bed_type_id', 'amount');
            }]);

            return response()->json([
                'success' => true,
                'message' => 'Room updated successfully',
                'room' => $updatedRoom
            ]);

        } catch (\Exception $e) {
            return response()->json([
                'success' => false,
                'message' => 'Error updating room: ' . $e->getMessage()
            ], 500);
        }
    }

    //TODO Add validation for requests.
}
