package org.nuii0.nuii0.androidforensik.Ausearch.Types;

/**
 * Eoe steht für 'End of Event' und werden vom Audit-Susbystem erzeugt
 * um anzugeben, dass ein Multi-Line Event nun beendet ist.
 * Ahand von Eoe-Einträgen kann 'ausearch' beispielsweise erkennen, wann ein Eintrag zuende ist
 * und der nächste Eintrag folgt.
 */
public class Eoe extends Type {
    public Eoe(String raw) {
        super(raw);
    }
}
