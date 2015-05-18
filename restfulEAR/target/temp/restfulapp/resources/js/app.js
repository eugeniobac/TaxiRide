'use strict';

var csrApp = angular.module('csrApp', [ 'ngResource', 'ngRoute', 'csrServices',
		'csrControllers', 'csrDirectives' ]);
csrApp.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'resources/partials/main.html',
		controller : 'MainCtrl'
	}).otherwise({
		redirectTo : '/'
	});
});