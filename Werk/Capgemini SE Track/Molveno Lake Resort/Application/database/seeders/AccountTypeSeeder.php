<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\AccountType;

class AccountTypeSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        AccountType::create(['role' => 'Management']);
        AccountType::create(['role' => 'Maintenance']);
        AccountType::create(['role' => 'Housekeeping']);
        AccountType::create(['role' => 'Reception']);
        AccountType::create(['role' => 'Guest']);
    }
}
