"use strict";

angular.module('cabinReservation.assetsModule.services', ['ngResource'])
    .factory('assetService',
        [
            '$resource',
            function($resource) {
                return {
                    list: $resource('assets/:assetId')
                }
            }
        ]);