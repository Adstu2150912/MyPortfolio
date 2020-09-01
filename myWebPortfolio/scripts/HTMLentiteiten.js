$('#HTMLentities').click(function () {
    $('.kolom456 > a').remove();
    $('#optie > p').replaceWith('<p>Hieronder ziet uw allerlei HTML-entiteiten en HTML-elementen</p>');
    $('header > h1').replaceWitch('<h1>Dit zijn HTML-entiteiten</h1>');
    $('div #kolom1 .kolom456').append('<figure><img src="#" height: "200px" width: "200px" alt="#"><figcaption>#</figcaption><figure>');
    $('div #kolom2 .kolom456').append('<hr>' + '<sup>2<sup>/<sub>4<sub>' + '&Tab' + '&NewLine' + '&excl' + '&quot' + '&nbsp');
    $('div #kolom3 .kolom456').append( '<a href="Opdracht 10.2">Voorbeeld HTML/CSS Tabel</a>' + '<br>' + '<iframe src="https://en.wikipedia.org/wiki/Alpaca"></iframe>')
});