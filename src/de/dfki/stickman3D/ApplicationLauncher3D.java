package de.dfki.stickman3D;

import de.dfki.common.ApplicationFXLauncherImpl;
import de.dfki.common.interfaces.StageStickman;

/**
 * Created by alvaro on 11/13/16.
 */
public class ApplicationLauncher3D extends ApplicationFXLauncherImpl {
    @Override
    public void launchStickmanAndWait() {
        StageStickman fx = new StickmanStage3D();
        getLaunchStickmanThread(fx).start();
        waitForApplicationToStart();
    }
}
