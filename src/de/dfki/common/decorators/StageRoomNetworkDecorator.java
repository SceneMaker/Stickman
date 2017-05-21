package de.dfki.common.decorators;

import de.dfki.common.XMLCommandParser;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickmanFX.client.CommonClientConnectionHandler;

/**
 * Created by alvaro on 9/17/16.
 */
public abstract class StageRoomNetworkDecorator extends StageRoomDecorator {

    protected XMLCommandParser commonXMLCommandParser;
    protected String mHost;
    protected int mPort;
    protected CommonClientConnectionHandler mConnection;

    public StageRoomNetworkDecorator(StageRoom wrappedController, String host, int port) {
        super(wrappedController);
        mHost = host;
        mPort = port;
        initConnectionToServer(wrappedController);
        getCommonStickmansOnStage().setStageRoom(this); //We need to set this as the new controller, in order to receive the EventInfo
    }

    protected abstract void initConnectionToServer(StageRoom wrappedController);

    @Override
    public boolean ismNetwork() {
        super.ismNetwork();
        return true;
    }

    @Override
    public void clearStage() {
        super.clearStage();
        if (mConnection != null) {
            mConnection.end();
            mConnection = null;
        }
    }

    @Override
    public void sendTimeMarkInformation(String timemark) {
        super.sendTimeMarkInformation(timemark);
        if (mConnection != null && mConnection.ismConnected()) {
            mConnection.sendToServer(timemark);
        }
    }

    @Override
    public void sendAnimationUpdate(String state, String id) {
        super.sendAnimationUpdate(state, id);
        if (mConnection != null && mConnection.ismConnected()) {
            mConnection.sendToServer("#ANIM#" + state + "#" + id);
        }
    }

}
