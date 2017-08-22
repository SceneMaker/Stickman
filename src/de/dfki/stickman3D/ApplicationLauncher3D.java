package de.dfki.stickman3D;

import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.stickman3D.stage.StickmanStage3D;

/**
 * Created by alvaro on 11/13/16.
 */
public class ApplicationLauncher3D extends ApplicationLauncherImpl
{

    @Override
    public void launchAgentAndWait()
    {
        AgentStage fx = new StickmanStage3D();
        getLaunchAgentThread(fx).start();
        waitForApplicationToStart();
    }
}
