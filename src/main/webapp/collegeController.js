var app = angular.module("myApp").
controller("CollegeController", function($scope, collegeService) {
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
			alert(document.getElementById('selectedCollege').value);
			$scope.student.college.id = document.getElementById('selectedCollege').value;
			alert($scope.student);
			$scope.user = angular.copy($scope.master);
		};
});