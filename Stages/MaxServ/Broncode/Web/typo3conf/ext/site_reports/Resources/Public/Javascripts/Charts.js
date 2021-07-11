jQuery(document).ready(function() {
    jQuery('.pieChart').each(function () {
        var data = window[jQuery(this).attr('data-variable')];
        var id = jQuery(this).attr('id');
        var pieChartOptions = {
            legend: {
                display: false
            },
            cutoutPercentage: 80,
        };
        var ctx = document.getElementById(id).getContext("2d");
        new Chart(ctx,{
            type: 'pie',
            data: data,
            options: pieChartOptions,
        });
    });

    jQuery('.doughnut').each(function () {
        var data = window[jQuery(this).attr('data-variable')];
        var id = jQuery(this).attr('id');

        var doughnutOptions = {
            tooltips: {
                mode: 'index',
                axis: 'y'
            },
            responsive: true
        };

        var ctx = document.getElementById(id).getContext("2d");
        new Chart(ctx, {type: 'doughnut', data: data, options:doughnutOptions});
    });

    jQuery('.stackedbar').each(function () {
        var data = window[jQuery(this).attr('data-variable')];
        var id = jQuery(this).attr('id');

        var stackedbarOptions = {
            legend: {
                position: 'bottom'
            },
            tooltips: {
                mode: 'index',
                axis: 'y'
            },
            responsive: true,
            scales: {
                xAxes: [{
                    stacked: true,
                    ticks: {
                        beginAtZero: true,
                        autoSkipPadding: 1
                    }
                }],
                yAxes: [{
                    stacked: true,
                    ticks: {
                        beginAtZero: true,
                    }
                }]
            }
        };

        var ctx = document.getElementById(id).getContext("2d");
        new Chart(ctx, {type: 'bar', data: data, options:stackedbarOptions});
    });


    jQuery('.bar').each(function () {
        var data = window[jQuery(this).attr('data-variable')];
        var id = jQuery(this).attr('id');

        var barOptions = {
            title: {
                display: true,
                text: 'Aantal tickets',
                fontSize: 16,
                position: 'top'
            },
            legend: {
                display: false
            },
            tooltips: {
                mode: 'index',
                axis: 'y'
            },
            responsive: true,
            scales: {
                xAxes: [{
                    ticks: {
                        beginAtZero: true,
                        autoSkipPadding: 1
                    }
                }],
                yAxes: [{
                    ticks: {
                        beginAtZero: true,
                    }
                }]
            }
        };

        var ctx = document.getElementById(id).getContext("2d");
        new Chart(ctx, {type: 'bar', data: data, options:barOptions});
    });

    jQuery('.linechart').each(function () {
        var data = window[jQuery(this).attr('data-variable')];
        var id = jQuery(this).attr('id');
        var max;

        if (parseInt(jQuery(this).attr('data-max')) > 0) {
            max = parseInt(jQuery(this).attr('data-max'));
        }

        var lineChartOptions = {
            legend: {
                position: 'bottom'
            },
            responsive: true,
            scales: {
                xAxes: [{
                    ticks: {
                        beginAtZero: true,
                        autoSkipPadding: 1
                    }
                }],
                yAxes: [{
                    ticks: {
                        beginAtZero: true,
                        max: max
                    }
                }]
            }
        };

        var ctx = document.getElementById(id).getContext("2d");
        new Chart(ctx, {type: 'line', data: data, options:lineChartOptions});
    });
});