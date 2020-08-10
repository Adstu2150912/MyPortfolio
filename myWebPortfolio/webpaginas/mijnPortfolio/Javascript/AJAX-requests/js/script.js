$('document').ready(function () {
    $('#verstuurKnop').click(function () {
        $.ajax({
            url: "php/highscores.php?newHighscore=" + $('input[name="newHighscore"]').val(),         
            success: function () {
                alert('AJAX verzoek geslaagd!');
            },
            error: function () {
                alert('Error! AJAX verzoek mislukt!');
            },
        });
    });
    $('#updateKnop').click(function () {
        $.ajax({
            url: "php/highscores.php",
            success: function (result) {
                alert('AJAX verzoek geslaagd!');
                result = JSON.parse(result);
                $("#1ste").text(result.eerste);
                $("#2de").text(result.tweede);
                $("#3de").text(result.derde);
            },
            error: function () {
                alert('Error! AJAX verzoek mislukt!');
            }
        });
    });
});