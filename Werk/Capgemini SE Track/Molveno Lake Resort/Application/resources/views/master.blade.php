<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Molveno Lake Resort</title>
        @vite(['resources/js/app.js'])
        @vite(['resources/css/main.css'])
        @vite(['resources/css/app.css'])
        @stack('additional-resources')
    </head>

    <body class="font-[ubuntu] h-full w-full @yield('body-class')">
        <div id="main" class="grid grid-cols-3 grid-rows-3">
            @section('header')
            <header id="main-header" class="grid-cols-3 col-span-3 flex justify-between items-center bg-white p-8" style="color: #002060; display:flex; width: 100vw; justify-content: space-between; align-items: center; position: relative;">
                <div id="main-logo" class="flex flex-row items-center">
                    <img src="{{ asset('images/logo.png') }}" alt="Molveno Lake Resort Logo" class="w-22 md:w-24 lg:w-24" />
                    <h1 class="text-3xl font-bold mb-4" style="margin: 0;"> Molveno Lake Resort</h1>
                </div>
                <nav id="main-nav-bar" class="justify-self-center text-xl" style="position: absolute; left: 50%; transform: translateX(-50%);">
                    <ul class="flex flex-row justify-between space-x-4">
                        <li><a href="/home">Home</a></li>
                        <li><a href="/home">About</a></li>
                        <li><a href="/roomsoverview">Rooms</a></li>
                    </ul>
                </nav>
                <div id="main-account-button" class="flex items-center space-x-4">
                    @guest
                        <a href="{{ route('login') }}" class="bg-[#8EC8E4] hover:bg-[#7AB8D4] text-[#002060] font-bold py-2 px-5 rounded-lg transition-colors shadow-md">Login</a>
                        <a href="{{ route('register') }}" class="border-2 border-[#002060] hover:bg-[#F0F8FF] text-[#002060] font-bold py-2 px-5 rounded-lg transition-colors">Register</a>
                    @endguest
                    <div id="myAccount" style="background-color: #002060; height: 90px; width:90px; border-radius: 50%; padding: 10px;" alt="user-account">
                        <a href="/dashboard"><image height="90px" class="w-18 md:w-22 lg:w-22" style="display: inline; padding: 7px;" src="{{ asset('images/user-account.png') }}"/></a>
                    </div>
                </div>
            </header>
            @show
            <div class="content">
                @yield('content')
            </div>
            @section('footer')
                <footer id="main-footer" class="grid-cols-3 col-span-3 flex justify-between items-center p-8 m-h-100" style="grid-row: 3; display: grid; color: #002060; position: relative">
                    <p class="col-start-1 m-auto" style=" position: absolute; left: 5%;">Copyright &copy 2025 AmazingBear</p>
                    <p class="col-start-3 m-auto" style="position: absolute; right: 30%;">Privacy - Terms of use - About</p>
                </footer>
            @show
        </div>
    </body>
</html>

