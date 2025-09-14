<?php
use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration // Its probably better to not have a booking number, since we can get bookings from the booking table itself.
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::table('registered_users', function (Blueprint $table) {
            $table->dropForeign(['current_booking_number']);
            $table->dropColumn('current_booking_number');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('registered_users', function (Blueprint $table) {
            $table->string('current_booking_number', 16)->nullable();
            $table->foreign('current_booking_number')
                  ->references('booking_number')
                  ->on('booking')
                  ->onDelete('no action');
        });
    }
};