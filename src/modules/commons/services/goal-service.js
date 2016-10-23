var GoalService = [
    '$localStorage',
    '$http',
    'Goal',

    function($localStorage, $http, Goal) {
        var USER_KEY = "goal";
        var goal = null;

        if ($localStorage[USER_KEY]) {
            goal = new Goal($localStorage[USER_KEY]);
        }

        var GoalService = {
            setGoal: function(newGoal) {
                goal = newGoal;
                $localStorage[GoalService.getGoalKey()] = goal;
            },
            getGoal: function() {
                var goalData = $localStorage[GoalService.getGoalKey()];

                if (goalData) {
                    goal = new Goal($localStorage[USER_KEY]);
                } else {
                    goal = null;
                }

                return goal;
            },
            save: function(callbackSuccess, callbackError) {
                $http({
                    method : 'POST',
                    url : SERVER_URL + 'goals',
                    data : goal.serialize()
                }).success(callbackSuccess).error(callbackError);
            },
            getGoalKey: function() {
                return USER_KEY;
            }
        };

        return GoalService;
    }
];