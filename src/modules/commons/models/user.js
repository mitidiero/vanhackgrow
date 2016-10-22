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
        },

        validate: function() {
            this.errors = [];

            return this._isValid();
        },

        save: function(callbackSuccess, callbackError) {
            if (this.hasErrors()) {
                return false;
            }

            //save and execute callbacks
        }

    };

    return User;
}];