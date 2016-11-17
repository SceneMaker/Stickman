package de.dfki.stickman3D;

import de.dfki.common.ApplicationFXLauncherImpl;
import de.dfki.common.StageStickman;
import de.dfki.stickmanfx.StickmanStageFX;

/**
 * Created by alvaro on 11/13/16.
 */
public class ApplicationLauncher3DFx extends ApplicationFXLauncherImpl {
    @Override
    public void launchStickmanAndWait() {
        StageStickman fx = new StickmanStage3D();
        getLaunchStickmanThread(fx).start();
        waitForApplicationToStart();
    }
}
