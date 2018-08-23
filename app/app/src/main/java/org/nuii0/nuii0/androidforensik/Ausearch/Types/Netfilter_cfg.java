package org.nuii0.nuii0.androidforensik.Ausearch.Types;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ein Netfilger_cfg Ereignis wird von Audit-Subsystem bei Änderungen am Netfilter-System, also der
 * Firewall ausgelöst.
 *
 * Beispielsweise dann, wenn über den Befehl 'iptables' Firewallregeln hinzugefügt oder entfernt werden.
 */
public class Netfilter_cfg extends Type {

    private final Pattern r = Pattern.compile("^.*: (table=.*) (family=.*) (entries=.*)$");

    /**
     * Nennt die Netfilter-Tabelle, in der eine Änderung stattgefunden hat.
     */
    public final String table;
    /**
     * Gibt die Netzwerkfamilie an (IPv4 oder IPv6)
     */
    public final String family;
    /**
     * Zählt die geänderten Einträge auf.
     */
    public final String entries;

    public Netfilter_cfg(String raw) {
        super(raw);
        Matcher m = r.matcher(raw);
        performFind(m);
        this.table = m.group(1);
        this.family = m.group(2);
        this.entries = m.group(3);
    }
}
