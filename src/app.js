angular.module('app', ['app.home'])
    .config(['$routeProvider', '$locationProvider', '$httpProvider',
        function ($routeProvider) {
            $routeProvider
                .when('/home', {
                    templateUrl: 'templates/home.html',
                    controller: 'HomeController'
                })
        }]);