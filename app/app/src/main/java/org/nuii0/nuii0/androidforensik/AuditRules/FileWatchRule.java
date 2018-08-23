package org.nuii0.nuii0.androidforensik.AuditRules;


public class FileWatchRule extends AuditRule {
    public String watch;
    public String perm;

    public FileWatchRule(String action, String filter, String watch, String perm, String key) {
        super(action, filter, key);
        this.watch = watch;
        this.perm = perm;
    }
    @Override
    public String toString() {
        return "Pfadüberwachung: " + watch;
    }

    @Override
    public String detail() {
        return "Pfad: " + watch + " \n" + "Modi: " + perm;
    }

    @Override
    public String auditctlDeleteString() {
        return "-W " + watch + " -p " + perm + " -k " + key;
    }

    @Override
    public String auditctlAddString() {
        return "-w " + watch + " -p " + perm + " -k " + key;
    }

}
