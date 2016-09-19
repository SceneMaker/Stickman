package de.dfki.stickmanfx.stagecontroller.decorators;

import de.dfki.common.CommonCommandParser;
import de.dfki.common.StageStickmanController;
import de.dfki.common.CommonStageStickmanNetworkControllerDecorator;
import de.dfki.stickmanfx.client.ClientConnectionHandlerFX;
import de.dfki.stickmanfx.client.CommandParserFX;

/**
 * Created by alvaro on 9/17/16.
 */
public  class StageStickmanNetworkControllerDecoratorFX extends CommonStageStickmanNetworkControllerDecorator {
    public StageStickmanNetworkControllerDecoratorFX(StageStickmanController wrappedController, String host, int port) {
        super(wrappedController, host, port);
    }
    protected void initConnectionToServer(StageStickmanController wrappedController){
        commonCommandParser = new CommandParserFX(getCommonStickmansOnStage());
        mConnection = new ClientConnectionHandlerFX(commonCommandParser);
        mConnection.tryToConnect(mHost, mPort);
    }


}
