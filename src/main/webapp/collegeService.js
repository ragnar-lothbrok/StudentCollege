var module = angular.module("myApp", []).
	factory("collegeService", function($http) {

	var getColleges = function(username) {
		return $http
				.get(
						"http://localhost:8081/test/rest/services/college")
				.then(function(response) {
					return response.data;
				});
	};

	return {
		get : getColleges
	};
});