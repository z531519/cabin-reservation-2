
angular.module('cabinReservation.employeebidsModule.controllers',
    ['angular-underscore', 'cabinReservation.employeebidsModule.services', 'cabinReservation.assetsModule.services'])
    .controller('employeebidsController',
                 ['$scope', '$state', '$stateParams', '$modal', 'employeebidsService', 'employeeService',
        function ($scope,    $state,   $stateParams,   $modal,   employeebidsService,   employeeService) {
            'use strict';
            $scope.employees = employeeService.list.query();
            $scope.viewBidsByEmployee = function(employee) {
                if (employee != null) {
                    $scope.employee = employee;
                    $state.go('employeebids.list', {employeeId: employee.id});
                }
            }


        }
    ])
    .controller('employeebidsListController',
                ['$scope', '$state',  '$stateParams', '$modal', 'employeebidsService', 'employeeService',
        function ($scope,    $state,   $stateParams,   $modal,   employeebidsService,   employeeService) {
            'use strict';

            $scope.dirtyOrder = false;

            function reorder() {
                var p = 0;
                $scope.dirtyOrder = false;
                angular.forEach($scope.bids, function(el){
                    if (el.priority !== p) {
                        $scope.dirtyOrder = true;
                    }
                    el.repriority = p++;
                });
            }

            function retrieveBids() {
                $scope.bids = employeebidsService.bids.query({employeeId:$stateParams.employeeId}, function() {
                    reorder();

                });
            }

            retrieveBids(); // initialize the bids


            if ($scope.employee == null) {
                $scope.employees = employeeService.list.query( function() {
                    $scope.employee = _.find($scope.employees, function (el) {
                        return el.id == $stateParams.employeeId;
                    });
                    $scope.$parent.employee = $scope.employee;
                });
            }

            $scope.openBidEditor = function($event) {
                $event.preventDefault();
                $event.stopPropagation();

                $scope.opened = true;
            };

            $scope.newEmployeeBid = function (employee) {
                var modalInstance = $modal.open({
                    templateUrl: '/app/employeebids/editbid.html',
                    controller: 'employeebidsEditController',
                    size: 'lg',
                    resolve: {
                        employee: function () {
                            return $scope.employee;
                        }
                    }
                });
                modalInstance.result.then(function (selectedItem) {
                    retrieveBids();
                });
            };

            $scope.deleteEmployeeBid = function(bid) {
                bid.$delete({employeeId:bid.employee.id, id:bid.id}, function() {
                    retrieveBids();
                });
            }

            $scope.applyReorder = function() {
                var reorder = new employeebidsService.reorder()
                reorder.order = [];
                angular.forEach($scope.bids, function(el) {
                   reorder.order.push( {id:el.id, priority: el.repriority});
                });
                reorder.$save({employeeId: $scope.employee.id}, function() {
                    $scope.dirtyOrder = false;
                    retrieveBids();
                });
            };

            $scope.sortOptions = {
                stop: function(e, ui) {
                    console.log(e);
                    console.log(ui);
                    reorder();
                }
            }

        }
    ])
    .controller('employeebidsEditController',
                 ['$scope', '$state', '$modalInstance', 'employeebidsService', 'assetService', 'employee',
        function ($scope,    $state,   $modalInstance,   employeebidsService,   assetService,   employee) {
            'use strict';

            $scope.employee = employee;
            $scope.assets = assetService.list.query();
            $scope.checkinDate = new Date();

            $scope.bid = new employeebidsService.save();
            $scope.isNewBid = true;
            $scope.bid.employee = $scope.employee


            $scope.open = function($event) {
                $event.preventDefault();
                $event.stopPropagation();

                $scope.opened = true;
            };

            $scope.ok = function () {
                $scope.bid.checkinDate = $scope.checkinDate.getTime();
                if ($scope.isNewBid) {
                    $scope.bid.$save( {employeeId : employee.id},  function() {$modalInstance.close($scope.bid);});
                } else {
                    $scope.bid.$save({employeeId: $scope.employee.id}, function() {$modalInstance.close($scope.bid);});
                }

            };

            $scope.cancel = function () {
                $modalInstance.dismiss('cancel');
            };
        }
    ])
    ;