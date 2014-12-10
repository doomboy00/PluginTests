var cordova = require('cordova');

/**
 * @constructor
 */
function Echo () {}

/**
 * @param {String}   text      The content to echo
 * @param {Function} onSuccess The function to call in case of success
 */
Echo.prototype.echo = function (text, onSuccess) {
    if (typeof text === "undefined" || text === null) text = "";
	cordova.exec(onSuccess, function(msg) { alert('Plugin error - ' + msg); }, "Echo", "echo", [text]);
};

// Register the plugin
var echo = new Echo();
module.exports = echo;
