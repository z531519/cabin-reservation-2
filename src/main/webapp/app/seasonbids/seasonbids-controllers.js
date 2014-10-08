
angular.module('cabinReservation.seasonbidsModule.controllers',
    ['cabinReservation.seasonbidsModule.services'])
    .controller('seasonbidsController', ['$scope', '$state', '$stateParams', 'seasonbidsService',
        function ($scope, $state, $stateParams, seasonbidsService) {
            'use strict';
            $scope.params = $stateParams;
            $scope.selectedSeason = null;
            $scope.seasons = seasonbidsService.list.query();

            $scope.viewBids = function(season) {
                console.log(season);
                $scope.selectedSeason = season;
                $state.go('seasons.bids', {seasonId:season.id});
            }

        }
    ])
    .controller('bidsController',
                ['$scope', '$stateParams', 'seasonbidsService',
        function( $scope,   $stateParams,   seasonbidsService) {
            'use strict';
            $scope.params = $stateParams;
            $scope.seasonId = $stateParams.seasonId;

            $scope.bids = seasonbidsService.bids.query({seasonId: $scope.params.seasonId});

            $scope.evaluateBids = function() {
                console.log({seasonId:$scope.params.seasonId});

                (new seasonbidsService.evaluateBids()).$save({seasonId:$scope.params.seasonId}
                , function() {
                    $scope.bids = seasonbidsService.bids.query({seasonId: $scope.params.seasonId});
                });
            };

            $scope.revokeBid = function(bid) {
                seasonbidsService.revokeBid(bid);
//                bid.$save({seasonId:$stateParams.seasonId});
            }

        }
    ])
    ;