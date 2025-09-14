<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\Booking;
use App\Models\RegisteredUser;
use Illuminate\Support\Str;
use App\Models\User;
use Carbon\Carbon;
use App\Models\Room;

class BookingSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    private function randomPrice(): int {
        return round(rand(15000, 25000) / 100) * 100;
    }
    
    private function bookingTemplate(array $overrides = []): array
    {
        $mainGuest = \App\Models\RegisteredUser::inRandomOrder()->first(); // or however you get the guest

        $price = $this->randomPrice();

        // Determine room number respecting overrides so dependent fields (has_disability) match the selected room
        $roomNumber = $overrides['room_number'] ?? Room::inRandomOrder()->value('room_number');
        $roomHasDisability = (bool) (Room::where('room_number', $roomNumber)->value('for_disabled') ?? false);

        // 50/50 chance: fully paid equals total price; otherwise set to 90% of price, rounded to nearest 100
        if (fake()->boolean()) {
            $paidCents = $price;
        } else {
            // 90% of the price, rounded like randomPrice() (nearest 100)
            $paidCents = (int) (round(($price * 0.90) / 100) * 100);
        }
        
        // Randomize dates with constraints:
        // - start_date >= 2025-09-08, with a small offset (0-21 days)
        // - stay length between 2 and 7 nights
        $minStart = Carbon::create(2025, 9, 8);
        $startDate = $minStart->copy()->addDays(rand(0, 21));
        $stayNights = rand(2, 7);
        $endDate = $startDate->copy()->addDays($stayNights);
     
        $template = [
            'booking_number'        => Str::random(3) . '-' . Str::random(3) . '-' . Str::random(3),
            'room_number'           => $roomNumber,
            'main_guest_id'         => $mainGuest->user_account_id,
            'total_group_size'      => rand(2, 4),
            'children_below_10'     => rand(0, 1),
            'children_below_4'      => rand(0, 1),
            'start_date'            => $startDate,
            'end_date'              => $endDate,
            'total_cost_cents'      => $price,
            'total_cost_paid_cents' => $paidCents,
            'includes_breakfast'    => fake()->boolean(),
            'has_disability'        => $roomHasDisability,
        ];
     
        return array_merge($template, $overrides);
    }

    public function run(): void
    {
        \App\Models\Booking::create( // Standard room with 1 adult.
            $this->bookingTemplate([
                'room_number' => 102,
                'total_group_size' => 1,
                'children_below_10' => 0,
                'children_below_4' => 0,
            ])
        );

        \App\Models\Booking::create( // Disability room.
            $this->bookingTemplate([
                'room_number' => 212,
                'total_group_size' => 1,
                'children_below_10' => 0,
                'children_below_4' => 0,
            ])
        );

        \App\Models\Booking::create( // Standard room with 2 adults and 1 child
            $this->bookingTemplate([
                'room_number' => 213,
                'total_group_size' => 3,
                'children_below_10' => 1,
                'children_below_4' => 0,
            ])
        );

        \App\Models\Booking::create( // Standard room with 2 adults and 1 toddler
            $this->bookingTemplate([
                'room_number' => 216,
                'total_group_size' => 3,
                'children_below_10' => 0,
                'children_below_4' => 1,
            ])
        );

        \App\Models\Booking::create( // Room changed, causing total_cost_paid_cents to be higher than total_cost_cents
            $this->bookingTemplate([ // For example, rebooked from Luxerious room to a standard room
                'room_number' => 104,
                'total_group_size' => 2,
                'children_below_10' => 0,
                'children_below_4' => 0,
                'total_cost_cents' => 15000,
                'total_cost_paid_cents' => 32000,
            ])
        );

        \App\Models\Booking::create( // Luxurious room with 2 adults and 1 child
            $this->bookingTemplate([
                'room_number' => 303,
                'total_group_size' => 2,
                'children_below_10' => 1,
                'children_below_4' => 0,
                'total_cost_cents' => 30000,
                'total_cost_paid_cents' => 30000,
            ])
        );

        \App\Models\Booking::create( // Standard room that hasnt been paid for yet
            $this->bookingTemplate([
                'room_number' => 106,
                'total_group_size' => 1,
                'children_below_10' => 1,
                'children_below_4' => 0,
                'total_cost_cents' => 15000,
                'total_cost_paid_cents' => 0,
            ])
        );

        \App\Models\Booking::create( // Quick other booking
            $this->bookingTemplate([
                'room_number' => 107,
                'total_group_size' => 3,
                'children_below_10' => 1,
                'children_below_4' => 0,
            ])
        );
    }
}

//