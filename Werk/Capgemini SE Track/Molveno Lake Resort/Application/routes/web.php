<?php

use App\Http\Controllers\ProfileController;
use App\Http\Controllers\RoomController;
use App\Http\Controllers\BookingController;
use App\Http\Controllers\ReceptionBookingController;
use App\Http\Controllers\Auth\RegisteredUserController;
use Illuminate\Support\Facades\Route;
use Illuminate\Http\Request;

Route::get('/dashboard', [BookingController::class, 'index'])
    ->middleware(['auth', 'verified'])
    ->name('dashboard');

Route::middleware('auth')->group(function () {
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');
});

Route::redirect('/home', '/');

Route::get('/', function () {
    return view('home', []);
})->name('home');

Route::get('/roomsoverview', function (Request $request) {
    if (!$request->has(['start_date', 'end_date'])) {
        $start = now()->addDays(1)->format('d/m/Y');
        $end = now()->addDays(8)->format('d/m/Y');

        $params = [
            'start_date' => $start,
            'end_date' => $end,
            'adults' => $request->get('adults'),
            'children' => $request->get('children'),
            'toddlers' => $request->get('toddlers'),
        ];

        return Redirect::route('room.index', $params);
    }

    return app(RoomController::class)->index($request);
})->name('room.index');

Route::get('/detail', [RoomController::class, 'show'])->name('room.show');

Route::get('/room/initiate-booking', [RoomController::class, 'initiateBooking'])->name('room.initiateBooking');

Route::get('/booking', [BookingController::class, 'create'])->name('booking.create');

Route::post('register-temp-account', [RegisteredUserController::class, 'storeTempAccount'])
    ->name('registerTempAccount');

// Rest of the routes with middleware
Route::middleware(['auth'])->group(function () {
    Route::get('/reception/reservations', [ReceptionBookingController::class, 'index'])
    ->name('reception.reservations');

    // Create new booking
    Route::get('/reception/booking', [ReceptionBookingController::class, 'create'])
        ->name('reception.booking');
    Route::post('/reception/booking', [ReceptionBookingController::class, 'store'])
        ->name('reception.booking.store');

    // Edit existing booking
    Route::get('/reception/booking/{id}', [ReceptionBookingController::class, 'edit'])
        ->name('reception.booking.edit');
    Route::put('/reception/booking/{id}', [ReceptionBookingController::class, 'update'])
        ->name('reception.booking.update');

    // Delete booking
    Route::delete('/reception/booking/{id}', [ReceptionBookingController::class, 'destroy'])
        ->name('reception.booking.destroy');

    // Check-out
    Route::post('/reception/booking/{id}/check-out', [ReceptionBookingController::class, 'checkOut'])
        ->name('reception.booking.checkout');

    // Check-in
    Route::post('/reception/booking/{id}/check-in', [ReceptionBookingController::class, 'checkIn'])
        ->name('reception.booking.checkin');
});

// Unified employee login route
Route::get('/employee/login', function () {
    return view('employee-login');
})->name('employee.login');

// Legacy routes redirecting to unified login
Route::get('/reception', function () {
    return redirect()->route('employee.login');
})->name('reception');
Route::get('/reception/login', function () {
    return redirect()->route('employee.login');
})->name('reception.login');

// Management routes
Route::get('/management', function () {
    return view('management-dashboard');
})->name('management');

Route::get('/management/room-edit', [RoomController::class, 'getAllRoom'])
->name('management.room-edit');

Route::get('/management/room-edit/data/{room_number}', [RoomController::class, 'getRoomData'])
->middleware('auth')
->name('management.get-room-data');

Route::put('/management/room-edit/{room_number}', [RoomController::class, 'updateRoom'])
->middleware('auth')
->name('management.update-room-data');

require __DIR__.'/auth.php';
