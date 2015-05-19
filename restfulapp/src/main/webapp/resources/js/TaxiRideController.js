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

		  $scope.openModal = function (size) {

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
		
		$scope.save = function() {
			console.debug(angular.toJson($scope.taxiRide));
			
			$http.post(url +  "/taxiRide/new", angular.toJson($scope.taxiRide)).success(function(data) {
				console.debug(data);
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
		
		$scope.today = function() {
		    $scope.dt = new Date();
		  };
		  $scope.today();

		  $scope.clear = function () {
		    $scope.dt = null;
		  };

		  $scope.open = function($event) {
		    $event.preventDefault();
		    $event.stopPropagation();

		    $scope.opened = true;
		  };

		  $scope.dateOptions = {
		    formatYear: 'yy',
		    startingDay: 1
		  };

		  var tomorrow = new Date();
		  tomorrow.setDate(tomorrow.getDate() + 1);
		  var afterTomorrow = new Date();
		  afterTomorrow.setDate(tomorrow.getDate() + 2);
		  $scope.events =
		    [
		      {
		        date: tomorrow,
		        status: 'full'
		      },
		      {
		        date: afterTomorrow,
		        status: 'partially'
		      }
		    ];

		  $scope.getDayClass = function(date, mode) {
		    if (mode === 'day') {
		      var dayToCheck = new Date(date).setHours(0,0,0,0);

		      for (var i=0;i<$scope.events.length;i++){
		        var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

		        if (dayToCheck === currentDay) {
		          return $scope.events[i].status;
		        }
		      }
		    }

		    return '';
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