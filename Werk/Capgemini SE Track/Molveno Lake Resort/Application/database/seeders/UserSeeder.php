<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Str;
use Illuminate\Support\Facades\Hash;
use App\Models\User;

class UserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        // Predefined staff accounts (type_id => email)
        $setAccounts = [
            1 => 'management@mlr.com',
            2 => 'maintenance@mlr.com',
            3 => 'housekeeping@mlr.com',
            4 => 'reception@mlr.com',
        ];

        foreach ($setAccounts as $typeId => $email) {
            User::create([
                'type_id'  => $typeId,
                'email'    => $email,
                'password' => Hash::make('password'),
            ]);
        }

        // Create 6 additional random guest user accounts
        for ($i = 0; $i < 6; $i++) {
            $lastNameRaw    = fake()->lastName();
            $lastName       = strtolower(preg_replace('/\s+/', '', $lastNameRaw));
            $digits         = (string) random_int(1000, 999999);
            $email          = $lastName . $digits . '@gmail.com';
            $plainPassword  = Str::random(12);

            User::create([
                'type_id'  => 5,
                'email'    => $email,
                'password' => Hash::make($plainPassword),
            ]);
        }

        // Create 1 additional random guest user accounts
        $lastNameRaw    = fake()->lastName();
        $lastName       = strtolower(preg_replace('/\s+/', '', $lastNameRaw));
        $digits         = (string) random_int(1000, 999999);
        $email          = $lastName . $digits . '@gmail.com';
        $plainPassword  = 'password';

        User::create([
            'type_id'  => 5,
            'email'    => $email,
            'password' => Hash::make($plainPassword),
        ]);
    }
}
