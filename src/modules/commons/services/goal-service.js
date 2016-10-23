var GoalService = [
    '$localStorage',
    '$http',
    'Goal',
    'UserService',

    function($localStorage, $http, Goal, UserService) {
        var GOAL_KEY = "goal";
        var goal = null;

        if ($localStorage[GOAL_KEY]) {
            goal = new Goal($localStorage[GOAL_KEY]);
        }

        var GoalService = {
            setGoal: function(newGoal) {
                goal = newGoal;
                goal.user = UserService.getUser();
                $localStorage[GoalService.getGoalKey()] = goal;
                goal.calculate();
            },
            getGoal: function() {
                var goalData = $localStorage[GoalService.getGoalKey()];

                if (goalData) {
                    goal = new Goal($localStorage[GOAL_KEY]);
                } else {
                    goal = null;
                }

                return goal;
            },
            list: function(callbackSuccess, callbackError) {
                $http({
                    method : 'GET',
                    params: {
                        userId: UserService.getUser().id
                    },
                    url : SERVER_URL + 'goals',
                    transformResponse: function(data, header){
                        //Getting string data in response
                        var jsonData = JSON.parse(data); //or angular.fromJson(data)
                        var goals = [];

                        angular.forEach(jsonData, function(item){
                            var goalItem = new Goal(item);
                            goals.push(goalItem);
                        });

                        return goals;
                    }
                }).success(callbackSuccess).error(callbackError);
            },
            save: function(callbackSuccess, callbackError) {
                $http({
                    method : 'POST',
                    url : SERVER_URL + 'goals',
                    data : goal.serialize()
                }).success(callbackSuccess).error(callbackError);
            },
            getGoalKey: function() {
                return GOAL_KEY;
            }
        };

        return GoalService;
    }
];