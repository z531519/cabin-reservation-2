
angular.module('cabinReservation.employeebidsModule.controllers',
    ['cabinReservation.employeebidsModule.services'])
    .controller('employeebidsController',
                 ['$scope', '$state', '$stateParams', 'employeebidsService', 'employeeService',
        function ($scope,    $state,   $stateParams,   employeebidsService,   employeeService) {
            'use strict';
            $scope.employees = employeeService.list.query();

            $scope.viewBidsByEmployee = function(employee) {
                if (employee != null) {
                    $scope.bids = employeebidsService.bids.query({employeeId:employee.id});
                }
            }

        }
    ])
    ;