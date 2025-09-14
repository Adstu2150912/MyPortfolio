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
        Schema::create('occupants', function (Blueprint $table) {
            $table->id();
            $table->string('booking_number', 16);
            $table->foreign('booking_number')
                ->references('booking_number')
                ->on('booking')
                ->onDelete('no action');
            $table->string('name', 100)->nullable();
            $table->date('date_of_birth')->nullable();
            $table->boolean('passport_checked');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('occupants');
    }
};
