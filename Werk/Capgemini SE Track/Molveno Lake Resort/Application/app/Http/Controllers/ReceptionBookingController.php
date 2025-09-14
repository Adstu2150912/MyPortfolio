<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Booking;
use App\Models\Room;
use App\Models\RegisteredUser;
use Illuminate\Support\Str;
use Carbon\Carbon;
use App\Http\Controllers\PriceController;
use App\Models\User;

class ReceptionBookingController extends Controller
{
    /**
     * Display a listing of the reservations.
     */
    public function index()
    {
        $bookings = Booking::with(['registeredGuest', 'room.status'])
            ->get()
            // First sort by checked-out status (0 for normal, 1 for checked out to put them at the end)
            ->sort(function ($a, $b) {
                $aIsCheckedOut = $a->room && $a->room->status && $a->room->status->status === 'Checked Out' ? 1 : 0;
                $bIsCheckedOut = $b->room && $b->room->status && $b->room->status->status === 'Checked Out' ? 1 : 0;
                
                if ($aIsCheckedOut !== $bIsCheckedOut) {
                    return $aIsCheckedOut <=> $bIsCheckedOut;
                }
                
                // When check-out status is the same, sort by start date
                $aDate = \Carbon\Carbon::parse($a->start_date);
                $bDate = \Carbon\Carbon::parse($b->start_date);
                return $aDate <=> $bDate;
            });
        
        return view('reception.reservations', compact('bookings'));
    }

    /**
     * Show the form for creating a new booking.
     */
    public function create(Request $request)
    {
        // Check if any filters are applied
        $filtersApplied = $request->has('start_date') || $request->has('end_date') || 
                         $request->has('adults') || $request->has('children') || 
                         $request->has('toddlers') || $request->has('room_type') || 
                         $request->has('view') || $request->has('single') || 
                         $request->has('double') || $request->has('accessible');
        
        // Get current date for default values or use request parameters
        $startDateRaw = $request->query('start_date') ?? now()->addDay()->format('d/m/Y');
        $endDateRaw = $request->query('end_date') ?? now()->addDays(8)->format('d/m/Y');
        
        // Only parse dates if they're provided in the request
        $startDate = null;
        $endDate = null;
        
        if ($request->has('start_date') && $request->has('end_date')) {
            $startDate = Carbon::createFromFormat('d/m/Y', $startDateRaw)->toDateString();
            $endDate = Carbon::createFromFormat('d/m/Y', $endDateRaw)->toDateString();
        }
        
        // Default guest counts
        $adults = $request->query('adults') ?? 1;
        $childrenBelow10 = $request->query('children') ?? 0;
        $childrenBelow4 = $request->query('toddlers') ?? 0;
        
        // Calculate total capacity needed
        $capacity = $filtersApplied ? ($adults + $childrenBelow10) : null;
        
        // Get filtered rooms or all rooms if no filters applied
        $rooms = $this->getFilteredRooms($request, $startDate, $endDate, $capacity, $childrenBelow4 > 0);
        $guests = RegisteredUser::all();
        
        // Format dates for display
        $startFormatted = Carbon::createFromFormat('d/m/Y', $startDateRaw)->format('d/m/Y');
        $endFormatted = Carbon::createFromFormat('d/m/Y', $endDateRaw)->format('d/m/Y');
        
        // This is important to prevent validation errors when only filtering
        // The filter form will be submitted via GET and doesn't need the guest fields
        $isFilterOnly = $request->isMethod('GET');
        
        return view('reception.booking', [
            'rooms' => $rooms,
            'guests' => $guests,
            'start_date' => $startFormatted,
            'end_date' => $endFormatted,
            'adults' => $adults,
            'children' => $childrenBelow10,
            'toddlers' => $childrenBelow4,
            'isEditing' => false,
            'isFilterOnly' => $isFilterOnly
        ]);
    }

    /**
     * Store a newly created booking in storage.
     */
    public function store(Request $request)
    {
        $request->validate([
            'room_number' => 'required',
            'start_date' => 'required|date_format:d/m/Y',
            'end_date' => 'required|date_format:d/m/Y|after:start_date',
            'adults' => 'required|integer|min:1',
            'children_below_10' => 'nullable|integer|min:0',
            'children_below_4' => 'nullable|integer|min:0',
            'total_cost_cents' => 'required|integer|min:0',
        ]);

        // Handle main guest (either selected or created)
        $guestOption = $request->input('guest_option', 'existing');
        $mainGuestId = $request->main_guest_id;
        
        if ($guestOption === 'new') {
             // Create a new guest
             $request->validate([
                 'firstname' => 'required|string|max:50',
                 'lastname' => 'required|string|max:50',
                 'email' => 'required|email|max:255',
                 'date_of_birth' => 'required|date_format:d/m/Y',
                 'phone' => 'required|string|max:20',
                 'address' => 'required|string|max:255',
             ]);
             
             // Use fullname if provided, otherwise combine firstname and lastname
             $guestName = $request->fullname ?: ($request->firstname . ' ' . $request->lastname);
             
             // Ensure a backing user exists for foreign key
             $user = User::firstOrCreate(
                 ['email' => $request->email],
                 ['password' => null]
             );
             
             $dob = Carbon::createFromFormat('d/m/Y', $request->date_of_birth)->toDateString();
             
             $newGuest = RegisteredUser::create([
                 'user_account_id' => $user->id,
                 'name' => $guestName,
                 'date_of_birth' => $dob,
                 'phone_number' => $request->phone,
                 'address' => $request->address,
                 'temp_account' => true,
                 'scheduled_deletion' => null,
             ]);
             
             $mainGuestId = $newGuest->user_account_id;
        } else {
            // Existing guest must be selected
            $request->validate([
                'main_guest_id' => 'required|exists:registered_users,user_account_id',
            ]);
        }
        
        // Calculate total group size
        $totalGroupSize = $request->adults + 
                          ($request->children_below_10 ?? 0) + 
                          ($request->children_below_4 ?? 0);
        
        // Parse dates from d/m/Y to proper DateTime
        $start = Carbon::createFromFormat('d/m/Y', $request->start_date)->startOfDay();
        $end = Carbon::createFromFormat('d/m/Y', $request->end_date)->endOfDay();
        
        // Create booking
        $booking = new Booking();
        $booking->room_number = $request->room_number;
        $booking->main_guest_id = $mainGuestId;
        $booking->total_group_size = $totalGroupSize;
        $booking->children_below_10 = $request->children_below_10 ?? 0;
        $booking->children_below_4 = $request->children_below_4 ?? 0;
        $booking->start_date = $start;
        $booking->end_date = $end;
        $booking->total_cost_cents = $request->total_cost_cents;
        $booking->total_cost_paid_cents = $request->total_cost_paid_cents ?? 0;
        $booking->includes_breakfast = $request->has('includes_breakfast') ? 1 : 0;
        $booking->has_disability = $request->has('has_disability') ? 1 : 0;
        $booking->save();
        
        return redirect()->route('reception.reservations')
            ->with('success', 'Booking created successfully.');
    }

    /**
     * Show the form for editing the specified booking.
     */
    public function edit(Request $request, $id)
    {
        $booking = Booking::with(['registeredGuest', 'room.type', 'room.bedTypes'])->where('booking_number', $id)->firstOrFail();
        
        // Normalize booked room display fields for the view
        if ($booking->room) {
            $booking->room->price_eur = number_format($booking->room->price_cents / 100, 2);
            foreach ($booking->room->bedTypes as $bedType) {
                $bedType->amount = $bedType->pivot->amount;
            }
        }
        
        // Prefer query params for dates if provided, otherwise fall back to booking's dates
        $startDateFormatted = $request->query('start_date') ?? Carbon::parse($booking->start_date)->format('d/m/Y');
        $endDateFormatted = $request->query('end_date') ?? Carbon::parse($booking->end_date)->format('d/m/Y');
         
        // Prefer query params for people counts when present
        $adults = $request->query('adults');
        $children = $request->query('children');
        $toddlers = $request->query('toddlers');
        if ($adults === null || $children === null || $toddlers === null) {
            // Fallback to booking-derived values
            $adults = $adults !== null ? (int)$adults : ($booking->total_group_size - $booking->children_below_10);
            $children = $children !== null ? (int)$children : $booking->children_below_10;
            $toddlers = $toddlers !== null ? (int)$toddlers : $booking->children_below_4;
        } else {
            $adults = (int)$adults;
            $children = (int)$children;
            $toddlers = (int)$toddlers;
        }
         
        // Calculate capacity needed
        $capacity = $adults + $children;
         
        // Parse date strings (d/m/Y) to proper dates for availability filtering
        $startDateForFilter = Carbon::createFromFormat('d/m/Y', $startDateFormatted)->toDateString();
        $endDateForFilter = Carbon::createFromFormat('d/m/Y', $endDateFormatted)->toDateString();

        // Get filtered rooms with requested (or booking) dates, excluding current booking
        $rooms = $this->getFilteredRooms($request, $startDateForFilter, $endDateForFilter, $capacity, $toddlers > 0, $booking->booking_number);
        $guests = RegisteredUser::all();
         
        return view('reception.booking', [
            'booking' => $booking,
            'rooms' => $rooms,
            'guests' => $guests,
            'start_date' => $startDateFormatted,
            'end_date' => $endDateFormatted,
            'adults' => $adults,
            'children' => $children,
            'toddlers' => $toddlers,
            'isEditing' => true
        ]);
    }

    /**
     * Update the specified booking in storage.
     */
    public function update(Request $request, $id)
    {
        $booking = Booking::where('booking_number', $id)->firstOrFail();
        
        $request->validate([
            'room_number' => 'required',
            'start_date' => 'required|date_format:d/m/Y',
            'end_date' => 'required|date_format:d/m/Y|after:start_date',
            'adults' => 'required|integer|min:1',
            'children_below_10' => 'nullable|integer|min:0',
            'children_below_4' => 'nullable|integer|min:0',
            'total_cost_cents' => 'required|integer|min:0',
        ]);

        // For edit mode: guest cannot be changed, but their info can be updated
        // Validate guest details
        $userId = $booking->main_guest_id;
        $user = User::findOrFail($userId);
        $request->validate([
            'firstname' => 'required|string|max:50',
            'lastname' => 'required|string|max:50',
            'email' => 'required|email|max:255|unique:users,email,' . $user->id,
            'date_of_birth' => 'required|date_format:d/m/Y',
            'phone' => 'required|string|max:20',
            'address' => 'required|string|max:255',
        ]);

        // Update linked User email if changed
        if ($user->email !== $request->email) {
            $user->email = $request->email;
            $user->save();
        }

        // Update RegisteredUser record
        $guest = RegisteredUser::where('user_account_id', $userId)->firstOrFail();
        $guest->name = ($request->fullname ?: ($request->firstname . ' ' . $request->lastname));
        $guest->date_of_birth = Carbon::createFromFormat('d/m/Y', $request->date_of_birth)->toDateString();
        $guest->phone_number = $request->phone;
        $guest->address = $request->address;
        $guest->save();
        
        // Calculate total group size
        $totalGroupSize = $request->adults + 
                          ($request->children_below_10 ?? 0) + 
                          ($request->children_below_4 ?? 0);
        
        // Parse dates from d/m/Y to proper DateTime
        $start = Carbon::createFromFormat('d/m/Y', $request->start_date)->startOfDay();
        $end = Carbon::createFromFormat('d/m/Y', $request->end_date)->endOfDay();
        
        // Update booking (keep main_guest_id unchanged)
        $booking->room_number = $request->room_number;
        $booking->total_group_size = $totalGroupSize;
        $booking->children_below_10 = $request->children_below_10 ?? 0;
        $booking->children_below_4 = $request->children_below_4 ?? 0;
        $booking->start_date = $start;
        $booking->end_date = $end;
        $booking->total_cost_cents = $request->total_cost_cents;
        $booking->includes_breakfast = $request->has('includes_breakfast') ? 1 : 0;
        $booking->has_disability = $request->has('has_disability') ? 1 : 0;
        $booking->save();
        
        return redirect()->route('reception.reservations')
            ->with('success', 'Booking updated successfully.');
    }

    /**
     * Remove the specified booking from storage.
     */
    public function destroy($id)
    {
        $booking = Booking::where('booking_number', $id)->firstOrFail();
        $booking->delete();
        
        return redirect()->route('reception.reservations')
            ->with('success', 'Booking deleted successfully.');
    }

    /**
     * Get filtered rooms based on availability and criteria
     */
    private function getFilteredRooms(Request $request, $startDate = null, $endDate = null, $capacity = null, $needsBabyBed = false, $excludeBookingNumber = null)
    {
        // Only load rooms if dates are provided, otherwise return empty array
        if (!$startDate || !$endDate) {
            return [];
        }

        $query = Room::select('room_number', 'capacity', 'view', 'babybed', 'for_disabled', 'price_cents', 'room_type_id')
            ->with(['booking', 'type', 'bedTypes' => function ($query) {
                $query->withPivot('bed_type_id', 'amount');
            }])
            // Filter by date availability - exclude rooms that are already booked during the requested period
            ->whereDoesntHave('booking', function ($q) use ($startDate, $endDate, $excludeBookingNumber) {
                $q->where(function ($q2) use ($startDate, $endDate) {
                    $q2->where('start_date', '<', $endDate)
                       ->where('end_date', '>', $startDate);
                });
                // Exclude current booking when editing
                if ($excludeBookingNumber) {
                    $q->where('booking_number', '!=', $excludeBookingNumber);
                }
            })
            // Filter by capacity if provided
            ->when($capacity, function ($query) use ($capacity) {
                $query->where('capacity', '>=', $capacity);
            });

        $rooms = $query->get();

        // Format room details and prepare parameters
        $uniqueRooms = [];
        foreach ($rooms as $room) {
            // Format price for display (keep raw price_cents intact)
            $room->price_eur = number_format($room->price_cents / 100, 2);
            
            // Add bed type amounts
            foreach ($room->bedTypes as $bedType) {
                $bedType->amount = $bedType->pivot->amount;
            }
            
            // Check for duplicates by room number only
            if (!$this->isRoomDuplicate($room, $uniqueRooms)) {
                $uniqueRooms[] = $room;
            }
        }

        return $uniqueRooms;
    }

    /**
     * Check if a room is a duplicate based on room number
     * We only consider a room duplicate if it has the same room number
     */
    private function isRoomDuplicate($room, $uniqueRooms)
    {
        foreach ($uniqueRooms as $uniqueRoom) {
            if ($room->room_number == $uniqueRoom->room_number) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compare bed types equality
     */
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
    
    /**
     * Prepare room parameters for links in the view
     */
    private function prepareRoomParameters($room)
    {
        $params = [
            'type' => $room->room_type_id,
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

    /**
     * Check-out a guest from their booking
     */
    public function checkOut($id)
    {
        try {
            $booking = Booking::where('booking_number', $id)->firstOrFail();
            
            // Get the 'Checked Out' status ID
            $checkedOutStatus = \App\Models\RoomStatus::where('status', 'Checked Out')->first();
            
            if ($checkedOutStatus) {
                // Update the room's status to 'Checked Out'
                $room = \App\Models\Room::where('room_number', $booking->room_number)->first();
                if ($room) {
                    $room->status_id = $checkedOutStatus->id;
                    $room->status_since = now();
                    $room->save();
                }
            }
            
            return response()->json(['success' => true, 'message' => 'Guest checked out successfully.']);
        } catch (\Exception $e) {
            \Log::error('Checkout failed: ' . $e->getMessage());
            return response()->json(['success' => false, 'message' => 'Failed to check out guest. Error: ' . $e->getMessage()], 500);
        }
    }
    
    /**
     * Check-in a guest for their booking
     */
    public function checkIn($id)
    {
        try {
            $booking = Booking::where('booking_number', $id)->firstOrFail();
            
            // Get the 'Checked In' status ID
            $checkedInStatus = \App\Models\RoomStatus::where('status', 'Checked In')->first();
            
            if (!$checkedInStatus) {
                throw new \Exception('Checked In status not found in the database');
            }
            
            // Update the room's status to 'Checked In'
            $room = \App\Models\Room::where('room_number', $booking->room_number)->first();
            if (!$room) {
                throw new \Exception('Room not found: ' . $booking->room_number);
            }
            
            $room->status_id = $checkedInStatus->id;
            $room->status_since = now();
            $room->save();
            
            // Get the verification data from the request
            $verificationData = request()->get('guests', []);
            
            // TODO: Store guest verification data if needed
            // This could be implemented based on business requirements
            
            return response()->json(['success' => true, 'message' => 'Guest checked in successfully.']);
        } catch (\Exception $e) {
            \Log::error('Check-in failed: ' . $e->getMessage());
            return response()->json(['success' => false, 'message' => 'Failed to check in guest. Error: ' . $e->getMessage()], 500);
        }
    }
}
