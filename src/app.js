var SERVER_URL = "http://localhost:8080/";

angular.module('app', ['app.home', 'app.signin', 'app.goals'])
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