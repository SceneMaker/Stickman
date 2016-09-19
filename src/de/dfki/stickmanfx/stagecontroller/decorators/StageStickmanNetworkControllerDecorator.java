package de.dfki.stickmanfx.stagecontroller.decorators;

import de.dfki.common.CommandParser;
import de.dfki.common.StageStickmanController;
import de.dfki.stickman.client.ClientConnectionHandler;
import de.dfki.stickman.stagecontroller.StageController;
import de.dfki.stickmanfx.client.ClientConnectionHandlerFX;
import de.dfki.stickmanfx.client.CommonClientConnectionHandler;
import de.dfki.stickmanfx.stagecontroller.StageStickmanControllerFX;

/**
 * Created by alvaro on 9/17/16.
 */
public class StageStickmanNetworkControllerDecorator extends StageStickmanDecorator {
    private CommandParser commandParser;
    private  String mHost;
    private int mPort;
    private CommonClientConnectionHandler mConnection;

    public StageStickmanNetworkControllerDecorator(StageStickmanController wrappedController, String host, int port){
        super(wrappedController);
        mHost = host;
        mPort = port;
        commandParser = new CommandParser(getCommonStickmansOnStage());
        initConnectionToServer(wrappedController);
        getCommonStickmansOnStage().setStageStickmanController(this); //We need to set this as the new controller, in order to receive the EventInfo
    }

    protected  void initConnectionToServer(StageStickmanController wrappedController){
        if(wrappedController instanceof StageStickmanControllerFX){
            mConnection = new ClientConnectionHandlerFX(commandParser);
        }else if(wrappedController instanceof StageController){
            mConnection = new ClientConnectionHandler(commandParser);
        }
        mConnection.tryToConnect(mHost, mPort);
    }

    @Override
    public boolean ismNetwork(){
        super.ismNetwork();
        return true;
    }

    @Override
    public void clearStage(){
        super.clearStage();
        if(mConnection != null){
            mConnection.end();
            mConnection = null;
        }
    }

    @Override
    public  void sendTimeMarkInformation(String timemark) {
        super.sendTimeMarkInformation(timemark);
        if (mConnection != null && mConnection.ismConnected()) {
            mConnection.sendToServer(timemark);
        }
    }

    @Override
    public  void sendAnimationUpdate(String state, String id) {
        super.sendAnimationUpdate(state, id);
        if (mConnection != null && mConnection.ismConnected()) {
            mConnection.sendToServer("#ANIM#" + state + "#" + id);
        }
    }


}
