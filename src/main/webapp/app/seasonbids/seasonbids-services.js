"use strict";

angular.module('cabinReservation.seasonbidsModule.services', ['ngResource'])
    .factory('seasonbidsService',
        [
            '$resource',
            function($resource) {
                var revokeBid = function(bid) {
                    bid.won = false;
                    bid.checkinDate + ' 00:00';
                    bid.$save();
                };
                return {
                    list: $resource('seasons'),
                    bids: $resource('seasons/:seasonId/bids/:bidId', {bidId: '@id'}, {
                        save:{
                            url:'bids/:bidId',
                            method:'POST',
                            isArray:false
                        }
                    }),
                    evaluateBids: $resource('seasons/:seasonId/bids/evaluate'),
                    revokeBid : revokeBid
                }
            }
        ]);