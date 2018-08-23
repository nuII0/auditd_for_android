package org.nuii0.nuii0.androidforensik.AuditRules;


public class EmptyRule extends AuditRule {
    public String mode;
    public String watch;

    public EmptyRule() {
        super(null,null,"nokey");
    }
    public String toString() {
        return "Keine Regeln angelegt.";
    }

    @Override
    public String auditctlDeleteString() {
        return null;
    }

    @Override
    public String auditctlAddString() {
        return null;
    }

    @Override
    public String detail() {
        return null;
    }

}
