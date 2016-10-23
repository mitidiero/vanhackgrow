var User = [function() {

    function User(data) {
        Entity.call(this);

        this.email = null;
        this.name = null;

        if (data) {
            this.setData(data);
        }
    };

    User.prototype = {
        setData: function(data) {
            angular.extend(this, data);
        },

        serialize : function(){
            var userCopy = angular.copy(this);

            delete userCopy.errors;

            return userCopy;
        }

    };

    return User;
}];