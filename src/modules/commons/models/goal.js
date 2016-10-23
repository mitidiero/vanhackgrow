var Goal = ['User', function(User) {
    function Goal(data) {
        Entity.call(this);

        this.name = null;
        this.value = 0;
        this.months = 0;
        this.monthlyCost = 0;

        if (data) {
            this.setData(data);
        }
    };

    Goal.prototype = {
        setData: function(data) {
            angular.extend(this, data);

            this.calculate();
        },

        serialize : function(){
            var goalCopy = angular.copy(this);

            goalCopy.userId = parseInt(this.user.id);

            delete goalCopy.errors;
            delete goalCopy.user;

            return goalCopy;
        },

        calculate:  function() {
            this.monthlyCost = this.value / this.months;
            return this.monthlyCost;
        }

    };

    return Goal;
}];