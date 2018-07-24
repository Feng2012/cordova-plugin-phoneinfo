const exec = require('cordova/exec');

let plugin = { 
  getSimSerialNumber(callback) {
    exec(callback, null, 'PhoneInfo', 'getSimSerialNumber', null);
  },
  getDeviceSoftwareVersion(callback) {
    exec(callback, null, 'PhoneInfo', 'getDeviceSoftwareVersion', null);
  },
  getImei(callback) {
    exec(callback, null, 'PhoneInfo', 'getImei', null);
  },
  getPhoneNumber(callback) {
    exec(callback, null, 'PhoneInfo', 'getLine1Number', null);
  },
  getMeid(callback) {
    exec(callback, null, 'PhoneInfo', 'getMeid', null);
  }
};

module.exports = plugin;