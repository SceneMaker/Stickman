package de.dfki.stickmanfx.stagecontroller.decorators;

import de.dfki.common.CommandParser;
import de.dfki.common.StageStickmanController;
import de.dfki.stickmanfx.client.ClientConnectionHandlerFX;
import de.dfki.stickmanfx.stagecontroller.StageStickmanControllerFX;

/**
 * Created by alvaro on 9/17/16.
 */
public class StageStickmanNetworkControllerFXDecorator extends StageStickmanControllerFX {
    private CommandParser commandParser;
    private  String mHost;
    private int mPort;
    private StageStickmanController controllerFX;
    private ClientConnectionHandlerFX mConnection;

    public StageStickmanNetworkControllerFXDecorator(StageStickmanController wrappedController, String host, int port){
        mHost = host;
        mPort = port;
        controllerFX = wrappedController;
        commandParser = new CommandParser(stickmansOnStage);
        initConnectionToServer();
    }

    private  void initConnectionToServer(){
        mConnection = new ClientConnectionHandlerFX(commandParser);
        mConnection.tryToConnect(mHost, mPort);
    }

    @Override
    public boolean ismNetwork(){
        return true;
    }

    @Override
    public void clearStage(){
        controllerFX.clearStage();
        if(mConnection != null){
            mConnection.end();
            mConnection = null;
        }
    }

    @Override
    public  void sendTimeMarkInformation(String timemark) {
        if (mConnection != null && mConnection.ismConnected()) {
            mConnection.sendToServer(timemark);
        }
    }

    @Override
    public  void sendAnimationUpdate(String state, String id) {
        if (mConnection != null && mConnection.ismConnected()) {
            mConnection.sendToServer("#ANIM#" + state + "#" + id);
        }
    }
}
