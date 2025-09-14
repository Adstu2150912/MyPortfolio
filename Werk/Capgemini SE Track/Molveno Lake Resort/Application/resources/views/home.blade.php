@extends('master')
@section('content')
@foreach (['error' => 'red', 'success' => 'green'] as $type => $color)
    @if(session($type))
        <div id="{{ $type }}Popup" class="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 z-50">
            <div class="bg-white rounded-lg shadow-lg p-6 max-w-sm w-full">
                <h3 class="text-lg font-semibold mb-4 text-{{ $color }}-600">{{ session($type)['title'] }}</h3>
                <p class="mb-4">{{ __('Booking number:') }} <strong>{{ session($type)['number'] }}</strong></p>
                <button data-popup-id="{{ $type }}Popup" class="closePopup mt-2 text-white font-bold px-4 py-2 rounded shadow-md {{ $type === 'success' ? 'bg-green-600 hover:bg-green-700' : 'bg-red-600 hover:bg-red-700' }}">
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
<div id="welcome" class="text-center pt-4">
    <h2 class="font-medium text-2xl mb-1 text-blue-950">Welcome to Molveno Lake Resort!</h2>
    <h2 class="font-light text-lg mb-4 text-blue-950">To make a booking, go to Rooms and select a listing</h2>
</div>

<div id="images-left" class="py-5 relative flex justify-center">
    <img src="{{ asset('images/lakeview.webp') }}" alt="Hotel Image" class="w-1/2 max-w-md h-80 object-cover rounded-2xl shadow-lg z-10 relative">
    <img src="{{ asset('images/hotel.png') }}" alt="Lake View Image" class="w-1/2 max-w-md h-80 object-cover rounded-2xl shadow-lg -ml-20 mt-28 mb-10 relative z-20">
</div>
@endsection
