var app = angular.module('app', ['ui.grid']);
 
function testController($scope, $http) {
	
	 $scope.state = 'busy';

	 $scope.lastAction = '';

	 $scope.url = "/angular/protected/test/";
	
	 $scope.myData = [
	                 {
	                     "firstName": "Cox",
	                     "lastName": "Carney",
	                     "company": "Enormo",
	                     "employed": true
	                 },
	                 {
	                     "firstName": "Lorraine",
	                     "lastName": "Wise",
	                     "company": "Comveyer",
	                     "employed": false
	                 },
	                 {
	                     "firstName": "Nancy",
	                     "lastName": "Waters",
	                     "company": "Fuelton",
	                     "employed": false
	                 }
	             ];
}
