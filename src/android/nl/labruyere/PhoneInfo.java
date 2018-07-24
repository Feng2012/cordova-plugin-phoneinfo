/**
 */
package nl.labruyere;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.widget.Toast;
import android.content.Context;
import android.telephony.TelephonyManager;

import android.util.Log;

import java.util.Date;

public class PhoneInfo extends CordovaPlugin {
  public TelephonyManager telephonyManager;

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    this.telephonyManager = (TelephonyManager)webView.getContext().getSystemService(Context.TELEPHONY_SERVICE);
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    try {
      if (action.equals("getSimSerialNumber")) {
        this.SendResult(callbackContext, this.telephonyManager.getSimSerialNumber());
        return true;
      }

      if (action.equals("getDeviceSoftwareVersion")) {
        this.SendResult(callbackContext, this.telephonyManager.getDeviceSoftwareVersion());
        return true;
      }

      if (action.equals("getImei")) {
        this.SendResult(callbackContext, this.telephonyManager.getImei());
        return true;
      }

      if (action.equals("getLine1Number")) {
        this.SendResult(callbackContext, this.telephonyManager.getLine1Number());
        return true;
      }

      if (action.equals("getMeid")) {
        this.SendResult(callbackContext, this.telephonyManager.getMeid());
        return true;
      }

      this.SendResult(callbackContext, "Unknown action " + action);
      return true;
    } catch (Exception ex) {
      this.SendResult(callbackContext, ex.toString());
      return false;
    }
  }

  public void SendResult(CallbackContext callbackContext, String data) {
    PluginResult result = new PluginResult(PluginResult.Status.OK, data);
    callbackContext.sendPluginResult(result);
  }
}
