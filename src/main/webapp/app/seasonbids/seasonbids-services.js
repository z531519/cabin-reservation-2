"use strict";

angular.module('cabinReservation.seasonbidsModule.services', ['ngResource'])
    .factory('seasonbidsService',
        [
            '$resource',
            function($resource) {
                return {
                    list: $resource('seasons'),
                    bids: $resource('seasons/:seasonId/bids')
                }
            }
        ]);