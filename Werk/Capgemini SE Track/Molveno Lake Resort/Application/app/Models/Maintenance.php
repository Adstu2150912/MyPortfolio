<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Maintenance extends Model
{
    protected $fillable = ['room_number', 'type', 'notes', 'notes_last_editor', 'start_date', 'end_date'];

    public function room()
    {
        return $this->belongsTo(Room::class, 'room_number');
    }
}
