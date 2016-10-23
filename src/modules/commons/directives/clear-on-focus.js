var clearOnFocusDirective = [function() {
    return {
        link: function(scope, element, attrs) {
            element.bind("focus", function(e) {
                element.val('');
            });
        }
    }
}];