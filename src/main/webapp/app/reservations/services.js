"use strict";

angular.module('cabinReservation.reservationModule.services', ['ngResource'])
    .factory('reservationService',
        [
            '$resource',
            function($resource) {
                return {
                    findByMonthYear: $resource('reservations')
                }
            }
        ]);