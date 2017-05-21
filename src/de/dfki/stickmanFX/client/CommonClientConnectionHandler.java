package de.dfki.stickmanFX.client;

/**
 * Created by alvaro on 9/19/16.
 */
public interface CommonClientConnectionHandler {

    void end();

    void sendToServer(String message);

    void connect(String host, int port);

    void connect();

    void tryToConnect(String host, int port);

    void run();

    boolean ismConnected();
}
