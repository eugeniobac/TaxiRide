(function() {
	var app = angular.module('angularjsapp', ['ui.bootstrap']);
	var url = "http://localhost:8080/restfulapp/api";

	app.config(['$httpProvider', function($httpProvider) {
	        $httpProvider.defaults.useXDomain = true;
	        delete $httpProvider.defaults.headers.common['X-Requested-With'];
	    }
	]);

	app.controller('TaxiRideController', ['$scope','$modal' ,'$http', function($scope,$modal,$http) {
		  $scope.animationsEnabled = true;

		  $scope.open = function (size) {

		    var modalInstance = $modal.open({
		      animation: $scope.animationsEnabled,
		      templateUrl: 'passenger.html',
		      controller: 'ModalInstanceController',
		      size: size
		    });

		    modalInstance.result.then(function (selectedItem) {
		      $scope.selected = selectedItem;
		    }, function () {
		    });
		  };

		  $scope.toggleAnimation = function () {
		    $scope.animationsEnabled = !$scope.animationsEnabled;
		  };

		$scope.listDriver = function() {
			$http.get(url + '/driver/list').success(function(data) {
				$scope.driverlist = data;
			});
		};
		
		$scope.listNewPassengers = function() {
			$http.get(url + '/passenger/listNewPassengers').success(function(data) {
				$scope.newPassengersList = data;
			});
		};
		
		$scope.listPassengersFromHistory = function() {
			$http.get(url + '/passenger/listPassengersFromHistory').success(function(data) {
				$scope.historyPassengersList = data;
			});
		};

		var init = function() {
			$scope.listDriver();
			$scope.listNewPassengers();
			$scope.listPassengersFromHistory();
		}();
	}]);

	app.controller('ModalInstanceController', function ($scope, $modalInstance, $http) {
		$scope.ok = function () {
			$http.post(url +  "/passenger/new", angular.toJson($scope.passenger)).success(function(data) {
				console.log(data);
			});
			$modalInstance.close();
		};
		
		$scope.cancel = function () {
			$modalInstance.dismiss('cancel');
		};
	});
	
})();