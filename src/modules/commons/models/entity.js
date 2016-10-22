var Entity = function(errors) {
    this.errors = [];
};

Entity.prototype.hasErrors = function(){
    return (this.errors == true)
};

Entity.prototype.addError = function(error) {
    this.errors.add(error);
};

Entity.prototype.cleanErrors = function() {
    this.errors = [];
};