var app = angular
		.module("myApp")
		.controller(
				"CollegeController",
				function($scope, collegeService, collegeServicePost,
						getStudentData) {

					$scope.filteredItems = [];
					$scope.groupedItems = [];
					$scope.itemsPerPage = 1;
					$scope.pagedItems = [];
					$scope.currentPage = 0;

					var onFetchError = function(message) {
						$scope.error = "Error Fetching Users. Message:"
								+ message;
					};

					var onFetchCompleted = function(data) {
						$scope.colleges = data;
						$scope.resetData = $scope.initial;
					};

					var getColleges = function() {
						collegeService.get().then(onFetchCompleted,
								onFetchError);
					};

					getColleges();

					$scope.reset = function() {
						$scope.message = "";
						angular.copy($scope.initial, $scope.student);
					};

					$scope.save = function(student) {
						if (student != undefined
								&& student.firstName.length != 0
								&& student.lastName.length != 0
								&& student.mobileNo.length != 0
								&& student.aboutMe.length != 0) {
							var studentData = {
								"id" : 1,
								"firstName" : student.firstName,
								"lastName" : student.lastName,
								"college" : {
									"id" : student.college.split(',')[0],
									"name" : student.college.split(',')[1]
								},
								"mobileNo" : student.mobileNo,
								"aboutMe" : student.aboutMe
							}
							collegeServicePost.update(studentData);
							$scope.message = "saved successfully";
							angular.copy($scope.initial, $scope.student);
						} else {
							$scope.message = "Please provide valid fields.";
						}
					};

					$scope.getData = function() {
						getStudentData
								.allData(function(data) {
									if (data.items != 'undefined'
											&& data.items.length > 0) {
										$scope.students = data.items;
										$scope.currentPage = 0;
										$scope.pagedItems = [];
										for (var i = 0; i < $scope.students.length; i++) {
											if (i % $scope.itemsPerPage === 0) {
												$scope.pagedItems[Math.floor(i
														/ $scope.itemsPerPage)] = [ $scope.students[i] ];
											} else {
												$scope.pagedItems[Math.floor(i
														/ $scope.itemsPerPage)]
														.push($scope.students[i]);
											}
										}
									}
								});
					}

					$scope.range = function(start, end) {
						var ret = [];
						if (!end) {
							end = start;
							start = 0;
						}
						for (var i = start; i < end; i++) {
							ret.push(i);
						}
						return ret;
					};

					$scope.prevPage = function() {
						if ($scope.currentPage > 0) {
							$scope.currentPage--;
						}
					};

					$scope.nextPage = function() {
						if ($scope.currentPage < $scope.pagedItems.length - 1) {
							$scope.currentPage++;
						}
					};

					$scope.setPage = function() {
						$scope.currentPage = this.n;
					};
				});