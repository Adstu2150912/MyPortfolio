$(document).ready(function () {

    var infoMsg = $('#infoPanel').text();

    if (infoMsg.length <= 0) {
        $('input[name="wachtwoord"]').removeClass('error');
    }
    else {
        $('input[name="wachtwoord"]').addClass('error');
    }

    $('#formulier').submit(function () {

        return true;

    });
});