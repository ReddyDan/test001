/**
 * ADD BY LYZ @2015/07/14
 */
package com.bshinfo.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SecureKey extends CordovaPlugin {
//    public static final String TAG = "SecureKey";

	public static String key="$^*%";
	public static String iv="58$#";

    /**
     * Constructor.
     */
    public SecureKey() {
    }

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
//        SecureKey.uuid = getUuid();
    }

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false if not.
     */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getSecureKeyInfo")) {
            JSONObject r = new JSONObject();
            r.put("key", SecureKey.key);
            r.put("iv", SecureKey.iv);
            callbackContext.success(r);
        }
        else {
            return false;
        }
        return true;
    }
}
