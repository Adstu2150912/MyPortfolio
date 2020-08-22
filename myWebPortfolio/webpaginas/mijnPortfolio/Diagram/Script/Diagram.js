$(document).ready(function () {
    $('#UML').click(function () {
        $('#main img').attr('src', 'IMG/ASP - UML Activiteitendiagram.jpg');
        $('#main img').css('visibility', 'visible');
        $('#main img').css('width', '30%');
    });

    $('#Bachmanndiagram').click(function () {
        $('#main img').attr('src', 'IMG/Bachmanndiagram.png');
        $('#main img').css('visibility', 'visible');
        $('#main img').css('width', '75%');
    });

    $('#cogNIAM').click(function () {
        $('#main img').attr('src', 'IMG/cogNIAM kennisdiagram.png');
        $('#main img').css('visibility', 'visible');
        $('#main img').css('width', '50%');
    });

    $('#klassen').click(function () {
        $('#main img').attr('src', 'IMG/klassendiagram.png');
        $('#main img').css('visibility', 'visible');
        $('#main img').css('width', '50%');
    });

    $('#SQL').click(function () {
        $('#main img').attr('src', 'IMG/SQL tabel KNVB voetbal.jpg');
        $('#main img').css('visibility', 'visible');
        $('#main img').css('width', '75%');
    });
})