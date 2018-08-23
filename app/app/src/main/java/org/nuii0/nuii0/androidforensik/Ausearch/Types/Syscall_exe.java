package org.nuii0.nuii0.androidforensik.Ausearch.Types;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Syscall_exe extends Type {

    private final Pattern r = Pattern.compile("^.*: arch=(.*) syscall=(.*) success=(.*) exit=(.*) a0=(.*) a1=(.*) a2=(.*) a3=(.*) items=(.*) ppid=(.*) pid=(.*) auid=(.*) uid=(.*) gid=(.*) euid=(.*) suid=(.*) fsuid=(.*) egid=(.*) sgid=(.*) fsgid=(.*) tty=(.*) ses=(.*) comm=(.*) subj=(.*) key=(.*)$");

    public final String arch;
    public final String syscall;
    public final String success;
    public final String exit;
    public final String a0;
    public final String a1;
    public final String a2;
    public final String a3;
    public final String items;
    public final String ppid;
    public final String pid;
    public final String auid;
    public final String uid;
    public final String gid;
    public final String euid;
    public final String suid;
    public final String fsuid;
    public final String egid;
    public final String sgid;
    public final String fsgid;
    public final String tty;
    public final String ses;
    public final String comm;
    public final String subj;
    public final String key;

    public Syscall_exe(String raw) {
        super(raw);
        Matcher m = r.matcher(raw);
        performFind(m);
        this.arch = m.group(1);
        this.syscall = m.group(2);
        this.success = m.group(3);
        this.exit = m.group(4);
        this.a0 = m.group(5);
        this.a1 = m.group(6);
        this.a2 = m.group(7);
        this.a3 = m.group(8);
        this.items = m.group(9);
        this.ppid = m.group(10);
        this.pid = m.group(11);
        this.auid    = m.group(12);
        this.uid = m.group(13);
        this.gid = m.group(14);
        this.euid    = m.group(15);
        this.suid = m.group(16);
        this.fsuid = m.group(17);
        this.egid = m.group(18);
        this.sgid = m.group(19);
        this.fsgid = m.group(20);
        this.tty = m.group(21);
        this.ses = m.group(22);
        this.comm = m.group(23);
        this.subj = m.group(24);
        this.key = m.group(25);
    }

    @Override
    public String toDetail() {
        StringBuilder r = new StringBuilder();
        r.append("arch : " + this.arch);
        r.append(System.getProperty("line.separator"));
        r.append("syscall : " + this.syscall);
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
        r.append("subj : " + this.subj);
        r.append(System.getProperty("line.separator"));
        r.append("key : " + this.key);
        r.append(System.getProperty("line.separator"));




        return r.toString();
    }
}
