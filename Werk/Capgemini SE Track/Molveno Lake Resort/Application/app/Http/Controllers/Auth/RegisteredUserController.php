<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use App\Models\User;
use App\Models\Room;
use App\Models\RegisteredUser;
use Illuminate\Auth\Events\Registered;
use Illuminate\Http\RedirectResponse;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;
use Illuminate\Validation\Rules;
use Carbon\Carbon;
use Illuminate\View\View;

class RegisteredUserController extends Controller
{
    /**
     * Display the registration view.
     */
    public function create(): View
    {
        return view('auth.register');
    }

    /**
     * Handle an incoming registration request.
     *
     * @throws \Illuminate\Validation\ValidationException
     */
    public function store(Request $request): RedirectResponse
    {
        $request->validate([
            'name' => ['required', 'string', 'max:255'],
            'email' => ['required', 'string', 'lowercase', 'email', 'max:255', 'unique:'.User::class],
            'password' => ['required', 'confirmed', Rules\Password::defaults()],
            'country_code' => ['required', 'string'],
            'phone_number' => ['required', 'string', 'regex:/^[0-9]{7,15}$/'],
            'date_of_birth' => [
                'required',
                'date',
                'before_or_equal:' . date('Y-m-d', strtotime('-18 years')),
            ],
            'street' => ['required', 'string', 'max:255'],
            'postal_code' => ['required', 'string', 'max:20'],
            'city' => ['required', 'string', 'max:100'],
            'country' => ['required', 'string', 'max:100'],
        ]);

        // Format the full address
        $address = $request->street . ', ' . $request->postal_code . ', ' . $request->city . ', ' . $request->country;
        
        // Format the full phone number with country code
        $phoneNumber = $request->country_code . $request->phone_number;

        $user = User::create([
            'email' => $request->email,
            'password' => Hash::make($request->password),
            'type_id' => 5, // Assuming 5 is the id for a guest user
        ]);

        $registeredUser = RegisteredUser::create([
            'user_account_id' => $user->id,
            'name' => $request->name,
            'date_of_birth' => $request->date_of_birth,
            'phone_number' => $phoneNumber,
            'address' => $address,
            'temp_account' => 0,
        ]);

        event(new Registered($user));

        Auth::login($user);

        $redirectTo = $request->input('redirect_to');
        if ($redirectTo && str_starts_with($redirectTo, url('/'))) {
            // Check if this is a booking redirect from detail page
            if (str_contains($redirectTo, '/detail') && str_contains($redirectTo, 'start_date')) {
                // Add a parameter to auto-trigger the booking modal
                $separator = str_contains($redirectTo, '?') ? '&' : '?';
                return redirect()->to($redirectTo . $separator . 'auto_book=1');
            }
            return redirect()->to($redirectTo);
        }
        return redirect(route('dashboard', absolute: false));
    }

    public function storeTempAccount(Request $request): RedirectResponse
    {
        $request->validate([
            'name' => ['required', 'string', 'max:100'],
            'date_of_birth' => [
                'required',
                'date',
                'before_or_equal:' . date('Y-m-d', strtotime('-18 years')),
            ],
            'email' => ['required', 'string', 'lowercase', 'email', 'max:255', 'unique:'.User::class],
            'country_code' => ['required', 'string'],
            'phone_number' => ['required', 'string', 'regex:/^[0-9]{7,15}$/'],
            'street' => ['required', 'string', 'max:255'],
            'postal_code' => ['required', 'string', 'max:20'],
            'city' => ['required', 'string', 'max:100'],
            'country' => ['required', 'string', 'max:100'],
        ]);
        
        // Format the full address
        $address = $request->street . ', ' . $request->postal_code . ', ' . $request->city . ', ' . $request->country;
        
        // Format the full phone number with country code
        $phoneNumber = $request->country_code . $request->phone_number;

        $room = $this->getRoom($request);
        if (!$room) {
            $start = now()->addDays(1)->format('d/m/Y');
            $end = now()->addDays(8)->format('d/m/Y');
            return redirect()->route('room.index', [
                'start_date' => $start, 
                'end_date' => $end
            ])->with('error', __('The selected room is no longer available, please choose another one.'));
        }

        $user = User::create([
            'email' => $request->email,
            'password' => null,
        ]);

        $registeredUser = RegisteredUser::create([
            'user_account_id' => $user->id,
            'name' => $request->name,
            'date_of_birth' => $request->date_of_birth,
            'phone_number' => $phoneNumber,
            'address' => $address,
            'temp_account' => true,
            'scheduled_deletion' => now()->addDays(14),
        ]);

        // After creating the temporary user, forward booking details to RoomController
        return redirect()->route('room.initiateBooking', [
            'user' => $user->id,
            'start_date' => $request->start_date,
            'end_date' => $request->end_date,
            'adults' => $request->adults ?? 2,
            'children' => $request->children ?? 0,
            'toddlers' => $request->toddlers ?? 0,
            'includes_breakfast' => $request->includes_breakfast ?? false,
            'view' => $request->view,
            'capacity' => $request->capacity,
            'babybed' => $request->babybed,
            'for_disabled' => $request->for_disabled,
            'price' => $request->price,
            'payment_option' => $request->payment_option, 
            ...array_filter($request->all(), fn($key) => strpos($key, 'bed_type_') === 0, ARRAY_FILTER_USE_KEY),
        ]);
    }

    private function getRoom(Request $request): ?Room
    {
        $request->validate([
            'view' => ['required', 'string', 'in:Standard,Lake,Mountain'],
            'capacity' => ['required', 'numeric', 'in:2,4'],
            'babybed' => ['required', 'boolean'],
            'for_disabled' => ['required', 'boolean'],
            'price' => ['required', 'numeric'],
        ]);

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

        return $roomQuery->first();
    }
}
