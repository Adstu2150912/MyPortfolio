<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class RoomStatus extends Model
{
    protected $fillable = ['status'];

    public function rooms()
    {
        return $this->hasMany(Room::class);
    }
}
