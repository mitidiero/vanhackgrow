var moduleCommons = angular.module('app.commons', []);

moduleCommons.factory('User', User);
moduleCommons.service('UserService', UserService);
moduleCommons.factory('Goal', Goal);
moduleCommons.service('GoalService', GoalService);
moduleCommons.directive('clearOnFocus', clearOnFocusDirective);