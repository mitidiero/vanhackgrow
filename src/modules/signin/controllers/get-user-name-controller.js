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
                $location.path("/get-user-name");
            } else {
                alert("Please, enter your e-mail address");
            }
        }
    }
];