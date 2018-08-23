package org.nuii0.nuii0.androidforensik.AuditRules;


public class DirWatchRule extends AuditRule {
    public String dir;
    public String perm;

    public DirWatchRule(String action, String filter, String watch, String perm, String key) {
        super(action, filter, key);
        this.dir = watch;
        this.perm = perm;
    }
    @Override
    public String toString() {
        return "Verzeichnis: " + dir;
    }

    @Override
    public String detail() {
        return "Verzeichnis: " + dir + " \n" + "Modi: " + perm;
    }

    @Override
    public String auditctlDeleteString() {
        return "-W " + dir + " -p " + perm + " -k " + key;
    }

    @Override
    public String auditctlAddString() {
        return "-w " + dir + " -p " + perm + " -k " + key;
    }

}
