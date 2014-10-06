"use strict";

//var app = window.cabinReservationApp = angular.module('cabinReservation', ['ngResource', 'ngRoute', 'ui.router']);

angular.module('cabinReservation.assetsModule', [
        'ngResource', 'hateoas',
        'cabinReservation.assetsModule.controllers',
        'cabinReservation.assetsModule.services'
    ]);

angular.module('cabinReservation.employeeModule', [
    'ngResource',
    'cabinReservation.employeeModule.controllers',
    'cabinReservation.employeeModule.services'
]);

angular.module('cabinReservation.reservationModule', [
    'ngResource',
    'cabinReservation.reservationModule.controllers'
]);

angular.module('cabinReservation.seasonbidsModule', [
    'ngResource',
    'cabinReservation.seasonbidsModule.controllers'
]);

angular.module('cabinReservation.employeebidsModule', [
    'ngResource',
    'cabinReservation.employeebidsModule.controllers'
]);

angular.module('cabinReservation',
    [   'ui.router', 'ui.bootstrap',
        'cabinReservation.assetsModule',
        'cabinReservation.employeeModule',
        'cabinReservation.reservationModule',
        'cabinReservation.seasonbidsModule',
        'cabinReservation.employeebidsModule'
    ])
    .run(
    [          '$rootScope', '$state', '$stateParams',
        function ($rootScope,   $state,   $stateParams) {

            // It's very handy to add references to $state and $stateParams to the $rootScope
            // so that you can access them from any scope within your applications.For example,
            // <li ng-class="{ active: $state.includes('contacts.list') }"> will set the <li>
            // to active whenever 'contacts.list' or one of its decendents is active.
            $rootScope.$state = $state;
            $rootScope.$stateParams = $stateParams;
        }
    ]
)
//    .config(function (HateoasInterceptorProvider) {
//        HateoasInterceptorProvider.transformAllResponses();
//    })
    .config(['$provide', '$httpProvider', '$urlRouterProvider', '$stateProvider',

        function ($provide, $httpProvider, $urlRouterProvider, $stateProvider) {
//        "use strict";
//        $provide.constant('contextPath', 'MinervaPreviewHub');
        $provide.constant('pollingInterval', 1000);
//        $httpProvider.interceptors.push('httpInterceptorService');
//        $httpProvider.interceptors.push('httpNoCacheInterceptor');

        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('assets', {
                url: '/assets',
                templateUrl: 'app/assets/results.html',
                controller: 'assetListController'
            })
            .state('employees', {
                url: '/employees',
                templateUrl: 'app/employees/results.html',
                controller: 'employeeListController'
            })
            .state('employees.reservations', {
                url: '/reservations',
                views : {
                    '' : {
                        templateUrl: 'app/reservations/results.html',
                        controller: 'reservationController'
                    }
                }
            })
            .state('reservations', {
                url: '/reservations',
                views : {
                    '' : {
                        templateUrl: 'app/reservations/results.html',
                        controller: 'reservationController'
                    }
                }
            })
            .state('seasons', {
                url: '/seasons',
                views : {
                    '' : {
                        templateUrl: 'app/seasonbids/results.html',
                        controller: 'seasonbidsController'
                    }
                }
            })
            .state('seasons.bids', {
                url: '/{seasonId}/bids',
                views : {
                    'bids' : {
                        templateUrl: 'app/seasonbids/bids.html',
                        controller: 'bidsController'
                    }
                }
            })
            .state('employeebids', {
                url: '/bids/employees',
                views : {
                    '' : {
                        templateUrl: 'app/employeebids/bids.html',
                        controller: 'employeebidsController'
                    }
                }
            })
            .state('employeebids.list', {
                url: '/{employeeId}',
                views : {

                    'bids' : {
                        templateUrl: 'app/employeebids/bids.html',
                        controller: 'employeebidsListController'
                    }
                }
            })
        ;
        }
        ]);


