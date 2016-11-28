package de.dfki.stickmanSwing.stagecontroller.decorators;

import de.dfki.common.CommonStageStickmanNetworkControllerDecorator;
import de.dfki.common.interfaces.StageStickmanController;
import de.dfki.stickmanSwing.client.ClientConnectionHandler;
import de.dfki.stickmanSwing.client.CommandParser;

/**
 * Created by alvaro on 9/17/16.
 */
public class StageStickmanNetworkControllerDecorator extends CommonStageStickmanNetworkControllerDecorator {
    public StageStickmanNetworkControllerDecorator(StageStickmanController wrappedController, String host, int port) {
        super(wrappedController, host, port);
    }
    protected void initConnectionToServer(StageStickmanController wrappedController){
        commonCommandParser = new CommandParser(getCommonStickmansOnStage());
        mConnection = new ClientConnectionHandler(commonCommandParser);
        mConnection.tryToConnect(mHost, mPort);
    }
    
    @Override
    public void launchStickmanConfiguration() {
    }


}
