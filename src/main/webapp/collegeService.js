(function() {

	var collegeService = function($http) {

		var getColleges = function(username) {
			return $http
					.get(
							"http://localhost:8081/SpringCxfRestDemo/rest/services/college")
					.then(function(response) {
						return response.data;
					});
		};
		return {
			get : getColleges
		};
	};
	
	var module = angular.module("formCtrl");
	module.factory("collegeService", collegeService);

}());