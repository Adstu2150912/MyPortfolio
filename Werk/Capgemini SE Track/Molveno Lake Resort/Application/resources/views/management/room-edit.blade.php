@extends('masteremployee', ['pageTitle' => ($pageTitle ?? 'Update Room')])
<meta name="csrf-token" content="{{ csrf_token() }}">
<script>
    document.addEventListener('DOMContentLoaded', function() {
        let roomSelection = document.getElementById('room-selection');
        let roomType = document.getElementById('room-type');
        let roomCapacity = document.getElementById('room-capacity');
        let roomView = document.getElementById('room-view');
        let roomBed = document.getElementById('room-bed');
        let roomBabybed = document.getElementById('room-babybed');
        let roomDisabled = document.getElementById('room-disabled');
        let roomPrice = document.getElementById('room-price');
        let roomBreakfastAdults = document.getElementById('room-breakfast-adults');
        let roomBreakfastChildren = document.getElementById('room-breakfast-children');
        let roomPaymentAmount = document.getElementById('room-payment-amount');
        let roomNotes = document.getElementById('room-notes-input');
        let updateRoomButton = document.getElementById('updateRoomButton');

        roomSelection.addEventListener('change', function() {
            let selectedRoomNumber = roomSelection.value;
            loadRoomData(selectedRoomNumber);
        });

        updateRoomButton.addEventListener("click", updateRoomData);

        // Function to load room data when room is selected
        function loadRoomData(roomNumber) {
            if (!roomNumber) {
                // Clear all fields if no room selected
                clearRoomDisplay();
                return;
            }

            // Fetch room data from database via AJAX
            fetch(`/management/room-edit/data/${roomNumber}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'X-CSRF-TOKEN': document.querySelector('meta[name="csrf-token"]').getAttribute('content')
                }
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                if (data.success && data.room) {
                    const room = data.room;
                    // Populate display fields
                    roomType.textContent = room.type ? room.type.type : '';
                    roomCapacity.textContent = room.capacity ?? '';
                    roomView.textContent = room.view ?? '';

                    // Handle bed types
                    if (room.bed_types && room.bed_types.length > 0) {
                        const bedTypeNames = room.bed_types.map(bt => `${bt.pivot.amount} x ${bt.type}`).join(', ');
                        roomBed.textContent = bedTypeNames;
                    } else {
                        roomBed.textContent = '';
                    }

                    roomBabybed.textContent = room.babybed ? 'Yes' : 'No';
                    roomDisabled.textContent = room.for_disabled ? 'Yes' : 'No';
                    roomPrice.textContent = '€ ' + (room.price_cents / 100).toFixed(2);

                    // Populate input fields for editing
                    document.getElementById('room-price-input').value = (room.price_cents / 100).toFixed(2);
                    document.getElementById('room-notes-input').value = room.comments ?? '';

                    // Set default values for breakfast and payment
                    roomBreakfastAdults.textContent = '€ 17,50';
                    roomBreakfastChildren.textContent = '€ 10,00';
                    roomPaymentAmount.textContent = room.booking && room.booking.length > 0 ? '€ ' + (room.booking[0].total_cost_paid_cents / 100).toFixed(2) : '€ 0,00';
                } else {
                    clearRoomDisplay();
                    alert('Failed to load room data: ' + (data.message || 'Unknown error'));
                }
            })
            .catch(error => {
                console.error('Error loading room data:', error);
                clearRoomDisplay();
                alert('Error loading room data. Please try again.');
            });
        }

        function clearRoomDisplay() {
            roomType.textContent = '';
            roomCapacity.textContent = '';
            roomView.textContent = '';
            roomBed.textContent = '';
            roomBabybed.textContent = '';
            roomDisabled.textContent = '';
            roomPrice.textContent = '';
            roomBreakfastAdults.textContent = '';
            roomBreakfastChildren.textContent = '';
            roomPaymentAmount.textContent = '';
            roomNotes.textContent = '';

            // Clear input fields
            document.getElementById('room-price-input').value = '';
            document.getElementById('room-notes-input').value = '';
        }

        // AJAX function to update room data
        function updateRoomData() {
            const selectedRoomNumber = parseInt(roomSelection.value);

            if (!selectedRoomNumber) {
                alert('Please select a room first');
                return;
            }

            const priceInput = document.getElementById('room-price-input')?.value;
            const priceDisplay = roomPrice?.textContent || '';
            const priceValue = priceInput || priceDisplay.replace('€ ', '').replace(',', '.');
            const parsedPrice = parseFloat(priceValue) || 0;

            const formData = {
                price: parsedPrice,
                comments: document.getElementById('room-notes-input')?.value || roomNotes.textContent
            };

            fetch(`/management/room-edit/${selectedRoomNumber}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'X-CSRF-TOKEN': document.querySelector('meta[name="csrf-token"]').getAttribute('content')
                },
                body: JSON.stringify(formData)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                if (data.success) {
                    // Update the display with new data
                    const updatedRoom = data.room;
                    roomType.textContent = updatedRoom.type ? updatedRoom.type.type : '';
                    roomCapacity.textContent = updatedRoom.capacity ?? '';
                    roomView.textContent = updatedRoom.view ?? '';
                    // Handle bed types - get the first bed type or create a summary
                    if (updatedRoom.bed_types && updatedRoom.bed_types.length > 0) {
                        const bedTypeNames = updatedRoom.bed_types.map(bt => `${bt.pivot.amount} x ${bt.type}`).join(', ');
                        roomBed.textContent = bedTypeNames;
                    } else {
                        roomBed.textContent = '';
                    }
                    roomBabybed.textContent = updatedRoom.babybed ? 'Yes' : 'No';
                    roomDisabled.textContent = updatedRoom.for_disabled ? 'Yes' : 'No';
                    roomPrice.textContent = '€ ' + (updatedRoom.price_cents / 100).toFixed(2);
                    // Set default values for breakfast and payment
                    roomBreakfastAdults.textContent = '€ 17,50';
                    roomBreakfastChildren.textContent = '€ 10,00';
                    roomPaymentAmount.textContent = updatedRoom.booking && updatedRoom.booking.length > 0 ? '€ ' + (updatedRoom.booking[0].total_cost_paid_cents / 100).toFixed(2) : '€ 0,00';
                    roomNotes.textContent = updatedRoom.comments;
                } else {
                    // Show error message
                    alert('Failed to update room: ' + (data.message || 'Unknown error'));
                }
            })
            .catch(error => {
                console.error('Error:', error);
                let errorMessage = 'An error occurred while updating the room';

                if (error.message.includes('422')) {
                    errorMessage = 'Validation error: Please check your input values';
                } else if (error.message.includes('404')) {
                    errorMessage = 'Room not found';
                } else if (error.message.includes('401') || error.message.includes('403')) {
                    errorMessage = 'You are not authorized to perform this action';
                } else if (error.message.includes('500')) {
                    errorMessage = 'Server error occurred. Please try again later';
                }

                alert(errorMessage);
            });
        }
    });
</script>
@section('content')
@if(Auth::check() && (Auth::user()->type_id == 1))
    <div style="background-color: #C2E5F2; min-height: calc(100vh - 120px); padding: 40px 20px;">
        <div class="max-w-6xl mx-auto">
            <!-- Main Content Grid -->
            <div class="grid grid-cols-1 lg:grid-cols-3 gap-6">
                <!-- Left Column - Room Selection & Price -->
                <div class="space-y-6">
                    <!-- Room Selection -->
                    <div style="background-color: #8EC8E4;" class="rounded-3xl p-6">
                        <h3 class="text-lg font-bold text-blue-900 mb-4">Room</h3>
                        <div class="bg-white rounded-2xl p-4">
                            <select name="btnRoom" id="room-selection" class="w-full bg-transparent text-blue-900 font-semibold text-center border-none outline-none cursor-pointer">
                                <option value="">--Please choose an option--</option>
                                @foreach($roomNumbers as $roomNumber)
                                    <option value="{{ $roomNumber->room_number }}">- room {{ $roomNumber->room_number }} -</option>
                                @endforeach
                            </select>
                        </div>
                    </div>

                    <!-- Price Input -->
                    <div style="background-color: #8EC8E4;" class=" bg-opacity-70 rounded-3xl p-6 ">
                        <h3 class="text-lg font-bold text-blue-900 mb-4">Price in €</h3>
                        <div class="bg-white rounded-2xl p-4">
                            <input type="text" id="room-price-input" class="w-full bg-transparent text-blue-900 font-semibold text-center border-none outline-none" placeholder="0,00" />
                        </div>
                    </div>
                </div>

                <!-- Right Column - Room Information -->
                <div class="lg:col-span-2">
                    <div style="background-color: #8EC8E4;" class="rounded-3xl p-6 h-full">
                        <div class="grid grid-cols-1 md:grid-cols-2 gap-x-8 gap-y-4 mb-6">
                            <!-- Left side info -->
                            <div class="space-y-3">
                                <div class="flex">
                                    <span class="font-bold text-blue-900 w-24">Roomtype:</span>
                                    <span id="room-type" class="text-blue-900 italic">*type of room*</span>
                                </div>
                                <div class="flex">
                                    <span class="font-bold text-blue-900 w-24">Capacity:</span>
                                    <span id="room-capacity" class="text-blue-900 italic">*Number of people*</span>
                                </div>
                                <div class="flex">
                                    <span class="font-bold text-blue-900 w-24">View:</span>
                                    <span id="room-view" class="text-blue-900 italic">*type of view*</span>
                                </div>
                                <div class="flex">
                                    <span class="font-bold text-blue-900 w-24">Bed:</span>
                                    <span id="room-bed" class="text-blue-900 italic">*type of bed*</span>
                                </div>
                                <div class="flex">
                                    <span class="font-bold text-blue-900 w-24">Baby bed:</span>
                                    <span id="room-babybed" class="text-blue-900 italic">*yes/no*</span>
                                </div>
                            </div>

                            <!-- Right side info -->
                            <div class="space-y-3">
                                <div class="flex">
                                    <span class="font-bold text-blue-900 w-32">Disabled room:</span>
                                    <span id="room-disabled" class="text-blue-900 italic">*yes or no*</span>
                                </div>
                                <div class="flex">
                                    <span class="font-bold text-blue-900 w-32">Price per night:</span>
                                    <span id="room-price" class="text-blue-900 italic">*price*</span>
                                </div>
                                <div class="flex">
                                    <span class="font-bold text-blue-900 w-32">Breakfast price (Adults):</span>
                                    <span id="room-breakfast-adults" class="text-blue-900 italic">*price*</span>
                                </div>
                                <div class="flex">
                                    <span class="font-bold text-blue-900 w-32">Breakfast price (Children):</span>
                                    <span id="room-breakfast-children" class="text-blue-900 italic">*price*</span>
                                </div>
                                <div class="flex">
                                    <span class="font-bold text-blue-900 w-32">Payment amount:</span>
                                    <span id="room-payment-amount" class="text-blue-900 italic">*price*</span>
                                </div>
                                <div class="flex">
                                    <span class="font-bold text-blue-900 w-32">Payment status:</span>
                                    <span class="text-blue-900 italic">*status*</span>
                                </div>
                            </div>
                        </div>

                        <!-- Notes Section -->
                        <div class="mt-6">
                            <h4 class="font-bold text-blue-900 mb-3">Notes:</h4>
                            <textarea id="room-notes-input" rows="4" class="w-full bg-white rounded-2xl p-4 border-none outline-none resize-none text-blue-900" placeholder="Enter notes here..."></textarea>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Action Buttons -->
            <div class="flex justify-center gap-6 mt-8">
                <button type="button" onclick="window.history.back()" class="bg-white text-blue-900 px-8 py-3 rounded-full font-bold text-lg hover:bg-gray-100 transition-colors">
                    Go back
                </button>
                <button type="button" id="updateRoomButton" class="bg-white text-blue-900 px-8 py-3 rounded-full font-bold text-lg hover:bg-gray-100 transition-colors">
                    Update Room
                </button>
            </div>
        </div>
    </div>
@elseif(Auth::check() && (Auth::user()->type_id != 1))
    <div style="background-color: #C2E5F2; min-height: calc(100vh - 120px); padding: 20px;">
        <div class="p-4 bg-red-100 border border-red-400 text-red-700 rounded">
            <p class="font-bold">Access Denied</p>
            <p>You do not have permission to access this page. Please contact an administrator if you believe this is an error.</p>
        </div>
    </div>
@endif
@endsection
