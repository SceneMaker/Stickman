package de.dfki.stickmanfx.stagecontroller.decorators;

import de.dfki.common.StageStickmanController;
import de.dfki.common.CommonStageStickmanNetworkControllerDecorator;
import de.dfki.stickmanfx.client.ClientConnectionHandlerFX;

/**
 * Created by alvaro on 9/17/16.
 */
public abstract class StageStickmanNetworkControllerDecoratorFX extends CommonStageStickmanNetworkControllerDecorator {
    public StageStickmanNetworkControllerDecoratorFX(StageStickmanController wrappedController, String host, int port) {
        super(wrappedController, host, port);
    }
    protected void initConnectionToServer(StageStickmanController wrappedController){
        mConnection = new ClientConnectionHandlerFX(commandParser);
        mConnection.tryToConnect(mHost, mPort);
    }


}
