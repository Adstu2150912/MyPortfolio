app.controller('highscoreController', function($scope) {
    $scope.highscores = [],
        $scope.addHighscore = function () {
        $scope.highscores += $scope.newHighscore;
        $scope.newHighscore = "";
        $scope.statusHighscore = false;
        };   
});