var UserService = [
    '$localStorage',
    '$http',
    'User',

    function($localStorage, $http, User) {
        var USER_KEY = "user";
        var user = null;

        if ($localStorage[USER_KEY]) {
            user = new User($localStorage[USER_KEY]);
        }

        var UserService = {
            setUser: function(newUser) {
                user = newUser;
                $localStorage[UserService.getUserKey()] = user;
            },
            getUser: function() {
                var userData = $localStorage[UserService.getUserKey()];

                if (userData) {
                    user = new User($localStorage[USER_KEY]);
                } else {
                    user = null;
                }

                return user;
            },
            signin: function(callbackSuccess, callbackError) {
                $http({
                    method : 'POST',
                    url : SERVER_URL + 'signin',
                    data : user.serialize()
                }).success(callbackSuccess).error(callbackError);
            },
            save: function(callbackSuccess, callbackError) {
                $http({
                    method : 'POST',
                    url : SERVER_URL + 'users',
                    data : user.serialize()
                }).success(callbackSuccess).error(callbackError);
            },
            getUserKey: function() {
                return USER_KEY;
            }
        }

        return UserService;
    }
];