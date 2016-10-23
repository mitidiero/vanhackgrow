getUserNameController = [
    '$scope',
    '$rootScope',
    '$location',
    'User',
    'UserService',

    function($scope, $rootScope, $location, User, UserService) {
        $scope.user = UserService.getUser();

        $scope.next = function() {
            if ($scope.user.email != null) {
                UserService.save(
                    function success() {
                        alert("User Saved");
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