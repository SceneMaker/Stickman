package de.dfki.common;

/**
 * Created by alvaro on 11/13/16.
 */
public interface ApplicationFXLauncher {
    void launchStickmanAndWait();
    void waitForApplicationToStart();
    Thread getLaunchStickmanThread(final StageStickman fx);
}
