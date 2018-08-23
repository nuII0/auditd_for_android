package org.nuii0.nuii0.androidforensik;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import org.nuii0.nuii0.androidforensik.AuditRules.AuditRule;
import org.nuii0.nuii0.androidforensik.Ausearch.AusearchEntry;

/**
 * Hauptansicht der App.
 * Der Nutzer kann über die Ansicht die bestehenden Audit-Regeln und deren Ereignisse einsehen.
 * Ausserdem kann er neue Regeln anlegen und entfernen.
 */
public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView socketConnectionStatus;

    public RequestManager requestManager;

    private SocketAlertPrompt alertDialog;

    private TypeAlertPrompt typeDialog;

    private ExpandableListView auditRules;

    /**
     * Beim schliessen der App muss der Socket
     * beendet werden.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        requestManager.close();

    }

    /**
     * Beim Pausieren der App muss nicht
     * auf eine Abbrechende Socketverbindung geachtet werden.
     * daher ist der Watcher anzuhalten.
     */
    @Override
    public void onPause() {
        super.onPause();
        auditRules = findViewById(R.id.rulesView);
        auditRules.setAdapter((BaseExpandableListAdapter)null);
        requestManager.stopWatcher();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    /**
     * Dieser Code wird ausgeführt, sobald die App gestartet wurde
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            requestManager = new RequestManager(getString(R.string.socket_name));
        } catch (IOException e) {
            e.printStackTrace();
            socketConnectionStatus.setText("Fehler beim erstellen des Sockets.");
        }
        alertDialog = new SocketAlertPrompt(this);
        requestManager.setFailurePrompt(alertDialog);
    }

    /** Beim Klick auf den 'refresh'-Button in der GUI wird diese Funktion
     * aufgerufen um die Liste der bestehenden Audit-Regeln zu erhalten.
     * @param view
     */
    public void refreshAuditRuleList(View view) {
        refreshAuditRuleList();
    }

    public void refreshAuditRuleList() {
        auditRules = findViewById(R.id.rulesView);
        try {
            ArrayList<AuditRule> rules = requestManager.getAuditRules();

            IndexedLinkedMap<AuditRule, ArrayList<AusearchEntry>> rulesWithEntries = new IndexedLinkedMap<>();
            IndexedLinkedMap<AuditRule, ArrayList<String>> rulesWithHeading = new IndexedLinkedMap<>();
            for (AuditRule rule: rules) {
                ArrayList<AusearchEntry> entries = requestManager.ausearch(rule.key).entries;
                ArrayList<AusearchEntry> filteredEntries = rule.filterEntries(entries);
                rulesWithEntries.put(rule, filteredEntries);
                rulesWithHeading.put(rule, rule.formatEntry(filteredEntries));
            }
            
            auditRules.setAdapter(new AuditRuleAdapter(rulesWithEntries, rulesWithHeading, this));
        } catch (IOException e) {
            e.printStackTrace();
            guiErrorToast(e.getMessage());
        }
    }

    /** Diese Funktion wird aufgerufen wenn der Benutzern auf den '+'-Button klickt,
     * um eine Regel anzulegen.
     * @param view
     */
    public void addAuditRuleBtn(View view) {
        AddAuditRuleDialog d = new AddAuditRuleDialog(this);
        d.show();
    }

    /**
     * Toasts sind kleine Benachrichtigungen die am unteren Ende
     * des Displays erscheinen. Mit dieser Methode kann eine
     * Toast-Nachricht auf der Hauptansicht angezeigt werden.
     * @param text
     */
    public void guiToast(String text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Wie guiToast(), aber diesmal für einen Fehlerfall.
     * @param text
     */
    public void guiErrorToast(String text) {
        guiToast("Fehler: " + text);
    }

}
