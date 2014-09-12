
angular.module('cabinReservation.assetsModule.assetListController', ['cabinReservation.assetsModule.assetService'])
    .controller('assetListController', ['$scope', 'assetService',
        function ($scope, assetService) {
            'use strict';
            $scope.assets = assetService.list.get();
        }
    ]);