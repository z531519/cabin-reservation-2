
angular.module('cabinReservation.employeeModule.controllers',
    ['cabinReservation.employeeModule.services'])
    .controller('employeeListController', ['$scope', 'employeeService',
        function ($scope, employeeService) {
            'use strict';
            $scope.employees = employeeService.list.get();
        }
    ]);