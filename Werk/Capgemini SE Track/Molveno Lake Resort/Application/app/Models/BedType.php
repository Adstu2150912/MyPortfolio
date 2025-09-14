<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class BedType extends Model
{
    protected $fillable = ['type'];

    public function rooms()
    {
        return $this->belongsToMany(Room::class)
                    ->using(BedTypeRoom::class);
    }
}
