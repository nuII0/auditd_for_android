package org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses;


import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import static java.lang.System.exit;

/**
 * Diese Klasse modelliert die Basisklasse für eine Response, welcher über den Socket empfangen werden kann.
 * Die Klasse beschreibt, wie ein Response von einem ByteArray zu konvertieren wird.
 */
public abstract class Response {
    private static final String TAG = Response.class.getSimpleName();

    protected JSONObject json;
    protected int id;

    public Response(byte[] data, int expected_id) {
        String jsonString = new String(data);
        try {
            json = new JSONObject(jsonString);
            this.id = json.getInt("id");
        } catch (JSONException e) {
            Log.e(TAG, "JSON kann nicht geparsed werden. Erhaltener String: " + jsonString);
            e.printStackTrace();
            exit(1);
        }
        verifyId(expected_id);
        Log.d(TAG, jsonString);
    }

    protected void verifyId(int id) {
        if (id != this.id) {
            try {
                throw new IOException("Die erhaltene ID stimmt nicht mit der ID des erwarteten \"" +
                        "Antwortpaketes überein." +
                        "Erhalten: " + this.id + " " +
                        "Erwartet: " + id + "\n");
            } catch (IOException e) {
                e.printStackTrace();
                exit(1);
            }
        }
    }
}
