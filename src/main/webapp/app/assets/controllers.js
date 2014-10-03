
angular.module('cabinReservation.assetsModule.controllers', ['cabinReservation.assetsModule.services'])
    .controller('assetListController', ['$scope', 'assetService',
        function ($scope, assetService) {
            'use strict';
            $scope.assets = assetService.list.query();
        }
    ]);