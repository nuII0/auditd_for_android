package org.nuii0.nuii0.androidforensik.SocketOperations.SocketRequests;

import org.nuii0.nuii0.androidforensik.Request;
import org.nuii0.nuii0.androidforensik.SocketOperations.ID;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.AuditRuleListResponse;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.Response;

/**
 * Dieser Request wird verwendet um eine Liste aller bestehenden Audit-Regeln zu erhalten.
 */
public class AuditRuleListRequest extends Request {
    private static final String TAG = Response.class.getSimpleName();

    public AuditRuleListRequest() {
        super(ID.AuditRuleListRequest.id);
    }

    @Override
    public Response makeResponse(byte[] data) {
        return new AuditRuleListResponse(data);
    }
}
