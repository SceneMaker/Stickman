package de.dfki.stickmanSwing.client;

import de.dfki.common.XMLCommandParser;
import de.dfki.stickmanSwing.stage.StickmanStageSwing;
import de.dfki.stickmanFX.client.CommonClientConnectionHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class ClientConnectionHandler extends Thread implements CommonClientConnectionHandler {

    private Socket mSocket;
    private String mHost = "127.0.0.1";
    private int mPort = 7777;
    private PrintWriter mOut;
    private BufferedReader mIn;
    private static String sIDENTIFIER = "StickmanStageSwing";

    private boolean mRunning = true;
    public boolean mConnected = false;
    private StickmanStageSwing mStickmanStage;
    private XMLCommandParser stickmanParser;

    public ClientConnectionHandler() {
        super.setName("StickmanStageSwing Socket Connection Handler");
    }

    public ClientConnectionHandler(StickmanStageSwing stage) {

        super.setName("StickmanStageSwing Socket Connection Handler");
        mStickmanStage = stage;
    }

    public ClientConnectionHandler(XMLCommandParser parser) {
        super.setName("StickmanStageSwing Socket Connection Handler");
        stickmanParser = parser;
    }

    public void end() {
        try {
            mSocket.shutdownInput();
            mSocket.shutdownOutput();
            mSocket.close();
            mRunning = false;
            mConnected = false;
        } catch (IOException ex) {
            StickmanStageSwing.mLogger.severe("Error closing socket to " + mHost + ", " + mPort);
        }
    }

    public void sendToServer(String message) {
        //StickmanStageSwing.mLogger.info("Sending " + message);

        if (mSocket.isConnected()) {
            mOut.println(message);
            mOut.flush();
        }
    }

    public void connect(String host, int port) {
        mHost = host;
        mPort = port;
        connect();
    }

    public void connect() {
        StickmanStageSwing.mLogger.info("StickmanStageSwing tries to connect with control application ...");
        try {
            InetAddress inteAddress = InetAddress.getByName(mHost);
            SocketAddress socketAddress = new InetSocketAddress(inteAddress, mPort);

            mSocket = new Socket();
            mSocket.connect(socketAddress, 2000); // wait max. 2000ms

            mOut = new PrintWriter(mSocket.getOutputStream(), true);
            mIn = new BufferedReader(new InputStreamReader(mSocket.getInputStream(), "UTF-8"));
        } catch (UnknownHostException e) {
            StickmanStageSwing.mLogger.severe(mHost + " is unknown - aborting!");
        } catch (IOException e) {
            StickmanStageSwing.mLogger.severe(mHost + " i/o exception - aborting!");
        }
        mConnected = true;
        StickmanStageSwing.mLogger.info("StickmanStageSwing connected to control application at " + mSocket.toString());
        // register at server
        sendToServer("CLIENTID#" + sIDENTIFIER);
        start();
    }

    @Override
    public void tryToConnect(String host, int port) {
        mHost = host;
        mPort = port;
        connect(mHost, mPort);
        while (!ismConnected()) {
            try {
                System.out.println("Waiting for connection to control application ...");
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void run() {
        String inputLine = "";

        while (mRunning) {
            try {
                inputLine = mIn.readLine();

                if (inputLine != null) {
                    stickmanParser.parseStickmanXMLCmd(inputLine);
                }
            } catch (IOException ex) {
                StickmanStageSwing.mLogger.severe(mHost + " i/o exception - aborting!");
            }
        }
    }

    @Override
    public boolean ismConnected() {
        return mConnected;
    }
}
