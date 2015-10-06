var module = angular.module("myApp", []).
	factory("collegeService", function($http) {

	var getColleges = function(username) {
		return $http
				.get(
						"/test/rest/services/college")
				.then(function(response) {
					return response.data;
				});
	};

	return {
		get : getColleges
	};
})
.factory("getStudentData", function($http) {
	return {
		 allData: function(callback) {
		   $http.get('/test/rest/services/student').success(callback);
		 }
   }
}).factory('collegeServicePost', function($http){
	var saveData = function(studentData) {
		return $http({
			method  : 'POST',
			url     : '/test/rest/services/student',
			data	: studentData
       })
	};
	
	return {
		update : saveData
	};
})