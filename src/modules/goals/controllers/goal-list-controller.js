goalListController = [
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
        $scope.goals = [];

        GoalService.list(
            function success(result) {
                console.log(result);
                $scope.goals = result;
            },
            function error(error) {
                $scope.goals = [];
                console.log(error);
            }
        )
    }
];