<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Relations\Pivot;

class BedTypeRoom extends Pivot
{
    protected $fillable = ['room_id', 'bed_type_id', 'amount'];
}