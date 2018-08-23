package org.nuii0.nuii0.androidforensik.AuditRules;


public class SyscallRule extends AuditRule {
    public String watch;
    public String perm;
    public String syscall;

    public SyscallRule(String action, String filter, String syscall, String key) {
        super(action, filter, key);
        this.syscall = syscall;
    }
    @Override
    public String toString() {
        return "Systemcall: " + syscall;
    }

    @Override
    public String detail() {
        return "Nicht verfügbar.";
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
