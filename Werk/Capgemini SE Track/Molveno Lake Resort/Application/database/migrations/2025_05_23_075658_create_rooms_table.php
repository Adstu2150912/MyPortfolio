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
        Schema::create('room', function (Blueprint $table) {
            $table->string('room_number', 5)->primary();
            $table->dateTime('status_since');
            $table->text('status_notes')->nullable();
            $table->unsignedTinyInteger('capacity');
            $table->enum('view',  ['Standard', 'Mountain', 'Lake']);
            $table->boolean('babybed');
            $table->boolean('for_disabled');
            $table->text('comments')->nullable();
            $table->integer('price_cents');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('room');
    }
};
