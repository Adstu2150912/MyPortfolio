<?php

namespace App\Services;

use App\Models\Room;
use Illuminate\Http\Request;

class RoomSelectionService
{
    public function findRoomByCriteria(Request $request)
    {
        $query = Room::where('view', $request->view)
               ->where('room_type_id', $request->type);
        
        if ($request->capacity) {
            $query->where('capacity', '>=', $request->capacity);
        }
        
        if ($request->has('babybed')) {
            $query->where('babybed', $request->babybed);
        }
        
        if ($request->has('for_disabled')) {
            $query->where('for_disabled', $request->for_disabled);
        }
        
        if ($request->price) {
            $minPrice = $request->price * 0.9;
            $maxPrice = $request->price * 1.1;
            $query->whereBetween('price_cents', [$minPrice, $maxPrice]);
        }
        
        $query = $query->with(['bedTypes' => function ($q) {
            $q->withPivot('amount');
        }]);
        
        foreach ($request->all() as $key => $value) {
            if (strpos($key, 'bed_type_') === 0) {
                $bedTypeId = substr($key, strlen('bed_type_'));
                $query = $query->whereHas('bedTypes', function ($q) use ($bedTypeId, $value) {
                    $q->where('bed_type_id', $bedTypeId)
                      ->where('amount', $value);
                });
            }
        }
        
        return $query->firstOrFail();
    }
}