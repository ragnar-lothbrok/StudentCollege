var app = angular.module("myApp").
controller("CollegeController", function($scope, collegeService, collegeServicePost, getStudentData) {
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
			
		};

		$scope.save = function(student) {			
			var studentData = {"id":1,"firstName":student.firstName,"lastName":student.lastName,"college":{"id":student.college.split(',')[0],"name":student.college.split(',')[1]},"mobileNo":student.mobileNo,"aboutMe":student.aboutMe}
			collegeServicePost.update(studentData);			
		};
		
		$scope.getData = function(){
			getStudentData.allData(function(data){
				if(data.items != 'undefined' && data.items.length > 0){
					$scope.students = data.items;
				}
			});
		}
});