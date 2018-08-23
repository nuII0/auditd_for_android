package org.nuii0.nuii0.androidforensik.Ausearch.Types;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Cwd Einträge stehen für 'Change Working Directory' und werden vom Audit-Subsystem erzeugt,
 * um das Arbeitsverzeichnis des Prozesses, welcher einen Syscall ausgelöst hat, anzugeben.
 */
public class Cwd extends Type {

    private final Pattern r = Pattern.compile("^.*(cwd=.*)$");

    /**
     * Gibt das Arbeitsverzeichnis des Prozesses an.
     */
    public final String cwd;

    public Cwd(String raw) {
        super(raw);
        Matcher m = r.matcher(raw);
        performFind(m);
        this.cwd = m.group(1);
    }
}
