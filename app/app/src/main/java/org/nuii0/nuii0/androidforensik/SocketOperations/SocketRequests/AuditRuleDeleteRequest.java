package org.nuii0.nuii0.androidforensik.SocketOperations.SocketRequests;

import android.util.Log;

import org.json.JSONException;

import org.nuii0.nuii0.androidforensik.AuditRules.AuditRule;
import org.nuii0.nuii0.androidforensik.Request;
import org.nuii0.nuii0.androidforensik.SocketOperations.ID;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.AuditRuleDeleteResponse;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.Response;

import static java.lang.System.exit;

/**
 * Dieser Request wird verwendet wenn eine Audit-Regel entfernt werden soll.
 * In dem Feld 'rule' steht die Audit-Regel im String-Format.
 */
public class AuditRuleDeleteRequest extends Request {
    private static final String TAG = Response.class.getSimpleName();

    public AuditRuleDeleteRequest(AuditRule rule) {
        super(ID.AuditRuleDeleteRequest.id);
        try {
            json.put("rule", rule.auditctlDeleteString());
        } catch (JSONException e) {
            Log.e(TAG,"Regel konnte nicht eingefügt werden.");
            e.printStackTrace();
            exit(1);
        }
    }

    @Override
    public Response makeResponse(byte[] data) {
        return new AuditRuleDeleteResponse(data);
    }
}
