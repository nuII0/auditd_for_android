package org.nuii0.nuii0.androidforensik.Ausearch.Types;


import java.util.regex.Pattern;

/**
 * Das Audit-System heftet zu jedem Ereignise ein AVC-Event an.
 * Diese beinhalten in der Regel Informationen wenn SELinux eine Operation blockiert hat
 * oder in welchem Kontext eine Audit-Nachricht ausgelöst worden ist.
 *
 * Für die Interpetation der Ereignisse spielt der AVC in dieser App keine Rolle,
 * daher sind die Felder auskommentiert.
 */
public class Avc extends Type {

    private final Pattern r = Pattern.compile("^.*: (avc: .*) for\\s+(pid=.*) (comm=.*) (name=.*) (dev=.*) (ino=.*) (scontext=.*) (tcontext=.*) (tclass=.*)$");

    /*public final String avc;
    public final String pid;
    public final String comm;
    public final String name;
    public final String dev;
    public final String ino;
    public final String scontext;
    public final String tcontext;
    public final String tclass; */

    public Avc(String raw) {
        super(raw);
        /*Matcher m = r.matcher(raw);
        performFind(m);
        this.avc = m.group(1);
        this.pid = m.group(2);
        this.comm = m.group(3);
        this.name = m.group(4);
        this.dev = m.group(5);
        this.ino = m.group(6);
        this.scontext = m.group(7);
        this.tcontext = m.group(8);
        this.tclass = m.group(9); */
    }
}
