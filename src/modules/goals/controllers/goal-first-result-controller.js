goalFirstResultController = [
    '$scope',
    '$rootScope',
    '$localStorage',
    '$location',
    'Goal',
    'GoalService',

    function($scope, $rootScope, $localStorage, $location, Goal, GoalService) {
        $scope.goal = GoalService.getGoal();
    }
];