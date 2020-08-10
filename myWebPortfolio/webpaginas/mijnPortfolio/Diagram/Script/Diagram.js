$(document).ready(function () {
    $('#UML').click(function () {
        $('#main img').attr('src', 'ASP - UML Activiteitendiagram.jpg');
        $('#main img').css('visibility', 'visible');
        $('#main img').css('width', '30%');
    });

    $('#Bachmanndiagram').click(function () {
        $('#main img').attr('src', 'Bachmanndiagram.png');
        $('#main img').css('visibility', 'visible');
        $('#main img').css('width', '75%');
    });

    $('#cogNIAM').click(function () {
        $('#main img').attr('src', 'cogNIAM kennisdiagram.png');
        $('#main img').css('visibility', 'visible');
        $('#main img').css('width', '50%');
    });

    $('#klassen').click(function () {
        $('#main img').attr('src', 'klassendiagram.png');
        $('#main img').css('visibility', 'visible');
        $('#main img').css('width', '50%');
    });

    $('#SQL').click(function () {
        $('#main img').attr('src', '../SQL/SQL tabel KNVB voetbal.jpg');
        $('#main img').css('visibility', 'visible');
        $('#main img').css('width', '75%');
    });


})