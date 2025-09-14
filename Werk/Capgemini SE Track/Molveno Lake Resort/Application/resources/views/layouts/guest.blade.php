<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="csrf-token" content="{{ csrf_token() }}">

        <title>{{ config('app.name', 'Laravel') }}</title>

        <!-- Fonts -->
        <link rel="preconnect" href="https://fonts.bunny.net">
        <link href="https://fonts.bunny.net/css?family=figtree:400,500,600&display=swap" rel="stylesheet" />

        <!-- Scripts -->
        @vite(['resources/css/app.css', 'resources/js/app.js'])
    </head>
    <body class="font-[ubuntu] antialiased h-full w-full" >
        <div class="min-h-screen flex flex-col  bg-white dark:bg-[#89C2D9]">
            <div class="flex justify-center h-16 h-max">
                <div class="flex">
                    <div id="main-header" class="grid-cols-3 col-span-3 items-center bg-white p-8" style="color: #002060; display:grid;">
                        <div id="main-logo" class="flex flex-row items-center">
                            <img src="{{ asset('images/logo.png') }}" alt="Molveno Lake Resort Logo" class="w-22 md:w-24 lg:w-24" />
                            <h1 class="text-3xl font-bold mb-4" style="margin: 0;"> Molveno Lake Resort</h1>
                        </div>
                        <nav id="main-nav-bar" class="justify-self-center text-xl">
                            <ul class="flex flex-row justify-between space-x-4">
                                <li><a href="/home">Home</a></li>
                                <li><a href="/home">About</a></li>
                                <li><a href="/roomsoverview">Rooms</a></li>
                            </ul>
                        </nav>
                        <div id="main-account-button" class="w-18 md:w-22 lg:w-22">
                            <div id="myAccount" style="background-color: #002060; height: 90px; width:90px; border-radius: 50%; padding: 10px; float: right" alt="user-account">
                                <a href="/register"><image height="90px" class="w-18 md:w-22 lg:w-22" style="display: inline; padding: 7px;" src="{{ asset('images/user-account.png') }}"/></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Page Content -->
            <main class="flex-1" style="background-color: #C2E5F2">
                <div class="w-max align-center mx-auto">
                    {{ $slot }}
                </div>
            </main>
            <div>
                <footer id="main-footer" class="max-w-7xl mx-auto sm:px-6 lg:px-8 grid-cols-3 col-span-3 flex justify-between items-center bg-white p-8 m-h-100" style="grid-row: 3; display: grid; color: #002060; position: relative">
                    <p class="col-start-1 m-auto" style=" position: absolute; left: 5%;">Copyright &copy 2025 AmazingBear</p>
                    <p class="col-start-3 m-auto" style="position: absolute; right: 30%;">Privacy - Terms of use - About</p>
                </footer>
            </div>
        </div>
    </body>
</html>
