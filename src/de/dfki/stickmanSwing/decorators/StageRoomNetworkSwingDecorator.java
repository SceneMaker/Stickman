package de.dfki.stickmanSwing.decorators;

import de.dfki.common.decorators.StageRoomNetworkDecorator;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickmanSwing.client.ClientConnectionHandler;
import de.dfki.stickmanSwing.client.XMLCommandParserSwing;

/**
 * Created by alvaro on 9/17/16.
 */
public class StageRoomNetworkSwingDecorator extends StageRoomNetworkDecorator {
    public StageRoomNetworkSwingDecorator(StageRoom wrappedController, String host, int port) {
        super(wrappedController, host, port);
    }
    protected void initConnectionToServer(StageRoom wrappedController){
        commonXMLCommandParser = new XMLCommandParserSwing(getCommonStickmansOnStage());
        mConnection = new ClientConnectionHandler(commonXMLCommandParser);
        mConnection.tryToConnect(mHost, mPort);
    }
    
    @Override
    public void launchStickmanConfiguration() {
    }


}
