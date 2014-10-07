"use strict";

angular.module('cabinReservation.employeebidsModule.services', ['ngResource'])
    .factory('employeebidsService',
        [
            '$resource',
            function($resource) {
                return {
                    bids: $resource('employees/:employeeId/bids/:id'),
                    save: $resource('employees/:employeeId/bids'),
                    reorder: $resource('employees/:employeeId/bids/reorder')
                }
            }
        ]);