angular.module('myapp').service("BackEndService", function($http) {
	var getCategoryList = function(cb) {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/app/category/getAll',
		}).success(function(data, status, headers, config) {
			cb(null, data);
		}).error(function(data, status, headers, config) {
			cb(data);
		});
	};

	var updateCategoryList = function(data, cb) {
		$http({
			method : 'PUT',
			url : 'http://localhost:8080/app/category/update',
			data : data,
		}).success(function(data, status, headers, config) {
			cb(null, data);
		}).error(function(data, status, headers, config) {
			cb(data);
		});
	};

	var deleteGoal = function(id, cb) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/app/goal/delete/' + id,
		}).success(function(data, status, headers, config) {
			cb(null, data);
		}).error(function(data, status, headers, config) {
			cb(data);
		});
	}

	var createGoal = function(data, cb) {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/app/goal/create',
			data : data,
		}).success(function(data, status, headers, config) {
			cb(null, data);
		}).error(function(data, status, headers, config) {
			cb(data);
		});
	}

	var createCategory = function(data, cb) {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/app/category/create',
			data : data,
		}).success(function(data, status, headers, config) {
			cb(null, data);
		}).error(function(data, status, headers, config) {
			cb(data);
		});
	}

	var deleteCategory = function(id, cb) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/app/category/delete/' + id,
		}).success(function(data, status, headers, config) {
			cb(null, data);
		}).error(function(data, status, headers, config) {
			cb(data);
		});
	}
	return {
		getCategoryList : getCategoryList,
		updateCategoryList : updateCategoryList,
		deleteGoal : deleteGoal,
		createGoal : createGoal,
		deleteCategory : deleteCategory,
		createCategory : createCategory
	};
});
