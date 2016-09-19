package de.dfki.stickman.stagecontroller.decorators;

import de.dfki.common.CommonStageStickmanNetworkControllerDecorator;
import de.dfki.common.StageStickmanController;
import de.dfki.stickman.client.ClientConnectionHandler;

/**
 * Created by alvaro on 9/17/16.
 */
public abstract class StageStickmanNetworkControllerDecorator extends CommonStageStickmanNetworkControllerDecorator {
    public StageStickmanNetworkControllerDecorator(StageStickmanController wrappedController, String host, int port) {
        super(wrappedController, host, port);
    }
    protected void initConnectionToServer(StageStickmanController wrappedController){
        mConnection = new ClientConnectionHandler(commandParser);
        mConnection.tryToConnect(mHost, mPort);
    }


}
