"use strict";

//var app = window.cabinReservationApp = angular.module('cabinReservation', ['ngResource', 'ngRoute', 'ui.router']);

angular.module('cabinReservation.assetsModule', [
        'ngResource', 'hateoas',
        'cabinReservation.assetsModule.controllers',
        'cabinReservation.assetsModule.services'
    ]);

angular.module('cabinReservation.employeeModule', [
    'ngResource', 'hateoas',
    'cabinReservation.employeeModule.controllers',
    'cabinReservation.employeeModule.services'
]);

angular.module('cabinReservation',
    [   'ui.router',
        'cabinReservation.assetsModule',
        'cabinReservation.employeeModule'
    ])
    .config(function (HateoasInterceptorProvider) {
        HateoasInterceptorProvider.transformAllResponses();
    })
    .config(['$provide', '$httpProvider', '$urlRouterProvider', '$stateProvider',

        function ($provide, $httpProvider, $urlRouterProvider, $stateProvider) {
        "use strict";
//        $provide.constant('contextPath', 'MinervaPreviewHub');
        $provide.constant('pollingInterval', 1000);
//        $httpProvider.interceptors.push('httpInterceptorService');
//        $httpProvider.interceptors.push('httpNoCacheInterceptor');

        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('assets', {

                url: '/assets',
                views: {
                    'results': {
                        templateUrl: '/app/assets/results.html',
                        controller: 'assetListController'
                    }

                }
            })
            .state('employees', {

                url: '/employees',
                views: {
                    'results': {
                        templateUrl: '/app/employees/results.html',
                        controller: 'employeeListController'
                    }

                }
            });
        }
        ]);


