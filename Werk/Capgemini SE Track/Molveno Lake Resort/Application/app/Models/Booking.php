<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Support\Str;

class Booking extends Model
{
    protected $table = 'booking';
    public $incrementing = false;
    protected $keyType = 'string';
    protected $primaryKey = 'booking_number';
    protected $fillable = [
        'booking_number',
        'room_number',
        'main_guest_id',
        'total_group_size',
        'children_below_10',
        'children_below_4',
        'start_date',
        'end_date',
        'total_cost_cents',
        'total_cost_paid_cents',
        'includes_breakfast',
        'has_disability',
    ];

    public static function boot()
    {
        parent::boot();

        static::creating(function ($model) {
            do {
                $booking_number = Str::random(3) . '-' . Str::random(3) . '-' . Str::random(3);
            } while (self::where('booking_number', $booking_number)->exists());
            $model->booking_number = $booking_number;
        });
    }

    public function room()
    {
        return $this->belongsTo(Room::class, 'room_number', 'room_number');
    }

    public function occupant()
    {
        return $this->hasMany(Occupant::class);
    }

    public function registeredGuest()
    {
        return $this->belongsTo(RegisteredUser::class, 'main_guest_id', 'user_account_id');
    }

    /**
     * Get the outstanding balance in cents (positive => guest owes; negative => refund to guest)
     */
    public function getBalanceCentsAttribute()
    {
        $total = (int) ($this->total_cost_cents ?? 0);
        $paid = (int) ($this->total_cost_paid_cents ?? 0);
        return $total - $paid;
    }

    /**
     * Helpers to display euro amounts
     */
    public function getTotalCostEurAttribute()
    {
        return number_format(((int)($this->total_cost_cents ?? 0)) / 100, 2);
    }

    public function getTotalCostPaidEurAttribute()
    {
        return number_format(((int)($this->total_cost_paid_cents ?? 0)) / 100, 2);
    }

    public function getBalanceEurAttribute()
    {
        return number_format($this->balance_cents / 100, 2);
    }
}
