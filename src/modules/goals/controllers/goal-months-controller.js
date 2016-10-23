goalMonthsController = [
    '$scope',
    '$rootScope',
    '$localStorage',
    '$location',
    'Goal',
    'GoalService',

    function($scope, $rootScope, $localStorage, $location, Goal, GoalService) {
        $scope.goal = GoalService.getGoal();

        $scope.next = function() {
            if ($scope.goal.months != null) {
                GoalService.setGoal($scope.goal);

                $location.path("/goal-first-result");
            } else {
                alert("Please, enter your goal deadline");
            }
        }
    }
];