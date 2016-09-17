package de.dfki.stickmanfx.stagecontroller.decorators;

import de.dfki.common.CommandParser;
import de.dfki.common.CommonStickman;
import de.dfki.common.StageStickmanController;
import de.dfki.stickmanfx.StickmanStageFX;
import de.dfki.stickmanfx.client.ClientConnectionHandlerFX;
import de.dfki.stickmanfx.stagecontroller.StageStickmanControllerFX;

/**
 * Created by alvaro on 9/17/16.
 */
public class StageStickmanFullScreenControllerFXDecorator extends StageStickmanDecorator {

    public StageStickmanFullScreenControllerFXDecorator(StageStickmanController wrappedController){
        super(wrappedController);
    }

    public void addStickman(String name){
        setFullScreen(true);
        super.addStickman(name);
    }

    @Override
    public void launchStickmanStage(){
        controllerFX.getStickmanStageFX().setStageFullScreen(controllerFX.getStageIdentifier());
        super.launchStickmanStage();
    }

}
