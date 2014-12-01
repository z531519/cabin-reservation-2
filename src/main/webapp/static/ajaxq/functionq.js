// AjaxQ jQuery Plugin
// Copyright (c) 2012 Foliotek Inc.
// MIT License
// https://github.com/Foliotek/ajaxq

// Extended version of ajaxq adding a functionality to add a functionq.  Basically allowing both ajax and function calls to
//  get queued up in their respective queues.  This allows for proper sequential processing of something like this
//
//  function call1() {  asyncAjaxCall(); }
//  function call2() {  asyncAjaxCall(); }
//
//  call1();
//  call2();
//
//  The async ajax call will typically allow call1 and call2 to proceed without waiting for the asnyc ajax calls to return.
//    However, we do want the whole of call2 to wait (note -- not the asyncAjaxCall within call2, but all of call2) for
//    call1's async ajax call to complete before proceeding.

//  TODO:  I think this can be done simply via jQuery.Deferred to simply allow chaining of ajax and function calls.  TBD






(function($) {

    var queues = {};
    var activeReqs = {};

    // Register an $.ajaxq function, which follows the $.ajax interface, but allows a queue name which will force only one request per queue to fire.
    $.ajaxq = function(qname, opts) {

        if (typeof opts === "undefined") {
            throw ("AjaxQ: queue name is not provided");
        }

        // Will return a Deferred promise object extended with success/error/callback, so that this function matches the interface of $.ajax
        var deferred = $.Deferred(),
            promise = deferred.promise();

        promise.success = promise.done;
        promise.error = promise.fail;
        promise.complete = promise.always;

        // Create a deep copy of the arguments, and enqueue this request.
        var clonedOptions = $.extend(true, {}, opts);
        enqueue(qname, function () {

            // Send off the ajax request now that the item has been removed from the queue
            var jqXHR = $.ajax.apply(window, [clonedOptions]);

            // Notify the returned deferred object with the correct context when the jqXHR is done or fails
            // Note that 'always' will automatically be fired once one of these are called: http://api.jquery.com/category/deferred-object/.
            jqXHR.done(function () {
                deferred.resolve.apply(this, arguments);
            });
            jqXHR.fail(function () {
                deferred.reject.apply(this, arguments);
            });

            deferred.always(function() {
                dequeue(qname);
            }); // make sure to dequeue the next request AFTER the done and fail callbacks are fired

            return jqXHR;
        });

        return promise;
    };

    // Register an $.functionq function, which follows the $.ajax interface, but allows a queue name which will force only one request per queue to fire.
    //  block - set to true to turn on a blocking frame on browser window when this call is made to prevent further interaction
    //
    $.functionq = function(qname, opts, block) {

        if (typeof opts === "undefined") {
            throw ("functionq: queue name is not provided");
        }

        if (typeof block === "undefined") {
            block = false;
        }

        // Will return a Deferred promise object extended with success/error/callback, so that this function matches the interface of $.ajax
        var deferred = $.Deferred(),
            promise = deferred.promise();

        promise.success = promise.done;
        promise.error = promise.fail;
        promise.complete = promise.always;

        // Create a deep copy of the arguments, and enqueue this request.
        var clonedOptions = $.extend(true, {}, opts);

        enqueue(qname, function () {

            if (block) {
                console.log("Block User Interaction");
            }

            opts(deferred);

            deferred.resolve.apply(this, arguments);
            deferred.always(function() {
                dequeue(qname);
            }); // make sure to dequeue the next request AFTER the done and fail callbacks are fired

            if (block) {
                console.log("Release Block Usr Interaction");
            }
            return deferred;
        });

        return clonedOptions;
    };


        // If there is no queue, create an empty one and instantly process this item.
        // Otherwise, just add this item onto it for later processing.
        function enqueue(qname, cb) {
            if (!queues[qname]) {
                queues[qname] = [];
                console.log("Running for " + qname);
                var xhr = cb();
                activeReqs[qname] = xhr;
            }
            else {
                queues[qname].push(cb);
            }
        }

        // Remove the next callback from the queue and fire it off.
        // If the queue was empty (this was the last item), delete it from memory so the next one can be instantly processed.
        function dequeue(qname) {
            if (!queues[qname]) {
                return;
            }
            var nextCallback = queues[qname].shift();
            if (nextCallback) {
                console.log("Running for " + qname);
                var xhr = nextCallback();
                activeReqs[qname] = xhr;
            }
            else {
                delete queues[qname];
                delete activeReqs[qname];
            }
        }



    var isQueueRunning = function(qname) {
        return queues.hasOwnProperty(qname);
    };

    var isAnyQueueRunning = function() {
        for (var i in queues) {
            if (isQueueRunning(i)) return true;
        }
        return false;
    };

    $.functionq.isRunning = function(qname) {
        if (qname) return isQueueRunning(qname);
        else return isAnyQueueRunning();
    };

    $.functionq.getActiveRequest = function(qname) {
        if (!qname) throw ("functionq: queue name is required");

        return activeReqs[qname];
    };

    $.functionq.abort = function(qname) {
        if (!qname) throw ("functionq: queue name is required");
        
        var current = $.functionq.getActiveRequest(qname);
        delete queues[qname];
        delete activeReqs[qname];
        if (current) current.abort();
    };

    $.functionq.clear = function(qname) {
        if (!qname) {
            for (var i in queues) {
                if (queues.hasOwnProperty(i)) {
                    queues[i] = [];
                }
            }
        }
        else {
            if (queues[qname]) {
                queues[qname] = [];
            }
        }
    };

})(jQuery);
