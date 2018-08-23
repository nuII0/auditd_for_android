package org.nuii0.nuii0.androidforensik.Ausearch;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.nuii0.nuii0.androidforensik.Ausearch.Types.Avc;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Config_change;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Cwd;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Eoe;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Execve;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Fd_pair;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Netfilter_cfg;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Path;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Sockaddr;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Socketcall;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Syscall;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Syscall_exe;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Syscall_exit;
import org.nuii0.nuii0.androidforensik.Ausearch.Types.Type;

import static java.lang.System.exit;

/**
 * 'ausearch' liefert als Ergebnis mehrere Einträge.
 * Jeder Eintrag kann sich aus beliebig vielen Typen zusammensetzen.
 *
 * Zum Beispiel erhält ein Eintrag, welcher die Modifikation an einer Datei angibt
 * den eigentlich Pfad zur Datei in einem PATH-Typ und darüber hinaus den dazugehöhrigen
 * Syscall in einem SYSCALL-Typ vor.
 *
 * Diese Klasse kann alle 'ausearch'-Einträge modellieren. Ein Eintrag kann zeilenweise
 * gebaut werden, da die Ergebnisse von 'ausearch'-Befehl ebenfalls zeilenweise erfolgt.
 */
public class AusearchEntry {
    private static final String TAG = AusearchEntry.class.getSimpleName();

    private final DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss yyyy", Locale.ENGLISH);

    public Date time = null;

    ArrayList<Type> types = new ArrayList<>();

    public AusearchEntry() {
    }

    /**
     * Diese Methode wird verwendet um einen Eintrag mit allen Details in einen
     * String zu konvertieren.
     * Die GUI Komponenten verwenden diese Methode um Details zu einem Eintrag anzuzueigen.
     * @return
     */
    public String toDetail() {
        StringBuilder sb = new StringBuilder();
        for( Type type: types) {
            sb.append(type.toDetail());
            sb.append(System.getProperty("line.separator"));
        }

        return sb.toString();
    }

    /**
     * Jeder AusearchEntry kann eine beliebige Anzahl an Typen enthalten.
     * Mit dieser Methode können nur Typen einer bestimmten Klasse zurückgegeben werden.
     *
     * So können die GUI Komponenten die Darstellung der Daten aus einem
     * AusearchEntry beliebig modellieren.
     * @param type
     */
    public void addType(Type type) {
        types.add(type);
    }
    public <T> ArrayList<T> getSubclassType(Class<T> cl)
    {
        ArrayList<T> list=new ArrayList<T>();
        for (Type entry: types) {
            if (cl.isInstance(entry)) {
                list.add((T) entry);
            }
        }
        return list;
    }

    /**
     * Diese Methode wird verwendet um den zurückgeliefert Zeitwert
     * von 'ausearch' dem Eintrag hinzuzufügen.
     * @param line
     */
    public void setTimeFromLine(String line) {
        Date result = null;
        try {
            result = df.parse(line.split("->")[1]);
        } catch (ParseException e) {
            e.printStackTrace();
            Log.e(TAG, "Time konnte nicht geparsed werden.");
            exit(1);
        }
        this.time = result;
    }

    /**
     * Mit dieser Methode wird der AusearchEntry zeilenweise aufgebaut.
     * Jede Zeile enthält einen Typ.
     * @param line
     */
    public void addTypeFromLine(String line) {
        Type type;
        if (line.matches("^.*type=EOE.*$")) {
            type = new Eoe(line);
            addType(type);
        } else if (line.matches("^.*type=SYSCALL.*$")) {
            if(line.contains("success")) {
                if (line.contains("exe=")) {
                    type = new Syscall(line);
                } else {
                    type = new Syscall_exe(line);
                }

            } else {
                type = new Syscall_exit(line);
            }
            addType(type);

        } else if (line.matches("^.*type=AVC.*$")) {
            type = new Avc(line);
            addType(type);

        } else if (line.matches("^.*type=NETFILTER_CFG.*$")) {
            type = new Netfilter_cfg(line);
            addType(type);
        } else if (line.matches("^.*type=CONFIG_CHANGE.*$")) {
            type = new Config_change(line);
            addType(type);
        } else if (line.matches("^.*type=PATH.*$")) {
            type = new Path(line);
            addType(type);
        } else if (line.matches("^.*type=FD_PAIR.*$")) {
            type = new Fd_pair(line);
            addType(type);
        } else if (line.matches("^.*type=CWD.*$")) {
            type = new Cwd(line);
            addType(type);
        } else if (line.matches("^.*TYPE=SOCKADDR.*$")) {
            line = "type=SOCKADDR audit(0): " + line;
            type = new Sockaddr(line);
            addType(type);
        } else if (line.matches("^.*type=EXECVE.*$")) {
            if(line.contains("argc")) {
                type = new Execve(line);
                addType(type);
            }
        } else if (line.matches("^.*type=SOCKETCALL.*$")) {
                type = new Socketcall(line);
                addType(type);
        } else {
            try {
                throw new Exception("Typ kann aus Line nicht erkannt werden: " + line);
            } catch (Exception e) {
                e.printStackTrace();
                exit(1);
            }
        }
    }

    /**
     * Abschliessend kann mit dieser Methode geprüft werden,
     * oder der Eintrag valide aufgebaut wurde.
     */
    public void validate() {
        try {
            if (time == null)
                time = new java.util.Date();
            if (types.isEmpty())
                throw new Exception("Keine Types gesetzt in AusearchEntry.");
        } catch (Exception e) {
            Log.e(TAG, "Fehler beim Validieren.");
            e.printStackTrace();
            exit(1);
        }
    }


}
