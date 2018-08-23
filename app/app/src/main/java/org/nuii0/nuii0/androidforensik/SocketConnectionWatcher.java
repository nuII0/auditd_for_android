package org.nuii0.nuii0.androidforensik;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;

import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.Response;

public class SocketConnectionWatcher extends AsyncTask<Void, SOCKETSTATE, Void> {
    WeakReference<SocketAlertPrompt> activity;

    private static final String TAG = Response.class.getSimpleName();

    private boolean done = false;

    public void quit() {
        done = true;
    }

    // Eingabeparameter
    private final SocketConnection socket;

    // Ausgabestring
    private String result;

    public SocketConnectionWatcher(SocketAlertPrompt activity, SocketConnection socket) {
        this.activity = new WeakReference<SocketAlertPrompt>(activity);
        this.socket = socket;
    }

    @Override
    protected void onPostExecute(Void v) {
        quit();
    }

    @Override
    protected void onProgressUpdate(SOCKETSTATE... state) {
        switch (state[0]) {
            case CONNECTED:
                activity.get().hide();
                break;
            case RECONNECTING:
                activity.get().show();
                break;
        }
    }

    @Override
    protected Void doInBackground(Void... voids) {
        while (!done) {
            if (!socket.isConnected()) {
                publishProgress(SOCKETSTATE.RECONNECTING);
                socket.waitUntilConnect();
            } else {
                publishProgress(SOCKETSTATE.CONNECTED);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
