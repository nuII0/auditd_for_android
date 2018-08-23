package org.nuii0.nuii0.androidforensik.Ausearch.Types;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Das Audit-Subsystem unterstüzt die Überwachung von Änderungen an Dateien und Verzeichnissen.
 * Änderungen dieser Art werden in einem Path-Eintrag dokumentiert.
 *
 * Welche Änderungen eine Datei genau erfahren hat, wird nicht dokumentiert. Es wird lediglich
 * erwähnt, dass eine Änderung stattgefunden hat.
 *
 * Mögliche Änderungen sind: Erzeugen, Entfernen oder Ändern einer Datei oder eines Verzeichnis.
 */
public class Path extends Type {

    private final Pattern r = Pattern.compile("^.*: (item=.*) (name=.*) (inode=.*) (dev=.*) (mode=.*) (ouid=.*) (ogid=.*) (rdev=.*) (obj=.*)$");
    private final Pattern r2 = Pattern.compile("^.*: (item=.*) (name=.*)$");


    public final String item;
    /**
     * Enthält den Namen der Datei oder des Verzeichnis, welche eine Änderungen erhalten hat.
     */
    public final String name;
    /**
     * Gibt die Inode auf dem Dateisystem an.
     */
    public  String inode;
    /**
     * Gibt den Filedeskriptor an, welcher zur Änderung verwendet wurde.
     */
    public  String dev;
    /**
     * Beschreibt die Berechtigungen der Datei
     */
    public  String mode;
    /**
     * ID des Besitzers der Datei
     */
    public  String ouid;
    /**
     * Gruppen-ID des Besitzers der Datei
     */
    public  String ogid;

    public  String rdev;
    /**
     * Angabe des SELinux Kontext
     */
    public  String obj;

    public Path(String raw) {
        super(raw);
        Matcher m = r.matcher(raw);
        try {
            tryFind(m);
            this.inode = m.group(3);
            this.dev = m.group(4);
            this.mode = m.group(5);
            this.ouid = m.group(6);
            this.ogid = m.group(7);
            this.rdev = m.group(8);
            this.obj = m.group(9);
        } catch (Exception e) {
            m = r2.matcher(raw);
            performFind(m);
        }
        this.item = m.group(1);
        this.name = m.group(2);

    }
}
