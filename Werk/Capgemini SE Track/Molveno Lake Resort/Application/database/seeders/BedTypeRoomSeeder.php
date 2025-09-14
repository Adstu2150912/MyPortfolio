<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\BedTypeRoom;
use App\Models\Room;
use App\Models\BedType;

class BedTypeRoomSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $roomBedTypes = [
            // Floor 1
            '101' => [
                ['bed_type_id' => 1, 'amount' => 2],
            ],
            '102' => [
                ['bed_type_id' => 1, 'amount' => 2],
            ],
            '103' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '104' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '105' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '106' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '107' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '108' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            // Floor 2
            '207' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '208' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '209' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '210' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '211' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '212' => [
                ['bed_type_id' => 1, 'amount' => 2],
            ],
            '213' => [
                ['bed_type_id' => 1, 'amount' => 2],
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '214' => [
                ['bed_type_id' => 1, 'amount' => 2],
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '215' => [
                ['bed_type_id' => 1, 'amount' => 2],
            ],
            '216' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '217' => [
                ['bed_type_id' => 1, 'amount' => 2],
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '218' => [
                ['bed_type_id' => 1, 'amount' => 2],
            ],
            '219' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '220' => [
                ['bed_type_id' => 1, 'amount' => 2],
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            // Floor 3
            '301' => [
                ['bed_type_id' => 1, 'amount' => 2],
            ],
            '302' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
            '303' => [
                ['bed_type_id' => 2, 'amount' => 1],
            ],
        ];
        foreach ($roomBedTypes as $roomNumber => $bedTypes) {
            foreach ($bedTypes as $bedTypeData) {
                BedTypeRoom::create([
                    'room_number' => $roomNumber,
                    'bed_type_id' => $bedTypeData['bed_type_id'],
                    'amount' => $bedTypeData['amount'],
                ]);
            }
        }
    }
}