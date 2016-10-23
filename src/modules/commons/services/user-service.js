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
                    headers : HEADERS,
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