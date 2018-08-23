package org.nuii0.nuii0.androidforensik.AuditRules;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.nuii0.nuii0.androidforensik.Ausearch.AusearchEntry;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Syscall;

public class AppStartStopRule extends AuditRule {

    public final static String KEY = "appstartstopp";

    public AppStartStopRule() {
        super("exit", "always", KEY );
    }
    @Override
    public String toString() {
        return "App Start Auditing";
    }

    @Override
    public String detail() {
        return "Nicht verfügbar.";
    }

    @Override
    public String auditctlDeleteString() {
        return "-d " + this.action + "," + this.filter + " -S " + "120" + " -k " + key;
    }

    @Override
    public String auditctlAddString() {
        return "-a " + this.action + "," + this.filter + " -S " + "120" + " -k " + key;
    }

    @Override
    public ArrayList<AusearchEntry> filterEntries(ArrayList<AusearchEntry> list) {

        ArrayList<AusearchEntry> tmp = new ArrayList<>();

        String last = new String();
        for (AusearchEntry entry: list) {
            for (Syscall syscall : entry.getSubclassType(Syscall.class)) {
                if(syscall.comm.contains("android") &&
                        !syscall.comm.contains("android.display") &&
                        !syscall.comm.contains("android.ui") &&
                        !syscall.comm.contains("android.bg") &&
                        !syscall.comm.contains("android.fg") &&
                        !syscall.comm.contains("android.phone"))
                    if(!tmp.contains(entry)) {
                        if(!syscall.comm.equals(last)) {
                            last = syscall.comm;
                            tmp.add(entry);
                        }
                    }
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
            tmp.add("App Start: " + syscall.comm + "\nZeit: " + df.format(entry.time));
        }

        return tmp;
    }

}
