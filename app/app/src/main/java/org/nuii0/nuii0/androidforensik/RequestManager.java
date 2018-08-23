package org.nuii0.nuii0.androidforensik;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import org.nuii0.nuii0.androidforensik.AuditRules.AuditRule;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketRequests.AuditRuleAddRequest;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketRequests.AuditRuleDeleteRequest;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketRequests.AuditRuleListRequest;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketRequests.AusearchRequest;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.AuditRuleAddResponse;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.AuditRuleDeleteResponse;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.AuditRuleListResponse;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.AusearchResponse;

import static java.lang.System.exit;

/**
 * Der RequestManager ist eine zentrale Komponente über die
 * alle Socketrequests laufen.
 * Zu jedem Request wird eine Response geliefert.
 *
 * Der RequestManager kann auserdem eine Alarmmeldung
 * auslösen wenn die Socketverbindung abbricht.
 */
public class RequestManager {
    private static final String TAG = RequestManager.class.getSimpleName();

    /** Über dieses Socketobjekt laufen alle Anfragen. */
    private SocketConnection socket;

    /** Der Watcher meldet, wenn die Socketverbindung abbricht. */
    private SocketConnectionWatcher watcher;

    public RequestManager(String socketAddress) throws IOException {
        this(new SocketConnection(socketAddress));
    }
    public RequestManager(SocketConnection socket) throws IOException {
            this.socket = socket;
            this.watcher = null;
    }

    /**
     * Methode um eventuell laufende Watcher und den
     * Socket ordnungsgemäß zu beenden.
     */
    public void close() {
        if (watcher != null)
            watcher.cancel(true);

        try {
            socket.close();
        } catch (IOException e) {
            Log.e(TAG, "Socket konnte nicht geschlossen werden.");
            e.printStackTrace();
            exit(1);
        }
    }
    /*

     */

    /**
     * Diese Methode ermöglicht es,
     * eine Alarmmeldung anzuzeigen, wenn die Socketverbindung
     * abbrechen sollte.
     * Die Alarmmeldung wird per Parameter übergeben.
     * Im Falle eines Verbindungsabbruch wird die .show()
     * Methode der Alarmmeldung aufgerufen.
     * Sobald die Verbindung wieder besteht, wird die
     * Alarmmeldung wieder mit .hide() versteckt.
     * @param ad SocketAlertPrompt
     */
    public void setFailurePrompt(SocketAlertPrompt ad) {
        watcher = new SocketConnectionWatcher(ad, socket);
        watcher.execute();
    }

    /** Mit dieser Methode kann der im Hintergrund laufende Watcher
     * angehalten werden. */
    public void stopWatcher() {
        watcher.quit();
    }


    /** Alle bestehenden Audit-Regeln können mit dieser Methode abgefragt werden
     * Intern wird dazu ein entsprechender Request formuliert und an den Socket und
     * den 'forensikmediator' geleitet.
     * @return Liste aller Audit-Regeln
     * @throws IOException Im Falle einer fehlgeschlagenen Socketoperation
     */
    public ArrayList<AuditRule> getAuditRules() throws IOException {
        AuditRuleListRequest req = new AuditRuleListRequest();
        AuditRuleListResponse resp;
        resp = (AuditRuleListResponse) socket.sendRequest(req);
        Log.d(TAG, "response data: " + resp.entries());

        ArrayList<AuditRule> auditRules = new ArrayList<>();

        for (String line : resp.entries()) {
            auditRules.add(AuditRule.buildRule(line));
        }

        return auditRules;
    }

    /**
     * Mit dieser Methode können neuen Audit-Regeln über den
     * Socket und 'forensikmediator' angelegt werden.
     * @param rule Die anzulegende Audit-Regel
     * @throws IOException Im Falle einer fehlgeschlagenen Socketoperation
     */
    public void addAuditRule(AuditRule rule) throws IOException {
        AuditRuleAddRequest req = new AuditRuleAddRequest(rule);
        AuditRuleAddResponse resp = (AuditRuleAddResponse)socket.sendRequest(req);

        if (!resp.success()) {
            throw new IOException("Hinzufügen der Audit-Regel war nicht erfolgreich.");
        }

        return;
    }

    /**
     * Mit dieser Methode können neuen Audit-Regeln über den
     * Socket und 'forensikmediator' entfernt werden.
     * @param rule Die anzulegende Audit-Regel
     * @throws IOException Im Falle einer fehlgeschlagenen Socketoperation
     */
    public void deleteAuditRule(AuditRule rule) throws IOException {
        AuditRuleDeleteRequest req = new AuditRuleDeleteRequest(rule);
        AuditRuleDeleteResponse resp = (AuditRuleDeleteResponse)socket.sendRequest(req);

        if (!resp.success()) {
            throw new IOException("Löschen der Audit-Regel war nicht erfolgreich.");
        }

        return;
    }

    /**
     * Mit dieser Methode lassen sich Ausearch-Suchanfragen abschicken.
     * Damit lassen sich alle Ereignisse für einer Regel bzw. zu dem Key
     * einer Regel abfragen.
     * @param key Eindeutiger Identifier. Jede Audit-Regel hat einen eigenen Key.
     * @return
     * @throws IOException Im Falle einer fehlgeschlagenen Socketoperation
     */
    public AusearchResponse ausearch(String key) throws IOException {
        AusearchRequest req = new AusearchRequest("-k " + key);
        return (AusearchResponse)socket.sendRequest(req);
    }
}
