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
        Schema::create('booking', function (Blueprint $table) {
            $table->string('booking_number', 16)->primary();
            $table->string('room_number', 5);
            $table->foreign('room_number')
                ->references('room_number')
                ->on('room')
                ->onDelete('no action');
            $table->unsignedTinyInteger('total_group_size');
            $table->unsignedTinyInteger('children_below_10')->nullable();
            $table->unsignedTinyInteger('children_below_4')->nullable();
            $table->dateTime('start_date', 0);
            $table->dateTime('end_date', 0);
            $table->integer('total_cost_cents');
            $table->integer('total_cost_paid_cents');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('booking');
    }
};
