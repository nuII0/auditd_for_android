package org.nuii0.nuii0.androidforensik.Ausearch.Types;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Execve Syscalls haben vom Audit-Subsystem einen eigenen Eintrag, welcher
 * über diesen Typen modelliert wird.
 */
public class Execve extends Type {

    private final Pattern r = Pattern.compile("^.*: argc=(.*) .*$");
    private final String raw;

    /**
     * Enthält die Anzahl der Argumente, welche an execve() übergeben wurde.
     */
    public final String argc;
    //public final String a0;
    public Execve(String raw) {
        super(raw);
        this.raw = raw;
        Matcher m = r.matcher(raw);
        performFind(m);
        this.argc = m.group(1);
    }

    @Override
    public String toDetail() {
        StringBuilder r = new StringBuilder();
        r.append("Execve Aufruf :");
        r.append(System.getProperty("line.separator"));
        r.append(raw);
        return r.toString();
    }
}
