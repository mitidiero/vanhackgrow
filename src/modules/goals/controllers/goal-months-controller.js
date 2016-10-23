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
                GoalService.save(
                    function success() {
                        console.log("Goal Saved!");
                        $location.path("/goal-first-result");
                    },
                    function error() {
                        alert("Error when saving your goal")
                    }
                )

            } else {
                alert("Please, enter your goal deadline");
            }
        }
    }
];