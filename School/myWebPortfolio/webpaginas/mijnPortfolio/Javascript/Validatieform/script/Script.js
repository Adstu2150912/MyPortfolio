$(document).ready(function () {
    $('#registratieFormulier').submit(function () {

        var naam = $('input[name="name"]').prop('value');

        if (naam.length > 7) {
            $('input[name="name"]').removeClass('error');
            if ($('#naam').val() == '') {
                $('#naam').text(naam);
            }
        }
        else {
            $('input[name="name"]').addClass('error');
        }

        var aantalpersonen = $('select[name="amount"]').prop('selectedIndex');
        if (aantalpersonen > 0) {
            $('select[name="amount"]').removeClass('error');
            if ($('#personen').val() == '') {
                $('#personen').text(aantalpersonen);
            }
        }
        else {
            $('select[name="amount"]').addClass('error');
        }

        if ($('input[name="date"]').val() == '') {
            $('input[name="date"]').addClass('error');
        }
        else {
            $('input[name="date"]').removeClass('error');
        }

        if ($('input[name="groupSelector"]').prop('checked') == true) {
            $('label[for="dinnerAmount"]').removeClass('hide');
            $('input[name="dinnerAmount"]').removeClass('hide');
            if ($('#eten').val() == '') {
                $('#eten').text('Ja, we willen graag eten');
            }
        }
        else {
            $('label[for="dinnerAmount"]').addClass('hide');
            $('input[name="dinnerAmount"]').addClass('hide');
            $('#eten').empty();
        }

        var eters = $('input[name="dinnerAmount"]').prop('value');
        if ($('input[name="groupSelector"]').prop('checked') == true) {
            if ($('#eters').val() == ''){
                $('#eters').text(eters);
            }
        }
        else {
            $('#eters').empty();
        }
        var datum = $('input[name="date"]').prop('value');

        if ($('#datum').val() == ''){
            $('#datum').text(datum);
        }

        return false;

    });
});