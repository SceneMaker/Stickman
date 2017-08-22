package de.dfki.common.client;

import de.dfki.common.XMLCommandParser;
import de.dfki.stickmanFX.stage.StickmanStageFX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

/**
 * @author Patrick Gebhard
 */
public class ClientConnectionHandler extends Thread implements CommonClientConnectionHandler
{

    private static String sIDENTIFIER = "StickmanStageSwing";
    private Socket mSocket;
    private String mHost = "127.0.0.1";
    private int mPort = 7777;
    private PrintWriter mOut;
    private BufferedReader mIn;
    private boolean mRunning = true;
    private boolean mConnected = false;
    private StickmanStageFX mStickmanStage;
    private XMLCommandParser stickmanParser;

    public ClientConnectionHandler()
    {
        super.setName("StickmanStageSwing Socket Connection Handler");
    }

    public ClientConnectionHandler(XMLCommandParser parser)
    {
        super.setName("StickmanStageSwing Socket Connection Handler");
        stickmanParser = parser;
    }

    @Override
    public void end()
    {
        try
        {
            mSocket.shutdownInput();
            mSocket.shutdownOutput();
            mSocket.close();
            mRunning = false;
            mConnected = false;
        } catch (IOException ex)
        {
        }
    }

    @Override
    public void sendToServer(String message)
    {
        //StickmanStageSwing.mLogger.info("Sending " + message);

        if (mSocket.isConnected())
        {
            mOut.println(message);
            mOut.flush();
        }
    }

    @Override
    public void connect(String host, int port)
    {
        mHost = host;
        mPort = port;
        connect();
    }

    @Override
    public void connect()
    {
        try
        {
            InetAddress inteAddress = InetAddress.getByName(mHost);
            SocketAddress socketAddress = new InetSocketAddress(inteAddress, mPort);

            mSocket = new Socket();
            mSocket.connect(socketAddress, 2000); // wait max. 2000ms

            mOut = new PrintWriter(mSocket.getOutputStream(), true);
            mIn = new BufferedReader(new InputStreamReader(mSocket.getInputStream(), "UTF-8"));
        } catch (UnknownHostException e)
        {
        } catch (IOException e)
        {
        }
        mConnected = true;
        // register at server
        sendToServer("CLIENTID#" + sIDENTIFIER);
        start();
    }

    @Override
    public void tryToConnect(String host, int port)
    {
        mHost = host;
        mPort = port;
        connect(mHost, mPort);
        while (!ismConnected())
        {
            try
            {
                System.out.println("Waiting for connection to control application ...");
                Thread.sleep(250);
            } catch (InterruptedException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void run()
    {
        String inputLine = "";

        while (mRunning)
        {
            try
            {
                inputLine = mIn.readLine();

                if (inputLine != null)
                {
                    stickmanParser.parseAgentXMLCmd(inputLine);
                }
            } catch (IOException ex)
            {
            }
        }
    }

    @Override
    public boolean ismConnected()
    {
        return mConnected;
    }
}
