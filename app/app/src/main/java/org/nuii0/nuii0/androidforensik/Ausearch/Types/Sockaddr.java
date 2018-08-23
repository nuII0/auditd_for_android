package org.nuii0.nuii0.androidforensik.Ausearch.Types;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sockaddr extends Type {

    private final Pattern r = Pattern.compile("^.*: TYPE=(.*) (.*) (.*) (.*)$");

    /**
     * Gibt den Typ des Sockets an. (Lokaler Socket, Internet Socket usw.)
     */
    public final String type;
    /**
     * Gibt die Netzwerkfamilie an (zB IPv4, IPv6)
     */
    public final String family;
    /**
     * Gibt den Host an.
     * Dies kann beispielsweise eine IPv4 oder IPv6 Adresse sein.
     */
    public final String host;
    /**
     * Gibt zusätzliche, protokollspezifische Informationen an
     * Im Falle von TCP/UDP zum Beispiel der Port.
     */
    public final String serv;

    public Sockaddr(String raw) {
        super(raw);
        Matcher m = r.matcher(raw);
        performFind(m);
        this.type = m.group(1);
        this.family = m.group(2);
        this.host = m.group(3);
        this.serv = m.group(4);
    }

    @Override
    public String toDetail() {
        StringBuilder r = new StringBuilder();
        r.append("Family : " + this.family);
        r.append(System.getProperty("line.separator"));
        r.append("Host : " + this.host);
        r.append(System.getProperty("line.separator"));
        r.append("Serv : " + this.serv);

        return r.toString();
    }
}
