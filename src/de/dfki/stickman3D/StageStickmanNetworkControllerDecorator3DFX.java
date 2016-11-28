package de.dfki.stickman3D;

import de.dfki.common.CommonStageStickmanNetworkControllerDecorator;
import de.dfki.common.interfaces.StageStickmanController;
import de.dfki.stickmanfx.client.ClientConnectionHandlerFX;


/**
 * Created by alvaro on 11/19/16.
 */
public class StageStickmanNetworkControllerDecorator3DFX extends CommonStageStickmanNetworkControllerDecorator {
    public StageStickmanNetworkControllerDecorator3DFX(StageStickmanController wrappedController, String host, int port) {
        super(wrappedController, host, port);
    }

    @Override
    protected void initConnectionToServer(StageStickmanController wrappedController) {
        commonCommandParser = new CommandParser3DFX(getCommonStickmansOnStage());
        mConnection = new ClientConnectionHandlerFX(commonCommandParser);
        mConnection.tryToConnect(mHost, mPort);
    }
}
