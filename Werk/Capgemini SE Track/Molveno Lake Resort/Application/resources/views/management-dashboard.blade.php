@extends('masteremployee', ['pageTitle' => ($pageTitle ?? 'Management login')])

@section('content')
@if(Auth::check() && (Auth::user()->type_id == 1))
    <div style="background-color: #C2E5F2; min-height: calc(100vh - 120px); padding: 20px;">
        <form method="GET" action="{{ route('reception.reservations') }}" class="m-0">
            @csrf
            <button type="submit" class="self-center rounded-xl m-4 font-bold w-1/5 text-center inline-block text-2xl bg-white text-[#022859]" style="padding: 2%;">
                Reception
            </button>
        </form>
        <form method="GET" action="{{ route('management.room-edit') }}" class="m-0">
            @csrf
            <button type="submit" class="self-center rounded-xl m-4 font-bold w-1/5 text-center inline-block text-2xl bg-white text-[#022859]" style="padding: 2%;">
                Update Room
            </button>
        </form>
    </div>
@elseif(Auth::check() && (Auth::user()->type_id != 1))
    <div style="background-color: #C2E5F2; min-height: calc(100vh - 120px); padding: 20px;">
        <div class="p-4 bg-red-100 border border-red-400 text-red-700 rounded">
            <p class="font-bold">Access Denied</p>
            <p>You do not have permission to access this page. Please contact an administrator if you believe this is an error.</p>
        </div>
    </div>
@else
    <div style="background-color: #C2E5F2; min-height: calc(100vh - 120px); padding: 20px;">
        <!-- Session Status -->
        <x-auth-session-status class="mb-4" :status="session('status')" />
        <div class="text-[#022859]">
            <div class="text-center mb-4">
                <h1 id="header-reception-login" style="font-size: 24px; font-weight: bold; padding: 2.5% 0; color: var(--color-dark-blue);">Welcome to the management portal of Molveno Lake Resort</h1>
            </div>

            <form method="POST" action="{{ route('login') }}" class="max-w-xl mx-auto">
            @csrf
            <!-- Email Address -->
            <div>
                <x-input-label for="email" :value="__('Email')" />
                <x-text-input id="email" class="block mt-1 w-full" type="email" name="email" :value="old('email')" required autofocus autocomplete="username" />
                <x-input-error :messages="$errors->get('email')" class="mt-2" />
            </div>

            <!-- Password -->
            <div class="mt-4">
                <x-input-label for="password" :value="__('Password')" />

                <x-text-input id="password" class="block mt-1 w-full"
                                type="password"
                                name="password"
                                required autocomplete="current-password" />

                <x-input-error :messages="$errors->get('password')" class="mt-2" />
            </div>

            <!-- Remember Me -->
            <div class="block mt-4">
                <label for="remember_me" class="inline-flex items-center">
                    <input id="remember_me" type="checkbox" class="rounded dark:bg-gray-900 border-gray-300 dark:border-gray-700 text-indigo-600 shadow-sm focus:ring-indigo-500 dark:focus:ring-indigo-600 dark:focus:ring-offset-gray-800" name="remember">
                    <span class="ms-2 text-sm text-gray-600 dark:text-gray-400">{{ __('Remember me') }}</span>
                </label>
            </div>

            <div class="flex items-center justify-end mt-4">
                @if (Route::has('password.request'))
                    <a class="underline text-sm text-gray-600 dark:text-gray-400 hover:text-gray-900 dark:hover:text-gray-100 rounded-md focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 dark:focus:ring-offset-gray-800" href="{{ route('password.request') }}">
                        {{ __('Forgot your password?') }}
                    </a>
                @endif

                <x-primary-button class="ms-3" style="margin: 6% 2%;" class="bg-[#022859]">
                    {{ __('Log in') }}
                </x-primary-button>
            </div>
        </form>
        </div>
    </div>
@endif
@endsection
