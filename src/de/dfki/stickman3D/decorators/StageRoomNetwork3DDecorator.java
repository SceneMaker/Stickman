package de.dfki.stickman3D.decorators;

import de.dfki.common.decorators.StageRoomNetworkDecorator;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickman3D.XMLCommandParser3D;
import de.dfki.stickmanFX.client.ClientConnectionHandlerFX;

/**
 * Created by alvaro on 11/19/16.
 */
public class StageRoomNetwork3DDecorator extends StageRoomNetworkDecorator {

    public StageRoomNetwork3DDecorator(StageRoom wrappedController, String host, int port) {
        super(wrappedController, host, port);
    }

    @Override
    protected void initConnectionToServer(StageRoom wrappedController) {
        commonXMLCommandParser = new XMLCommandParser3D(getCommonStickmansOnStage());
        mConnection = new ClientConnectionHandlerFX(commonXMLCommandParser);
        mConnection.tryToConnect(mHost, mPort);
    }
}
