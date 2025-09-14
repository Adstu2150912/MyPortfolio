@extends('masteremployee', ['pageTitle' => 'Reception Reservation Overview'])
@push('additional-resources')
@vite(['resources/css/reservationsreception.css'])
@endpush

@section('content')
@if(Auth::check() && (Auth::user()->type_id == 1 || Auth::user()->type_id == 4))
<div id="reservations" class="bg-[#8ec8e4] p-5 rounded-2xl text-blue-950 overflow-auto">
    <div id="table-header" class="grid gap-3 text-center font-bold text-lg leading-6" style="grid-template-columns: 1.3fr 1.3fr 0.9fr 0.4fr 0.3fr 0.4fr 1.2fr 0.6fr 0.6fr">
        <div class="py-2 px-1">Date</div>
        <div class="py-2 px-1">Name</div>
        <div class="py-2 px-1">Booking nr.</div>
        <div class="py-2 px-1">Room<br>nr.</div>
        <div class="py-2 px-1">👤</div>
        <div class="py-2 px-1">Break-<br>fast</div>
        <div class="py-2 px-1">Comments</div>
        <div class="py-2 px-1">Paid<br>amount</div>
        <div class="py-2 px-1">Total<br>amount</div>
    </div>

    @foreach ($bookings as $booking)
        @php
            $isCheckedOut = $booking->room && $booking->room->status && $booking->room->status->status === 'Checked Out';
            $isCheckedIn = $booking->room && $booking->room->status && $booking->room->status->status === 'Checked In';
            
            // Set row classes based on status
            if ($isCheckedOut) {
                $rowClass = 'opacity-50 pointer-events-none';
                $cellClass = 'bg-gray-200 text-gray-500';
            } elseif ($isCheckedIn) {
                $rowClass = 'hover:opacity-90';
                $cellClass = 'bg-green-100 text-blue-950';
            } else {
                $rowClass = 'hover:opacity-90';
                $cellClass = 'bg-white';
            }
        @endphp
        <a href="{{ route('reception.booking.edit', ['id' => $booking->booking_number]) }}?from_reservations=1" class="booking-row grid gap-3 mb-3 text-center cursor-pointer {{ $rowClass }}" style="grid-template-columns: 1.3fr 1.3fr 0.9fr 0.4fr 0.3fr 0.4fr 1.2fr 0.6fr 0.6fr">
            <div class="{{ $cellClass }} py-2 px-1">{{ $booking->start_date }} / {{ $booking->end_date }}</div>
            <div class="{{ $cellClass }} py-2 px-1">{{ $booking->registeredGuest ? $booking->registeredGuest->name : 'No name available' }}</div>
            <div class="{{ $cellClass }} py-2 px-1">{{ $booking->booking_number }}</div>
            <div class="{{ $cellClass }} py-2 px-1">{{ $booking->room_number }}</div>
            <div class="{{ $cellClass }} py-2 px-1">{{ $booking->total_group_size }}</div>
            <div class="{{ $cellClass }} py-2 px-1">{{ $booking->includes_breakfast ? '✓' : '-' }}</div>
            <div class="{{ $cellClass }} py-2 px-1">
                @if($booking->children_below_4 > 0)
                <div class="inline">baby bed</div>
            @endif
            @if($booking->has_disability)
                @if($booking->children_below_4 > 0) <div class="inline">+</div> @endif
                <div class="inline">disability</div>
            @endif
            </div>
            <div class="{{ $cellClass }} py-2 px-1">€ {{ number_format($booking->total_cost_paid_cents / 100, 2, ',', '.') }}</div>
            <div class="{{ $cellClass }} py-2 px-1">€ {{ number_format($booking->total_cost_cents / 100, 2, ',', '.') }}</div>
        </a>
    @endforeach
</div>
<div id="create-booking" class="p-10 text-blue-950 font-bold text-right">
    <a href="{{ route('reception.booking') }}" class="bg-white py-3 px-7 rounded-lg text-lg inline-block">Create Booking</a>
</div>
@else
<div class="p-4 bg-red-100 border border-red-400 text-red-700 rounded">
    <p class="font-bold">Access Denied</p>
    <p>You do not have permission to access this page. Please contact an administrator if you believe this is an error.</p>
</div>
@endif
@endsection
