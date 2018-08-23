package org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import org.nuii0.nuii0.androidforensik.SocketOperations.ID;

/**
 * Dieser Response wird gesendet wenn vorher ein AuditRuleListRequest geschickt wurde.
 * Er enthält alle angelegten Audit-Regeln.
 */
public class AuditRuleListResponse extends Response {
    private static final String TAG = Response.class.getSimpleName();

    private static int RESPONSE_ID = ID.AuditRuleListResponse.id;
    public AuditRuleListResponse(byte[] data) {
        super(data,RESPONSE_ID);
    }

    public ArrayList<String> entries() {
        ArrayList<String> list = new ArrayList<String>();
        try {
            JSONArray jsonArray = json.getJSONArray("entries");
            if (jsonArray != null) {
                int len = jsonArray.length();
                for (int i=0;i<len;i++){
                    list.add(jsonArray.get(i).toString());
                }
            }
        } catch (JSONException e) {
            Log.e(TAG,"Fehler beim Verarbeiten von JSON Daten.");
            e.printStackTrace();
        }
        return list;
    }
}
