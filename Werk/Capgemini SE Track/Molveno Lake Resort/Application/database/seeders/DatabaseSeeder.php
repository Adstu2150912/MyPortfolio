<?php

namespace Database\Seeders;

use App\Models\User;
// use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        $useDummyData = true;

        if($useDummyData){ // Uses mostly dummy data.
            $this->call([
                // Rooms
                RoomStatusSeeder::class,
                RoomTypeSeeder::class,
                RoomSeeder::class,
                BedTypesSeeder::class,
                BedTypeRoomSeeder::class,
                
                // Users
                AccountTypeSeeder::class,
                UserSeeder::class,
                RegisteredUserSeeder::class,

                // Booking (after users to link up users with bookings)
                BookingSeeder::class,
                OccupantsSeeder::class
            ]);
        } else { //TODO: will use more proper client Data

        }        
    }
}