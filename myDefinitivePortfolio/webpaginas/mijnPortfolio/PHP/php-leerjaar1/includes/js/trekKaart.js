/**
 * Created by D.Lyte on 3/28/2017.
 */
$(document).ready(function () {

    function dealerTrekKaart(trekKaart) {
        $('dealer > p:last-child').after("<br>" + trekKaart);
    }

    function userTrekKaart() {
        $(".game > form > label").after("<input type='submit' name='trek' value='Trek nog een kaart'>");
    }

    function klikInputBedrag() {
        $('.game > form > input[name="name"]').click();
    }
});