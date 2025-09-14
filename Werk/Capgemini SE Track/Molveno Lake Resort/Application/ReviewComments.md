Pull Request Overview
This PR implements functionality to display detailed booking information from the account dashboard, allowing users to click on a booking to view full details on the room detail page. The main purpose is to create navigable links from dashboard bookings to their corresponding room detail views.

Key changes:

Enhanced dashboard booking display with clickable room links that pass booking parameters
Modified BookingController to fetch room data with relationships and format dates for display
Restructured the dashboard template to build proper room detail URLs with booking context
Reviewed Changes
Copilot reviewed 2 out of 2 changed files in this pull request and generated 4 comments.

File	Description
dashboard.blade.php	Updated booking table to generate clickable room links with booking parameters and improved date formatting
BookingController.php	Added room data fetching with relationships and date formatting for dashboard display
Tip: Customize your code reviews with copilot-instructions.md. Create the file or learn how to get started.

Application/app/Http/Controllers/BookingController.php
            ->whereHas('booking', function ($query) use ($userId) {
                $query->where('main_guest_id', $userId);
            })
            ->get();
        $bookings = Booking::where('main_guest_id', $userId)
            ->whereDate('end_date', '>=', now())
            ->orderBy('start_date')
            ->with('room')
            ->get();
Copilot AI
22 minutes ago
This query fetches all rooms that have bookings for the user, but the dashboard logic suggests only rooms matching specific booking room numbers are needed. Consider filtering rooms by the booking room numbers to avoid unnecessary data retrieval.

Suggested change
            ->get();
        $bookings = Booking::where('main_guest_id', $userId)
            ->whereDate('end_date', '>=', now())
            ->orderBy('start_date')
            ->with('room')
            ->get();
        $roomIds = $bookings->pluck('room_id')->unique()->toArray();
        $rooms = Room::with(['booking','type', 'bedTypes' => function ($query) {
                $query->withPivot('bed_type_id', 'amount');
            }])
            ->whereIn('id', $roomIds)
            ->get();
Copilot uses AI. Check for mistakes.

@JeroenEgelmeers JeroenEgelmeers 11 minutes ago
Kijk even naar deze.

@Adstu2150912	Reply...
Application/resources/views/dashboard.blade.php
                                            @endif
                                        @empty
                                            <td class="px-4 py-3 whitespace-nowrap">{{ $booking->room_number }}</td>
                                        @endforelse
Copilot AI
22 minutes ago
The nested loop structure creates an O(n*m) performance issue where for each booking, all rooms are iterated to find a match. Consider using a more efficient approach like indexing rooms by room_number or using a collection lookup.

Copilot uses AI. Check for mistakes.

@Adstu2150912	Reply...
Application/resources/views/dashboard.blade.php
                                                        $bedTypeParams['bed_type_' . $bedType->id] = $bedType->amount;
                                                    }
                                                @endphp

Copilot AI
22 minutes ago
Using @php blocks in Blade templates is generally discouraged as it reduces readability and testability. Consider moving this logic to the controller or creating a helper method.

Suggested change
Copilot uses AI. Check for mistakes.

@Adstu2150912	Reply...
Application/app/Http/Controllers/BookingController.php
        foreach ($bookings as $booking) {
            $booking->start_date = Carbon::parse($booking->start_date)->format('d/m/Y');
            $booking->end_date = Carbon::parse($booking->end_date)->format('d/m/Y');
        }
Copilot AI
22 minutes ago
Date formatting is being done in the controller but also appears to be handled differently in the view (lines 65-66 show raw dates). This creates inconsistency - consider standardizing the date formatting approach.

Suggested change
        }
        // Pass raw dates to the view; format in the view for consistency
Copilot uses AI. Check for mistakes.

@JeroenEgelmeers JeroenEgelmeers 10 minutes ago
Kijk hier even naar.

