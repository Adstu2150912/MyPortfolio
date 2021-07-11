$(document).ready(function () {

    $('img[alt="Fitness"]').click(function () {
        $('img[alt="Fitness"]').animate({ width: '100%', height: '60%', display: 'block' }, 100);
        $('img:nth-child(2)').css('display', 'none');
        $('img:nth-child(3)').css('display', 'none');
        $('#kolom1').animate({ width: '100%', height: '50%', display: 'block' }, 100);
        $('.kolom456:nth-child(2)').css('display', 'none');
        $('.kolom456:nth-child(3)').css('display', 'none');

    });

    $('img[alt="Hardware"]').click(function () {
        $('img[alt="Hardware"]').animate({ width: '100%', height: '60%', display: 'block' }, 100);
        $('img:nth-child(1)').css('display', 'none');
        $('img:nth-child(3)').css('display', 'none');
        $('#kolom2').animate({ width: '100%', height: '50%', display: 'block' }, 100);
        $('.kolom456:nth-child(1)').css('display', 'none');
        $('.kolom456:nth-child(3)').css('display', 'none');
    });

    $('img[alt="Software"]').click(function () {
        $('img[alt="Software"]').animate({ width: '100%', height: '60%', display: 'block' }, 100);
        $('img:nth-child(1)').css('display', 'none');
        $('img:nth-child(2)').css('display', 'none');
        $('#kolom3').animate({ width: '100%', height: '50%', display: 'block' }, 100);
        $('.kolom456:nth-child(1)').css('display', 'none');
        $('.kolom456:nth-child(2)').css('display', 'none');
    });


    //teruggaan naar standaard hobby pagina

    $('img[alt="Fitness"]').dblclick(function () {
        $('img[alt="Fitness"]').animate({ width: '33.3%', height: '30%', display: 'block' }, 100, function () {
            $('img[alt="Fitness"]').removeAttr('style');
        });
        $('img:nth-child(2)').css('display', 'block');
        $('img:nth-child(3)').css('display', 'block');
        $('#kolom1').animate({ width: '33.3%', height: '60vh', display: 'block' }, 100, function () {
            $('#kolom1').removeAttr('style');
        });
        $('.kolom456').css('display', 'block');
    });

    $('img[alt="Hardware"]').dblclick(function () {
        $('img[alt="Hardware"]').animate({ width: '33.3%', height: '30%', display: 'block' }, 100, function () {
            $('img[alt="Hardware"]').removeAttr('style');
        });
        $('img:nth-child(1)').css('display', 'block');
        $('img:nth-child(3)').css('display', 'block');
        $('#kolom2').animate({ width: '33.3%', height: '60vh', display: 'block' }, 100, function () {
            $('#kolom2').removeAttr('style');
        });
        $('.kolom456').css('display', 'block');
    });

    $('img[alt="Software"]').dblclick(function () {
        $('img[alt="Software"]').animate({ width: '33.3%', height: '30%', display: 'block' }, 100, function () {
            $('img[alt="Software"]').removeAttr('style');
        });
        $('img:nth-child(1)').css('display', 'block');
        $('img:nth-child(2)').css('display', 'block');
        $('#kolom3').animate({ width: '33.3%', height: '60vh', display: 'block' }, 100, function () {
            $('#kolom3').removeAttr('style');
        });
        $('.kolom456').css('display', 'block');
    });
});
    