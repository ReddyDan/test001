var utils = require('cordova/utils'),
    exec = require('cordova/exec'),
    cordova = require('cordova');

var SecureKey =function SecureKey() {
    this.key=null;
    this.iv=null;
    var me = this;
    me.getInfo(function(info) {
        me.available = true;
        me.key=info.key;
        me.iv=info.iv;
    },function(e) {
        me.available = false;
        utils.alert("[ERROR] Error initializing Cordova: " + e);
    });
};

/**
 * Get SecureKey info
 *
 * @param {Function} successCallback The function to call when the heading data is available
 * @param {Function} errorCallback The function to call when there is an error getting the heading data. (OPTIONAL)
 */
SecureKey.prototype.getInfo = function(successCallback, errorCallback) {
    exec(successCallback, errorCallback, "SecureKey", "getSecureKeyInfo", []);
};

module.exports = new SecureKey();

