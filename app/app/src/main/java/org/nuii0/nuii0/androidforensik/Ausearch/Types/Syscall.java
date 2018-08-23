package org.nuii0.nuii0.androidforensik.Ausearch.Types;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Wann immer ein Syscall vom Audit-Subsystem dokumentiert wird,
 * wird dieser Eintrag erzeugt.
 */
public class Syscall extends Type {

    private final Pattern r = Pattern.compile("^.*: arch=(.*) syscall=(.*) per=(.*) success=(.*) exit=(.*) a0=(.*) a1=(.*) a2=(.*) a3=(.*) items=(.*) ppid=(.*) pid=(.*) auid=(.*) uid=(.*) gid=(.*) euid=(.*) suid=(.*) fsuid=(.*) egid=(.*) sgid=(.*) fsgid=(.*) tty=(.*) ses=(.*) comm=(.*) exe=(.*) subj=(.*) key=(.*)$");

    /**
     * Architektur des Systems (x86, ARMv7, x86_64 usw.)
     */
    public final String arch;
    /**
     * Nummer oder Bezeichnung des Syscalls
     */
    public final String syscall;
    public final String per;
    /**
     * Gibt an ob der Syscall erfolgreich war oder nicht
     */
    public final String success;
    /**
     * Rückgabewert des Syscalls
     */
    public final String exit;
    /**
     * 1. Parameter an den Syscall
     */
    public final String a0;
    /**
     * 2. Parameter an den Syscall
     */
    public final String a1;
    /**
     * 3. Parameter an den Syscall
     */
    public final String a2;
    /**
     * 4. Parameter an den Syscall
     */
    public final String a3;
    public final String items;
    /**
     * Pid von Parent-Prozess vom Prozess, welcher
     * den Syscall ausgelöst hat.
     */
    public final String ppid;
    /**
     * Pid vom Prozess, welcher
     * den Syscall ausgelöst hat.
     */
    public final String pid;
    /**
     * User ID unter dem 'auditd' läuft
     */
    public final String auid;
    /**
     * User ID welcher dem Prozess gehöhrt
     */
    public final String uid;
    /**
     * Group ID welcher dem Prozess gehöhrt
     */
    public final String gid;
    public final String euid;
    /**
     * Angabe des SUID, falls verwendet.
     */
    public final String suid;
    public final String fsuid;
    public final String egid;
    public final String sgid;
    public final String fsgid;
    /**
     * Angabe des Terminals,
     * in welchem der Befehl ausgeführt wurde
     * (falls vorhanden)
     */
    public final String tty;
    public final String ses;
    /**
     * Zusätzliches Kommentar.
     * Enthält verschiedene Informationen,
     * die abhängig vom jeweiligen
     * Syscall sind.
     */
    public final String comm;
    /**
     * Name des Prozesses, welcher
     * den Syscall ausgeführt hat
     */
    public final String exe;
    /**
     * Gibt den SELinux-Kontext des
     * Prozesses an.
     */
    public final String subj;
    public final String key;

    public Syscall(String raw) {
        super(raw);
        Matcher m = r.matcher(raw);
        performFind(m);
        this.arch = m.group(1);
        this.syscall = m.group(2);
        this.per = m.group(3);
        this.success = m.group(4);
        this.exit = m.group(5);
        this.a0 = m.group(6);
        this.a1 = m.group(7);
        this.a2 = m.group(8);
        this.a3 = m.group(9);
        this.items = m.group(10);
        this.ppid = m.group(11);
        this.pid = m.group(12);
        this.auid    = m.group(13);
        this.uid = m.group(14);
        this.gid = m.group(15);
        this.euid    = m.group(16);
        this.suid = m.group(17);
        this.fsuid = m.group(18);
        this.egid = m.group(19);
        this.sgid = m.group(20);
        this.fsgid = m.group(21);
        this.tty = m.group(22);
        this.ses = m.group(23);
        this.comm = m.group(24);
        this.exe = m.group(25);
        this.subj = m.group(26);
        this.key = m.group(27);
    }

    @Override
    public String toDetail() {
        StringBuilder r = new StringBuilder();
        r.append("arch : " + this.arch);
        r.append(System.getProperty("line.separator"));
        r.append("syscall : " + this.syscall);
        r.append(System.getProperty("line.separator"));
        r.append("per : " + this.per);
        r.append(System.getProperty("line.separator"));
        r.append("success : " + this.success);
        r.append(System.getProperty("line.separator"));
        r.append("a0 : " + this.a0);
        r.append(System.getProperty("line.separator"));
        r.append("a1 : " + this.a1);
        r.append(System.getProperty("line.separator"));
        r.append("a2 : " + this.a2);
        r.append(System.getProperty("line.separator"));
        r.append("a3 : " + this.a3);
        r.append(System.getProperty("line.separator"));
        r.append("items : " + this.items);
        r.append(System.getProperty("line.separator"));
        r.append("ppid : " + this.ppid);
        r.append(System.getProperty("line.separator"));
        r.append("pid : " + this.pid);
        r.append(System.getProperty("line.separator"));
        r.append("auid : " + this.auid);
        r.append(System.getProperty("line.separator"));
        r.append("euid : " + this.euid);
        r.append(System.getProperty("line.separator"));
        r.append("suid : " + this.suid);
        r.append(System.getProperty("line.separator"));
        r.append("fsuid : " + this.fsuid);
        r.append(System.getProperty("line.separator"));
        r.append("egid : " + this.egid);
        r.append(System.getProperty("line.separator"));
        r.append("sgid : " + this.sgid);
        r.append(System.getProperty("line.separator"));
        r.append("fsgid : " + this.fsgid);
        r.append(System.getProperty("line.separator"));
        r.append("tty : " + this.tty);
        r.append(System.getProperty("line.separator"));
        r.append("ses : " + this.ses);
        r.append(System.getProperty("line.separator"));
        r.append("comm : " + this.comm);
        r.append(System.getProperty("line.separator"));
        r.append("exe : " + this.exe);
        r.append(System.getProperty("line.separator"));
        r.append("subj : " + this.subj);
        r.append(System.getProperty("line.separator"));
        r.append("key : " + this.key);
        r.append(System.getProperty("line.separator"));

        return r.toString();
    }
}
