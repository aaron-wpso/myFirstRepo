angular.module("myModule").factory("BackEndService", function($http)
{
  var getCategoryList = function(cb)
  {
    $http
    ({
          method : 'GET',
          url : 'http://localhost:8080/app/category/getAll',
    })
    .success(function(data, status, headers, config)
    {
      cb(null, data);
    })
    .error(function(data, status, headers, config)
    {
      cb(data);
    });
  }

  return
  {
    getCategoryList: getCategoryList
  }
});
