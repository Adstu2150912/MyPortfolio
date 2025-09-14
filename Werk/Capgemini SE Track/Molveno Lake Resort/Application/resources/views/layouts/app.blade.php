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
    <body class="font-[ubuntu] antialiased h-full w-full ">
        <div class="min-h-screen flex flex-col bg-white dark:bg-[#89C2D9]">
            @include('layouts.navigation')
            <!-- Page Content -->
            <main class="flex-1" style="background-color: #C2E5F2">
                {{ $slot }}
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
