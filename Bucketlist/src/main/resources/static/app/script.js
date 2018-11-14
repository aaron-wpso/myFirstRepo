angular.module('myapp').controller(
		'MainCtrl',
		function($scope, BackEndService) {

			$scope.categoryList = [];
			$scope.availableCategoryOption = [];
			$scope.selectedCategory = {};

			$scope.verifyInConsole = function(data) {
				console.log(data);
				toastr.info("something is printed in the console");
			};

			$scope.getCategoryList = function() {
				BackEndService.getCategoryList(function(err, data) {
					if (!err) {
						$scope.categoryList = data;
					}
				});

			};

			$scope.selectCategory = function(category) {
				$scope.selectedCategory = category;
			}

			$scope.deleteCategory = function(id) {
				BackEndService.deleteCategory(id, function() {
					$scope.getCategoryList();
				});
			}

			$scope.updateCategoryList = function() {
				BackEndService.updateCategoryList($scope.categoryList,
						function(status) {

						});
			};

			$scope.deleteGoal = function(id) {
				BackEndService.deleteGoal(id, function() {
					$scope.getCategoryList();
				});
			}

			$scope.importance = {
				availableOptions : [ 1, 2, 3, 4, 5 ]

			};

			$scope.createNewGoal = function(newGoal) {
				BackEndService.createGoal(newGoal, function() {
					$scope.getCategoryList();
				});
			}

			$scope.createNewCategory = function(newGoal) {
				BackEndService.createCategory(newGoal, function() {
					$scope.getCategoryList();
				});
			}

			$scope.$on('ReceiveNewGoal', function(event, data) {
				$scope.createNewGoal(data);
			});

			$scope.$on('ReceiveNewCategory', function(event, data) {
				$scope.createNewCategory(data);
			});

			$scope.getCategoryList();

		});

angular.module('myapp').controller('ModalCtrl', function($scope) {
	$scope.newGoal = {};
	$scope.newCategory = {};

	$scope.createNewGoal = function() {
		var newGoal = {
			title : $scope.newGoalTitle,
			done : $scope.newGoalDone,
			importance : $scope.newGoalImportance,
			cateName : $scope.selectedCategory.cateName,
		}

		$scope.newGoal = newGoal;
		$scope.emitGoal($scope.newGoal);

		$scope.newGoalTitle = "";
		$scope.newGoalDone = false;
		$scope.newGoalImportance = undefined;
	}
	$scope.createNewCategory = function() {
		var newCategory = {
			cateName : $scope.newCategoryName,
			goalDTOs : null,
		}

		$scope.newCategory = newCategory;
		$scope.emitCategory($scope.newCategory);

		$scope.newCategoryName = "";
	}

	$scope.emitGoal = function(newGoal) {
		$scope.$emit('ReceiveNewGoal', $scope.newGoal);
	}

	$scope.emitCategory = function(newCategory) {
		$scope.$emit('ReceiveNewCategory', $scope.newCategory);
	}
});
