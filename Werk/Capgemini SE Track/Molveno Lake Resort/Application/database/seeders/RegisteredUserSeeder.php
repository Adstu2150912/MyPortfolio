<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\User;
use App\Models\RegisteredUser;
use Carbon\Carbon;

class RegisteredUserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $guestAccounts = User::where('type_id', 5)->get();

        foreach ($guestAccounts as $account) {
            $tempAccount = fake()->boolean();
            $firstName = preg_replace('/\s+/', '', fake()->firstName());
            $lastName = preg_replace('/\s+/', '', fake()->lastName());
            $emailLast = strtolower($lastName);
            $digits = (string) random_int(1, 99999);
            $email = $emailLast . $digits . '@gmail.com';

            // Ensure the linked guest User email reflects the last name pattern
            $account->email = $email;
            $account->save();

            RegisteredUser::create([
                'user_account_id' => $account->id,
                'name' => $firstName . ' ' . $lastName,
                'date_of_birth' => fake()->date(),
                'phone_number' => fake()->phoneNumber(),
                'address' => fake()->address(),
                'temp_account' => $tempAccount,
                'scheduled_deletion' => $tempAccount ? Carbon::now()->addDays(rand(7, 30)) : null,
            ]);
        }
    }
}