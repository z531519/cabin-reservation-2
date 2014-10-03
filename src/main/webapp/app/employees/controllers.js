
angular.module('cabinReservation.employeeModule.controllers',
    ['cabinReservation.employeeModule.services'])
    .controller('employeeListController', ['$scope', '$modal', 'employeeService',
        function ($scope, $modal, employeeService) {
            'use strict';
            $scope.employees = employeeService.list.query();

            $scope.editEmployee = function (employee) {
                var modalInstance = $modal.open( {
                    templateUrl : '/app/employees/edit.html',
                    controller : 'employeeEditController',
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
    .controller('employeeEditController', ['$scope', '$modalInstance', 'employeeService', 'employee',
        function ($scope, $modalInstance, employeeService, employee) {
            'use strict';
            $scope.employee = new employeeService.save();
            $scope.isNewEmployee = true;
            if (employee) {
                $scope.employee = angular.copy(employee);
                $scope.hireDate = new Date(employee.hired);
                $scope.isNewEmployee = false;
            }
            $scope.ok = function () {
                $scope.employee.hired = $scope.hireDate.getTime();
                if ($scope.isNewEmployee) {
                   $scope.employee.$save( function() {$modalInstance.close($scope.employee);});
                } else {
                    $scope.employee.$save({employeeId: $scope.employee.id}, function() {$modalInstance.close($scope.employee);});
                }

            };

            $scope.cancel = function () {
                $modalInstance.dismiss('cancel');
            };

            $scope.open = function($event) {
                $event.preventDefault();
                $event.stopPropagation();

                $scope.opened = true;
            };
        }
    ]);