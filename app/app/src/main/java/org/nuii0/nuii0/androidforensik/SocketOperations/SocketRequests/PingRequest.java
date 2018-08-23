package org.nuii0.nuii0.androidforensik.SocketOperations.SocketRequests;

import org.nuii0.nuii0.androidforensik.Request;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.PingResponse;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.Response;

/**
 * Dieser PingRequest kann verwendet werden um zu prüfen,
 * ob die Socketverbindung besteht.
 */
public class PingRequest extends Request {
    private static final String TAG = Response.class.getSimpleName();

    public PingRequest() {
        super(0);
    }

    @Override
    public Response makeResponse(byte[] data) {
        return new PingResponse(data);
    }
}
