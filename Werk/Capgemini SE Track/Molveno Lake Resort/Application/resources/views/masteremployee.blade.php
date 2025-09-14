<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="csrf-token" content="{{ csrf_token() }}">
    @vite(['resources/css/app.css'])
    @stack('additional-resources')
    @vite(['resources/css/employee.css'])
    <!-- No custom logout script needed as we'll use a form -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
</head>
<body>
    @section('header')
    <header class="flex flex-row justify-between p-1">
        <img class="w-20 md:w-28 lg:w-28" id="logo" src="{{ asset('images/logo.png') }}" alt="Logo">
        <h1 class="self-center font-bold text-2xl text-[#022859]">{{ $pageTitle ?? '' }}</h1>
        <form method="POST" action="{{ route('logout') }}" class="m-0">
            @csrf
            @if(Auth::check())
                <button type="submit" class="bg-[#022859] flex self-center p-3 rounded-xl m-4 text-white font-bold text-lg">
                    Logout
                </button>
            @endif
        </form>
    </header>
    @show
    <div class="content">
        @yield('content')
    </div>
</body>
</html>
