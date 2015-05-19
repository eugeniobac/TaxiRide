(function() {
	var app = angular.module('angularjsapp', ['ui.bootstrap']);
	var url = "http://localhost:8080/restfulapp/api";

	app.config(['$httpProvider', function($httpProvider) {
	        $httpProvider.defaults.useXDomain = true;
	        delete $httpProvider.defaults.headers.common['X-Requested-With'];
	    }
	]);

	app.controller('ReportController', ['$scope','$modal' ,'$http', function($scope,$modal,$http) {
		$scope.generate = function() {
			console.debug(angular.toJson($scope.report));
			
			$http.post(url +  "/report/generate", angular.toJson($scope.report)).success(function(data) {
				$scope.taxiRideList.unshift(data);
			});
		};
		
		$scope.today = function() {
		    $scope.dt = new Date();
		  };
		  $scope.today();

		  $scope.clear = function () {
		    $scope.dt = null;
		  };

		  $scope.openStartDate = function($event) {
		    $event.preventDefault();
		    $event.stopPropagation();

		    $scope.openedStartDate = true;
		  };
		  
		  $scope.openEndDate = function($event) {
			  $event.preventDefault();
			  $event.stopPropagation();
			  
			  $scope.openedEndDate = true;
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
		}();
	}]);
	
})();