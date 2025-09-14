<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Occupant extends Model
{
    public function booking()
    {
        return $this->hasOne(Booking::class);
    }

    public function registeredUser()
    {
        return $this->hasOne(RegisteredUser::class);
    }
}
