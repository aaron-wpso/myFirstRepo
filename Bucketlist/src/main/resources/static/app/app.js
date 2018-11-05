var myModule = angular.module('myModule',[]);

myModule.controller('mainCtrl', ['$scope', function($scope, BackEndService)
{
  // BackEndService.getCategoryList(function(err, data)
  // {
  //     $scope.categoryList = data;
  // });
}]);
