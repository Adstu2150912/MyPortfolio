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
        Schema::create('registered_users', function (Blueprint $table) {
            $table->foreignId('user_account_id')
                  ->primary()
                  ->constrained('user_accounts')
                  ->onDelete('cascade');
            $table->string('name', 100);
            $table->date('date_of_birth');
            $table->string('email', 100);
            $table->foreign('email')
                ->references('username')
                ->on('user_accounts')
                ->onDelete('cascade');
            $table->string('phone_number', 20);
            $table->string('address', 100);
            $table->string('current_booking_number', 16);
            $table->foreign('current_booking_number')
                  ->references('booking_number')
                  ->on('booking')
                  ->onDelete('no action');
            $table->boolean('temp_account');
            $table->dateTime('scheduled_deletion' , 0);
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('registered_users');
    }
};
