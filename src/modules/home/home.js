var appHome = angular.module('app.home', ['ngRoute', 'app.commons'])
    .config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: '/modules/home/templates/home.html',
                controller: 'HomeController'

            })
    }]);

appHome.controller('HomeController', homeController);