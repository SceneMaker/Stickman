package de.dfki.common.interfaces;

/**
 * Created by alvaro on 11/13/16.
 */
public interface ApplicationLauncher
{

    void launchAgentAndWait();

    void waitForApplicationToStart();

    Thread getLaunchAgentThread(final AgentStage fx);
}
