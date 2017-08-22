package de.dfki.stickmanFX;

import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.stickmanFX.stage.StickmanStageFX;

/**
 * Created by alvaro on 11/13/16.
 */
public class ApplicationLauncherFX extends ApplicationLauncherImpl
{

    @Override
    public void launchAgentAndWait()
    {
        AgentStage fx = new StickmanStageFX();
        getLaunchAgentThread(fx).start();
        waitForApplicationToStart();
    }
}
