<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use App\Models\User;
use App\Models\Booking;
use App\Models\Occupant;

class RegisteredUser extends Model
{
    // Use user_account_id as primary key to align with Users table
    protected $primaryKey = 'user_account_id';
    public $incrementing = false; // user IDs come from users table
    protected $fillable = [
        'user_account_id',
        'name',
        'date_of_birth',
        'phone_number',
        'address',
        'temp_account',
        'scheduled_deletion'
    ];
    
    public function userAccount()
    {
        return $this->belongsTo(User::class, 'user_account_id');
    }

    public function booking()
    {
        return $this->belongsTo(Booking::class);
    }

    public function occupant()
    {
        return $this->hasMany(Occupant::class);
    }
}
