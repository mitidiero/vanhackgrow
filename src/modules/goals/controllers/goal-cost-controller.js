goalCostController = [
    '$scope',
    '$rootScope',
    '$localStorage',
    '$location',
    'Goal',
    'GoalService',

    function($scope, $rootScope, $localStorage, $location, Goal, GoalService) {
        $scope.goal = GoalService.getGoal();

        $scope.next = function() {
            if ($scope.goal.value != null) {
                GoalService.setGoal($scope.goal);

                $location.path("/goal-months");
            } else {
                alert("Please, enter your goal cost");
            }
        }
    }
];