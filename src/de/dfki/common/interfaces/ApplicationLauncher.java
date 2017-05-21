package de.dfki.common.interfaces;

/**
 * Created by alvaro on 11/13/16.
 */
public interface ApplicationLauncher {

    void launchStickmanAndWait();

    void waitForApplicationToStart();

    Thread getLaunchStickmanThread(final StickmanStage fx);
}
