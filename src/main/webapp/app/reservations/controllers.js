
angular.module('cabinReservation.reservationModule.controllers',
    ['cabinReservation.employeeModule.services', 'cabinReservation.reservationModule.services'])
    .controller('reservationController', ['$scope', '$stateParams', 'reservationService',
        function ($scope,$stateParams, reservationService) {
            'use strict';
            $scope.params = $stateParams;

            var currentDate = new Date();

            $scope.reservations = reservationService.findByMonthYear.query( {month: currentDate.getMonth()+1, year: currentDate.getFullYear()});

//            $scope.employee = employee;
//            $scope.reservations = employeeService.reservations.query({employeeId: employee.id });

        }
    ])
    ;