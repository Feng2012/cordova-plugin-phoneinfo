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
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);    
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if (action.equals("simserialnumber")) {
      try {
        TelephonyManager telemamanger = (TelephonyManager) webView.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        String simSerialNumber = telemamanger.getSimSerialNumber();

        PluginResult result = new PluginResult(PluginResult.Status.OK, simSerialNumber);
        callbackContext.sendPluginResult(result);
      } catch (Exception ex) {
        PluginResult result = new PluginResult(PluginResult.Status.OK, ex.toString());
        callbackContext.sendPluginResult(result);
      }
    }

    return true;
  }
}
