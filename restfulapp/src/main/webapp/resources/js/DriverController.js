(function() {
	var app = angular.module('angularjsapp', ['ui.bootstrap']);
	var url = "http://localhost:8080/restfulapp/api";

	app.config(['$httpProvider', function($httpProvider) {
	        $httpProvider.defaults.useXDomain = true;
	        delete $httpProvider.defaults.headers.common['X-Requested-With'];
	    }
	]);

	app.controller('DriverController', ['$scope', '$http', function($scope, $http) {
		$scope.list = function() {
			$http.get(url + '/driver/list').success(function(data) {
				console.debug(data);
				$scope.driverlist = data;
			});
		};


		$scope.save = function() {
			$http.post(url +  "/driver/new", angular.toJson($scope.driver)).success(function(data) {
				$scope.driverlist.unshift(data);
			});
		};
		
		$scope.updateData = function(driver) {
			$scope.driver = driver;
		};	

		$scope.update = function() {
			$http.put(url +  "/driver/update", angular.toJson($scope.driver)).success(function(data) {
				$scope.driverlist.unshift(data);
				$scope.list();
			});
		};

		$scope.remove = function(driver) {
			var id = driver.id;
			$http['delete'](url + "/driver/delete/" + id).success(function() {
				var index = $scope.driverlist.indexOf(driver);
				$scope.driverlist.splice(index, 1);
			});
		};

		var init = function() {
			$scope.list();
		}();
	}]);

})();