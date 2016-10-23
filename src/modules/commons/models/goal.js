var Goal = [function() {
    function Goal(data) {
        Entity.call(this);

        this.name = null;
        this.value = null;
        this.months = 0;

        if (data) {
            this.setData(data);
        }
    };

    Goal.prototype = {
        setData: function(data) {
            angular.extend(this, data);
        },

        serialize : function(){
            var goalCopy = angular.copy(this);

            delete goalCopy.errors;

            return goalCopy;
        }

    };

    return Goal;
}];