package de.dfki.stickmanfx.stagecontroller;

import de.dfki.common.ApplicationLauncherImpl;
import de.dfki.common.interfaces.StageStickman;
import de.dfki.stickmanfx.StickmanStageFX;

/**
 * Created by alvaro on 11/13/16.
 */
public class ApplicationLauncherFX extends ApplicationLauncherImpl {
    @Override
    public void launchStickmanAndWait() {
        StageStickman fx = new StickmanStageFX();
        getLaunchStickmanThread(fx).start();
        waitForApplicationToStart();
    }
}
