package org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import org.nuii0.nuii0.androidforensik.Ausearch.AusearchEntry;
import org.nuii0.nuii0.androidforensik.SocketOperations.ID;

import static java.lang.System.exit;

/**
 * Dieser Response wird gesendet wenn vorher ein AusearchRequest geschickt wurde.
 * Er enthält alle Zeilen die vom 'ausearch'-Befehl zurückgeliefert worden sind.
 *
 * Die Zeilen werden nacheinander interpretiert.
 * Aus ihnen entstehen dann AusearchEntry-Objekte.
 */
public class AusearchResponse extends Response {
    private static final String TAG = AusearchResponse.class.getSimpleName();
    private static int RESPONSE_ID = ID.AusearchResponse.id;

    public ArrayList<String> lines;
    public ArrayList<AusearchEntry> entries;

    public AusearchResponse(byte[] data) {
        super(data,RESPONSE_ID);
        this.lines = makeLines();
        this.entries = makeEntries();
    }

    private ArrayList<String> makeLines() {
        ArrayList<String> list = new ArrayList<String>();
        try {
            JSONArray jsonArray = json.getJSONArray("entries");
            if (jsonArray != null) {
                int len = jsonArray.length();
                for (int i=0;i<len;i++){
                    list.add(jsonArray.get(i).toString());
                }
            }
        } catch (JSONException e) {
            Log.e(TAG,"Fehler beim Verarbeiten von JSON Daten.");
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Wenn 'ausearch' keine Einträge gefunden hat gibt der Befehl '<no matches>' zurück.
     * In allen anderen Fällen beginnt jeder Eintrag entweder mit '----' oder '--'.
     * Daraufhin folgt eine Zeile, die den Zeitpunkt des Eintrages angibt.
     * Daraufhin folgen beliebig viele Zeilen, welche Typen wie zB Syscalls, Sockaddr, AVC-Nachrichten
     * usw. enthalten.
     * @return
     */
    private ArrayList<AusearchEntry> makeEntries() {
        ArrayList<AusearchEntry> list = new ArrayList<>();
        AusearchEntry currentEntry = null;
        Boolean emtpyEntry = false;
        for (String line: lines) {
            emtpyEntry = false;
            if (line.equals("<no matches>"))
                break;
            else if(line.equals("----") || line.equals("--")) {
                if (currentEntry != null) {
                    currentEntry.validate();
                    list.add(currentEntry);

                }
                currentEntry = new AusearchEntry();
                emtpyEntry = true;
            }
            else if(line.matches("^time->.*$"))
                currentEntry.setTimeFromLine(line);
            else if(line.matches("^type=.*$"))
                currentEntry.addTypeFromLine(line);
            else if(line.matches("^TYPE=.*$"))
                currentEntry.addTypeFromLine(line);
            else
                try {
                    throw new IOException("Zeile von Ausearch kann nicht verarbeitet werden:" + line);
                } catch (IOException e) {
                    e.printStackTrace();
                    exit(1);
                }
        }
        if (currentEntry != null && (emtpyEntry == false)) {
            currentEntry.validate();
            list.add(currentEntry);
        }
        return list;
    }

}
