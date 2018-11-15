angular.module('myapp').controller(
		'MainCtrl',
		function($scope, BackEndService, toaster, $window) {

			$scope.categoryList = [];
			$scope.availableCategoryOption = [];
			$scope.selectedCategory = {};

			$scope.verifyInConsole = function(data) {
				console.log(data);
			};

			$scope.getCategoryList = function() {
				BackEndService.getCategoryList(function(err, data) {
					if (!err)
          {
						$scope.categoryList = data;
					}
          else
          {
              toaster.pop('error',"Error Message: ", data, 5000);
          }
				});

			};

			$scope.selectCategory = function(category) {
				$scope.selectedCategory = category;
      }

			$scope.deleteCategory = function(id) {
				BackEndService.deleteCategory(id, function(err,data) {
          if(!err)
          {
					  $scope.getCategoryList();
            toaster.pop('success', "Category Deleted", null, 3000);
          }
          else
          {
            toaster.pop('error',"Error Message: ", data, 5000);
          }
				});
			}

			$scope.updateCategoryList = function() {
				BackEndService.updateCategoryList($scope.categoryList, function(err,data) {
          if(!err)
          {
            $scope.getCategoryList();
            toaster.pop('success',"Database Updated", null, 3000);
          }
          else
          {
            toaster.pop('error',"Error Message: ", data, 5000);
          }
				});
			};

			$scope.deleteGoal = function(id) {
				BackEndService.deleteGoal(id, function(err,data) {
          if(!err)
          {
            $scope.getCategoryList();
            toaster.pop('success',"Goal Delete", null, 3000);
          }
          else
          {
            toaster.pop('error',"Error Message: ", data, 5000);
          }
				});
			}

			$scope.importance = {
				availableOptions : [ 1, 2, 3, 4, 5 ]
			};

			$scope.createNewGoal = function(newGoal) {
				BackEndService.createGoal(newGoal, function(err,data) {
          if(!err)
          {
            $scope.getCategoryList();
            toaster.pop('success',"Goal Created", null, 3000);
          }
          else
          {
            toaster.pop('error',"Error Message: ", err.message, 5000);
          }



				});
			}

			$scope.createNewCategory = function(newCategory) {
				BackEndService.createCategory(newCategory, function(err,data) {
          if(!err)
          {
            $scope.getCategoryList();
            toaster.pop('success',"Category Created", null, 3000);
          }
          else
          {
            toaster.pop('error',"Error Message: ", data, 5000);
          }

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
