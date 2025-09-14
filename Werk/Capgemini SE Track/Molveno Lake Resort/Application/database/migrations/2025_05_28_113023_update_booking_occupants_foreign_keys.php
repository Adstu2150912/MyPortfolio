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
        Schema::table('booking', function (Blueprint $table) {
            $table->unsignedBigInteger('main_guest_id');
            $table->foreign('main_guest_id')
                ->references('user_account_id')
                ->on('registered_users')
                ->onDelete('no action');
        });

        Schema::table('occupants', function (Blueprint $table) {
            $table->unsignedBigInteger('guest_id')->nullable();
            $table->foreign('guest_id')
                ->references('user_account_id')
                ->on('registered_users')
                ->onDelete('no action');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('booking', function (Blueprint $table) {
            $table->dropForeign(['main_guest_id']);
            $table->dropColumn('main_guest_id');
        });

        Schema::table('occupants', function (Blueprint $table) {
            $table->dropForeign(['guest_id']);
            $table->dropColumn('guest_id');
        });
    }
};
