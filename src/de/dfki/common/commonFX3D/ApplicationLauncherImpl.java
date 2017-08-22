package de.dfki.common.commonFX3D;

import de.dfki.common.interfaces.AgentStage;
import de.dfki.common.interfaces.ApplicationLauncher;

public abstract class ApplicationLauncherImpl implements ApplicationLauncher
{

    private static boolean isRunning = false;

    public static boolean isRunning()
    {
        return isRunning;
    }

    public static synchronized void setIsRunning()
    {
        isRunning = true;
    }

    @Override
    public void waitForApplicationToStart()
    {
        while (!isRunning)
        { //New class for running
            try
            {
                Thread.sleep(200);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Thread getLaunchAgentThread(final AgentStage agentStage)
    {
        return new Thread()
        {
            public void run()
            {
                agentStage.lauchAgent();
            }

        };
    }
}
