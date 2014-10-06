
angular.module('cabinReservation.employeebidsModule.controllers',
    ['cabinReservation.employeebidsModule.services'])
    .controller('employeebidsController',
    ['$scope', '$state', '$stateParams', 'employeebidsService', 'employeeService',
        function ($scope,    $state,   $stateParams,   employeebidsService,   employeeService) {
            'use strict';
            $scope.employees = employeeService.list.query();
            $scope.selectedEmployee = null;
            $scope.viewBidsByEmployee = function(employee) {
                if (employee != null) {
                    $scope.selectedEmployee = employee;
                    $state.go('employeebids.list', {employeeId: employee.id});
//                    $scope.bids = employeebidsService.bids.query({employeeId:employee.id});
                }
            }


            $scope.editEmployee = function (employee) {
                var modalInstance = $modal.open({
                    templateUrl: '/app/employees/edit.html',
                    controller: 'employeeEditController',
                    size: 'lg',
                    resolve: {
                        employee: function () {
                            return employee;
                        }
                    }
                });
                modalInstance.result.then(function (selectedItem) {
                    $scope.employees = employeeService.list.query();
                });
            }

        }
    ])
    .controller('employeebidsListController',
    ['$scope', '$state', '$stateParams', 'employeebidsService', 'employeeService',
        function ($scope,    $state,   $stateParams,   employeebidsService,   employeeService) {
            'use strict';
            $scope.bids = employeebidsService.bids.query({employeeId:$stateParams.employeeId});

            $scope.openBidEditor = function($event) {
                $event.preventDefault();
                $event.stopPropagation();

                $scope.opened = true;
            };

        }
    ])
    ;