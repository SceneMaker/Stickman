package de.dfki.stickmanfx.stagecontroller.decorators;

import de.dfki.common.CommandParser;
import de.dfki.common.CommonStickman;
import de.dfki.common.StageStickmanController;
import de.dfki.stickmanfx.client.ClientConnectionHandlerFX;
import de.dfki.stickmanfx.stagecontroller.StageStickmanControllerFX;

/**
 * Created by alvaro on 9/17/16.
 */
public class StageStickmanNetworkControllerFXDecorator extends StageStickmanDecorator {
    private CommandParser commandParser;
    private  String mHost;
    private int mPort;
    private ClientConnectionHandlerFX mConnection;

    public StageStickmanNetworkControllerFXDecorator(StageStickmanController wrappedController, String host, int port){
        super(wrappedController);
        mHost = host;
        mPort = port;
        commandParser = new CommandParser(getStickmansOnStage());
        initConnectionToServer();
        getStickmansOnStage().setStageStickmanController(this); //We need to set this as the new controller, in order to receive the EventInfo
    }

    private  void initConnectionToServer(){
        mConnection = new ClientConnectionHandlerFX(commandParser);
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

    @Override
    public void launchStickmanStage(){
        super.launchStickmanStage();
    }

    @Override
    public void addStickman(String name){
        super.addStickman(name);
    }


}
