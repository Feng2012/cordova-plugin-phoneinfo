const exec = require('cordova/exec');

let plugin = { 
  getSimSerialNumber(callback) {
    exec(callback, null, 'PhoneInfo', 'simserialnumber', null);
  }
};

module.exports = plugin;