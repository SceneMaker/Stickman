package de.dfki.common.decorators;

import de.dfki.common.interfaces.StageRoom;

/**
 * Created by alvaro on 9/17/16.
 */
public class StageRoomFullScreenDecorator extends StageRoomDecorator {

    public StageRoomFullScreenDecorator(StageRoom wrappedController){
        super(wrappedController);
    }

    @Override
    public void addStickman(String name){
        setFullScreen(true);
        super.addStickman(name);
    }

    @Override
    public void launchStickmanStage(boolean show){
        controllerFX.getStickmanStage().setStageFullScreen(controllerFX.getStageIdentifier());
        super.launchStickmanStage(show);
    }

    @Override
    public void launchStickmanStage(boolean show, String filepath){
        controllerFX.getStickmanStage().setStageFullScreen(controllerFX.getStageIdentifier());
        super.launchStickmanStage(show, filepath);
    }

}
