package de.dfki.common;

import de.dfki.stickmanfx.client.CommonClientConnectionHandler;
import de.dfki.stickmanfx.stagecontroller.decorators.StageStickmanDecorator;

/**
 * Created by alvaro on 9/17/16.
 */
public abstract class CommonStageStickmanNetworkControllerDecorator extends StageStickmanDecorator {
    protected CommonCommandParser commonCommandParser;
    protected   String mHost;
    protected int mPort;
    protected CommonClientConnectionHandler mConnection;

    public CommonStageStickmanNetworkControllerDecorator(StageStickmanController wrappedController, String host, int port){
        super(wrappedController);
        mHost = host;
        mPort = port;
        initConnectionToServer(wrappedController);
        getCommonStickmansOnStage().setStageStickmanController(this); //We need to set this as the new controller, in order to receive the EventInfo
    }

    protected abstract void initConnectionToServer(StageStickmanController wrappedController);

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
