package org.nuii0.nuii0.androidforensik.Ausearch.Types;

/**
 * Die Syscalls 'pipe' und 'socketpair' erzeugen immer zwei File-Deskriptoren um
 * Daten hinein- und herauszuschreiben.
 * Dieses Ereignis gibt die Identitifier dieser beiden Deskriptoren an.
 *
 * Deskriptoren werden von dieser App allerdings nicht interpretiert, daher
 * sind hier keine Felder gesetzt.
 */
public class Fd_pair extends Type {
    public Fd_pair(String raw) {
        super(raw);
    }
}
