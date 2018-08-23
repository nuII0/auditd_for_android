package org.nuii0.nuii0.androidforensik;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.ArrayAdapter;

import java.io.IOException;

import org.nuii0.nuii0.androidforensik.AuditRules.AppStartStopRule;
import org.nuii0.nuii0.androidforensik.AuditRules.AuditRule;
import org.nuii0.nuii0.androidforensik.AuditRules.CameraActivity;
import org.nuii0.nuii0.androidforensik.AuditRules.ExecveRule;
import org.nuii0.nuii0.androidforensik.AuditRules.FileWatchRule;
import org.nuii0.nuii0.androidforensik.AuditRules.NetworkActivity;
import org.nuii0.nuii0.androidforensik.AuditRules.SystemCommandRule;

/**
 * Dieser Dialog erscheint, wenn der Nutzer eine Regel anlegen will.
 * Er erhält dann eine Liste aus denen er sich eine Regel aussuchen kann.
 * Alternativ kann der Vorgang über den 'cancel'-Button abgebrochen werden.
 */
public class AddAuditRuleDialog {


    AlertDialog.Builder adBuilder;
    public AddAuditRuleDialog(Context con) {
        final Context context = con;
        adBuilder = new AlertDialog.Builder(context);
        adBuilder.setTitle("Audit Regel hinzufügen:-");

        final ArrayAdapter<AuditRule> arrayAdapter = new ArrayAdapter<AuditRule>(context, android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add(new AppStartStopRule());
        arrayAdapter.add(new SystemCommandRule());
        arrayAdapter.add(new CameraActivity());
        arrayAdapter.add(new ExecveRule());
        arrayAdapter.add(new NetworkActivity());
        arrayAdapter.add(new FileWatchRule("exit", "always", "/storage/test", "warx", "storage_test"));
        arrayAdapter.add(new FileWatchRule("exit", "always", "/storage/test2", "warx", "storage_test2"));

        adBuilder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        adBuilder.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AuditRule rule = arrayAdapter.getItem(which);
                try {
                    ((MainActivity) context).requestManager.addAuditRule(rule);
                    ((MainActivity) context).guiToast("Audit-Regel hinzugefügt.");
                    ((MainActivity) context).refreshAuditRuleList();
                } catch (IOException e) {
                    ((MainActivity) context).guiErrorToast("Fehler beim Hinzufügen einer Audit Regel.");
                    e.printStackTrace();
                }
            }
        });
    }

    public void show(){
        adBuilder.show();
    }
}
