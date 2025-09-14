<?php
namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\RoomType;

class RoomTypeSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        RoomType::create([
            'type' => 'Economy',
            'description' => 'A budget-friendly room with essential amenities, perfect for short stays. Simple, clean, and comfortable.',
        ]);

        RoomType::create([
            'type' => 'Standard',
            'description' => 'A well-balanced room offering comfort and convenience. Ideal for both business and leisure travelers.',
        ]);

        RoomType::create([
            'type' => 'Luxurious',
            'description' => 'A premium room with upscale furnishings and extra features. Designed for maximum comfort and indulgence.',
        ]);
    }
}