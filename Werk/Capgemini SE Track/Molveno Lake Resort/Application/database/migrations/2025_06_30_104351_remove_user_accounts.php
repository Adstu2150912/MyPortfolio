<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::table('registered_users', function (Blueprint $table) {
            $table->dropForeign(['user_account_id']);
            $table->dropForeign(['email']);
        });

        Schema::dropIfExists('user_accounts');
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::create('user_accounts', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('type_id');
            $table->foreign('type_id')
                ->references('id')
                ->on('account_types')
                ->onDelete('no action');
            $table->string('username', 100)->unique();
            $table->string('password_hash', 255);
            $table->timestamps();
        });
    }
};
