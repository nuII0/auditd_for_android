package org.nuii0.nuii0.androidforensik;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Dieses Prompt erscheint, sobald die Socketverbindung abbricht.
 */
public class SocketAlertPrompt {
    private AlertDialog ad;

    public SocketAlertPrompt(Context context) {
        ad = new AlertDialog.Builder(context).create();
        ad.setTitle("Keine Socketverbindung");
        ad.setMessage("Bitte warten");
    }

    public void show(){
        ad.show();
    }

    public void hide() {
        ad.hide();
    }

}
