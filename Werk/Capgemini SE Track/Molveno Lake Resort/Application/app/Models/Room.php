<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Room extends Model
{
    protected $table = 'room'; // Todo try and fix this
    protected $primaryKey = 'room_number';
    public $incrementing = false;
    protected $keyType = 'string';

    protected $fillable = ['room_number', 'status_id', 'status_since', 'status_notes', 'room_type_id', 
                           'capacity', 'view', 'babybed', 'for_disabled', 'comments', 'price_cents'];

    public function bedTypes()
    {
        return $this->belongsToMany(BedType::class, 'bed_type_room', 'room_number')
                    ->using(BedTypeRoom::class)->withPivot('amount');
    }

    public function status()
    {
        return $this->belongsTo(RoomStatus::class, 'status_id');
    }

    public function type()
    {
        return $this->belongsTo(RoomType::class, 'room_type_id');
    }

    public function maintenances()
    {
        return $this->hasMany(Maintenance::class);
    }

    public function booking()
    {
        return $this->hasMany(Booking::class, 'room_number', 'room_number'); // added foreign key definitions
    }
}
