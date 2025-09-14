<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\BedType;

class BedTypesSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        BedType::create(['type' => 'Single']);
        BedType::create(['type' => 'Double']);
    }
}
