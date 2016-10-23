getUserNameController = [
    '$scope',
    '$rootScope',
    '$location',
    'User',
    'UserService',

    function($scope, $rootScope, $location, User, UserService) {
        $scope.user = UserService.getUser();

        $scope.next = function() {
            if ($scope.user.name != null) {
                UserService.setUser($scope.user);

                UserService.save(
                    function success(result) {
                        console.log(result);
                        UserService.setUser(result);
                        $location.path("/goal-name");
                    },
                    function error(error) {
                        alert("Error!");
                        console.log(error);
                    }
                );
            } else {
                alert("Please, enter your e-mail address");
            }
        }
    }
];