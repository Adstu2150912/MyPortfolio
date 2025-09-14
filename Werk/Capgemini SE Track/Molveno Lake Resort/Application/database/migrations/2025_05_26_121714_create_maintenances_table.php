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
        Schema::create('maintenance', function (Blueprint $table) {
            $table->id();
            $table->string('room_number', 5);
            $table->foreign('room_number')
                ->references('room_number')
                ->on('room')
                ->onDelete('restrict');
            $table->enum('type', ['Minor', 'Regular', 'Major']);
            $table->text('notes');
            $table->string('notes_last_editor', 100);
            $table->dateTime('start_date', 0);
            $table->dateTime('end_date', 0);
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('maintenance');
    }
};
