package de.dfki.reeti;

import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.common.interfaces.AgentStage;
import de.dfki.reeti.stage.ReetiStage;

/**
 * Created by alvaro on 11/13/16.
 */
public class ApplicationLauncherReeti extends ApplicationLauncherImpl
{

    @Override
    public void launchAgentAndWait()
    {
        AgentStage fx = new ReetiStage();
        getLaunchAgentThread(fx).start();
        waitForApplicationToStart();
    }
}
