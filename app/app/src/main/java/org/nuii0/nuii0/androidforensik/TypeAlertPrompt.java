package org.nuii0.nuii0.androidforensik;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Dieses Prompt wird verwendet um Ereignisse von auditd detailliert
 * anzuzeigen.
 */
public class TypeAlertPrompt {
    private final AlertDialog.Builder adBuilder;

    public TypeAlertPrompt(Context context, String heading, String msg ) {
        adBuilder = new AlertDialog.Builder(context);
        adBuilder.setTitle(heading);
        adBuilder.setMessage(msg);
        adBuilder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }

    public void show(){
        adBuilder.show();
    }


}
