<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;

class ReceptionManagementAccess
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure  $next
     * @return mixed
     */
    public function handle(Request $request, Closure $next)
    {
        if (!Auth::check()) {
            return redirect()->route('login');
        }

        // Check if user is reception or management staff
        $allowedRoles = [1, 4]; // Management = 1, Reception = 4
        if (!in_array(Auth::user()->type_id, $allowedRoles)) {
            abort(403, 'Unauthorized access. This area is only for reception and management staff.');
        }

        return $next($request);
    }
}
