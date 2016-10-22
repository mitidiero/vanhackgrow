var appHome = angular.module('app.home', ['ngRoute', 'app.commons'])
    .config(['$routeProvider', '$locationProvider',
        function ($routeProvider, $locationProvider) {
            $locationProvider.html5Mode(false);
            $locationProvider.hashPrefix("!");

            $routeProvider
                .when('/', {
                    templateUrl: '/modules/home/templates/home.html',
                    controller: 'HomeController'
                })
    }]);

appHome.controller('HomeController', homeController);