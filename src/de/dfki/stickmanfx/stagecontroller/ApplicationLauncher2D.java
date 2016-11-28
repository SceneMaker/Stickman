package de.dfki.stickmanfx.stagecontroller;

import de.dfki.common.ApplicationFXLauncherImpl;
import de.dfki.common.interfaces.StageStickman;
import de.dfki.stickmanfx.StickmanStageFX;

/**
 * Created by alvaro on 11/13/16.
 */
public class ApplicationLauncher2D extends ApplicationFXLauncherImpl {
    @Override
    public void launchStickmanAndWait() {
        StageStickman fx = new StickmanStageFX();
        getLaunchStickmanThread(fx).start();
        waitForApplicationToStart();
    }
}
