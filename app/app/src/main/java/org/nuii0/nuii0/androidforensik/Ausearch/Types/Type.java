package org.nuii0.nuii0.androidforensik.Ausearch.Types;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.nuii0.nuii0.androidforensik.RequestManager;

import static java.lang.System.exit;

/**
 * Diese Klasse stellt die Basis für alle weiteren Typen von Audit-Subsystem.
 * Die generellen Einträge, welche bei allen Typen gleich sind
 * werden von dieser Klasse geparsed.
 */
public class Type {
    private static final String TAG = RequestManager.class.getSimpleName();
    private final Pattern r = Pattern.compile("^type=(.*).*(audit\\(.*\\)).*");

    public final String type;
    public final String audit;
    public final String raw;

    Type(String raw) {
        this.raw = raw;
        Matcher m = r.matcher(raw);
        performFind(m);
        this.type = m.group(1);
        this.audit = m.group(2);
    }

    void tryFind(Matcher m) throws Exception {
        m.find();
        if (!m.matches()) {
            throw new Exception("Matcher hat nichts gefunden: " + raw);
        }
    }
    void performFind(Matcher m) {
        try {
            tryFind(m);
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
            e.printStackTrace();
            exit(1);
        }
        //Log.d(TAG,raw);

    }

    public String toDetail() {
        return new String();
    }


}
