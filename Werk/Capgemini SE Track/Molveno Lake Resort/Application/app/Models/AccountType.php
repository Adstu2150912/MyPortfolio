<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class AccountType extends Model
{
    protected $fillable = ['role'];

    public function userAccounts()
    {
        return $this->hasMany(userAccounts::class);
    }
}
