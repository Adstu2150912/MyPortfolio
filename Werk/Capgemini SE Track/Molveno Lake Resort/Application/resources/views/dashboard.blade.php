<x-app-layout>


    <div class="py-12">
        <div class="max-w-7xl mx-auto sm:px-6 lg:px-8">
            <div class="bg-white dark:bg-gray-800 overflow-hidden shadow-sm sm:rounded-lg">
                <div class="p-6 text-gray-900 dark:text-gray-100">
                    <h2 class="font-semibold text-2xl mb-6 text-center">Active Bookings</h2>

                    <!-- Bookings Table -->
                    <div class="overflow-x-auto">
                        <table class="min-w-full divide-y divide-gray-200 dark:divide-gray-700">
                            <thead class="bg-gray-100 dark:bg-gray-700">
                                <tr>
                                    <th class="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Booking No.</th>
                                    <th class="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Room No.</th>
                                    <th class="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Start Date</th>
                                    <th class="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">End Date</th>
                                    <th class="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Group Size</th>
                                    <th class="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Children &lt; 10</th>
                                    <th class="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Children &lt; 4</th>
                                    <th class="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Breakfast</th>
                                    <th class="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Total Paid (€)</th>
                                    <th class="px-4 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-300 uppercase tracking-wider">Total Cost (€)</th>
                                </tr>
                            </thead>
                            <tbody class="bg-white dark:bg-gray-800 divide-y divide-gray-200 dark:divide-gray-700">

                                @forelse($bookings as $booking)
                                    <tr class="hover:bg-gray-50 dark:hover:bg-gray-900 cursor-pointer transition-colors"
                                        @if(isset($roomsLookup[$booking->room_number]))
                                            onclick="window.location.href='{{ route('room.show', array_merge(
                                                $roomsLookup[$booking->room_number],
                                                [
                                                    'start_date' => $booking->formatted_start_date,
                                                    'end_date' => $booking->formatted_end_date,
                                                    'adults' => $booking->total_group_size - ($booking->children_below_10 + $booking->children_below_4),
                                                    'children' => $booking->children_below_10,
                                                    'toddlers' => $booking->children_below_4
                                                ]
                                            )) }}'"
                                        @endif>
                                        <td class="px-4 py-3 whitespace-nowrap">{{ $booking->booking_number }}</td>

                                        <td class="px-4 py-3 whitespace-nowrap">
                                            {{ $booking->room_number }}
                                        </td>
                                        <td class="px-4 py-3 whitespace-nowrap">{{ $booking->formatted_start_date }}</td>
                                        <td class="px-4 py-3 whitespace-nowrap">{{ $booking->formatted_end_date }}</td>
                                        <td class="px-4 py-3 whitespace-nowrap">{{ $booking->total_group_size }}</td>
                                        <td class="px-4 py-3 whitespace-nowrap">{{ $booking->children_below_10 }}</td>
                                        <td class="px-4 py-3 whitespace-nowrap">{{ $booking->children_below_4 }}</td>
                                        <td class="px-4 py-3 whitespace-nowrap">
                                            @if($booking->includes_breakfast)
                                                <span class="text-green-600 font-semibold">Yes</span>
                                            @else
                                                <span class="text-red-600 font-semibold">No</span>
                                            @endif
                                        </td>
                                        <td class="px-4 py-3 whitespace-nowrap">&euro; {{ number_format($booking->total_cost_paid_cents / 100, 2) }}</td>
                                        <td class="px-4 py-3 whitespace-nowrap">&euro; {{ number_format($booking->total_cost_cents / 100, 2) }}</td>
                                    </tr>
                                @empty
                                    <tr>
                                        <td colspan="10" class="px-4 py-6 text-center text-sm text-gray-500 dark:text-gray-400">No active bookings found.</td>
                                    </tr>
                                @endforelse
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</x-app-layout>
