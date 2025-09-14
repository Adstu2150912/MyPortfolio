<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\Occupant;
use App\Models\Booking;
use App\Models\RegisteredUser;

class OccupantsSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $bookings = Booking::all();

        foreach ($bookings as $booking) {
            $registeredUser = RegisteredUser::where('user_account_id', $booking->main_guest_id)->first();

            if ($registeredUser) {
                Occupant::create([
                    'booking_number' => $booking->booking_number,
                    'guest_id' => $registeredUser->user_account_id,
                    'name' => $registeredUser->name,
                    'date_of_birth' => $registeredUser->date_of_birth,
                    'passport_checked' => fake()->boolean()
                ]);
                for ($i = 0; $i < 2; $i++) {
                    Occupant::create([
                        'booking_number' => $booking->booking_number,
                        'name' => fake()->name(),
                        'date_of_birth' => fake()->date(),
                        'passport_checked' => fake()->boolean(),
                    ]);
                }
            }
        }
    }
}