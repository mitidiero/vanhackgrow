var Goal = [function() {
    function Goal(data) {
        Entity.call(this);

        this.name = null;
        this.value = 0;
        this.months = 0;
        this.monthlyValue = 0;

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

            delete goalCopy.errors;
            delete goalCopy.monthlyValue;

            return goalCopy;
        },

        calculate:  function() {
            this.monthlyValue = this.value / this.months;
            return this.monthlyValue;
        }

    };

    return Goal;
}];