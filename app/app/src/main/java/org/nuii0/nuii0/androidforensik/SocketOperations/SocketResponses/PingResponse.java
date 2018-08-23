package org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses;

/**
 * Passende Antwort auf ein 'PingRequest'.
 */
public class PingResponse extends Response {
    private static final String TAG = Response.class.getSimpleName();

    private static int RESPONSE_ID = 1;
    public PingResponse(byte[] data) {
        super(data,RESPONSE_ID);
    }
}
