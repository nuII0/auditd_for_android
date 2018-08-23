package org.nuii0.nuii0.androidforensik;

import org.json.JSONException;
import org.json.JSONObject;

import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.Response;

/**
 * Diese Klasse modelliert die Basisklasse für einen Request, welcher über den Socket abgeschickt werden kann.
 * Die Klasse beschreibt, wie ein Request in ein ByteArray zu konvertieren ist.
 * Ausserdem hält jeder Request die dazugehöhrige Response-Klasse vor und weiss, wie aus einem
 * empfangenen ByteArray eine Response zu bauen ist.
 */
public abstract class Request {
    private static final String TAG = Response.class.getSimpleName();

    public final int id;
    public final JSONObject json;

    public Request(final int id) {
        this.id = id;
        json = new JSONObject();
        try {
            json.put("id", id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    // Zu jedem Request gibt es einen passenden Response,
    // welcher hiermit modelliert wird.
    abstract public Response makeResponse(byte[] data);

    protected byte[] toByteArray() {
        return json.toString().getBytes();
    }
}
