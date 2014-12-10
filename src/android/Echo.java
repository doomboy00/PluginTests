
public class Clipboard extends CordovaPlugin {

    private static final String actionCopy = "copy";
    private static final String actionPaste = "paste";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        ClipboardManager clipboard = (ClipboardManager) cordova.getActivity().getSystemService(Context.CLIPBOARD_SERVICE);

        if (action.equals(actionCopy)) {
            try {
                String text = args.getString(0);
                ClipData clip = ClipData.newPlainText("Text", text);

                clipboard.setPrimaryClip(clip);

                callbackContext.success(text);

                return true;
            } catch (JSONException e) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
            } catch (Exception e) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, e.toString()));
            }
        } else if (action.equals(actionPaste)) {
            if (!clipboard.getPrimaryClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.NO_RESULT));
            }

            try {
                ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
                String text = item.getText().toString();

                if (text == null) text = "";

                callbackContext.success(text);

                return true;
            } catch (Exception e) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, e.toString()));
            }
        }

        return false;
    }
}





package co.uk.ultimateweb.test;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

public class Echo extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("echo")) {
            String message = args.getString(0);
            return this.echo(message, callbackContext);
        }
        return false;
    }

    private boolean echo(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
            return true;
        } else {
            callbackContext.error("Expected one non-empty string argument.");
            return false;
        }
    }
}