@extends('master')
@push('additional-resources')
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
    @vite(['resources/js/roomsoverview.js', 'resources/css/roomsoverview.css'])
@endpush
@section('content')
@foreach (['error' => 'red', 'success' => 'green'] as $type => $color)
    @if(session($type))
        <div id="{{ $type }}Popup" class="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 z-50">
            <div class="bg-white rounded-lg shadow-lg p-6 max-w-sm w-full">
                <h3 class="text-lg font-semibold mb-4 text-{{ $color }}-600">
                    @if(is_array(session($type)))
                        @foreach(session($type) as $line)
                            {{ $line }}<br>
                        @endforeach
                    @else
                        {{ session($type) }}
                    @endif
                </h3>
                <button data-popup-id="{{ $type }}Popup" class="closePopup mt-2 bg-{{ $color }}-600 hover:bg-{{ $color }}-700 text-white px-4 py-2 rounded">
                    {{ __('Close') }}
                </button>
            </div>
        </div>
    @endif
@endforeach
<script>
    document.addEventListener('DOMContentLoaded', function() {
        document.querySelectorAll('.closePopup').forEach(btn => {
            btn.addEventListener('click', () => {
                const id = btn.getAttribute('data-popup-id');
                document.getElementById(id)?.remove();
            });
        });
    });
</script>
<div class="date-picker">
    @php
        $defaultRange = $start_date . ' - ' . $end_date;
    @endphp
    <form method="get" action="{{ route('room.index') }}">
        <input type="text" name="daterange" value="{{ $defaultRange }}" />
    </form>
</div>
<div class="flex justify-center my-4">
    <button id="guest-selector-trigger" class="bg-white  text-[#022859] font-medium py-2 px-6 rounded-lg transition-colors duration-200 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2 shadow-lg">
        <span id="guest-summary">1 Adult, 0 Children, 0 Toddlers</span>
        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 inline-block ml-2" viewBox="0 0 20 20" fill="currentColor">
            <path fill-rule="evenodd" d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z" clip-rule="evenodd" />
        </svg>
    </button>
</div>

<div id="guest-selector-popup" class="fixed inset-0 z-50 items-center justify-center hidden">
    <div class="absolute inset-0 bg-black bg-opacity-50" id="guest-selector-overlay"></div>
    <div class="guest-selector-container bg-white rounded-lg shadow-lg p-6 max-w-md mx-auto relative z-10">
    <div class="text-center mb-6">
        <h3 class="text-xl font-bold text-gray-800 mb-1">Select Group Size</h3>
        <p class="text-sm text-gray-600">Maximum group size (excluding toddlers): 4</p>
    </div>
    <div class="space-y-6">
        <div class="flex items-center justify-between">
            <div>
                <div class="font-medium text-gray-700">Adults</div>
                <div class="text-xs text-gray-500">Age 10+</div>
            </div>
            <div class="flex items-center space-x-3">
                <button type="button" class="guest-btn minus" data-type="adults" disabled>
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd" />
                    </svg>
                </button>
                <span id="adults-count" class="w-8 text-center text-lg font-semibold">1</span>
                <input type="hidden" name="adults" id="adults-input" value="1">
                <button type="button" class="guest-btn plus" data-type="adults">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M10 3a1 1 0 011 1v5h5a1 1 0 110 2h-5v5a1 1 0 11-2 0v-5H4a1 1 0 110-2h5V4a1 1 0 011-1z" clip-rule="evenodd" />
                    </svg>
                </button>
            </div>
        </div>
        <div class="flex items-center justify-between">
            <div>
                <div class="font-medium text-gray-700">Children</div>
                <div class="text-xs text-gray-500">Ages 4-10</div>
            </div>
            <div class="flex items-center space-x-3">
                <button type="button" class="guest-btn minus" data-type="children" disabled>
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd" />
                    </svg>
                </button>
                <span id="children-count" class="w-8 text-center text-lg font-semibold">0</span>
                <input type="hidden" name="children" id="children-input" value="0">
                <button type="button" class="guest-btn plus" data-type="children">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M10 3a1 1 0 011 1v5h5a1 1 0 110 2h-5v5a1 1 0 11-2 0v-5H4a1 1 0 110-2h5V4a1 1 0 011-1z" clip-rule="evenodd" />
                    </svg>
                </button>
            </div>
        </div>
        <div class="flex items-center justify-between">
            <div>
                <div class="font-medium text-gray-700">Toddlers</div>
                <div class="text-xs text-gray-500">Ages 0-3</div>
            </div>
            <div class="flex items-center space-x-3">
                <button type="button" class="guest-btn minus" data-type="toddlers" disabled>
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd" />
                    </svg>
                </button>
                <span id="toddlers-count" class="w-8 text-center text-lg font-semibold">0</span>
                <input type="hidden" name="toddlers" id="toddlers-input" value="0">
                <button type="button" class="guest-btn plus" data-type="toddlers">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M10 3a1 1 0 011 1v5h5a1 1 0 110 2h-5v5a1 1 0 11-2 0v-5H4a1 1 0 110-2h5V4a1 1 0 011-1z" clip-rule="evenodd" />
                    </svg>
                </button>
            </div>
        </div>
        <div class="pt-2 flex space-x-4">
            <button type="button" id="close-guest-selector" class="w-1/2 bg-gray-300 text-[#022859] font-medium py-2 px-6 rounded-lg transition-colors duration-200 focus:outline-none focus:ring-2 focus:ring-gray-500 focus:ring-offset-2">
                Cancel
            </button>
            <button type="button" id="update-guests" class="w-1/2 bg-[#8ec8e4] text-[#022859] font-medium py-2 px-6 rounded-lg transition-colors duration-200 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2">
                Apply
            </button>
        </div>
    </div>
    </div>
</div>
<div class="flex flex-col md:flex-row justify-around items-start">
    <div class="p-5 rounded-3xl bg-blue-100 w-1/3 mr-4 sticky-filter" style="background-color: #8EC8E4;">
        <h1 class="text-2xl text-blue-950 font-bold mb-4">Filters</h1>
        <div>
            <h2 class="font-bold">Room type</h2>
            <div class="space-y-2">
                <div>
                    <input type="radio" name="room_type" value="0" id="room_type_all" checked>
                    <label for="room_type_all">All room types</label>
                </div>
                <div>
                    <input type="radio" name="room_type" value="1" id="room_type_economy">
                    <label for="room_type_economy">Economy</label>
                </div>
                <div>
                    <input type="radio" name="room_type" value="2" id="room_type_standard">
                    <label for="room_type_standard">Standard</label>
                </div>
                <div>
                    <input type="radio" name="room_type" value="3" id="room_type_luxurious">
                    <label for="room_type_luxurious">Luxurious</label>
                </div>
            </div>
        </div>
        <br>
        <div>
            <h2 class="font-bold">View</h2>
            <div class="space-y-2">
                <div>
                    <input type="radio" name="view" value="0" id="view_any" checked>
                    <label for="view_any">Any view</label>
                </div>
                <div>
                    <input type="radio" name="view" value="Standard" id="view_standard">
                    <label for="view_standard">Standard</label>
                </div>
                <div>
                    <input type="radio" name="view" value="Mountain" id="view_mountain">
                    <label for="view_mountain">Mountain</label>
                </div>
                <div>
                    <input type="radio" name="view" value="Lake" id="view_lake">
                    <label for="view_lake">Lake</label>
                </div>
            </div>
        </div>
        <br>
        <div>
            <h2 class="font-bold">Bed</h2>
            <div class="space-y-2">
                <div>
                    <input type="checkbox" name="single" value="true" id="bed_single">
                    <label for="bed_single">Single</label>
                </div>
                <div>
                    <input type="checkbox" name="double" value="true" id="bed_double">
                    <label for="bed_double">Double</label>
                </div>
            </div>
        </div>
        <br>
        <div>
            <h2 class="font-bold">Disability</h2>
            <input type="checkbox" name="accessible" value="1"></input>
            <label for="accessible">Disability Friendly</label>
        </div>
    </div>
    @if ($rooms == null || count($rooms) == 0)
        <p>No rooms are available matching your selected criteria</p>
    @endif
    <div class="flex flex-col space-y-6">
    @foreach ($rooms as $room)
    <div class="room-overview flex flex-row  bg-white rounded-lg shadow-md overflow-hidden">
        <div class="w-1/3">
            @if($room->view == 'Lake')
                <img src="{{ asset('images/lake-view.jpg') }}" alt="Lake view" class="w-full h-full object-cover">
            @elseif($room->view == 'Mountain')
                <img src="{{ asset('images/mountain-view.webp') }}" alt="Mountain view" class="w-full h-full object-cover">
            @elseif($room->view == 'Standard')
                <img src="{{ asset('images/standard-view.jpeg') }}" alt="Standard view" class="w-full h-full object-cover">
            @endif
        </div>
        <div id="room-listings" class="w-2/3 bg-[#8ec8e4] text-[#022859] p-4 rounded-r-lg">
            <p class="text-2xl font-bold"> {{ $room->type->type }}</p>
            <p class="font-bold"> {{ $room->type->description}}</p>
            <p> {{ $room->view }} view</p>
            <p> {{ $room->capacity }} people </p>
            <p></p>
            @if($room->babybed == 1)
                <p>Has baby bed capacity</p>
            @endif
            @if($room->for_disabled == 1)
                <p>Is disabled friendly</p>
            @endif
            <p>&#128;  {{number_format((float) str_replace(',', '', $room->price_cents), 0, '', '.')}} per night</p>
            <ul>
                @foreach($room->bedTypes as $bedType)
                    <li> {{ $bedType->amount }} {{ $bedType->type }} </li>
                @endforeach
            </ul>
            @php
                $bedTypeParams = [];
                foreach($room->bedTypes as $bedType) {
                    $bedTypeParams['bed_type_' . $bedType->id] = $bedType->amount;
                }
            @endphp
            <br>
            <a href="{{ route('room.show', array_merge([
                'type' => $room->type->id,
                'view' => $room->view,
                'capacity' => $room->capacity,
                'babybed' => $room->babybed,
                'for_disabled' => $room->for_disabled,
                'price' => preg_replace('/[^\d]/', '', $room->price_cents),
                'start_date' => $start_date,
                'end_date' => $end_date,
                'adults' => $adults,
                'children' => $children,
                'toddlers' => $toddlers,
                ], $bedTypeParams)) }}"
                class="bg-white hover:bg-gray-100 text-gray-800 font-semibold py-2 px-4 border rounded shadow mt-4 justify-self-end">
                View room
            </a>
        </div>
    </div>
    @endforeach
    </div>
</div>
<br>
<br>
@endsection
