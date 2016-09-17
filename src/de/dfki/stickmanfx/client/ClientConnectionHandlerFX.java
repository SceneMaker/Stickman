package de.dfki.stickmanfx.client;

import de.dfki.common.CommandParser;
import de.dfki.stickman.StickmanStage;
import de.dfki.stickmanfx.StickmanStageFX;
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
public class ClientConnectionHandlerFX extends Thread {

	private Socket mSocket;
	private String mHost = "127.0.0.1";
	private int mPort = 7777;
	private PrintWriter mOut;
	private BufferedReader mIn;
	private static String sIDENTIFIER = "StickmanStage";

	private boolean mRunning = true;
	private boolean mConnected = false;
	private StickmanStageFX mStickmanStage;
	private CommandParser stickmanParser;



	public ClientConnectionHandlerFX() {
		super.setName("StickmanStage Socket Connection Handler");
	}

	public ClientConnectionHandlerFX(CommandParser parser) {
		super.setName("StickmanStage Socket Connection Handler");
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
			StickmanStage.mLogger.severe("Error closing socket to " + mHost + ", " + mPort);
		}
	}

	public void sendToServer(String message) {
		//StickmanStage.mLogger.info("Sending " + message);

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
		StickmanStage.mLogger.info("StickmanStage tries to connect with control application ...");
		try {
			InetAddress inteAddress = InetAddress.getByName(mHost);
			SocketAddress socketAddress = new InetSocketAddress(inteAddress, mPort);

			mSocket = new Socket();
			mSocket.connect(socketAddress, 2000); // wait max. 2000ms

			mOut = new PrintWriter(mSocket.getOutputStream(), true);
			mIn = new BufferedReader(new InputStreamReader(mSocket.getInputStream(), "UTF-8"));
		} catch (UnknownHostException e) {
			StickmanStage.mLogger.severe(mHost + " is unknown - aborting!");
		} catch (IOException e) {
			StickmanStage.mLogger.severe(mHost + " i/o exception - aborting!");
		}
		mConnected = true;
		StickmanStage.mLogger.info("StickmanStage connected to control application at " + mSocket.toString());
		// register at server
		sendToServer("CLIENTID#" + sIDENTIFIER);
		start();
	}

	public void tryToConnect(String host, int port){
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
					stickmanParser.parseStickmanMLCmd(inputLine);
				}
			} catch (IOException ex) {
				StickmanStage.mLogger.severe(mHost + " i/o exception - aborting!");
			}
		}
	}

	public boolean ismConnected() {
		return mConnected;
	}
}
