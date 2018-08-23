package org.nuii0.nuii0.androidforensik.AuditRules;

import android.util.Log;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.nuii0.nuii0.androidforensik.Ausearch.AusearchEntry;

import static android.content.ContentValues.TAG;

public abstract class AuditRule {
    public String action;
    public String filter;
    public String key;

    public AuditRule(String action, String filter, String key) {
        this.action = action;
        this.filter = filter;
        this.key = key;
    }

    public abstract String toString();
    public abstract String auditctlDeleteString();
    public abstract String auditctlAddString();
    public abstract String detail();
    public ArrayList<AusearchEntry> filterEntries(ArrayList<AusearchEntry> list) {
        return list;
    }

    public ArrayList<String> formatEntry(ArrayList<AusearchEntry> list) {
        ArrayList<String> tmp = new ArrayList<>();
        for (AusearchEntry entry: list) {
            tmp.add("Nicht definiert");
        }

        return tmp;
    }


    /* Der Befehlt 'auditctl' gibt die angelegten Audit-Regeln in einem bestimmten Format zurück.
    Die Funktion buildRule erzeugt aus einem String in diesem Format das korrekte AuditRule-Objekt.

    Der Input sieht zB wie folgt aus:
    LIST_RULES: exit,always watch=/storage/test perm=rwxa key=erm

    In dem Fall wird ein FileWatchRule-Objekt erzeugt.
     */
    public static AuditRule buildRule(String line) throws IllegalArgumentException {
        //Matcher m = Pattern.compile("^LIST_RULES: (\\w*),(\\w*) (.*) key=(\\w*)").matcher(line);
        Matcher m = Pattern.compile("^.*: (\\w*),(\\w*) (.*)").matcher(line);

        // Es wurde eine gültige Audit-Regel erkannt.
        if (m.find()) {
            String action = m.group(1);
            String filter = m.group(2);

            String rest =  m.group(3);

            Pattern fileWatchPattern = Pattern.compile("watch=(.*) perm=(.*) key=(.*)");

            m = fileWatchPattern.matcher(rest);

            if (m.find()) {
                String watch = m.group(1);
                String perm = m.group(2);
                String key = m.group(3);
                return new FileWatchRule(action, filter, watch, perm, key);
            }

            Pattern dirWatchPattern = Pattern.compile("dir=(.*) perm=(.*) key=(.*)");

            m = dirWatchPattern.matcher(rest);

            if (m.find()) {
                String dir = m.group(1);
                String perm = m.group(2);
                String key = m.group(3);
                if (key.equals(CameraActivity.KEY))
                    return new CameraActivity();
                else
                    return new DirWatchRule(action, filter, dir, perm, key);
            }

            Pattern syscallPattern = Pattern.compile("key=(.*) syscall=(.*)");

            m = syscallPattern.matcher(rest);

            if (m.find()) {
                String key = m.group(1);
                String syscall = m.group(2);

                Log.e(TAG,"key: " + key);
                if (key.equals(AppStartStopRule.KEY))
                    return new AppStartStopRule();
                if (key.equals(SystemCommandRule.KEY))
                    return new SystemCommandRule();
                if (key.equals(ExecveRule.KEY))
                    return new ExecveRule();
                if (key.equals(NetworkActivity.KEY))
                    return new NetworkActivity();
            }


            throw new IllegalArgumentException("Nicht definierte Audit Regel erhalten:" + rest);
        } else if (line.equals("No rules")) {
            return new EmptyRule();
        } else {
            throw new IllegalArgumentException("Keine gültige Audit Regel als Input geliefert.");
        }
    }
     /*   else {
            Matcher m = Pattern.compile("^LIST_RULES: \\w*,\\w* (watch)").matcher(line);
            if (m.find()) {

                System.out.println("Found value: " + m.group(0));
                System.out.println("Found value: " + m.group(1));
            } else {
                System.out.println("NO MATCH");
            }
            // ^LIST_RULES: \w*,\w* (watch)

        }
        return new EmptyRule();
    } */
}
