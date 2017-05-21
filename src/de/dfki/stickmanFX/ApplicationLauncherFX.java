package de.dfki.stickmanFX;

import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.interfaces.StickmanStage;
import de.dfki.stickmanFX.stage.StickmanStageFX;

/**
 * Created by alvaro on 11/13/16.
 */
public class ApplicationLauncherFX extends ApplicationLauncherImpl {

    @Override
    public void launchStickmanAndWait() {
        StickmanStage fx = new StickmanStageFX();
        getLaunchStickmanThread(fx).start();
        waitForApplicationToStart();
    }
}
