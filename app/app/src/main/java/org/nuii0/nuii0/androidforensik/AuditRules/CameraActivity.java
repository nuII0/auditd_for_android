package org.nuii0.nuii0.androidforensik.AuditRules;


import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.nuii0.nuii0.androidforensik.Ausearch.AusearchEntry;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Path;

import static android.content.ContentValues.TAG;

public class CameraActivity extends AuditRule {

    public final static String KEY = "cameraactivity";

    public CameraActivity() {
        super("exit", "always", KEY );
    }
    @Override
    public String toString() {
        return "Kamera Aktivität";
    }

    @Override
    public String detail() {
        return "Nicht verfügbar.";
    }

    @Override
    public String auditctlDeleteString() {
        return "-W" + "/data/media/0/DCIM/Camera" + " -p " + "w" + " -k " + key;
    }

    @Override
    public String auditctlAddString() {
        return "-w" + "/data/media/0/DCIM/Camera" + " -p " + "w" + " -k " + key;
    }

    @Override
    public ArrayList<AusearchEntry> filterEntries(ArrayList<AusearchEntry> list) {

        ArrayList<AusearchEntry> tmp = new ArrayList<>();

        String last = new String();
        for (AusearchEntry entry: list) {
            for (Path path : entry.getSubclassType(Path.class)) {
                if(!tmp.contains(entry)) {
                    if(path.name.contains(("jpg"))) {
                        if (!path.name.equals(last)) {
                            last = path.name;
                            Log.e(TAG, last);
                            tmp.add(entry);
                        }
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
            Path path = entry.getSubclassType(Path.class).get(0);
            tmp.add("Bild erzeugt: " + path.name + "\nZeit: " + df.format(entry.time));
        }

        return tmp;
    }

}
