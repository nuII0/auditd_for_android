package org.nuii0.nuii0.androidforensik.SocketOperations;

/** Jeder Request und jede Response hat einen Identifier,
 * welcher in diesem Enum abgebildelt wird.
 * Die Gegenstelle muss dieselben Werte für die Kommunikation verwenden.
 */
public enum ID {
    PingRequest(0),
    PongResponse(10),
    AuditRuleListRequest(1),
    AuditRuleListResponse(111),
    AuditRuleAddRequest(2),
    AuditRuleAddResponse(222),
    AuditRuleDeleteRequest(3),
    AuditRuleDeleteResponse(333),
    AusearchRequest(4),
    AusearchResponse(444);

    public final int id;

    ID(int id) {
        this.id = id;
    }
}