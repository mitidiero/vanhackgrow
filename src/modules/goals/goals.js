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
                .when('/goal-cost', {
                    templateUrl: '/modules/goals/templates/goal-cost.html',
                    controller: 'GoalCostController'
                })
                .when('/goal-months', {
                    templateUrl: '/modules/goals/templates/goal-months.html',
                    controller: 'GoalMonthsController'
                })
                .when('/goal-first-result', {
                    templateUrl: '/modules/goals/templates/goal-first-result.html',
                    controller: 'GoalFirstResultController'
                })
                .when('/goal-list', {
                    templateUrl: '/modules/goals/templates/goal-list.html',
                    controller: 'GoalListController'
                })
    }]);

appGoals.controller('GoalNameController', goalNameController);
appGoals.controller('GoalCostController', goalCostController);
appGoals.controller('GoalMonthsController', goalMonthsController);
appGoals.controller('GoalFirstResultController', goalFirstResultController);
appGoals.controller('GoalListController', goalListController);