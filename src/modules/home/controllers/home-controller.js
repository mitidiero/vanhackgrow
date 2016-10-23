homeController = [
    '$scope',
    '$rootScope',
    '$localStorage',
    'User',
    'UserService',

    function($scope, $rootScope, $localStorage, User, UserService) {
        if (UserService.getUser()) {
            //verify if has a goal
            // if has, redirect to see the goal
            // if not, redirect to register a goal
        } else {
            console.log("no user");
        }
    }
];