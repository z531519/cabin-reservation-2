"use strict";

angular.module('cabinReservation.employeebidsModule.services', ['ngResource'])
    .factory('employeebidsService',
        [
            '$resource',
            function($resource) {
                return {
                    bids: $resource('employees/:employeeId/bids'),
                    save: $resource('employees/:employeeId/bids')
                }
            }
        ]);