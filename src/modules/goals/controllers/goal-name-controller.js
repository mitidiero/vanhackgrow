goalNameController = [
    '$scope',
    '$rootScope',
    '$localStorage',
    '$location',
    'Goal',
    'GoalService',
    'User',
    'UserService',

    function($scope, $rootScope, $localStorage, $location, Goal, GoalService, User, UserService) {
        $scope.user = UserService.getUser();
        $scope.goal = new Goal();

        $scope.next = function() {
            if ($scope.goal.name != null) {
                GoalService.setGoal($scope.goal);

                $location.path("/goal-cost");
            } else {
                alert("Please, enter your goal name");
            }
        }
    }
];