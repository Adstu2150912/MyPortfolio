@extends('master')
@push('additional-resources')
@vite(['resources/js/detail.js', 'resources/js/guest-country-selection.js'])
@endpush
@section('content')
@section('body-class', 'detail-page')
@if ($errors->any())
    <div class="mb-4 mt-4 p-3 bg-red-100 text-red-700 rounded">
        <ul class="list-disc pl-5">
            @foreach ($errors->all() as $error)
                <li>{{ $error }}</li>
            @endforeach
        </ul>
    </div>
@endif
<div id="placeholders" class="grid grid-cols-11 grid-rows-2 gap-3 mx-auto py-4 w-full h-[32vw]">
    <img src="{{ asset('images/detailplaceholder1.png') }}" alt="Placeholder Image" class="w-full h-full row-span-2 col-span-4 object-cover rounded-lg">
    <div class="contents col-span-7">
        <img src="{{ asset('images/detailplaceholder2.png') }}" alt="Placeholder Image" class="w-full h-full col-span-4 object-cover rounded-lg">
        <img src="{{ asset('images/detailplaceholder3.png') }}" alt="Placeholder Image" class="w-full h-full col-span-3 object-cover rounded-lg">
        <img src="{{ asset('images/detailplaceholder4.png') }}" alt="Placeholder Image" class="w-full h-full col-span-4 object-cover rounded-lg">
        <img src="{{ asset('images/detailplaceholder5.png') }}" alt="Placeholder Image" class="w-full h-full col-span-3 object-cover rounded-lg">
    </div>
</div>
<h1 class="text-blue-950 font-bold mb-4 text-2xl"> {{ $room->type->type }} Room</h1>
<p class="text-xl text-blue-950 font-bold mb-2"> {{ $room->view }} View</p>
<p class="text-blue-950">Relax and recharge in this spacious, well-equipped hotel room overlooking Lake Molveno. With a private balcony, you'll have your own quiet spot to enjoy the fresh mountain air and beautiful lake views.
The room includes one comfortable double bed and two single beds, making it ideal for couples or families. The room features a spacious private bathroom, and a baby bed can be added on request to suit your needs.
Guests also have access to the hotel's swimming pool—a great way to unwind after a day of exploring the area. Simple, thoughtful comfort in a stunning natural setting.</p>
<div id="facilities-img" class="grid grid-cols-10 items-stretch my-8 gap-6">
    <div id="facilities" class="col-span-4 p-6 rounded-3xl" style="background-color: #8EC8E4;">
        <h3 class="text-center text-xl text-blue-950 font-bold mb-2">Facilities</h3>
        <hr class="border-0.5 border-blue-950 opacity-50 py-2 -mx-6">
        <div class="grid grid-cols-2 gap-4">
            <div>
                <h4 class="text-md text-blue-950 font-bold mb-2">Room</h4>
                <ul class="list-disc pl-4 mb-4 text-sm font-bold text-blue-950">
                    @foreach($room->bedTypes as $bedType)
                        <li> {{ $bedType->pivot->amount }} {{ $bedType->type }} bed(s)</li>
                    @endforeach
                    @php
                    $bedTypeParams = [];
                    foreach($room->bedTypes as $bedType) {
                        $bedTypeParams['bed_type_' . $bedType->id] = $bedType->amount;
                    }
                @endphp
                    <li>Private balcony</li>
                    <li>Free Wi-Fi</li>
                    <li>Air Conditioning</li>
                    <li>Flat-screen TV</li>
                </ul>
            </div>
            <div>
                <h4 class="text-md text-blue-950 font-bold mb-2">Private Bathroom</h4>
                <ul class="list-disc pl-4 mb-4 text-sm font-semibold text-blue-950">
                    <li>Shower</li>
                    <li>Toilet</li>
                    <li>Sink</li>
                    <li>Hairdryer</li>
                    <li>Complimentary toiletries</li>
                </ul>
            </div>
            <div>
                <h4 class="text-md text-blue-950 font-semibold mb-2">Hotel</h4>
                <ul class="list-disc pl-4 mb-4 text-sm font-semibold text-blue-950">
                    <li>Swimming pool</li>
                    <li>Restaurant</li>
                    <li>Free parking</li>
                    <li>Laundry service</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="col-span-6 h-full">
        <img id="separate-img" src="{{ asset('images/detailplaceholder1.png') }}" alt="Room Image" class="w-full h-full rounded-3xl object-cover">
    </div>
</div>
<div id="date-type-breakfast-price" class="grid grid-cols-2 gap-8 mt-8">
    <div id="date-type-breakfast" class="col-span-1 space-y-8">
        <div id="date" class="text-blue-950 p-4 rounded-3xl text-center" style="background-color: #8EC8E4;">
            <p class="font-bold">{{ $start_date }}</p>
            <p class="font-bold">–</p>
            <p class="font-bold">{{ $end_date }}</p>
            <p class="font-bold">{{ $duration }} nights</p>
        </div>
        <div id="room-type" class="text-blue-950 p-4 rounded-3xl font-bold text-center" style="background-color: #8EC8E4;">
            <p>Can fit up to {{ $room->capacity }} people (excluding baby beds)</p>
            @if($room->babybed == 1)
                <p>Baby bed capacity</p>
            @endif
            @if($room->for_disabled == 1)
                <p>Is disabled friendly</p>
            @endif
            <p>{{ $room->type->type }} room, {{ $room->view }} view</p>
        </div>
        <div id="breakfast-options" class="p-4 rounded-3xl text-center" style="background-color: #8EC8E4;">
            <div class="flex items-center gap-2 mb-1 justify-center">
                <label for="breakfast" class="text-blue-950 font-bold">Include breakfast</label>
                <input type="checkbox" id="breakfast" name="breakfast" value="breakfast" class="w-4 h-4 border-gray-300" checked>
            </div>
            <p class="text-blue-950 text-xs text-opacity-60">Adult: €17,50 | Child: €10,00</p>
        </div>
    </div>
<div id="price-and-booking" class="w-[28vw] relative left-[4vw] mb-12 pb-20">
    <div id="price-estimation" class="text-blue-950 h-[18rem] px-8 pt-8 pb-6 rounded-[2.5rem] mt-4 relative z-10" style="background-color: #8EC8E4;">
        <div id="room_rate_segment" class="mb-6 grid grid-cols-12 items-center">
            <div class="col-span-4">
                @if($duration==1)
                    <p class="font-bold text-lg">{{$duration}} night</p>
                @elseif($duration>1)
                    <p class="font-bold text-lg">{{$duration}} nights</p>
                @endif
            </div>
            <div class="col-span-4">
                <p class="text-blue-950 text-opacity-60 text-sm whitespace-nowrap">&euro;{{number_format($room->price_cents,$room->price_cents==floor($room->price_cents)?0:2)}} * {{$duration}}</p>
            </div>
            <div class="col-span-4">
                <p class="font-bold text-lg">&euro;{{$formattedStayPrice}}</p>
            </div>
        </div>
        <div id="breakfast_rates_segment" class="mb-6">
            <div class="grid grid-cols-12 items-center">
                <div class="col-span-4 row-span-2 self-start">
                    <p class="font-bold text-lg">Breakfast</p>
                </div>
                @if($adults>0)
                    <div class="col-span-4">
                        <p class="text-blue-950 text-opacity-60 text-sm whitespace-nowrap">&euro;17.50 * {{$adults}} * {{$duration}}</p>
                    </div>
                    <div class="col-span-4">
                        <p class="font-bold text-lg">&euro;{{$formattedBreakfastPriceAdult}}</p>
                    </div>
                @endif
                @if($children>0)
                    <div class="col-span-4">
                        <p class="text-blue-950 text-opacity-60 text-sm whitespace-nowrap">&euro;10 * {{$children}} * {{$duration}}</p>
                    </div>
                    <div class="col-span-4">
                        <p class="font-bold text-lg">&euro;{{$formattedBreakfastPriceChild}}</p>
                    </div>
                @endif
            </div>
        </div>
        @if($room->babybed==1)
            <div id="baby_bed_segment" class="mb-6 grid grid-cols-12 items-center">
                <div class="col-span-4">
                    <p class="font-bold text-lg">Baby bed</p>
                </div>
                <div class="col-span-4"></div>
                <div class="col-span-4">
                    <p class="font-bold text-lg">&euro;0</p>
                </div>
            </div>
        @endif
        <div id="total_price_segment" class="grid grid-cols-12 mt-6 pt-3">
            <div class="col-span-8">
                <p class="font-bold text-xl">Total price:</p>
            </div>
            <div class="col-span-4">
                <p id="total_price_value" class="font-bold text-xl">&euro;{{$formattedTotalPrice}}</p>
            </div>
        </div>
    </div>
    <!-- Hidden price data for JS-driven updates -->
    <div id="price_data" data-total-with-breakfast="{{$formattedTotalPrice}}" data-total-without-breakfast="{{$formattedStayPrice}}" style="display:none"></div>
    <div id="book" class="absolute bottom-3 w-full">
        <button id="book-now-btn" class="bg-white text-blue-950 rounded-[2.5rem] font-bold text-2xl w-full pb-5 pt-28 tracking-wide">BOOK NOW</button>
    </div>
</div>
<div id="auth-modal" class="fixed inset-0 bg-black bg-opacity-50 items-center justify-center hidden z-50">
    @if(Auth::check())
        <form id="auth-booking-form" method="GET" action="{{ route('booking.create') }}" class="bg-white rounded-lg p-6 w-full max-w-md mx-4 space-y-4">
            <div class="flex justify-between items-center mb-2">
                <h3 class="text-xl font-bold text-gray-800">Booking Confirmation</h3>
                <button type="button" id="close-auth-modal" class="text-gray-500 hover:text-gray-700">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
                    </svg>
                </button>
            </div>
            <p class="text-gray-600 mb-4">Please confirm your booking details.</p>
            
            @if($room->for_disabled == 1)
            <div class="flex items-center mb-4">
                <input type="checkbox" id="has-disability-auth" name="has_disability" value="1"
                       class="h-4 w-4 text-blue-600 focus:ring-blue-500">
                <label for="has-disability-auth" class="ml-2 block text-sm text-gray-700">
                    I require disability-friendly accommodations
                </label>
            </div>
            @endif
            
            <div class="border-t border-gray-200 pt-4 mb-4">
                <h4 class="font-medium text-gray-800 mb-3">Payment Options</h4>
                <p class="text-gray-600 mb-2">Total Price: <span id="auth_total_price_value" class="font-bold">&euro;{{$formattedTotalPrice}}</span></p>
                
                <div class="space-y-2">
                    <div class="flex items-center">
                        <input type="radio" id="pay-now-auth" name="payment_option" value="now" checked
                               class="h-4 w-4 text-blue-600 focus:ring-blue-500">
                        <label for="pay-now-auth" class="ml-2 block text-sm text-gray-700">
                            Pay now online
                        </label>
                    </div>
                    <div class="flex items-center">
                        <input type="radio" id="pay-hotel-auth" name="payment_option" value="hotel"
                               class="h-4 w-4 text-blue-600 focus:ring-blue-500">
                        <label for="pay-hotel-auth" class="ml-2 block text-sm text-gray-700">
                            Pay at hotel during check-out
                        </label>
                    </div>
                </div>
            </div>
            
            {{-- Required booking parameters --}}
            <input type="hidden" name="user" value="{{ Auth::user()->id }}">
            <input type="hidden" name="view" value="{{ request('view', $room->view ?? '') }}">
            <input type="hidden" name="capacity" value="{{ request('capacity', $room->capacity ?? '') }}">
            <input type="hidden" name="babybed" value="{{ request('babybed', $room->babybed ?? '') }}">
            <input type="hidden" name="for_disabled" value="{{ request('for_disabled', $room->for_disabled ?? '') }}">
            <input type="hidden" name="price" value="{{ request('price', $room->price_cents ?? '') }}">
            <input type="hidden" name="start_date" value="{{ request('start_date') }}">
            <input type="hidden" name="end_date" value="{{ request('end_date') }}">
            <input type="hidden" name="adults" value="{{ request('adults', $adults ?? 2) }}">
            <input type="hidden" name="children" value="{{ request('children', $children ?? 0) }}">
            <input type="hidden" name="toddlers" value="{{ request('toddlers', $toddlers ?? 0) }}">
            <input type="hidden" id="includes_breakfast_auth" name="includes_breakfast" value="1">
            <input type="hidden" name="total_price" value="{{$formattedTotalPrice}}">
            {{-- Bed type parameters --}}
            @foreach(request()->all() as $key => $value)
                @if(Str::startsWith($key, 'bed_type_'))
                    <input type="hidden" name="{{ $key }}" value="{{ $value }}">
                @endif
            @endforeach
            <button type="submit" id="confirm-booking" class="w-full bg-blue-600 text-white py-2 px-4 rounded-md hover:bg-blue-700 transition-colors">
                Book Now
            </button>
        </form>
    @else
        <div class="bg-white rounded-lg p-6 w-full max-w-md mx-4">
            <div class="flex justify-between items-center mb-4">
                <h3 class="text-xl font-bold text-gray-800">Continue to Booking</h3>
                <button id="close-modal" class="text-gray-500 hover:text-gray-700">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
                    </svg>
                </button>
            </div>

            <div class="space-y-4">
                <div class="border border-gray-200 rounded-lg p-4">
                    <h4 class="font-medium text-gray-700 mb-3">Already have an account?</h4>
                    <form method="POST" action="{{ route('login') }}" class="space-y-3">
                            <input type="hidden" name="redirect_to" value="{{ url()->full() }}">
                        @csrf
                        <div>
                            <input type="email" name="email" required
                                class="w-full px-3 py-2 border border-gray-300 rounded-md"
                                placeholder="Email Address">
                        </div>
                        <div>
                            <input type="password" name="password" required
                                class="w-full px-3 py-2 border border-gray-300 rounded-md"
                                placeholder="Password">
                        </div>
                        <div class="flex items-center justify-between">
                            <label class="flex items-center text-sm text-gray-600">
                                <input type="checkbox" name="remember" class="rounded border-gray-300 text-blue-600 shadow-sm focus:border-blue-300 focus:ring focus:ring-blue-200 focus:ring-opacity-50">
                                <span class="ml-2">Remember me</span>
                            </label>
                            @if (Route::has('password.request'))
                                <a href="{{ route('password.request') }}" class="text-sm text-blue-600 hover:underline">
                                    Forgot password?
                                </a>
                            @endif
                        </div>
                        <button type="submit" class="w-full bg-blue-600 text-white py-2 px-4 rounded-md hover:bg-blue-700 transition-colors">
                            Sign In
                        </button>
                    </form>
                </div>

                <div class="text-center">
                    <p class="text-gray-600">Don't have an account?
                        <a href="{{ route('register', ['redirect_to'=>url()->full()]) }}" class="text-blue-600 font-medium hover:underline">
                            Create one
                        </a>
                    </p>
                </div>

                <div class="pt-2">
                    <button id="continue-guest" class="w-full bg-gray-100 text-gray-700 py-2 px-4 rounded-md hover:bg-gray-200 transition-colors">
                        Continue as Guest
                    </button>
                </div>
            </div>
        </div>
    @endif
</div>
<div id="guest-info-modal" class="fixed inset-0 bg-black bg-opacity-50 items-center justify-center hidden z-50">
    <div class="bg-white rounded-lg p-6 w-full max-w-3xl mx-4 overflow-y-auto max-h-[90vh]">
        <div class="flex justify-between items-center mb-4">
            <h3 class="text-lg font-semibold text-gray-800">Guest Information</h3>
            <button id="close-guest-modal" class="text-gray-500 hover:text-gray-700">
                <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12"></path>
                </svg>
            </button>
        </div>        
        <form id="guest-info-form" method="POST" action="{{ route('registerTempAccount') }}">
            @csrf
            <input type="hidden" name="room_type" value="{{ request('type', $room->room_type_id ?? '') }}">
            <input type="hidden" name="view" value="{{ request('view', $room->view ?? '') }}">
            <input type="hidden" name="capacity" value="{{ request('capacity', $room->capacity ?? '') }}">
            <input type="hidden" name="babybed" value="{{ request('babybed', $room->babybed ?? '') }}">
            <input type="hidden" name="for_disabled" value="{{ request('for_disabled', $room->for_disabled ?? '') }}">
            <input type="hidden" name="price" value="{{ request('price', $room->price_cents ?? '') }}">
            <input type="hidden" name="start_date" value="{{ request('start_date', $start_date ?? '') }}">
            <input type="hidden" name="end_date" value="{{ request('end_date', $end_date ?? '') }}">
            <input type="hidden" name="adults" id="adults-form" value="{{ request('adults', $adults ?? 2) }}">
            <input type="hidden" name="children" id="children-form" value="{{ request('children', $children ?? 0) }}">
            <input type="hidden" name="toddlers" id="toddlers-form" value="{{ request('toddlers', $toddlers ?? 0) }}">

            <input type="hidden" name="includes_breakfast" id="breakfast-form" value="1">
            <input type="hidden" name="payment_option" id="payment-option-form" value="now">
            <input type="hidden" name="has_disability" id="disability-form" value="0">
            @foreach(request()->all() as $key => $value)
                @if(Str::startsWith($key, 'bed_type_'))
                    <input type="hidden" name="{{ $key }}" value="{{ $value }}">
                @endif
            @endforeach
            
            <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
                <!-- Left Column -->
                <div class="space-y-4">
                    <div>
                        <label for="guest-first-name" class="block text-sm font-medium text-gray-700 mb-1">First Name</label>
                        <input type="text" id="guest-first-name" name="first_name" required maxlength="50"
                            class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
                    </div>

                    <div>
                        <label for="guest-last-name" class="block text-sm font-medium text-gray-700 mb-1">Last Name</label>
                        <input type="text" id="guest-last-name" name="last_name" required maxlength="50"
                            class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
                        <!-- Hidden full name field -->
                        <input type="hidden" id="guest-full-name" name="name" value="">
                    </div>

                    <div>
                        <label for="guest-email" class="block text-sm font-medium text-gray-700 mb-1">Email</label>
                        <input type="email" id="guest-email" name="email" required maxlength="255"
                            class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
                    </div>

                    <!-- Phone Number with Country Code -->
                    <div>
                        <label for="guest-phone" class="block text-sm font-medium text-gray-700 mb-1">Phone Number</label>
                        <div class="flex flex-col">
                            <div class="flex">
                                <select name="country_code_select" id="guest-country-code" 
                                    class="rounded-l-md border-gray-300 focus:border-blue-500 focus:ring-blue-500" style="width: 120px">
                                    <option value="+1">+1 (US/CA)</option>
                                    <option value="+31">+31 (NL)</option>
                                    <option value="+32">+32 (BE)</option>
                                    <option value="+33">+33 (FR)</option>
                                    <option value="+34">+34 (ES)</option>
                                    <option value="+39">+39 (IT)</option>
                                    <option value="+41">+41 (CH)</option>
                                    <option value="+43">+43 (AT)</option>
                                    <option value="+44">+44 (GB)</option>
                                    <option value="+45">+45 (DK)</option>
                                    <option value="+46">+46 (SE)</option>
                                    <option value="+47">+47 (NO)</option>
                                    <option value="+48">+48 (PL)</option>
                                    <option value="+49">+49 (DE)</option>
                                    <option value="custom">Other</option>
                                </select>
                                <input type="tel" id="guest-phone" name="phone_number" required pattern="[0-9]{7,15}" minlength="7" maxlength="15" inputmode="numeric"
                                    class="w-full px-3 py-2 border border-gray-300 rounded-r-md focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="123456789">
                            </div>
                            
                            <!-- Custom country code input -->
                            <div id="guest_custom_country_code_div" class="mt-2" style="display: none">
                                <label for="guest_custom_country_code" class="block text-sm font-medium text-gray-700 mb-1">Enter country code (with + symbol)</label>
                                <input type="text" id="guest_custom_country_code" name="custom_country_code" 
                                    class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
                                    placeholder="+123" pattern="\+[0-9]{1,4}" title="Country code must start with + followed by 1-4 digits">
                            </div>
                            
                            <!-- Hidden field to store the actual country code value -->
                            <input type="hidden" id="guest_country_code" name="country_code" value="+31">
                        </div>
                    </div>

                    <div>
                        <label for="guest-dob" class="block text-sm font-medium text-gray-700 mb-1">Date of Birth (Must be 18+)</label>
                        <input type="date" id="guest-dob" name="date_of_birth" required
                            min="{{ now()->subYears(120)->format('Y-m-d') }}"
                            max="{{ now()->subYears(18)->format('Y-m-d') }}"
                            class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
                        <p class="text-xs text-gray-500 mt-1">You must be at least 18 years old to book</p>
                    </div>
                </div>

                <!-- Right Column -->
                <div class="space-y-4">
                    <div>
                        <label for="guest-street" class="block text-sm font-medium text-gray-700 mb-1">Street Address</label>
                        <input type="text" id="guest-street" name="street" required maxlength="255"
                            class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="Street name and number">
                    </div>

                    <div class="flex space-x-2">
                        <div class="w-1/2">
                            <label for="guest-postal" class="block text-sm font-medium text-gray-700 mb-1">Postal Code</label>
                            <input type="text" id="guest-postal" name="postal_code" required maxlength="10"
                                class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="1234 AB">
                        </div>
                        <div class="w-1/2">
                            <label for="guest-city" class="block text-sm font-medium text-gray-700 mb-1">City</label>
                            <input type="text" id="guest-city" name="city" required maxlength="100"
                                class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
                        </div>
                    </div>

                    <div class="country-selection">
                        <label for="guest-country-select" class="block text-sm font-medium text-gray-700 mb-1">Country</label>
                        <select id="guest-country-select" name="country_select" required
                            class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
                            <option value="" disabled selected>Select your country</option>
                            <option value="Netherlands">Netherlands</option>
                            <option value="Belgium">Belgium</option>
                            <option value="Germany">Germany</option>
                            <option value="France">France</option>
                            <option value="United Kingdom">United Kingdom</option>
                            <option value="Spain">Spain</option>
                            <option value="Italy">Italy</option>
                            <option value="Switzerland">Switzerland</option>
                            <option value="Austria">Austria</option>
                            <option value="Denmark">Denmark</option>
                            <option value="Sweden">Sweden</option>
                            <option value="Norway">Norway</option>
                            <option value="Finland">Finland</option>
                            <option value="Portugal">Portugal</option>
                            <option value="Ireland">Ireland</option>
                            <option value="United States">United States</option>
                            <option value="Canada">Canada</option>
                            <option value="other">Other (specify)</option>
                        </select>
                        
                        <div id="guest_custom_country_div" class="mt-2" style="display: none">
                            <label for="guest_custom_country" class="block text-sm font-medium text-gray-700 mb-1">Enter your country</label>
                            <input type="text" id="guest_custom_country" name="custom_country" 
                                class="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
                        </div>
                        
                        <!-- Hidden field to store the actual country value -->
                        <input type="hidden" id="guest_country" name="country" value="">
                    </div>

                    <!-- Price Calculation -->
                    <div class="bg-gray-50 p-4 rounded-md mt-2">
                        <h4 class="font-medium text-gray-800 mb-2">Booking Summary</h4>
                        <p class="text-sm text-gray-600">Room: {{ $room->name ?? 'Selected Room' }}</p>
                        <p class="text-sm text-gray-600">Dates: {{ request('start_date') }} to {{ request('end_date') }}</p>
                        <p class="text-sm text-gray-600">Guests: {{ request('adults', $adults ?? 2) }} adults, {{ request('children', $children ?? 0) }} children, {{ request('toddlers', $toddlers ?? 0) }} toddlers</p>
                        <p class="font-bold text-gray-800 mt-2">Total Price: &euro;{{$formattedTotalPrice}}</p>
                    </div>
                </div>
            </div>

            @if($room->for_disabled == 1)
            <div class="border-t border-gray-200 pt-4 mt-4">
                <h4 class="font-medium text-gray-800 mb-3">Accessibility</h4>
                <div class="flex items-center mb-4">
                    <input type="checkbox" id="has-disability-guest" name="has_disability_guest" value="1"
                           class="h-4 w-4 text-blue-600 focus:ring-blue-500">
                    <label for="has-disability-guest" class="ml-2 block text-sm text-gray-700">
                        I require disability-friendly accommodations
                    </label>
                </div>
            </div>
            @endif
            
            <div class="border-t border-gray-200 pt-4 mt-4">
                <h4 class="font-medium text-gray-800 mb-3">Payment Options</h4>
                <p class="text-gray-600 mb-2">Total Price: <span id="guest_total_price_value" class="font-bold">&euro;{{$formattedTotalPrice}}</span></p>
                
                <div class="space-y-2">
                    <div class="flex items-center">
                        <input type="radio" id="pay-now" name="payment_option_radio" value="now" checked
                               class="h-4 w-4 text-blue-600 focus:ring-blue-500">
                        <label for="pay-now" class="ml-2 block text-sm text-gray-700">
                            Pay now online
                        </label>
                    </div>
                    <div class="flex items-center">
                        <input type="radio" id="pay-hotel" name="payment_option_radio" value="hotel"
                               class="h-4 w-4 text-blue-600 focus:ring-blue-500">
                        <label for="pay-hotel" class="ml-2 block text-sm text-gray-700">
                            Pay at hotel during check-out
                        </label>
                    </div>
                </div>
                <input type="hidden" name="total_price" value="{{$formattedTotalPrice}}">
            </div>

            <div class="pt-4">
                <button type="submit" class="w-full bg-blue-600 text-white py-2 px-4 rounded-md hover:bg-blue-700 transition-colors">
                    Book Now
                </button>
            </div>
        </form>
    </div>
</div>
@endsection
