goalNameController = [
    '$scope',
    '$rootScope',
    '$localStorage',
    'Goal',
    'GoalService',
    'User',
    'UserService',

    function($scope, $rootScope, $localStorage, Goal, GoalService, User, UserService) {
        $scope.user = UserService.getUser();
        $scope.goal = new Goal();

        $scope.next = function() {
            if ($scope.goal.name != null) {
                GoalService.setGoal($scope.goal);

                $location.path("/get-user-name");
            } else {
                alert("Please, enter your goal name");
            }
        }
    }
];