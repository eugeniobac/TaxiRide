'use strict';

var csrServices = angular.module('csrServices', [ 'ngResource' ]);

csrServices.factory('Books', [ '$resource', function($resource) {
	return $resource('api/bookservices/:pendingTransactions/:id', {
		id : '@id'
	}, {
		get : {
			params : {
				'pendingTransactions' : 'pendingTransactions',
			}
		}
	});
} ]);
