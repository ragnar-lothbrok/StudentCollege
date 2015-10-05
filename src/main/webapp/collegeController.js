(function() {


	
	var CollegeController = function($scope, collegeService) {

		var onFetchError = function(message) {
			$scope.error = "Error Fetching Users. Message:" + message;
		};

		var onFetchCompleted = function(data) {
			$scope.colleges = data;
		};

		var getColleges = function() {
			collegeService.get().then(onFetchCompleted, onFetchError);
		};

		getColleges();

		$scope.reset = function() {
			alert("lol");
			$scope.user = angular.copy($scope.master);
		};

		$scope.save = function() {
			alert("lol1");
			$scope.user = angular.copy($scope.master);
		};

	};
	
	var app = angular.module("myApp", []);
	app.controller("CollegeController", CollegeController);
}());
