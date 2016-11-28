package de.dfki.stickman.stagecontroller.decorators;

import de.dfki.common.interfaces.StageStickmanController;
import de.dfki.stickmanfx.stagecontroller.decorators.StageStickmanDecorator;

/**
 * Created by alvaro on 9/19/16.
 */
public class StageStickmanFullScreenDecorator extends StageStickmanDecorator {
    public StageStickmanFullScreenDecorator(StageStickmanController wrappedController) {
        super(wrappedController);
        setFullScreen(true);

    }

    @Override
    public void launchStickmanConfiguration() {
    }
}
