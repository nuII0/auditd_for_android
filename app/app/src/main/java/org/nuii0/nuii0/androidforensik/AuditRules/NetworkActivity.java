package org.nuii0.nuii0.androidforensik.AuditRules;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.nuii0.nuii0.androidforensik.Ausearch.AusearchEntry;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Sockaddr;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Syscall;

public class NetworkActivity extends AuditRule {

    public final static String KEY = "networkactivity";

    public NetworkActivity() {
        super("exit", "always", KEY );
    }
    @Override
    public String toString() {
        return "Netzwerkaktivität (IPv4/IPv6 connect)";
    }

    @Override
    public String detail() {
        return "Nicht verfügbar.";
    }

    @Override
    public String auditctlDeleteString() {
        return "-d " + this.action + "," + this.filter + " -F " + "arch=b32 " + " -F " + "a0=3 " + "-S"  + "socketcall " + "-k " + KEY;
    }

    @Override
    public String auditctlAddString() {
        return "-a " + this.action + "," + this.filter + " -F " + "arch=b32 " + " -F " + "a0=3 " + "-S"  + "socketcall " + "-k " + KEY;
    }

    @Override
    public ArrayList<AusearchEntry> filterEntries(ArrayList<AusearchEntry> list) {

        ArrayList<AusearchEntry> tmp = new ArrayList<>();

        String last = new String();
        for (AusearchEntry entry: list) {
                            tmp.add(entry);
            }


        return tmp;
    }

    @Override
    public ArrayList<String> formatEntry(ArrayList<AusearchEntry> list) {
        ArrayList<String> tmp = new ArrayList<>();
        SimpleDateFormat df = new SimpleDateFormat("kk:mm:ss", Locale.ENGLISH);
        for (AusearchEntry entry: list) {
            Sockaddr sockaddr = entry.getSubclassType(Sockaddr.class).get(0);
            Syscall syscall = entry.getSubclassType(Syscall.class).get(0);


            tmp.add("Prozess:" + syscall.comm + "\n" + "Familie:" + sockaddr.family +
                    "\n" + sockaddr.host + "\n" + sockaddr.serv +
                    "\nZeit: " + df.format(entry.time));
        }

        return tmp;
    }

}
