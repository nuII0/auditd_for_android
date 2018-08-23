package org.nuii0.nuii0.androidforensik;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.SystemClock;
import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.nuii0.nuii0.androidforensik.SocketOperations.SocketRequests.PingRequest;
import org.nuii0.nuii0.androidforensik.SocketOperations.SocketResponses.Response;

/**
 * Diese Klasse kümmert sich um die Kommunikation mit und über den Socket.
 * Requests und Responses werden Byteweise in den Socket geschrieben bzw. ausgelesen.
 *
 * Alle Socketoperationen sind synchronisiert, d.h. bei mehreren eingehenden
 * Anfragen muss die zweite Anfrage warten bis die erste Anfrage abgeschickt ist
 * und eine Antwort empfangen worden ist.
 *
 * Dadurch kann das Kommunikationsprotokoll für den Socket vereinfacht werden,
 * da auf eine Anfrage immer garantiert eine passende Antwort folgt.
 */
public class SocketConnection {
    private static final String TAG = Response.class.getSimpleName();

    private LocalSocket socket;
    private LocalSocketAddress addr;

    private DataInputStream is;
    private DataOutputStream os;

    private boolean isConnected;

    public SocketConnection(LocalSocketAddress addr) throws IOException {
        this.addr = addr;
        isConnected = false;
    }

    public SocketConnection(String socketAddress) throws IOException {
        this(new LocalSocketAddress(socketAddress));
    }

    /**
     * Mit dieser Methode kann geprüft werden, ob der Socket noch verbunden ist.
     * @return
     */
    public synchronized boolean isConnected() {
        if (!isConnected)
            return isConnected;
        PingRequest ping = new PingRequest();
        boolean ret = true;
        try {
            sendRequest(ping);
        } catch (IOException e) {
            Log.w(TAG, "Fehler beim Senden eines Ping Paketes.");
            ret = false;
        }
        return ret;
    }

    /**
     * Mit dieser Methode kann eine Verbindung zum Socket aufgebaut werden.
     * @throws IOException
     */
    public synchronized void connect() throws IOException {
        if (!isConnected) {
            socket = new LocalSocket();
            socket.connect(addr);
            is = new DataInputStream(socket.getInputStream());
            os = new DataOutputStream(socket.getOutputStream());
            isConnected = true;
        }
    }

    /**
     * Mit dieser Methode kann die Socketverbindung geschlossen werden.
     * @throws IOException
     */
    public synchronized void close() throws IOException {
        try (
                LocalSocket s = socket;
                DataInputStream i = is;
                DataOutputStream o = os
        ) {
            Log.d(TAG,"Closing Socket.");
            isConnected = false;
        }
    }

    /**
     * Mit dieser Methode kann ein Request abgeschickt werden und
     * dessen Response wird zurückgegeben.
     *
     * Der Request wird dazu in ein ByteArray konvertiert.
     * Als nächstes wird die Größe des ByteArrays über den Socket geschickt
     * damit die Gegenstelle Bescheid weiss, wieviele Bytes sie zu empfangen hat.
     * Danach wird das eigentliche ByteArray in den Socket geschrieben.
     *
     * Anschliessend wird auf die Größe der Antwort und den darauffolgenden
     * Nutzdaten gewartet.
     *
     * Aus der Antwort wird dann eine gültige Response formuliert und zurückgegeben.
     * @param request Der abzuschickende Request
     * @return Passende Response auf den Request
     * @throws IOException
     */
    public synchronized Response sendRequest(Request request) throws IOException {
        if (!isConnected) {
            waitUntilConnect();
            //throw new IOException("Der Socket ist nicht verbunden");
        }
        Response response;
        byte[] rawRequest = request.toByteArray();

        try {

            Log.d(TAG, "Abzuschickeneder Request: " + request.getClass().toString());

            // Übermittlung der Anzahl zu sendener Bytes
            Log.d(TAG, "Schreibe " + rawRequest.length + " Bytes in den Socket");
            os.writeInt(rawRequest.length);

            // Übermittlung der eigentlichen Daten
            Log.d(TAG, "Schreibe Daten " + rawRequest + " Bytes in den Socket");
            os.write(rawRequest);

            // Empfangen der Anzahl zu empfangener Bytes
            Log.d(TAG, "Empfange zu erwartende Packetgröße aus dem Socket.");
            int responseSize = is.readInt();
            Log.d(TAG, "Empfange " + responseSize + " Bytes aus dem Socket.");

            // Empfangen des Antwortpaketes
            Log.d(TAG, "Anzahl der verfügbaren Bytes " + is.available() + " aus dem Socket.");
            byte[] rawResponseData = new byte[responseSize];
            is.readFully(rawResponseData);

            // Konstruieren des Response-Objektes aus den Rohdaten.
            response = request.makeResponse(rawResponseData);

        } catch (IOException e) {
            e.printStackTrace();
            String msg = "Fehler während der Socketkommunikation.";
            Log.e(TAG, msg);
            close();
            throw new IOException(msg);
        }

        return response;
    }

    /**
     * Diese Methode blockiert solange, bis der Socket ordnungsgemäß zur
     * Verfügung steht.
     */
    public void waitUntilConnect() {
        while (!isConnected) {
            try {
                connect();
            } catch (IOException e) {
                Log.e("SocketConnection", "Es kann keine Socketverbindung hergestellt werden.");
                e.printStackTrace();
                SystemClock.sleep(10000);
            }
        }
    }
}
