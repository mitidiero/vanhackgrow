var appGoals = angular.module('app.goals', ['ngStorage', 'ngRoute', 'app.commons'])
    .config(['$routeProvider', '$locationProvider',
        function ($routeProvider, $locationProvider) {
            $locationProvider.html5Mode(false);
            $locationProvider.hashPrefix("!");

            $routeProvider
                .when('/goal-name', {
                    templateUrl: '/modules/goals/templates/goal-name.html',
                    controller: 'GoalNameController'
                })
    }]);

appGoals.controller('GoalNameController', goalNameController);