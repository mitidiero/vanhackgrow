var appSignin = angular.module('app.signin', ['ngRoute', 'app.commons'])
    .config(['$routeProvider', '$locationProvider',
        function ($routeProvider, $locationProvider) {
            $locationProvider.html5Mode(false);
            $locationProvider.hashPrefix("!");

            $routeProvider
                .when('/try-on', {
                    templateUrl: '/modules/signin/templates/signin-with-email.html',
                    controller: 'SigninWithEmailController'
                })
                .when('/get-user-name', {
                    templateUrl: '/modules/signin/templates/get-user-name.html',
                    controller: 'GetUserNameController'
                })
    }]);

appSignin.controller('SigninWithEmailController', signinWithEmailController);
appSignin.controller('GetUserNameController', getUserNameController);