angular.module('myapp').controller('MainCtrl', function($scope, BackEndService) {

  $scope.categoryList = [];
  $scope.availableCategoryOption = [];
  $scope.selectedCategory = {};

  $scope.verifyInConsole = function(data)
  {
      console.log(data);
  };

  $scope.getCategoryList = function()
  {
    BackEndService.getCategoryList(function(err, data) {
    if(!err)
    {
        $scope.categoryList = data;
    }
    });
  };

  $scope.selectCategory = function(category)
  {
    $scope.selectedCategory = category;
  }

  $scope.updateCategoryList = function()
  {
    BackEndService.updateCategoryList(function(status)
	  {

    }, $scope.categoryList);
  };

  $scope.deleteGoal = function(id)
  {
      BackEndService.deleteGoal(id,function()
      {
        $scope.getCategoryList();
      });


  }

  $scope.importance =
  {
    availableOptions:
    [
      1,2,3,4,5
    ]

  };

  $scope.createNewGoal = function(newGoal)
  {
    BackEndService.createGoal(newGoal,function()
    {
      $scope.getCategoryList();
    });
  }

  $scope.$on('ReceiveNewGoal', function(event,data)
  {
    $scope.createNewGoal(data);
  });

  $scope.getCategoryList();



});

angular.module('myapp').controller('ModalCtrl', function($scope)
{
  $scope.newGoal = {};

  $scope.createNewGoal = function()
  {
    var newGoal =
    {
      title : $scope.newGoalTitle,
      done : $scope.newGoalDone,
      importance : $scope.newGoalImportance,
      cateName : $scope.selectedCategory.cateName,
    }

    $scope.newGoal = newGoal;
    $scope.emitEvent($scope.newGoal);

    $scope.newGoalTitle = "";
    $scope.newGoalDone = false;
    $scope.newGoalImportance = undefined;
  }


  $scope.emitEvent = function(newGoal)
  {
    $scope.$emit('ReceiveNewGoal', $scope.newGoal);
  }
});
