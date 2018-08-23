package org.nuii0.nuii0.androidforensik.SocketOperations.SocketRequests;

import android.util.Log;

import org.json.JSONException;

import org.nuii0.nuii0.androidforensik.Request;
import org.nuii0.nuii0.androidforensik.SocketOperations.ID;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.AusearchResponse;

import static java.lang.System.exit;

/**
 * Dieser Request enthält Parameter die an 'ausearch' weitergeleitet werden um
 * aufgelaufende Ereignisse aus dem Audit-System zu erhalten.
 */
public class AusearchRequest extends Request {
    private static final String TAG = AusearchRequest.class.getSimpleName();

    public AusearchRequest(String param) {
        super(ID.AusearchRequest.id);
        try {
            json.put("param", param);
        } catch (JSONException e) {
            Log.e(TAG,"Ausearch konnte nicht abgefragt werden.");
            e.printStackTrace();
            exit(1);
        }
    }

    @Override
    public AusearchResponse makeResponse(byte[] data) {
        return new AusearchResponse(data);
    }
}
