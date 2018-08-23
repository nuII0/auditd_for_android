package org.nuii0.nuii0.androidforensik.AuditRules;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.nuii0.nuii0.androidforensik.Ausearch.AusearchEntry;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Syscall;

public class ExecveRule extends AuditRule {

    public final static String KEY = "execve";

    public ExecveRule() {
        super("exit", "always", KEY );
    }
    @Override
    public String toString() {
        return "Execve Auditing";
    }

    @Override
    public String detail() {
        return "Nicht verfügbar.";
    }

    @Override
    public String auditctlDeleteString() {
        return "-d " + this.action + "," + this.filter + " -F " + "euid=0" + " -S " + "11" + " -k " + key;
    }

    @Override
    public String auditctlAddString() {
        return "-a " + this.action + "," + this.filter + " -F " + "euid=0" + " -S " + "11" + " -k " + key;
    }

    @Override
    public ArrayList<AusearchEntry> filterEntries(ArrayList<AusearchEntry> list) {

        ArrayList<AusearchEntry> tmp = new ArrayList<>();

        String last = new String();
        for (AusearchEntry entry: list) {
            for (Syscall syscall : entry.getSubclassType(Syscall.class)) {
                            tmp.add(entry);
            }
        }

        return tmp;
    }

    @Override
    public ArrayList<String> formatEntry(ArrayList<AusearchEntry> list) {
        ArrayList<String> tmp = new ArrayList<>();
        SimpleDateFormat df = new SimpleDateFormat("kk:mm:ss", Locale.ENGLISH);
        for (AusearchEntry entry: list) {
            Syscall syscall = entry.getSubclassType(Syscall.class).get(0);
            tmp.add("Execve Syscall: " + syscall.exe + "\nZeit: " + df.format(entry.time));
        }

        return tmp;
    }

}
