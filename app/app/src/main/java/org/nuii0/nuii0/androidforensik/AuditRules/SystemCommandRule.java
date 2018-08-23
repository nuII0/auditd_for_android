package org.nuii0.nuii0.androidforensik.AuditRules;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.nuii0.nuii0.androidforensik.Ausearch.AusearchEntry;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Syscall_exit;

public class SystemCommandRule extends AuditRule {

    public final static String KEY = "systemcommands";

    public SystemCommandRule() {
        super("exit", "always", KEY );
    }
    @Override
    public String toString() {
        return "Systembefehle";
    }

    @Override
    public String detail() {
        return toString();
    }

    @Override
    public String auditctlDeleteString() {
        return "-d " + this.action + "," + this.filter + " -S " + "exit" + " -S " + "exit_group" + " -k " + key;
    }

    @Override
    public String auditctlAddString() {
        return "-a " + this.action + "," + this.filter + " -S " + "exit" + " -S " + "exit_group" + " -k " + key;
    }

    @Override
    public ArrayList<AusearchEntry> filterEntries(ArrayList<AusearchEntry> list) {

        ArrayList<AusearchEntry> tmp = new ArrayList<>();

        String last = new String();
        for (AusearchEntry entry: list) {
            for (Syscall_exit syscall : entry.getSubclassType(Syscall_exit.class)) {
                if(syscall.exe.contains("/system/bin") && !syscall.exe.contains("app_process"))
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
            Syscall_exit syscall = entry.getSubclassType(Syscall_exit.class).get(0);
            tmp.add("Systembefehl ausgeführt: " + syscall.comm + "\nZeit: " + df.format(entry.time));
        }

        return tmp;
    }

}
