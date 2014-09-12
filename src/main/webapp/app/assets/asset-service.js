"use strict";

angular.module('cabinReservation.assetsModule.assetService', ['ngResource'])
    .factory('assetService',
        [
            '$resource',
            function($resource) {
                return {
                    list: $resource('assets/:assetId')
                }
            }
        ]);