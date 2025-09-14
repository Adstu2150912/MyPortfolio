@extends('masteremployee', ['pageTitle' => isset($booking) ? 'Modify Booking' : 'Create New Booking'])

@push('additional-resources')
    @vite(['resources/js/booking-filters.js', 'resources/css/bookingreception.css'])
@endpush

<script>
    // Global functions for check-in popup
    function handleCheckIn(bookingNumber) {
        // Get guest counts from the booking
        const adults = parseInt(document.getElementById('hidden_adults').value) || 1;
        const children = parseInt(document.getElementById('hidden_children').value) || 0;
        const totalGuests = adults + children; // Toddlers don't need verification

        // Show check-in popup with guest forms
        showCheckInPopup(bookingNumber, totalGuests);

        // Set up the confirm button with the booking number
        const confirmBtn = document.getElementById('confirm-checkin-btn');
        confirmBtn.onclick = function() {
            confirmCheckIn(bookingNumber, totalGuests);
        };
    }

    // Add any helper functions for check-in process here

    function showCheckInPopup(bookingNumber, totalGuests) {
        const popup = document.getElementById('checkin-popup');
        const guestTabsContainer = document.getElementById('guest-tabs');
        const formsContainer = document.getElementById('guest-verification-container');

        // Reset containers
        guestTabsContainer.innerHTML = '';
        formsContainer.innerHTML = '';

        // Ensure we have at least one guest
        const numGuests = Math.max(1, totalGuests);

        // Create tabs and forms for each guest
        for (let i = 0; i < numGuests; i++) {
            const guestNumber = i + 1;
            const isMainGuest = i === 0;
            const tabId = `guest-tab-${i}`;
            const formId = `guest-form-${i}`;

            // Create tab
            const tabLi = document.createElement('li');
            tabLi.className = 'mr-2';
            const tabButton = document.createElement('button');
            tabButton.id = tabId;
            tabButton.className = isMainGuest ?
                'py-2 px-4 text-sm font-medium text-center text-[#002060] border-b-2 border-[#002060]' :
                'py-2 px-4 text-sm font-medium text-center text-gray-500 hover:text-[#002060] hover:border-b-2 hover:border-gray-300';
            tabButton.innerHTML = isMainGuest ? 'Main Guest' : `Guest ${guestNumber}`;
            tabButton.onclick = () => switchGuestTab(i, numGuests);
            tabLi.appendChild(tabButton);
            guestTabsContainer.appendChild(tabLi);

            // Create verification form
            const form = document.createElement('div');
            form.id = formId;
            form.className = isMainGuest ? 'guest-form' : 'guest-form hidden';
            form.innerHTML = `
                <h4 class="text-md font-semibold text-[#002060] mb-3">${isMainGuest ? 'Main Guest' : `Guest ${guestNumber}`}</h4>
                <div class="space-y-3">
                    <div class="grid grid-cols-2 gap-3 mb-3">
                        <div>
                            <label for="verified-firstname-${i}" class="block text-sm font-medium text-gray-700 mb-1">First Name</label>
                            <input type="text" id="verified-firstname-${i}" name="verified-firstname-${i}"
                                class="w-full border border-gray-300 rounded p-2"
                                placeholder="First name" required>
                        </div>
                        <div>
                            <label for="verified-lastname-${i}" class="block text-sm font-medium text-gray-700 mb-1">Last Name</label>
                            <input type="text" id="verified-lastname-${i}" name="verified-lastname-${i}"
                                class="w-full border border-gray-300 rounded p-2"
                                placeholder="Last name" required>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="verified-dob-${i}" class="block text-sm font-medium text-gray-700 mb-1">Verified Date of Birth</label>
                        <input type="text" id="verified-dob-${i}" name="verified-dob-${i}"
                            class="w-full border border-gray-300 rounded p-2 guest-datepicker"
                            placeholder="DD/MM/YYYY" required autocomplete="off">
                    </div>

                    <div class="mb-3">
                        <label class="flex items-center">
                            <input type="checkbox" id="passport-verified-${i}" name="passport-verified-${i}"
                                class="form-checkbox h-5 w-5 text-[#002060]" required>
                            <span class="ml-2 text-sm font-medium text-gray-700">Passport verified <span class="text-red-500">*</span></span>
                        </label>
                    </div>
                </div>
            `;
            formsContainer.appendChild(form);
        }

        // Initialize datepickers for all guest forms
        initializeGuestDatepickers();

        // Show the popup
        popup.classList.remove('hidden');
        popup.style.display = 'flex';
    }

    function switchGuestTab(selectedIndex, totalGuests) {
        // Update tab styles
        for (let i = 0; i < totalGuests; i++) {
            const tabButton = document.getElementById(`guest-tab-${i}`);
            const form = document.getElementById(`guest-form-${i}`);

            if (i === selectedIndex) {
                tabButton.className = 'py-2 px-4 text-sm font-medium text-center text-[#002060] border-b-2 border-[#002060]';
                form.classList.remove('hidden');
            } else {
                tabButton.className = 'py-2 px-4 text-sm font-medium text-center text-gray-500 hover:text-[#002060] hover:border-b-2 hover:border-gray-300';
                form.classList.add('hidden');
            }
        }
    }

    function initializeGuestDatepickers() {
        // Initialize datepickers for guest DOB fields
        document.querySelectorAll('.guest-datepicker').forEach(input => {
            // Check if a datepicker is already initialized
            if (!input.hasAttribute('data-datepicker-initialized')) {
                // Initialize datepicker for this input
                $(input).datepicker({
                    dateFormat: 'dd/mm/yy',
                    changeMonth: true,
                    changeYear: true,
                    yearRange: '-100:+0',
                    maxDate: '0'
                });
                // Mark as initialized
                input.setAttribute('data-datepicker-initialized', 'true');
            }
        });
    }

    function hideCheckInPopup() {
        const popup = document.getElementById('checkin-popup');
        popup.classList.add('hidden');
        popup.style.display = 'none';
    }

    function confirmCheckIn(bookingNumber, totalGuests) {
        // Ensure we have at least one guest
        const numGuests = Math.max(1, totalGuests);
        const dateRegex = /^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\d\d$/;
        const guestVerifications = [];

        // Validate all guest forms
        for (let i = 0; i < numGuests; i++) {
            const firstNameField = document.getElementById(`verified-firstname-${i}`);
            const lastNameField = document.getElementById(`verified-lastname-${i}`);
            const dobField = document.getElementById(`verified-dob-${i}`);
            const passportField = document.getElementById(`passport-verified-${i}`);

            if (!firstNameField || !lastNameField || !dobField || !passportField) {
                console.error(`Form fields for guest ${i+1} not found`);
                continue;
            }

            const verifiedFirstName = firstNameField.value.trim();
            const verifiedLastName = lastNameField.value.trim();
            const verifiedDob = dobField.value.trim();
            const passportVerified = passportField.checked;

            // Clear any previous error messages for this guest
            document.querySelectorAll(`#guest-form-${i} .validation-error`).forEach(el => el.remove());

            let hasErrors = false;

            // Validate first name field
            if (!verifiedFirstName) {
                // Add error message for first name
                const firstNameErrorMsg = document.createElement('div');
                firstNameErrorMsg.className = 'validation-error text-red-500 text-sm mt-1';
                firstNameErrorMsg.innerText = 'First name is required';
                firstNameField.style.border = '1px solid #ef4444';
                firstNameField.parentNode.appendChild(firstNameErrorMsg);
                hasErrors = true;
            } else {
                firstNameField.style.border = '1px solid #d1d5db';
            }
            
            // Validate last name field
            if (!verifiedLastName) {
                // Add error message for last name
                const lastNameErrorMsg = document.createElement('div');
                lastNameErrorMsg.className = 'validation-error text-red-500 text-sm mt-1';
                lastNameErrorMsg.innerText = 'Last name is required';
                lastNameField.style.border = '1px solid #ef4444';
                lastNameField.parentNode.appendChild(lastNameErrorMsg);
                hasErrors = true;
            } else {
                lastNameField.style.border = '1px solid #d1d5db';
            }

            // Validate date of birth field
            if (!verifiedDob) {
                // Add error message for empty DOB
                const dobErrorMsg = document.createElement('div');
                dobErrorMsg.className = 'validation-error text-red-500 text-sm mt-1';
                dobErrorMsg.innerText = 'Date of birth verification is required';
                dobField.style.border = '1px solid #ef4444';
                dobField.parentNode.appendChild(dobErrorMsg);
                hasErrors = true;
            } else if (!dateRegex.test(verifiedDob)) {
                // Add error message for invalid date format
                const dobFormatErrorMsg = document.createElement('div');
                dobFormatErrorMsg.className = 'validation-error text-red-500 text-sm mt-1';
                dobFormatErrorMsg.innerText = 'Please enter a valid date format (DD/MM/YYYY)';
                dobField.style.border = '1px solid #ef4444';
                dobField.parentNode.appendChild(dobFormatErrorMsg);
                hasErrors = true;
            } else {
                dobField.style.border = '1px solid #d1d5db';
            }

            if (hasErrors) {
                switchGuestTab(i, numGuests); // Switch to the tab with errors
                return;
            }

            // Validate passport verification
            if (!passportVerified) {
                // Add an inline error message instead of popup
                const errorMsg = document.createElement('div');
                errorMsg.className = 'validation-error text-red-500 text-sm mt-1';
                errorMsg.innerText = 'Passport verification is required by law';

                // Get the passport checkbox label container
                const passportContainer = passportField.closest('.mb-3');
                passportContainer.appendChild(errorMsg);
                hasErrors = true;

                switchGuestTab(i, numGuests); // Switch to the tab with the error
                return;
            }

            // Add to verification array
            guestVerifications.push({
                verifiedFirstName: verifiedFirstName,
                verifiedLastName: verifiedLastName,
                verifiedFullName: verifiedFirstName + ' ' + verifiedLastName,
                verifiedDob: verifiedDob,
                passportVerified: true,
                isMainGuest: i === 0
            });
        }

        hideCheckInPopup();

        // Send request to check-in endpoint with verification data for all guests
        fetch(`/reception/booking/${bookingNumber}/check-in`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': document.querySelector('meta[name="csrf-token"]').getAttribute('content')
            },
            body: JSON.stringify({
                guests: guestVerifications
            })
        })
        .then(response => {
            if (response.ok) {
                showCustomPopup('Success', 'Guest checked in successfully!');
            } else {
                showCustomPopup('Error', 'Failed to check in guest. Please try again.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            showCustomPopup('Error', 'An error occurred while checking in.');
        });
    }

    // Make functions globally available
    window.handleCheckIn = handleCheckIn;
    window.showCheckInConfirmation = showCheckInConfirmation;
    window.hideCheckInPopup = hideCheckInPopup;
    window.confirmCheckIn = confirmCheckIn;

    function handleCheckOut(bookingNumber) {
        if (confirm('Are you sure you want to check-out this guest?')) {
            // Send request to check-out endpoint
            fetch(`/reception/booking/${bookingNumber}/check-out`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'X-CSRF-TOKEN': document.querySelector('meta[name="csrf-token"]').getAttribute('content')
                }
            })
            .then(response => {
                if (response.ok) {
                    showCustomPopup('Success', 'Guest checked out successfully!');
                } else {
                    showCustomPopup('Error', 'Failed to check out guest. Please try again.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                showCustomPopup('Error', 'An error occurred while checking out.');
            });
        }
    }
    </script>

@section('content')
@if(Auth::check() && (Auth::user()->type_id == 1 || Auth::user()->type_id == 4))
<!-- Close button to go back to reservations -->
<div class="flex justify-end mr-2">
    <a href="{{ route('reception.reservations') }}" class="bg-white text-[#002060] hover:bg-gray-100 border border-gray-300 rounded-full p-2 shadow-md transition duration-300">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
        </svg>
    </a>
</div>

<!-- Booking Form -->
<form id="booking-form" method="POST" action="{{ isset($booking) ? route('reception.booking.update', $booking->booking_number) : route('reception.booking.store') }}" novalidate>
    @csrf
    @if(isset($booking))
        @method('PUT')
    @endif

    <!-- Server-side validation errors -->
    @if ($errors->any())
        <div class="mb-4 bg-red-50 border border-red-200 text-red-800 rounded p-4">
            <div class="font-semibold mb-2">An error occurred:</div>
            <ul class="list-disc list-inside text-sm">
                @foreach ($errors->all() as $error)
                    <li>{{ $error }}</li>
                @endforeach
            </ul>
        </div>
    @endif

    <!-- Hidden inputs for form submission -->
    <input type="hidden" name="hidden_start_date" id="hidden_start_date" value="{{ $start_date ?? '' }}">
    <input type="hidden" name="hidden_end_date" id="hidden_end_date" value="{{ $end_date ?? '' }}">
    <input type="hidden" name="hidden_adults" id="hidden_adults" value="{{ $adults ?? 1 }}">
    <input type="hidden" name="children_below_10" id="hidden_children" value="{{ $children ?? 0 }}">
    <input type="hidden" name="children_below_4" id="hidden_toddlers" value="{{ $toddlers ?? 0 }}">
    <!-- Required fields for booking -->
    <input type="hidden" name="total_cost_cents" id="total_cost_cents" value="{{ isset($booking) ? $booking->total_cost_cents : 1000 }}">
    @if(isset($booking))
    <input type="hidden" name="total_cost_paid_cents" id="total_cost_paid_cents" value="{{ $booking->total_cost_paid_cents }}">
    @else
    <input type="hidden" name="total_cost_paid_cents" id="total_cost_paid_cents" value="0">
    @endif

    <div class="p-2">
        <!-- Main booking grid -->
        <div class="grid grid-cols-12 gap-4">
            <!-- Left Column: Date and People -->
            <div class="col-span-3">
                <!-- Dates Section -->
                <div class="bg-white rounded-lg shadow p-4 mb-4">
                    <h3 class="text-lg font-bold text-[#002060] mb-2">Dates</h3>
                    <div class="grid grid-cols-2 gap-3">
                        <div>
                            <label class="block text-sm font-medium text-gray-700 mb-1">Start date</label>
                            <input type="text" class="w-full border border-gray-300 rounded p-2 datepicker" id="start_date" name="start_date" value="{{ $start_date ?? '' }}" placeholder="DD/MM/YYYY" required autocomplete="off">
                        </div>
                        <div>
                            <label class="block text-sm font-medium text-gray-700 mb-1">End date</label>
                            <input type="text" class="w-full border border-gray-300 rounded p-2 datepicker" id="end_date" name="end_date" value="{{ $end_date ?? '' }}" placeholder="DD/MM/YYYY" required autocomplete="off">
                        </div>
                    </div>
                </div>

                <!-- People Section -->
                <div class="bg-white rounded-lg shadow p-4 mb-4">
                    <h3 class="text-lg font-bold text-[#002060] mb-3">People</h3>

                    <div class="grid grid-cols-3 gap-2 mb-2">
                        <div class="text-center">
                            <label class="block text-xs font-medium text-gray-700 mb-1">Adults</label>
                            <div class="flex items-center justify-center">
                                <button type="button" onclick="decrement('adults')" class="bg-gray-200 text-gray-700 px-2 py-1 rounded-l text-sm">-</button>
                                <input type="number" class="w-10 text-center border-t border-b border-gray-300 py-1 text-sm [appearance:textfield] [&::-webkit-outer-spin-button]:appearance-none [&::-webkit-inner-spin-button]:appearance-none" id="adults" name="adults" min="1" max="10" value="{{ $adults ?? 1 }}" required>
                                <button type="button" onclick="increment('adults', 4)" class="bg-gray-200 text-gray-700 px-2 py-1 rounded-r text-sm">+</button>
                            </div>
                        </div>

                        <div class="text-center">
                            <label class="block text-xs font-medium text-gray-700 mb-1">Children</label>
                            <div class="flex items-center justify-center">
                                <button type="button" onclick="decrement('children')" class="bg-gray-200 text-gray-700 px-2 py-1 rounded-l text-sm">-</button>
                                <input type="number" class="w-10 text-center border-t border-b border-gray-300 py-1 text-sm [appearance:textfield] [&::-webkit-outer-spin-button]:appearance-none [&::-webkit-inner-spin-button]:appearance-none" id="children" name="children" min="0" max="10" value="{{ $children ?? 0 }}">
                                <button type="button" onclick="increment('children', 4)" class="bg-gray-200 text-gray-700 px-2 py-1 rounded-r text-sm">+</button>
                            </div>
                        </div>

                        <div class="text-center">
                            <label class="block text-xs font-medium text-gray-700 mb-1">Toddlers</label>
                            <div class="flex items-center justify-center">
                                <button type="button" onclick="decrement('toddlers')" class="bg-gray-200 text-gray-700 px-2 py-1 rounded-l text-sm">-</button>
                                <input type="number" class="w-10 text-center border-t border-b border-gray-300 py-1 text-sm [appearance:textfield] [&::-webkit-outer-spin-button]:appearance-none [&::-webkit-inner-spin-button]:appearance-none" id="toddlers" name="toddlers" min="0" max="5" value="{{ $toddlers ?? 0 }}">
                                <button type="button" onclick="increment('toddlers', 2)" class="bg-gray-200 text-gray-700 px-2 py-1 rounded-r text-sm">+</button>
                            </div>
                        </div>
                    </div>

                    <div class="text-center text-xs text-gray-500 mt-2">
                        Adults + Children ≤ 4 per room
                    </div>
                </div>

                <!-- Load Available Rooms Section -->
                <div class="bg-white rounded-lg shadow p-4 mb-4">
                    <div class="text-center">
                        <button type="button" id="load-rooms-btn" class="bg-[#002060] text-white px-6 py-3 rounded-lg font-bold hover:bg-[#00184d] w-full text-lg">
                            Load Available Rooms
                        </button>
                        <div class="text-xs text-gray-500 mt-2">Search by dates & people count</div>
                    </div>
                </div>

                @if(isset($booking))
                <!-- Check-in and Check-out Buttons -->
                <div class="bg-white rounded-lg shadow p-4 mb-4">
                    <div class="text-center space-y-3">
                        <button type="button" id="check-in-btn" class="bg-white text-blue-950 px-4 py-2 rounded-lg font-bold hover:bg-gray-100 border border-blue-950 w-full" onclick="handleCheckIn('{{ $booking->booking_number }}')">
                            Check-in
                        </button>
                        <button type="button" id="check-out-btn" class="bg-white text-blue-950 px-4 py-2 rounded-lg font-bold hover:bg-gray-100 border border-blue-950 w-full" onclick="handleCheckOut('{{ $booking->booking_number }}')">
                            Check-out
                        </button>
                    </div>
                </div>
                @endif
            </div>

            <!-- Middle Column: Filters and Room Results -->
            <div class="col-span-5">
                <!-- Filters Section -->
                <div class="bg-white rounded-lg shadow p-4 mb-4 top-4">
                    <h3 class="text-lg font-bold text-[#002060] mb-2 text-center">Filters for searching rooms</h3>

                        <div class="grid grid-cols-2 gap-4 mb-3">
                            <div>
                                <label for="room_type" class="block text-sm font-medium text-gray-700 mb-1">Room Type</label>
                                <select class="w-full border border-gray-300 rounded p-2" id="room_type" name="room_type">
                                    <option value="0">All Room Types</option>
                                    @php $selectedRoomType = request('room_type', '0'); @endphp
                                    <option value="1" {{ $selectedRoomType == '1' ? 'selected' : '' }}>Economy</option>
                                    <option value="2" {{ $selectedRoomType == '2' ? 'selected' : '' }}>Standard</option>
                                    <option value="3" {{ $selectedRoomType == '3' ? 'selected' : '' }}>Luxurious</option>
                                </select>
                            </div>

                            <div>
                                <label for="view" class="block text-sm font-medium text-gray-700 mb-1">View</label>
                                <select class="w-full border border-gray-300 rounded p-2" id="view" name="view">
                                    <option value="0">All Views</option>
                                    @php $selectedView = request('view', '0'); @endphp
                                    <option value="Standard" {{ $selectedView == 'Standard' ? 'selected' : '' }}>Standard</option>
                                    <option value="Mountain" {{ $selectedView == 'Mountain' ? 'selected' : '' }}>Mountain</option>
                                    <option value="Lake" {{ $selectedView == 'Lake' ? 'selected' : '' }}>Lake</option>
                                </select>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="block text-sm font-medium text-gray-700 mb-1">Bed Types</label>
                            <div class="flex space-x-4">
                                <label class="inline-flex items-center">
                                    <input type="checkbox" class="form-checkbox" id="single" name="single" value="true" {{ request('single') == 'true' ? 'checked' : '' }}>
                                    <span class="ml-2">Single</span>
                                </label>
                                <label class="inline-flex items-center">
                                    <input type="checkbox" class="form-checkbox" id="double" name="double" value="true" {{ request('double') == 'true' ? 'checked' : '' }}>
                                    <span class="ml-2">Double</span>
                                </label>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="block text-sm font-medium text-gray-700 mb-1">Additional Options</label>
                            <div class="flex space-x-4">
                                <label class="inline-flex items-center">
                                    <input type="checkbox" class="form-checkbox" id="accessible" name="accessible" value="true" {{ request('accessible') == 'true' ? 'checked' : '' }}>
                                    <span class="ml-2">Disability Friendly</span>
                                </label>
                                <!-- Baby bed filter removed - now automatically handled by toddler selection -->
                                <input type="hidden" id="babybed_filter" name="babybed" value="false">
                            </div>
                        </div>
                </div>

                <!-- Room Results Section -->
                <div class="bg-white rounded-lg shadow p-4">
                    <h3 class="text-lg font-bold text-[#002060] mb-2 text-center">Found rooms</h3>

                    <div id="room-loading-message" class="bg-blue-50 border border-blue-200 text-blue-800 p-4 rounded mb-4" style="display: {{ count($rooms) == 0 && !isset($booking) ? 'block' : 'none' }}">
                        Please select dates and click "Load Rooms" to see available rooms.
                    </div>

                    <div id="no-rooms-message" class="bg-yellow-50 border border-yellow-200 text-yellow-800 p-4 rounded mb-4" style="display: {{ count($rooms) == 0 && !isset($booking) ? 'block' : 'none' }}">
                        No rooms available for the selected dates and filters.
                    </div>

                    @if(count($rooms) > 0 || isset($booking))
                        <div class="overflow-auto max-h-52">
                            <table class="w-full">
                                <thead>
                                    <tr class="bg-gray-100">
                                        <th class="p-2 text-left">Room</th>
                                        <th class="p-2 text-left">Type</th>
                                        <th class="p-2 text-left">Cap.</th>
                                        <th class="p-2 text-left">Beds</th>
                                        <th class="p-2 text-left">Price</th>
                                        <th class="p-2 text-left">Select</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    @if(isset($booking) && $booking->room)
                                    <tr class="border-b hover:bg-gray-50 room-row"
                                        data-room-number="{{ $booking->room_number }}"
                                        data-room-type="{{ $booking->room->room_type_id }}"
                                        data-view="{{ $booking->room->view }}"
                                        data-capacity="{{ $booking->room->capacity }}"
                                        data-accessible="{{ $booking->room->for_disabled ? 'true' : 'false' }}"
                                        data-babybed="{{ $booking->room->babybed ? 'true' : 'false' }}"
                                        data-price-cents="{{ $booking->room->price_cents }}"
                                        data-bed-types='@json($booking->room->bedTypes->map(function($bed){ return ["type"=>$bed->type, "amount"=>$bed->amount]; }))'>
                                        <td class="p-2">
                                            <strong>Room #{{ $booking->room_number }}</strong><br>
                                            <span class="text-sm">{{ $booking->room->view }} view</span>
                                            @if($booking->room->for_disabled)
                                            <br>
                                            <span class="ml-1 bg-blue-100 text-blue-800 text-xs font-medium px-2 py-0.5 rounded" style="display: inline-block;">Accessible</span>
                                            @endif
                                            @if($booking->room->babybed)
                                            <br>
                                            <span class="ml-1 bg-yellow-100 text-yellow-800 text-xs font-medium px-2 py-0.5 rounded" style="display: inline-block;">Baby bed</span>
                                            @endif
                                        </td>
                                        <td class="p-2">{{ $booking->room->type->type }}</td>
                                        <td class="p-2">{{ $booking->room->capacity }}</td>
                                        <td class="p-2">
                                            <ul class="list-disc list-inside text-sm">
                                                @foreach($booking->room->bedTypes as $bedType)
                                                    <li>{{ $bedType->amount }} {{ $bedType->type }}</li>
                                                @endforeach
                                            </ul>
                                        </td>
                                        <td class="p-2">&euro; {{ $booking->room->price_eur }}</td>
                                        <td class="p-2">
                                            <label class="inline-flex items-center">
                                                <input type="radio" name="room_number" value="{{ $booking->room_number }}" class="form-radio" checked>
                                                <span class="ml-2">Select</span>
                                            </label>
                                        </td>
                                    </tr>
                                    @endif
                                    @foreach($rooms as $room)
                                    @if(isset($booking) && $room->room_number == $booking->room_number)
                                        @continue
                                    @endif
                                    <tr class="border-b hover:bg-gray-50 room-row"
                                        data-room-number="{{ $room->room_number }}"
                                        data-room-type="{{ $room->room_type_id }}"
                                        data-view="{{ $room->view }}"
                                        data-capacity="{{ $room->capacity }}"
                                        data-accessible="{{ $room->for_disabled ? 'true' : 'false' }}"
                                        data-babybed="{{ $room->babybed ? 'true' : 'false' }}"
                                        data-price-cents="{{ $room->price_cents }}"
                                        data-bed-types="{{ json_encode($room->bedTypes->map(function($bed) { return ['type' => $bed->type, 'amount' => $bed->amount]; })->toArray()) }}">
                                        <td class="p-2">
                                            <strong>Room #{{ $room->room_number }}</strong><br>
                                            <span class="text-sm">{{ $room->view }} view</span>
                                            @if($room->for_disabled)
                                            <br>
                                            <span class="ml-1 bg-blue-100 text-blue-800 text-xs font-medium px-2 py-0.5 rounded" style="display: inline-block;">Accessible</span>
                                            @endif
                                            @if($room->babybed)
                                            <br>
                                            <span class="ml-1 bg-yellow-100 text-yellow-800 text-xs font-medium px-2 py-0.5 rounded" style="display: inline-block;">Baby bed</span>
                                            @endif
                                        </td>
                                        <td class="p-2">{{ $room->type->type }}</td>
                                        <td class="p-2">{{ $room->capacity }}</td>
                                        <td class="p-2">
                                            <ul class="list-disc list-inside text-sm">
                                                @foreach($room->bedTypes as $bedType)
                                                    <li>{{ $bedType->amount }} {{ $bedType->type }}</li>
                                                @endforeach
                                            </ul>
                                        </td>
                                        <td class="p-2">&euro; {{ $room->price_eur }}</td>
                                        <td class="p-2">
                                            <label class="inline-flex items-center">
                                                <input type="radio" name="room_number" value="{{ $room->room_number }}" class="form-radio"
                                                    {{ isset($booking) && $booking->room_number == $room->room_number ? 'checked' : '' }}>
                                                <span class="ml-2">Select</span>
                                            </label>
                                        </td>
                                    </tr>
                                    @endforeach
                                </tbody>
                            </table>
                        </div>
                    @endif
                </div>
            </div>

            <!-- Right Column: Guest Information -->
            <div class="col-span-4">
                <div class="bg-white rounded-lg shadow p-4 flex flex-col" style="max-height: 550px;">
                    <h3 class="text-lg font-bold text-[#002060] mb-4 text-center">Guest information</h3>

                    @if(empty($isEditing) || !$isEditing)
                    <div class="mb-4">
                        <div class="flex justify-center space-x-4">
                            <label class="inline-flex items-center">
                                <input type="radio" name="guest_option" value="existing" class="form-radio" checked onclick="toggleGuestForm('existing')">
                                <span class="ml-2">Existing Guest</span>
                            </label>
                            <label class="inline-flex items-center">
                                <input type="radio" name="guest_option" value="new" class="form-radio" onclick="toggleGuestForm('new')">
                                <span class="ml-2">New Guest</span>
                            </label>
                        </div>
                    </div>

                    <!-- Existing Guest Selection -->
                    <div id="existing-guest" class="guest-form mb-4">
                        <label for="guest_id" class="block text-sm font-medium text-gray-700 mb-1">Select Guest</label>
                        <select class="w-full border border-gray-300 rounded p-2" id="main_guest_id" name="main_guest_id">
                            <option value="">-- Select a Guest --</option>
                            @foreach($guests as $guest)
                                <option value="{{ $guest->user_account_id }}" {{ isset($booking) && $booking->main_guest_id == $guest->user_account_id ? 'selected' : '' }}>
                                    {{ $guest->name }}
                                </option>
                            @endforeach
                        </select>
                    </div>

                    <!-- New Guest Form -->
                    <div id="new-guest" class="guest-form mb-2 overflow-y-auto max-h-[500px] border border-gray-300 rounded p-4" style="display: none;">
                        <input type="hidden" name="create_new_guest" value="true">

                        <div class="grid grid-cols-2 gap-4 mb-3">
                            <div>
                                <label for="firstname" class="block text-sm font-medium text-gray-700 mb-1">First Name</label>
                                <input type="text" class="w-full border border-gray-300 rounded p-2" id="firstname" name="firstname" value="{{ old('firstname') }}" {{ isset($isFilterOnly) && $isFilterOnly ? '' : 'required' }}>
                            </div>
                            <div>
                                <label for="lastname" class="block text-sm font-medium text-gray-700 mb-1">Last Name</label>
                                <input type="text" class="w-full border border-gray-300 rounded p-2" id="lastname" name="lastname" value="{{ old('lastname') }}" {{ isset($isFilterOnly) && $isFilterOnly ? '' : 'required' }}>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="email" class="block text-sm font-medium text-gray-700 mb-1">Email</label>
                            <input type="email" class="w-full border border-gray-300 rounded p-2" id="email" name="email" value="{{ old('email') }}" {{ isset($isFilterOnly) && $isFilterOnly ? '' : 'required' }}>
                        </div>

                        <div class="mb-3">
                            <label for="date_of_birth" class="block text-sm font-medium text-gray-700 mb-1">Date of Birth (dd/mm/yyyy)</label>
                            <input type="text" class="w-full border border-gray-300 rounded p-2" id="date_of_birth" name="date_of_birth" value="{{ old('date_of_birth') }}" {{ isset($isFilterOnly) && $isFilterOnly ? '' : 'required' }}>
                        </div>

                        <div class="mb-3">
                            <label for="phone" class="block text-sm font-medium text-gray-700 mb-1">Phone</label>
                            <input type="text" class="w-full border border-gray-300 rounded p-2" id="phone" name="phone" value="{{ old('phone') }}" {{ isset($isFilterOnly) && $isFilterOnly ? '' : 'required' }}>
                        </div>

                        <div class="mb-3">
                            <label for="address" class="block text-sm font-medium text-gray-700 mb-1">Address</label>
                            <input type="text" class="w-full border border-gray-300 rounded p-2" id="address" name="address" value="{{ old('address') }}" {{ isset($isFilterOnly) && $isFilterOnly ? '' : 'required' }}>
                        </div>

                        <div class="grid grid-cols-2 gap-4 mb-3">
                            <div>
                                <label for="city" class="block text-sm font-medium text-gray-700 mb-1">City</label>
                                <input type="text" class="w-full border border-gray-300 rounded p-2" id="city" name="city" value="{{ old('city') }}">
                            </div>
                            <div>
                                <label for="postal_code" class="block text-sm font-medium text-gray-700 mb-1">Postal Code</label>
                                <input type="text" class="w-full border border-gray-300 rounded p-2" id="postal_code" name="postal_code" value="{{ old('postal_code') }}">
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="country" class="block text-sm font-medium text-gray-700 mb-1">Country</label>
                            <input type="text" class="w-full border border-gray-300 rounded p-2" id="country" name="country" value="{{ old('country') }}">
                        </div>


                    </div>
                    @else
                    <!-- Edit mode: show editable guest details, but no ability to change the guest -->
                    @php
                        $fullName = $booking->registeredGuest->name ?? '';
                        $firstName = trim(strstr($fullName, ' ', true) ?: $fullName);
                        $lastName = trim(strstr($fullName, ' ') ?: '');
                        $guestEmail = optional($booking->registeredGuest->userAccount)->email;
                        $dobFormatted = $booking->registeredGuest->date_of_birth ? \Carbon\Carbon::parse($booking->registeredGuest->date_of_birth)->format('d/m/Y') : '';
                    @endphp
                    <div id="edit-guest-details" class="guest-form mb-2 overflow-y-auto max-h-[500px] border border-gray-300 rounded p-4">
                        <div class="grid grid-cols-2 gap-4 mb-3">
                            <div>
                                <label for="firstname" class="block text-sm font-medium text-gray-700 mb-1">First Name</label>
                                <input type="text" class="w-full border border-gray-300 rounded p-2" id="firstname" name="firstname" value="{{ old('firstname', $firstName) }}" required>
                            </div>
                            <div>
                                <label for="lastname" class="block text-sm font-medium text-gray-700 mb-1">Last Name</label>
                                <input type="text" class="w-full border border-gray-300 rounded p-2" id="lastname" name="lastname" value="{{ old('lastname', $lastName) }}" required>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label for="email" class="block text-sm font-medium text-gray-700 mb-1">Email</label>
                            <input type="email" class="w-full border border-gray-300 rounded p-2" id="email" name="email" value="{{ old('email', $guestEmail) }}" required>
                        </div>

                        <div class="mb-3">
                            <label for="date_of_birth" class="block text-sm font-medium text-gray-700 mb-1">Date of Birth (dd/mm/yyyy)</label>
                            <input type="text" class="w-full border border-gray-300 rounded p-2" id="date_of_birth" name="date_of_birth" value="{{ old('date_of_birth', $dobFormatted) }}" required>
                        </div>

                        <div class="mb-3">
                            <label for="phone" class="block text-sm font-medium text-gray-700 mb-1">Phone</label>
                            <input type="text" class="w-full border border-gray-300 rounded p-2" id="phone" name="phone" value="{{ old('phone', $booking->registeredGuest->phone_number) }}" required>
                        </div>

                        <div class="mb-3">
                            <label for="address" class="block text-sm font-medium text-gray-700 mb-1">Address</label>
                            <input type="text" class="w-full border border-gray-300 rounded p-2" id="address" name="address" value="{{ old('address', $booking->registeredGuest->address) }}" required>
                        </div>


                    </div>
                    @endif

                    <!-- Booking Additional Options (global) -->
                    <div>
                        <label class="block text-sm font-medium text-gray-700">Additional Options</label>
                        <div class="space-y-2">
                            <label class="items-center inline-block mr-4">
                                <input type="checkbox" class="form-checkbox" id="breakfast" name="includes_breakfast" value="true" {{ isset($booking) && $booking->includes_breakfast ? 'checked' : '' }}>
                                <span class="ml-2">Include Breakfast</span>
                            </label>
                            <label class="items-center inline-block">
                                <input type="checkbox" class="form-checkbox" id="has_disability" name="has_disability" value="true" {{ isset($booking) && $booking->has_disability ? 'checked' : '' }}>
                                <span class="ml-2">Guest has disability</span>
                            </label>
                        </div>
                    </div>

                    <div class="pt-4">
                        <!-- Price Summary -->
                        <div id="price-summary" class="bg-gray-50 border border-gray-200 rounded p-3 mb-3">
                            <div class="font-semibold text-gray-800 mb-1">Price summary</div>
                            <div class="text-sm text-gray-700">Nights: <span id="ps-nights">0</span></div>
                            <div class="text-sm text-gray-700">Nightly rate: &euro; <span id="ps-rate">0.00</span></div>
                            <div class="text-sm text-gray-700">Breakfast: &euro; <span id="ps-breakfast">0.00</span></div>
                            <div class="text-sm font-bold text-gray-900">Total: &euro; <span id="ps-total">0.00</span></div>
                            <div class="text-sm text-gray-700">Paid: &euro; <span id="ps-paid">{{ isset($booking) ? number_format(($booking->total_cost_paid_cents ?? 0) / 100, 2) : '0.00' }}</span></div>
                            <div class="text-sm text-gray-700">Balance: &euro; <span id="ps-balance">{{ isset($booking) ? number_format((($booking->total_cost_cents ?? 0) - ($booking->total_cost_paid_cents ?? 0)) / 100, 2) : '0.00' }}</span></div>
                        </div>
                      
                    </div>
                </div>
                <div class="flex justify-end">
                            <button type="submit" class="bg-[#002060] text-white px-6 py-3 rounded-lg font-bold hover:bg-[#00184d] mt-4">
                                {{ isset($booking) ? 'Update Booking' : 'Create Booking' }}
                            </button>
                        </div>
            </div>
        </div>
    </div>
</form>

<!-- Custom Alert Popups -->
<div id="custom-popup" class="fixed inset-0 bg-black bg-opacity-50 z-50 items-center justify-center hidden" style="display: none;">
    <div class="bg-white rounded-lg shadow-xl p-6 max-w-md w-full mx-4">
        <div class="flex items-start justify-between mb-4">
            <h3 class="text-lg font-bold text-[#002060]" id="popup-title">Notice</h3>
            <button type="button" class="text-gray-400 hover:text-gray-500" onclick="hideCustomPopup()">
                <svg class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
                </svg>
            </button>
        </div>
        <div class="mb-5">
            <p id="popup-message" class="text-gray-600"></p>
        </div>
        <div class="flex justify-end">
            <button type="button" class="bg-[#002060] text-white px-4 py-2 rounded font-medium hover:bg-[#00184d]" onclick="hideCustomPopup()">OK</button>
        </div>
    </div>
</div>

<!-- Check-in Confirmation Popup -->
<div id="checkin-popup" class="fixed inset-0 bg-black bg-opacity-50 z-50 items-center justify-center hidden" style="display: none;">
    <div class="bg-white rounded-lg shadow-xl p-6 max-w-xl w-full mx-4">
        <h3 class="text-lg font-bold text-[#002060] mb-4">Confirm Check-in</h3>
        <p class="text-gray-700 mb-4">Please verify all guests' identity before check-in:</p>

        <!-- Guest verification tabs -->
        <div class="mb-4">
            <ul id="guest-tabs" class="flex flex-wrap border-b border-gray-200">
                <!-- Tabs will be added dynamically -->
            </ul>
        </div>

        <!-- Guest Verification Forms -->
        <div id="guest-verification-container" class="mb-4 max-h-[400px] overflow-y-auto">
            <!-- Forms will be added dynamically -->
        </div>

        <div class="flex justify-end space-x-3">
            <button type="button" class="bg-white text-[#002060] px-4 py-2 rounded hover:bg-gray-100 font-medium" onclick="hideCheckInPopup()">Cancel</button>
            <button type="button" id="confirm-checkin-btn" class="bg-[#002060] text-white px-4 py-2 rounded hover:bg-[#00184d] font-medium">Check-in</button>
        </div>
    </div>
</div>
<!-- Custom Check-out Confirmation Popup -->
<div id="checkout-confirmation-popup" class="fixed inset-0 bg-black bg-opacity-50 z-50 items-center justify-center" style="display: none;">
    <div class="bg-white rounded-lg shadow-xl p-6 max-w-md w-full mx-4">
        <div class="flex items-start justify-between mb-4">
            <h3 class="text-lg font-bold text-[#002060]" id="checkout-popup-title">Confirm Check-out</h3>
            <button type="button" class="text-gray-400 hover:text-gray-500" onclick="hideCheckOutConfirmation()">
                <svg class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
                </svg>
            </button>
        </div>
        <div class="mb-6">
            <p id="checkout-popup-message" class="text-gray-600">Are you sure you want to check-out this guest? This action cannot be undone.</p>
        </div>
        <div class="flex justify-end space-x-3">
            <button type="button" class="bg-gray-300 text-gray-700 px-4 py-2 rounded font-medium hover:bg-gray-400" onclick="hideCheckOutConfirmation()">Cancel</button>
            <button type="button" id="confirm-checkout-btn" class="bg-red-600 text-white px-4 py-2 rounded font-medium hover:bg-red-700">Check-out</button>
        </div>
    </div>
</div>

<!-- JavaScript for form functionality -->
<script>
        // Custom popup functions
    function showCustomPopup(title, message) {
        document.getElementById('popup-title').textContent = title;
        document.getElementById('popup-message').textContent = message;
        document.getElementById('custom-popup').classList.remove('hidden');
        document.getElementById('custom-popup').style.display = 'flex';
    }

    function hideCustomPopup() {
        document.getElementById('custom-popup').classList.add('hidden');
        document.getElementById('custom-popup').style.display = 'none';
    }

    window.showCheckOutConfirmation = function(bookingNumber) {
        document.getElementById('checkout-confirmation-popup').style.display = 'flex';
        // Set the booking number for the confirm button
        const confirmBtn = document.getElementById('confirm-checkout-btn');
        confirmBtn.onclick = function() { window.confirmCheckOut(bookingNumber); };
    };

    window.hideCheckOutConfirmation = function() {
        document.getElementById('checkout-confirmation-popup').style.display = 'none';
    };

    window.handleCheckOut = function(bookingNumber) {
        window.showCheckOutConfirmation(bookingNumber);
    };

    window.confirmCheckOut = function(bookingNumber) {
        window.hideCheckOutConfirmation();

        // Get CSRF token
        const csrfToken = document.querySelector('meta[name="csrf-token"]')?.getAttribute('content');
        console.log('CSRF Token:', csrfToken);
        console.log('Checking out booking:', bookingNumber);

        if (!csrfToken) {
            showCustomPopup('Error', 'CSRF token not found. Please refresh the page.');
            return;
        }

        // Send request to check-out endpoint
        fetch(`/reception/booking/${bookingNumber}/check-out`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': csrfToken
            }
        })
        .then(response => {
            console.log('Response status:', response.status);
            return response.json();
        })
        .then(data => {
            console.log('Response data:', data);
            if (data.success) {
                showCustomPopup('Success', 'Guest checked out successfully!');
            } else {
                showCustomPopup('Error', 'Failed to check out guest: ' + (data.message || 'Unknown error'));
            }
        })
        .catch(error => {
            console.error('Error:', error);
            showCustomPopup('Error', 'An error occurred while checking out: ' + error.message);
        });
    };

    window.showCustomPopup = showCustomPopup;
    window.hideCustomPopup = hideCustomPopup;

    document.addEventListener('DOMContentLoaded', function() {
        // Initialize all datepickers including the verification one in the check-in popup
        $(".datepicker").datepicker({
            dateFormat: 'dd/mm/yy',
            changeMonth: true,
            changeYear: true,
            yearRange: '-1:+2' // Default for generic datepickers (e.g., DOB in other contexts)
        });

        // Helper functions for date parsing/formatting
        function parseDdMmYy(str) {
            try { return $.datepicker.parseDate('dd/mm/yy', str); } catch (e) { return null; }
        }
        function formatDdMmYy(d) { return $.datepicker.formatDate('dd/mm/yy', d); }
        function addDays(d, days) { const nd = new Date(d.getTime()); nd.setDate(nd.getDate() + days); return nd; }
        function todayStart() { const t = new Date(); t.setHours(0,0,0,0); return t; }

        // Compute initial min date for end date: start + 1 day or tomorrow
        const initialStartVal = $("#start_date").val();
        const initialStartDate = initialStartVal ? parseDdMmYy(initialStartVal) : null;
        const initialEndMinDate = initialStartDate ? addDays(initialStartDate, 1) : 1; // 1 = tomorrow

        $("#start_date").datepicker({
            dateFormat: 'dd/mm/yy',
            changeMonth: true,
            changeYear: true,
            yearRange: 'c:c+5', // Allow at least 5 years ahead (>=2 years as requested)
            minDate: todayStart(), // Prevent selecting dates in the past
            beforeShow: function() {
                // Re-assert today's min date each time the picker opens
                $(this).datepicker('option', 'minDate', todayStart());
            },
            onSelect: function(selectedDate) {
                // Set the hidden input value
                $("#hidden_start_date").val(selectedDate);

                // Calculate end date min = start + 1 day
                const sd = parseDdMmYy(selectedDate);
                const endMin = sd ? addDays(sd, 1) : 1;
                $("#end_date").datepicker("option", "minDate", endMin);

                // If current end date is missing or before min, set it to min (auto +1 day)
                const currentEndVal = $("#end_date").val();
                const currentEnd = currentEndVal ? parseDdMmYy(currentEndVal) : null;
                if (!currentEnd || (sd && currentEnd <= sd)) {
                    const newEndStr = sd ? formatDdMmYy(endMin) : currentEndVal;
                    if (newEndStr) {
                        $("#end_date").val(newEndStr);
                        $("#hidden_end_date").val(newEndStr);
                    }
                }

                // Update hidden input
                $("#hidden_start_date").val(selectedDate);
            }
        });

        $("#end_date").datepicker({
            dateFormat: 'dd/mm/yy',
            changeMonth: true,
            changeYear: true,
            yearRange: 'c:c+5', // Allow at least 5 years ahead (>=2 years as requested)
            minDate: initialEndMinDate, // Enforce at least +1 day from start (or tomorrow)
            onSelect: function(selectedDate) {
                // Set the hidden input value
                $("#hidden_end_date").val(selectedDate);

                // Update hidden input
                $("#hidden_end_date").val(selectedDate);
            }
        });

        // Handle manual edits to start_date to keep end_date >= start+1 and disallow past dates
        $("#start_date").on('change', function() {
            const val = $(this).val();
            const sd = parseDdMmYy(val);
            if (!sd) return; // ignore invalid manual input

            // Clamp start date to today if typed in the past
            const today = todayStart();
            let startEffective = sd;
            if (sd < today) {
                startEffective = today;
                const correctedStartStr = formatDdMmYy(today);
                $("#start_date").val(correctedStartStr);
            }

            const endMin = addDays(startEffective, 1);
            $("#end_date").datepicker("option", "minDate", endMin);
            const currentEndVal = $("#end_date").val();
            const currentEnd = currentEndVal ? parseDdMmYy(currentEndVal) : null;
            if (!currentEnd || currentEnd <= startEffective) {
                const newEndStr = formatDdMmYy(endMin);
                $("#end_date").val(newEndStr);
                $("#hidden_end_date").val(newEndStr);
            }
            // Sync hidden start date from possibly corrected visible value
            $("#hidden_start_date").val($("#start_date").val());
        });

        // Ensure hidden end date syncs when end_date is typed manually and enforce >= (start||today)+1
        $("#end_date").on('change', function() {
            const val = $(this).val();
            const ed = parseDdMmYy(val);
            if (!ed) return; // ignore invalid

            const sdVal = $("#start_date").val();
            const sd = sdVal ? parseDdMmYy(sdVal) : null;
            const base = sd && sd >= todayStart() ? sd : todayStart();
            const min = addDays(base, 1);

            if (ed < min) {
                const corrected = formatDdMmYy(min);
                $("#end_date").val(corrected);
                $("#hidden_end_date").val(corrected);
            } else {
                $("#hidden_end_date").val(val);
            }
        });

        // Enforce constraints immediately on load (prefilled values from server or query)
        (function enforceInitialDateConstraints() {
            const today = todayStart();
            const sdVal = $("#start_date").val();
            let sd = sdVal ? parseDdMmYy(sdVal) : null;

            if (sd && sd < today) {
                sd = today;
                $("#start_date").val(formatDdMmYy(today));
            }

            // Ensure start datepicker respects today's min date on load
            $("#start_date").datepicker("option", "minDate", today);

            const base = sd || today;
            const minEnd = addDays(base, 1);
            $("#end_date").datepicker("option", "minDate", minEnd);

            const edVal = $("#end_date").val();
            const ed = edVal ? parseDdMmYy(edVal) : null;
            if (!ed || ed < minEnd) {
                const corrected = formatDdMmYy(minEnd);
                $("#end_date").val(corrected);
                $("#hidden_end_date").val(corrected);
            }

            // Sync hidden fields
            const finalStart = $("#start_date").val();
            if (finalStart) { $("#hidden_start_date").val(finalStart); }
            const finalEnd = $("#end_date").val();
            if (finalEnd) { $("#hidden_end_date").val(finalEnd); }
        })();

        // Check which guest form should be displayed initially (only when radios exist)
        const initialGuestRadio = document.querySelector('input[name="guest_option"]:checked');
        if (initialGuestRadio) {
            toggleGuestForm(initialGuestRadio.value);
        }

        // Add load rooms button functionality
        document.getElementById('load-rooms-btn').addEventListener('click', function() {
            loadRoomsForDates();
        });

        // Setup client-side filtering
        setupClientSideFiltering();

        // If a room is already selected (e.g., edit mode), visually highlight it
        (function highlightPreselectedRoom() {
            let prechecked = document.querySelector('input[name="room_number"]:checked');
            if (!prechecked && BOOKED_ROOM_NUMBER) {
                const match = document.querySelector(`input[name="room_number"][value="${BOOKED_ROOM_NUMBER}"]`);
                if (match) {
                    match.checked = true;
                    prechecked = match;
                }
            }
            if (!prechecked) return;
            const rn = prechecked.value;
            document.querySelectorAll('.room-row').forEach(row => row.classList.remove('bg-blue-100'));
            const row = document.querySelector(`.room-row[data-room-number="${rn}"]`);
            if (row) {
                row.classList.add('bg-blue-100');
                try { row.scrollIntoView({ behavior: 'smooth', block: 'nearest' }); } catch (e) {}
            }
            // Ensure price summary reflects the pre-selected room
            if (typeof updatePriceSummary === 'function') {
                updatePriceSummary();
            }
        })();

        // Enforce disability-friendly constraint helpers
        const disabilityCheckbox = document.getElementById('has_disability');
        const submitBtn = document.querySelector('#booking-form button[type="submit"]');

        function isSelectedRoomAccessible() {
            const checked = document.querySelector('input[name="room_number"]:checked');
            const selected = checked ? checked.value : (typeof selectedRoomNumber !== 'undefined' ? selectedRoomNumber : null);
            if (!selected) return true; // nothing selected yet; allow
            const row = document.querySelector(`.room-row[data-room-number="${selected}"]`);
            if (!row) return true; // if we cannot verify, do not block here (validation will re-check)
            return row.dataset.accessible === 'true';
        }

        function enforceDisabilityConstraint(showPopup = true) {
            try {
                if (!disabilityCheckbox) return;
                const hasDisability = disabilityCheckbox.checked;
                const roomRows = document.querySelectorAll('.room-row');
                let deselectedDueToConstraint = false;
                roomRows.forEach(row => {
                    const radio = row.querySelector('input[name="room_number"]');
                    if (!radio) return;
                    const isAccessible = row.dataset.accessible === 'true';
                    const label = radio.closest('label');
                    if (hasDisability && !isAccessible) {
                        // Disable non-accessible rooms
                        radio.disabled = true;
                        if (label) {
                            label.classList.add('opacity-50', 'cursor-not-allowed');
                            label.title = 'Not accessible: disabled guests require an accessible room';
                        }
                        if (radio.checked) {
                            radio.checked = false;
                            if (row) row.classList.remove('bg-blue-100');
                            selectedRoomNumber = null;
                            deselectedDueToConstraint = true;
                        }
                    } else {
                        // Re-enable (capacity and other rules may later disable via applyFilters)
                        if (!radio.disabled) return; // already enabled
                        radio.disabled = false;
                        if (label) {
                            label.classList.remove('opacity-50', 'cursor-not-allowed');
                            if (label.title === 'Not accessible: disabled guests require an accessible room') {
                                label.removeAttribute('title');
                            }
                        }
                    }
                });

                // When constraint is active, prevent submission unless selection is accessible
                if (submitBtn) {
                    submitBtn.disabled = hasDisability && !isSelectedRoomAccessible();
                }
                if (hasDisability && deselectedDueToConstraint && showPopup) {
                    showCustomPopup('Accessibility Required', 'Selected room is not disability friendly. Please choose an accessible room.');
                }
            } catch (e) {
                console.warn('Failed to enforce disability constraint', e);
            }
        }

        if (disabilityCheckbox) {
            disabilityCheckbox.addEventListener('change', function() {
                enforceDisabilityConstraint(true);
                // Re-apply filters so capacity/other rules also run
                if (typeof applyFilters === 'function') {
                    applyFilters();
                }
            });
        }

        // Initial enforcement on load
        enforceDisabilityConstraint(false);

        // Ensure booked room is preserved in edit mode even if it doesn't appear in the list
        (function ensurePreselectedRoomHidden() {
            try {
                if (!IS_EDITING || !BOOKED_ROOM_NUMBER) return;
                const checked = document.querySelector('input[name="room_number"]:checked');
                if (checked) return; // already selected via radio in list
                // Preserve current booking's room number
                selectedRoomNumber = String(BOOKED_ROOM_NUMBER);
                let hidden = document.getElementById('hidden_room_number');
                if (!hidden) {
                    hidden = document.createElement('input');
                    hidden.type = 'hidden';
                    hidden.id = 'hidden_room_number';
                    hidden.name = 'room_number';
                    document.getElementById('booking-form').appendChild(hidden);
                }
                hidden.value = selectedRoomNumber;
                if (typeof updatePriceSummary === 'function') {
                    updatePriceSummary();
                }
            } catch (e) {
                console.warn('Failed to preserve preselected room:', e);
            }
        })();

        // Prevent form submission on Enter key press in number inputs
        const numberInputs = document.querySelectorAll('input[type="number"]');
        numberInputs.forEach(input => {
            input.addEventListener('keydown', function(e) {
                if (e.key === 'Enter') {
                    e.preventDefault();
                    return false;
                }
            });
        });

        // Add main booking form validation
        document.getElementById('booking-form').addEventListener('submit', function(e) {
            e.preventDefault();
            // Sync visible inputs into hidden fields used by backend
            const c = document.getElementById('children');
            const t = document.getElementById('toddlers');
            const a = document.getElementById('adults');
            if (c) document.getElementById('hidden_children').value = c.value || 0;
            if (t) document.getElementById('hidden_toddlers').value = t.value || 0;
            if (a) document.getElementById('hidden_adults').value = a.value || 1;
            const sd = document.getElementById('start_date');
            const ed = document.getElementById('end_date');
            if (sd) document.getElementById('hidden_start_date').value = sd.value || '';
            if (ed) document.getElementById('hidden_end_date').value = ed.value || '';
            // Ensure room number is submitted even if its radio isn't present
            const checkedRadio = document.querySelector('input[name="room_number"]:checked');
            const roomVal = checkedRadio ? checkedRadio.value : (typeof selectedRoomNumber !== 'undefined' ? selectedRoomNumber : '');
            if (roomVal) {
                let hidden = document.getElementById('hidden_room_number');
                if (!hidden) {
                    hidden = document.createElement('input');
                    hidden.type = 'hidden';
                    hidden.id = 'hidden_room_number';
                    hidden.name = 'room_number';
                    this.appendChild(hidden);
                }
                hidden.value = roomVal;
                // Disable radios to avoid duplicate name submissions
                document.querySelectorAll('input[name="room_number"]').forEach(r => { if (r.type === 'radio') r.disabled = true; });
            }
            if (validateBookingForm()) {
                this.submit();
            }
        });

        // Handle prefilling from reservations page
        handlePrefillFromReservations();

        // --- Balance tracking: keep paid amount and update balance dynamically ---
        const paidCentsInput = document.getElementById('total_cost_paid_cents');
        const paidCentsStatic = paidCentsInput ? parseInt(paidCentsInput.value || '0', 10) : 0;
        const psTotalEl = document.getElementById('ps-total');
        const psPaidEl = document.getElementById('ps-paid');
        const psBalanceEl = document.getElementById('ps-balance');

        function updateBalanceFromDisplay() {
            if (!psTotalEl || !psBalanceEl) return;
            const totalText = (psTotalEl.textContent || '0').replace(/[^0-9.]/g, '');
            const totalCents = Math.round(parseFloat(totalText || '0') * 100);
            const balanceCents = totalCents - paidCentsStatic;
            const balanceEur = (balanceCents / 100).toFixed(2);
            if (psPaidEl) psPaidEl.textContent = (paidCentsStatic / 100).toFixed(2);
            psBalanceEl.textContent = balanceEur;
        }

        // Initial computation
        updateBalanceFromDisplay();

        // Observe changes to total to keep balance in sync
        if (psTotalEl) {
            const observer = new MutationObserver(updateBalanceFromDisplay);
            observer.observe(psTotalEl, { characterData: true, childList: true, subtree: true });
        }
    });

    // Global context for routes
    const IS_EDITING = {!! isset($isEditing) && $isEditing ? 'true' : 'false' !!};
    const EDIT_URL = {!! isset($isEditing) && $isEditing ? json_encode(route('reception.booking.edit', $booking->booking_number)) : 'null' !!};
    const CREATE_URL = {!! json_encode(route('reception.booking')) !!};
    const BOOKED_ROOM_NUMBER = {!! isset($booking) ? json_encode($booking->room_number) : 'null' !!};
    const BOOKED_ROOM_PRICE_CENTS = {!! isset($booking) ? json_encode(optional($booking->room)->price_cents ?? null) : 'null' !!};

    // Function to load rooms for selected dates
    function loadRoomsForDates() {
        const startDate = document.getElementById('start_date').value;
        const endDate = document.getElementById('end_date').value;
        const adults = document.getElementById('adults').value;
        const children = document.getElementById('children').value;
        const toddlers = document.getElementById('toddlers').value;

        if (!startDate || !endDate) {
            showCustomPopup('Date Required', 'Please select both start and end dates before loading rooms.');
            return;
        }

        // Show loading state
        const loadBtn = document.getElementById('load-rooms-btn');
        const originalText = loadBtn.textContent;
        loadBtn.textContent = 'Loading...';
        loadBtn.disabled = true;

        // Build URL with parameters
        const params = new URLSearchParams({
            start_date: startDate,
            end_date: endDate,
            adults: adults,
            children: children,
            toddlers: toddlers
        });

        // Redirect to load rooms (stay in edit mode when editing)
        const baseUrl = IS_EDITING && EDIT_URL ? EDIT_URL : CREATE_URL;
        window.location.href = `${baseUrl}?${params.toString()}`;
    }

    // Function to set up client-side filtering of rooms
    function setupClientSideFiltering() {
        // Get filter elements
        const roomTypeFilter = document.getElementById('room_type');
        const viewFilter = document.getElementById('view');
        const singleBedFilter = document.getElementById('single');
        const doubleBedFilter = document.getElementById('double');
        const accessibleFilter = document.getElementById('accessible');
        const babybedFilter = document.getElementById('babybed_filter');

        // Add event listeners to filters for immediate filtering
        roomTypeFilter.addEventListener('change', applyFilters);
        viewFilter.addEventListener('change', applyFilters);
        singleBedFilter.addEventListener('change', applyFilters);
        doubleBedFilter.addEventListener('change', applyFilters);
        accessibleFilter.addEventListener('change', applyFilters);

        // Add event listeners to people count elements for filtering
        document.getElementById('adults').addEventListener('input', applyFilters);
        document.getElementById('children').addEventListener('input', applyFilters);
        document.getElementById('toddlers').addEventListener('input', handleToddlerChange);
        document.getElementById('adults').addEventListener('change', applyFilters);
        document.getElementById('children').addEventListener('change', applyFilters);
        document.getElementById('toddlers').addEventListener('change', handleToddlerChange);

        // Function to handle toddler count changes and auto-enable baby bed filter
        function handleToddlerChange() {
            const toddlers = parseInt(document.getElementById('toddlers').value) || 0;
            const babybedFilter = document.getElementById('babybed_filter');

            if (toddlers > 0) {
                // Set the hidden input value to true when toddlers are selected
                babybedFilter.value = 'true';

                // Show notification that baby beds are required
                if (!handleToddlerChange._notified) {
                    showCustomPopup('Baby Bed Required', 'Toddlers require rooms with baby beds. Filtering has been adjusted automatically.');
                    handleToddlerChange._notified = true;
                    setTimeout(() => { handleToddlerChange._notified = false; }, 5000);
                }
            } else {
                // Reset the hidden input value when no toddlers
                babybedFilter.value = 'false';
            }

            // Apply filters after handling toddler change
            applyFilters();
        }

        // Initial filtering on page load
        applyFilters();

        // Initialize toddler change handler on page load
        handleToddlerChange();

        // Function to apply filters
        function applyFilters() {
            const roomType = roomTypeFilter.value;
            const view = viewFilter.value;
            const singleBed = singleBedFilter.checked;
            const doubleBed = doubleBedFilter.checked;
            const accessible = accessibleFilter.checked;
            const babybed = babybedFilter.value === 'true';

            // Get people count for capacity filtering
            const adults = parseInt(document.getElementById('adults').value) || 0;
            const children = parseInt(document.getElementById('children').value) || 0;
            const toddlers = parseInt(document.getElementById('toddlers').value) || 0;
            const totalPeople = adults + children; // Toddlers don't count toward capacity

            // Get all room rows
            const roomRows = document.querySelectorAll('.room-row');
            let visibleCount = 0;

            // Filter each room
            roomRows.forEach(row => {
                let showRoom = true;

                // Always keep the currently booked room visible and selectable in edit mode
                const isBookedRow = IS_EDITING && BOOKED_ROOM_NUMBER && row.dataset.roomNumber === String(BOOKED_ROOM_NUMBER);
                if (isBookedRow) {
                    row.style.display = '';
                    visibleCount++;
                    const radio = row.querySelector('input[name="room_number"]');
                    if (radio) {
                        radio.disabled = false;
                        radio.checked = true;
                        const label = radio.closest('label');
                        if (label) {
                            label.classList.remove('opacity-50', 'cursor-not-allowed');
                            label.removeAttribute('title');
                        }
                    }
                    return; // Skip further filtering for the booked room
                }

                // Apply room type filter
                if (roomType !== '0') {
                    if (row.dataset.roomType !== roomType) {
                        showRoom = false;
                    }
                }

                // Apply view filter
                if (view !== '0') {
                    if (row.dataset.view !== view) {
                        showRoom = false;
                    }
                }

                // Apply capacity filter: if more than 2 people, only show rooms with capacity 4
                const capacity = parseInt(row.dataset.capacity) || 0;
                if (totalPeople > 2) {
                    // More than 2 people need capacity 4 rooms
                    if (capacity < 4) {
                        showRoom = false;
                    }
                } else {
                    // 2 or fewer people: show all rooms (both capacity 2 and 4)
                    // No filtering needed - all rooms should be visible based on capacity
                }

                // Apply bed type filters
                let hasSingleBed = false;
                let hasDoubleBed = false;

                try {
                    // Parse the JSON data for bed types
                    const bedTypesData = JSON.parse(row.dataset.bedTypes);

                    // Check each bed in the array
                    bedTypesData.forEach(bed => {
                        if (bed && bed.type) {
                            const bedType = String(bed.type).toLowerCase();
                            if (bedType.includes('single')) {
                                hasSingleBed = true;
                            }
                            if (bedType.includes('double')) {
                                hasDoubleBed = true;
                            }
                        }
                    });
                } catch (e) {
                    console.error('Error parsing bed types for room ' + row.dataset.roomNumber + ':', e, row.dataset.bedTypes);
                }

                // Apply bed type filters only if at least one is checked
                if (singleBed || doubleBed) {
                    // If both filters are checked, require both bed types
                    if (singleBed && doubleBed) {
                        if (!(hasSingleBed && hasDoubleBed)) {
                            showRoom = false;
                        }
                    } else {
                        // If only one filter is checked, match that bed type
                        if (singleBed && !hasSingleBed) {
                            showRoom = false;
                        }
                        if (doubleBed && !hasDoubleBed) {
                            showRoom = false;
                        }
                    }
                }

                // Apply accessibility filter
                if (accessible && row.dataset.accessible !== 'true') {
                    showRoom = false;
                }

                // Apply baby bed filter - if toddlers > 0, require baby bed
                if (toddlers > 0 && row.dataset.babybed !== 'true') {
                    showRoom = false;
                }

                // Apply explicit baby bed filter
                if (babybed && row.dataset.babybed !== 'true') {
                    showRoom = false;
                }

                // Enforce selection guard on capacity: disable radios for under-capacity when totalPeople > 2
                const radio = row.querySelector('input[name="room_number"]');
                if (radio) {
                    const shouldDisable = totalPeople > 2 && capacity < 4;
                    radio.disabled = shouldDisable;
                    const label = radio.closest('label');
                    if (label) {
                        if (shouldDisable) {
                            label.classList.add('opacity-50', 'cursor-not-allowed');
                            label.title = 'Not enough capacity for selected people (adults + children)';
                        } else {
                            label.classList.remove('opacity-50', 'cursor-not-allowed');
                            label.removeAttribute('title');
                        }
                    }

                    // If an under-capacity room was selected and is now invalid, unselect it
                    if (shouldDisable && radio.checked) {
                        radio.checked = false;
                        selectedRoomNumber = null;
                        row.classList.remove('bg-blue-100');
                        if (typeof updatePriceSummary === 'function') {
                            updatePriceSummary();
                        }
                        // Notify once per applyFilters call when deselect happens
                        if (!applyFilters._notified) {
                            showCustomPopup('Room Capacity', 'Selected room cannot accommodate more than 2 people. Please choose a larger room.');
                            applyFilters._notified = true;
                            setTimeout(() => { applyFilters._notified = false; }, 0);
                        }
                    }

                    // Disability constraint: if guest has disability, disable non-accessible rooms
                    const hasDisability = document.getElementById('has_disability')?.checked;
                    if (hasDisability && row.dataset.accessible !== 'true') {
                        radio.disabled = true;
                        if (label) {
                            label.classList.add('opacity-50', 'cursor-not-allowed');
                            label.title = 'Not accessible: disabled guests require an accessible room';
                        }
                        if (radio.checked) {
                            radio.checked = false;
                            selectedRoomNumber = null;
                            row.classList.remove('bg-blue-100');
                            if (!applyFilters._notified_accessibility) {
                                showCustomPopup('Accessibility Required', 'Selected room is not disability friendly. Please choose an accessible room.');
                                applyFilters._notified_accessibility = true;
                                setTimeout(() => { applyFilters._notified_accessibility = false; }, 0);
                            }
                        }
                    }
                }

                // Show or hide the room based on filters
                if (showRoom) {
                    row.style.display = '';
                    visibleCount++;
                } else {
                    row.style.display = 'none';
                }
            });

            // Show message if no rooms match filters
            const noRoomsMessage = document.getElementById('no-rooms-message');
            const loadingMessage = document.getElementById('room-loading-message');

            if (noRoomsMessage) {
                if (visibleCount === 0 && document.querySelectorAll('.room-row').length > 0) {
                    noRoomsMessage.style.display = 'block';
                } else {
                    noRoomsMessage.style.display = 'none';
                }
            }

            if (loadingMessage) {
                if (document.querySelectorAll('.room-row').length === 0) {
                    loadingMessage.style.display = 'block';
                } else {
                    loadingMessage.style.display = 'none';
                }
            }
        }
    }

    // Function to handle prefilling from reservations page
    function handlePrefillFromReservations() {
        // Check URL parameters for prefill data
        const urlParams = new URLSearchParams(window.location.search);
        const fromReservations = urlParams.get('from_reservations');

        if (fromReservations) {
            // If coming from reservations, the booking data should already be loaded
            // Additional prefill logic can be added here if needed
            console.log('Prefilling from reservations page');
        }
    }

    // Room selection handler
    let selectedRoomNumber = null;

    document.addEventListener('click', function(event) {
        if (event.target.closest('.room-select-btn')) {
            const btn = event.target.closest('.room-select-btn');
            selectedRoomNumber = btn.getAttribute('data-room-number');

            // Set the room number in a hidden form field
            let roomNumberInput = document.querySelector('input[name="room_number"]');
            if (!roomNumberInput) {
                roomNumberInput = document.createElement('input');
                roomNumberInput.type = 'hidden';
                roomNumberInput.name = 'room_number';
                document.getElementById('booking-form').appendChild(roomNumberInput);
            }
            roomNumberInput.value = selectedRoomNumber;

            // Highlight the selected room
            document.querySelectorAll('.room-row').forEach(row => {
                row.classList.remove('bg-blue-100');
            });
            document.querySelector(`.room-row[data-room-number="${selectedRoomNumber}"]`).classList.add('bg-blue-100');

            // Update price summary after selection
            updatePriceSummary();
        }
    });

    // Recalculate price when room radio selection changes
    document.addEventListener('change', function(event) {
        if (event.target && event.target.name === 'room_number') {
            // Block selecting non-accessible rooms when the guest has a disability
            const hasDisability = document.getElementById('has_disability')?.checked;
            if (hasDisability) {
                const rn = event.target.value;
                const selectedRow = document.querySelector(`.room-row[data-room-number="${rn}"]`);
                if (selectedRow && selectedRow.dataset.accessible !== 'true') {
                    event.target.checked = false;
                    showCustomPopup('Accessibility Required', 'This room is not disability friendly. Please choose an accessible room.');
                    // Re-enforce constraints and abort handler
                    if (typeof enforceDisabilityConstraint === 'function') enforceDisabilityConstraint(false);
                    return;
                }
            }
            selectedRoomNumber = event.target.value;
            // Highlight the selected room row
            document.querySelectorAll('.room-row').forEach(row => {
                row.classList.remove('bg-blue-100');
            });
            const row = document.querySelector(`.room-row[data-room-number="${selectedRoomNumber}"]`);
            if (row) row.classList.add('bg-blue-100');
            // Update price summary
            updatePriceSummary();
        }
    });

    // Form validation function
    function validateBookingForm() {
        // Check required fields
        const startDate = document.getElementById('start_date').value;
        const endDate = document.getElementById('end_date').value;
        const roomNumber = document.querySelector('input[name="room_number"]:checked')?.value || selectedRoomNumber;

        let isValid = true;
        let errorMessage = '';

        if (!startDate) {
            errorMessage += '• Start date is required\n';
            isValid = false;
        }

        if (!endDate) {
            errorMessage += '• End date is required\n';
            isValid = false;
        }

        if (!roomNumber) {
            errorMessage += '• Please select a room\n';
            isValid = false;
        }

        // Add validation for guest information
        const editMode = document.getElementById('edit-guest-details') !== null;
        if (editMode) {
            const requiredFields = ['firstname', 'lastname', 'email', 'date_of_birth', 'phone', 'address'];
            requiredFields.forEach(field => {
                const input = document.querySelector(`input[name="${field}"]`);
                if (!input || !input.value.trim()) {
                    errorMessage += `• ${field.charAt(0).toUpperCase() + field.slice(1).replace('_', ' ')} is required\n`;
                    isValid = false;
                }
            });
        } else {
            const guestOption = document.querySelector('input[name="guest_option"]:checked')?.value;
            if (guestOption === 'new') {
                const requiredFields = ['firstname', 'lastname', 'email', 'date_of_birth', 'phone', 'address'];
                requiredFields.forEach(field => {
                    const input = document.querySelector(`input[name="${field}"]`);
                    if (!input || !input.value.trim()) {
                        errorMessage += `• ${field.charAt(0).toUpperCase() + field.slice(1).replace('_', ' ')} is required\n`;
                        isValid = false;
                    }
                });
            } else if (guestOption === 'existing') {
                const mainGuestId = document.getElementById('main_guest_id').value;
                if (!mainGuestId) {
                    errorMessage += '• Please select a guest\n';
                    isValid = false;
                }
            }
        }

        // Capacity rule: Adults + Children > 2 cannot book capacity 2 rooms (toddlers excluded)
        const adults = parseInt(document.getElementById('adults').value || '0', 10);
        const children = parseInt(document.getElementById('children').value || '0', 10);
        const totalPeople = adults + children;
        if (roomNumber && totalPeople > 2) {
            const selectedRow = document.querySelector(`.room-row[data-room-number="${roomNumber}"]`);
            if (selectedRow) {
                const cap = parseInt(selectedRow.dataset.capacity || '0', 10);
                if (cap < 4) {
                    errorMessage += '• Selected room does not have enough capacity for more than 2 people (adults + children)\n';
                    isValid = false;
                }
            }
        }

        // Accessibility rule: if guest has disability, selected room must be accessible
        const hasDisability = document.getElementById('has_disability')?.checked;
        if (hasDisability && roomNumber) {
            const selectedRow = document.querySelector(`.room-row[data-room-number="${roomNumber}"]`);
            if (selectedRow && selectedRow.dataset.accessible !== 'true') {
                errorMessage += '• Selected room is not disability friendly while guest has disability selected\n';
                isValid = false;
            }
        }

        if (!isValid) {
            showCustomPopup('Form Validation', 'Please fix the following errors:\n\n' + errorMessage);
        }

        return isValid;
    }

    // Guest count increment/decrement functions with total limit of 4 people (excluding toddlers)
    function increment(field, max = 10) {
        const input = document.getElementById(field);
        const value = parseInt(input.value);

        // Check total people count limit (excluding toddlers)
        if (field !== 'toddlers') {
            const adults = parseInt(document.getElementById('adults').value);
            const children = parseInt(document.getElementById('children').value);
            const totalPeople = adults + children;

            // If we're already at 4 people and trying to add more, don't allow it
            if (totalPeople >= 4 && value >= 1) {
                showCustomPopup('Room Capacity Limit', 'Maximum of 4 people (adults + children) allowed per room.');
                return;
            }
        }

        // Regular max check
        if (value < max) {
            input.value = value + 1;
            document.getElementById('hidden_' + field).value = value + 1;

            // Apply filters after changing count
            if (typeof applyFilters === 'function') {
                applyFilters();
            }
            updatePriceSummary();
        }
    }

    function decrement(field) {
        const input = document.getElementById(field);
        const value = parseInt(input.value);
        if (field === 'adults' && value > 1) {
            input.value = value - 1;
            document.getElementById('hidden_' + field).value = value - 1;

            // Apply filters after changing count
            if (typeof applyFilters === 'function') {
                applyFilters();
            }
            updatePriceSummary();
        } else if (field !== 'adults' && value > 0) {
            input.value = value - 1;
            document.getElementById('hidden_' + field).value = value - 1;

            // No automatic babybed filter manipulation

            // Apply filters after changing count
            if (typeof applyFilters === 'function') {
                applyFilters();
            }
            updatePriceSummary();
        }
    }

    // Toggle between existing and new guest forms
    function toggleGuestForm(type) {
        const existingGuest = document.getElementById('existing-guest');
        const newGuest = document.getElementById('new-guest');

        if (type === 'existing') {
            existingGuest.style.display = 'block';
            newGuest.style.display = 'none';
        } else {
            existingGuest.style.display = 'none';
            newGuest.style.display = 'block';
        }
    }

    // Update price summary and hidden totals (includes breakfast if selected)
    function updatePriceSummary() {
        try {
            const sd = document.getElementById('start_date').value;
            const ed = document.getElementById('end_date').value;
            if (!sd || !ed) { return; }
            const partsS = sd.split('/');
            const partsE = ed.split('/');
            if (partsS.length !== 3 || partsE.length !== 3) { return; }
            const dS = new Date(+partsS[2], partsS[1]-1, +partsS[0]);
            const dE = new Date(+partsE[2], partsE[1]-1, +partsE[0]);
            const diffMs = dE - dS;
            const nights = Math.max(0, Math.round(diffMs / (1000*60*60*24)));
            const nightsEl = document.getElementById('ps-nights');
            if (nightsEl) nightsEl.textContent = nights;

            // Determine selected room (or fallback to booked room context in edit mode)
            const checked = document.querySelector('input[name="room_number"]:checked');
            let roomNo = checked ? checked.value : (typeof selectedRoomNumber !== 'undefined' ? selectedRoomNumber : null);
            const row = roomNo ? document.querySelector(`.room-row[data-room-number="${roomNo}"]`) : null;
            let priceCents = 0;
            if (row) {
                priceCents = parseInt(row.dataset.priceCents || '0', 10);
            } else if (IS_EDITING && BOOKED_ROOM_PRICE_CENTS) {
                priceCents = parseInt(BOOKED_ROOM_PRICE_CENTS, 10);
                // Ensure selectedRoomNumber is set so submission works
                if (!roomNo && BOOKED_ROOM_NUMBER) {
                    roomNo = String(BOOKED_ROOM_NUMBER);
                    selectedRoomNumber = roomNo;
                }
            } else {
                // No price context available; nothing to update
                return;
            }
            const rateEl = document.getElementById('ps-rate');
            const totalEl = document.getElementById('ps-total');
            const breakfastEl = document.getElementById('ps-breakfast');
            const totalHidden = document.getElementById('total_cost_cents');

            const rate = (priceCents / 100).toFixed(2);

            // Breakfast calculation
            const adults = parseInt(document.getElementById('adults').value || '0', 10);
            const children = parseInt(document.getElementById('children').value || '0', 10);
            const breakfastCreate = document.getElementById('breakfast');
            const breakfastEdit = document.getElementById('breakfast_edit');
            const includesBreakfast = !!((breakfastCreate && breakfastCreate.checked) || (breakfastEdit && breakfastEdit.checked));
            const breakfastPerNightCents = (adults * 1750) + (children * 1000);
            const breakfastCents = includesBreakfast ? (nights * breakfastPerNightCents) : 0;

            const baseCents = nights * priceCents;
            const totalCents = baseCents + breakfastCents;
            const total = (totalCents / 100).toFixed(2);

            if (rateEl) rateEl.textContent = rate;
            if (breakfastEl) breakfastEl.textContent = (breakfastCents / 100).toFixed(2);
            if (totalEl) totalEl.textContent = total;
            if (totalHidden) totalHidden.value = totalCents;
        } catch (e) {
            console.warn('Price summary update failed:', e);
        }
    }

    // Trigger price summary updates on date changes
    ['start_date','end_date'].forEach(id => {
        const el = document.getElementById(id);
        if (el) {
            el.addEventListener('change', updatePriceSummary);
        }
    });
    // Initial compute
    updatePriceSummary();

    // React to breakfast toggles (create and edit forms)
    (function attachBreakfastListeners() {
        const breakfastCreate = document.getElementById('breakfast');
        const breakfastEdit = document.getElementById('breakfast_edit');
        if (breakfastCreate) breakfastCreate.addEventListener('change', updatePriceSummary);
        if (breakfastEdit) breakfastEdit.addEventListener('change', updatePriceSummary);
    })();
</script>

@endif
@endsection
