'use strict';

var csrControllers = angular.module('csrControllers', []);

csrControllers.controller('MainCtrl', [ '$scope', '$routeParams', 'Books',
		'$http', function($scope, $routeParams, Books, $http) {
			$scope.bookForm = {
				tSpecified : Now()
			};
			$scope.welldone = '';
			$scope.bookService = function() {
				if ($scope.bookForm.tSpecified) {
					$scope.welldone = '';
					$scope.loading = true;
					Books.save({
						tSpecified : $scope.bookForm.tSpecified
					}, function(data) {
						$http.prototype.pool = setInterval(function() {
							pooling($scope, $http, data);
						}, 2000);
					});
				}
			};
		} ]);

function pooling($scope, $http, data) {

	$http({
		method : 'GET',
		url : data.poolref
	}).success(function(data, status, headers, config) {
		if (data != "") {
			clearInterval($http.prototype.pool);
			$scope.welldone = data;
			$scope.loading = false;
		}
	}).error(function(data, status, headers, config) {
		$scope.welldone = 'Ops...' + status;
		$scope.loading = false;
		clearInterval($http.prototype.pool);
	});
}

function Now() {
	var now = new Date($.now()), year, month, date, hours, minutes, seconds;

	year = now.getFullYear();
	month = now.getMonth().toString().length === 1 ? '0'
			+ (now.getMonth() + 1).toString() : now.getMonth() + 1;
	date = now.getDate().toString().length === 1 ? '0'
			+ (now.getDate()).toString() : now.getDate();
	hours = now.getHours().toString().length === 1 ? '0'
			+ now.getHours().toString() : now.getHours();
	minutes = now.getMinutes().toString().length === 1 ? '0'
			+ now.getMinutes().toString() : now.getMinutes();
	seconds = now.getSeconds().toString().length === 1 ? '0'
			+ now.getSeconds().toString() : now.getSeconds();

	return year + '-' + month + '-' + date + 'T' + hours + ':' + minutes + ':'
			+ seconds;
};