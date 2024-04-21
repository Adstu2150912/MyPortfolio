var projectHours = <f:format.raw>{projectHours}</f:format.raw>;
var contractHours = <f:format.raw>{assocFields.3.value}</f:format.raw>;
var pieChartData = {
    labels: <f:format.raw>{labelsPieChartJson}</f:format.raw>,
datasets: [{
    backgroundColor: ['#000000','#E0E0E0'],
    data:[projectHours, (contractHours - projectHours)]
}],
};

