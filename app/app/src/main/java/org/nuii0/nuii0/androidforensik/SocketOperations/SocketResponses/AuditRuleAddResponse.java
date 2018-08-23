package org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses;

import android.util.Log;

import org.json.JSONException;

import org.nuii0.nuii0.androidforensik.SocketOperations.ID;

/**
 * Dieser Response wird gesendet wenn vorher ein AuditRuleAddRequest geschickt wurde.
 * Er sagt aus, ob das Anlegen der Regel erfolgreich war oder nicht.
 */
public class AuditRuleAddResponse extends Response {
    private static final String TAG = Response.class.getSimpleName();

    private static int RESPONSE_ID = ID.AuditRuleAddResponse.id;
    public AuditRuleAddResponse(byte[] data) {
        super(data,RESPONSE_ID);
    }

    public Boolean success() {
        Boolean success = false;
        try {
            if (json.getInt("success") == 1)
                success = true;
        } catch (JSONException e) {
            Log.e(TAG,"Fehler beim Verarbeiten von JSON Daten.");
            e.printStackTrace();
        }
        return success;
    }
}
