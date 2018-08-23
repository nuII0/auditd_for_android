package org.nuii0.nuii0.androidforensik.Ausearch.Types;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * X86 basierte Systeme bündeln alle Syscalls die Sockets betrefen (connect(), bind(), close() usw)
 * über den Socketcall-Syscall.
 * Dieser erhält als Parameter die auszuführende Socketoperation.
 * Das Audit-Subsystem hält diese Syscalls als Socketcall Ereignise fest.
 *
 * Andere Architetkuren (ARM, x86_64) verwenden für jede Socketoperationen einen einzelnen Syscall
 * und bündeln diese nicht.
 */
public class Socketcall extends Type {

    private final Pattern r = Pattern.compile("^.*: nargs=(.*) .*$");

    public final String nargs;

    public Socketcall(String raw) {
        super(raw);
        Matcher m = r.matcher(raw);
        performFind(m);
        this.nargs = m.group(1);
    }

    @Override
    public String toDetail() {
        StringBuilder r = new StringBuilder();
        r.append("nargs : " + this.nargs);
        return r.toString();
    }
}
