<!DOCTYPE html>
<html lang="en">
<head>
    @vite(['resources/css/app.css'])
    @stack('additional-resources')
    @vite(['resources/css/reservationsreception.css'])
    <script>
        function logout() {
            window.location.href = '{{ route('employee.login') }}';
        }
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
    @section('header')
    <header class="flex flex-row justify-center p-1 py-4 h-28">
        <img class="w-20 md:w-28 lg:w-28 absolute left-4 self-center" id="logo" src="{{ asset('images/logo.png') }}" alt="Logo">
        <h1 class="self-center font-bold text-2xl text-[#022859] mx-auto">{{ $pageTitle ?? '' }}</h1>
    </header>
    @show
    <div class="content">
        @yield('content')
    </div>
</body>
</html>

