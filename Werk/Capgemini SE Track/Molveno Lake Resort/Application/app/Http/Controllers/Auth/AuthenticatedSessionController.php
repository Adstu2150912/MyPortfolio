<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use App\Http\Requests\Auth\LoginRequest;
use Illuminate\Http\RedirectResponse;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\View\View;

class AuthenticatedSessionController extends Controller
{
    /**
     * Display the login view.
     */
    public function create(): View
    {
        return view('auth.login');
    }

    /**
     * Handle an incoming authentication request.
     */
    public function store(LoginRequest $request): RedirectResponse
    {
        $request->authenticate();

        $request->session()->regenerate();

        $redirectTo = $request->input('redirect_to');

        if ($redirectTo && str_starts_with($redirectTo, url('/'))) {
            return redirect()->to($redirectTo);
        }

        switch($request->user()->type_id)
        {
            case 1:
                $pageTitle = 'Management dashboard';
                return redirect()->intended(route('management', absolute: false));
                break;
            case 4:
                $pageTitle = 'Reception dashboard';
                return redirect()->intended(route('reception.reservations', absolute: false));
                break;
            default:
                return redirect()->intended(route('dashboard', absolute: false));
                break;
        }
    }

    /**
     * Destroy an authenticated session.
     */
    public function destroy(Request $request): RedirectResponse
    {
        $redirectURL = '/';

        // Redirect employees (management and reception) to unified employee login
        if (in_array($request->user()->type_id, [1, 4])) {
            $redirectURL = route('employee.login');
        }

        Auth::guard('web')->logout();

        $request->session()->invalidate();

        $request->session()->regenerateToken();

        return redirect($redirectURL);
    }
}
