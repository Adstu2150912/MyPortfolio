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
        Schema::create('bed_type_room', function (Blueprint $table) {
            $table->id();
            $table->string('room_number', 5);
            $table->foreign('room_number')
                ->references('room_number')
                ->on('room')
                ->onDelete('no action');
            $table->unsignedBigInteger('bed_type_id');
            $table->foreign('bed_type_id')
                ->references('id')
                ->on('bed_types')
                ->onDelete('no action');
            $table->unsignedTinyInteger('amount');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('bed_type_room');
    }
};
