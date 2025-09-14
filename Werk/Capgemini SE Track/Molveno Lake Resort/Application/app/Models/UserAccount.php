<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class UserAccount extends Model
{
    protected $fillable = ['username', 'password_hash', 'type_id'];

    public function accountType()
    {
        return $this->belongsTo(AccountType::class);
    }

    public function registeredGuest()
    {
        return $this->hasMany(RegisteredUser::class);
    }

    public function setPasswordAttribute($password)
    {
        $this->attributes['password_hash'] = Hash::make($password);
    }
}
