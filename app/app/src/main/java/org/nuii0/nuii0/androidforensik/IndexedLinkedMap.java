package org.nuii0.nuii0.androidforensik;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Eigene Klasse, die LinkedHashMap um einen Index erweitert.
 * Sie wird benötigt um klare Zurordnungen zu Audit-Regeln
 * und den dazugehöhrigen Ereignissen zu behalten.
 *
 * Die Funktion ist von: https://stackoverflow.com/questions/13581997/how-get-value-from-linkedhashmap-based-on-index-not-on-key
 *
 * Die GUI Elemente benutzen den Index um die entsprechenden
 * Regeln und Einträge auszulesen.
 * @param <KEY> HashMap-Key
 * @param <VALUE> HashMap-Value
 */
public class IndexedLinkedMap<KEY,VALUE> extends LinkedHashMap<KEY, VALUE> {
    public VALUE getValue(int i)
    {

        Map.Entry<KEY, VALUE>entry = this.getEntry(i);
        if(entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public Map.Entry<KEY, VALUE> getEntry(int index)
    {
        Set<Entry<KEY,VALUE>> entries = entrySet();
        int inner_index = 0;

        for(Map.Entry<KEY, VALUE>entry : entries) {
            if (inner_index++ == index) {
                return entry;
            }
        }
        return null;
    }
}
