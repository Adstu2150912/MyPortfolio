app.controller('highscoreController', function($scope) {
    $scope.highscores = [],
    $scope.statusHighscore = true;
    $scope.addHighscore = function () {
        $scope.highscores += $scope.newHighscore;
        $scope.newHighscore = "";
        $scope.statusHighscore = false;
    },
    $scope.removeHighscore = function () {
        $scope.highscores -= $scope.newHighscore;
        $scope.newHighscore = "";
        $scope.statusHighscore = false;
    };
});