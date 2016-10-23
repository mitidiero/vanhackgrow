signinWithEmailController = [
    '$scope',
    '$rootScope',
    '$location',
    'User',
    'UserService',

    function($scope, $rootScope, $location, User, UserService) {
        $scope.user = new User();

        $scope.next = function() {
            if ($scope.user.email != null) {
                UserService.setUser($scope.user);

                UserService.signin(
                    function success(result) {
                        UserService.setUser(result);
                        $location.path("/goal-name");
                    },
                    function error(error) {
                        $location.path("/get-user-name");
                    }
                );
            } else {
                alert("Please, enter your e-mail address");
            }
        }
    }
];