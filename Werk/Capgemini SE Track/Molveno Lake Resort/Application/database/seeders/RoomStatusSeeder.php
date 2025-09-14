<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\RoomStatus;

class RoomStatusSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        RoomStatus::create(['status' => 'Available']);
        RoomStatus::create(['status' => 'Occupied']);
        RoomStatus::create(['status' => 'Cleaning']);
        RoomStatus::create(['status' => 'Maintenance']);
        RoomStatus::create(['status' => 'Out of Service']);
        RoomStatus::create(['status' => 'Checked Out']);
        RoomStatus::create(['status' => 'Checked In']);
    }
}
