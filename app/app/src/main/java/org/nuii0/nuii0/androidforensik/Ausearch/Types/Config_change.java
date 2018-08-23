package org.nuii0.nuii0.androidforensik.Ausearch.Types;


import java.util.regex.Pattern;

/**
 * Config_change Ereignisse werden ausgelöst,
 * wenn sich die Konfiguration des Audit-Subsystem ändert.
 * Beispielsweise durch das Hinzufügen oder Entfernen von Regeln.
 *
 * Änderungen am Audit-Subsystem werden in dieser App nicht explizit interpretiert.
 * Daher sind die Felder auskommentiert.
 */
public class Config_change extends Type {

    private final Pattern r = Pattern.compile("^.*: (auid=.*) (ses=.*) (subj=.*) (op=.*) (key=.*) (list=.*) (res=.*)$");

   /* public final String auid;
    public final String ses;
    public final String subj;
    public final String op;
    public final String key;
    public final String list;
    public final String res; */

    public Config_change(String raw) {
        super(raw);
       /* Matcher m = r.matcher(raw);
        performFind(m);
        this.auid = m.group(1);
        this.ses = m.group(2);
        this.subj = m.group(3);
        this.op = m.group(4);
        this.key = m.group(5);
        this.list = m.group(6);
        this.res = m.group(7); */
    }
}
