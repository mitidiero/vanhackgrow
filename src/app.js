angular.module('app', ['app.home'])
    .config(['$routeProvider', '$locationProvider',
        function ($routeProvider, $locationProvider) {
            $locationProvider.html5Mode(false);
            $locationProvider.hashPrefix("!");

            $routeProvider
                .when('/home', {
                    templateUrl: '/modules/home/templates/home.html',
                    controller: 'HomeController'
                })
        }]);