"use strict";

angular.module('cabinReservation.employeeModule.services', ['ngResource'])
    .factory('employeeService',
        [
            '$resource',
            function($resource) {
                return {
                    list: $resource('employees/:employeeId'),
                    save: $resource('employees/:employeeId'),
                    reservations: $resource('employees/:employeeId/reservations')
                }
            }
        ]);