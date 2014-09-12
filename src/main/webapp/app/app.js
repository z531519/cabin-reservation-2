"use strict";

//var app = window.cabinReservationApp = angular.module('cabinReservation', ['ngResource', 'ngRoute', 'ui.router']);

angular.module('cabinReservation.assetsModule', [
        'ngResource', 'hateoas',
        'cabinReservation.assetsModule.assetListController',
        'cabinReservation.assetsModule.assetService'
    ]);

angular.module('cabinReservation',['ui.router', 'cabinReservation.assetsModule'])
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
            .state('viewassets', {

                url: '/viewassets',
                views: {
                    'results': {
                        templateUrl: '/app/assets/results.html',
                        controller: 'assetListController'
                    }

                }
            });
        }
        ]);


