app.controller('highscoreController', function($scope) {
    $scope.highscores = [],
    $scope.statusHighscore = true;
    $scope.addHighscore = function () {
        if ($scope.newHighscore !== "") {
            $scope.highscores += (isNaN(Number($scope.newHighscore)) ? 0 : Number($scope.newHighscore));
            $scope.newHighscore = "";
            $scope.statusHighscore = false;
        }
        else {
            $scope.statusHighscore = true;
        }
    },
    $scope.removeHighscore = function () {       
        if ($scope.highscores.length > 0) {
            $scope.highscores -= $scope.selected;
            if ($scope.highscores.length <= 0) {
                $scope.statusHighscore = true;
            }
        }	                
    };
    $scope.selectHighscore = function (selectedHighScore) {
        $scope.selected = selectedHighScore;
    }


});