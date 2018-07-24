# Cordova Phoneinfo plugin

**This plugin can be used within a Cordova app to provide info from the device. Currently it works for Android only. I am planning to add iOS support in the future. This plugin can be used for apps for phones *and tablets* even though I clearly named it 'phoneinfo', but be aware that some calls may not work on tablets.**

## Supported information
The plugin currently provides support to retreive the following device information:
* Sim Serial Number
* Software Version
* Phone Number (also known as line1Number)
* IMEI
* MEID
## Installation
```
cordova plugin add cordova-plugin-phoneinfo
```
## How to use
All calls are part of the 'phone' object. After installing this plugin you should be able to access the 'phone' object with javascript.

```javascript
phone.getSimSerialNumber(function(res) {
  // Do something with res
});
phone.getDeviceSoftwareVersion(function(res) {
  // Do something with res
});
phone.getImei(function(res) {
  // Do something with res
});
```
### Supported calls
getSimSerialNumber(callback) - Returns the sim card's unique number
getDeviceSoftwareVersion(callback) - Returns the device's software version
getImei(callback) - Returns the IMEI
getMeid(callback) - Returns the MEID
getPhoneNumber(callback) - Returns the line1Number, if available.
### Important notes
* Sometimes a call may return NULL, this means that the information is not available or not accessible.
* In order for the entire plugin to work, the android permission READ_PHONE_STATE needs to be granted.

## Requests
Feel free to contact me with info requests you need, the android SDK offers so many info I wont be able to provide it all at once.
