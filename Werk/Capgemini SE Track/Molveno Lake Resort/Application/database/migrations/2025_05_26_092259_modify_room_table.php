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
        Schema::table('room', function (Blueprint $table) {
            $table->unsignedBigInteger('room_type_id');
            $table->unsignedBigInteger('status_id');
            $table->foreign('room_type_id')
                ->references('id')
                ->on('room_types')
                ->onDelete('restrict');
            $table->foreign('status_id')
                ->references('id')
                ->on('room_statuses')
                ->onDelete('restrict');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('room', function (Blueprint $table) {
            $table->dropForeign(['room_type_id']);
            $table->dropForeign(['status_id']);
            $table->dropColumn('room_type_id');
            $table->dropColumn('status_id');
        });
    }
};
