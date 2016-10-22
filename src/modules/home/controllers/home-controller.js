homeController = [
    '$scope',
    '$rootScope',
    'User',

    function($s, $rs, User) {
        var user = new User();
        user.name = "Luiz"
        //alert(user.name);
    }
];