package de.dfki.common;

import de.dfki.stickmanfx.StickmanStageFX;

public abstract class ApplicationFXLauncherImpl implements de.dfki.common.ApplicationFXLauncher {
    private static boolean isRunning = false;
    @Override
    public void waitForApplicationToStart() {
        while (!isRunning) { //New class for running
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Thread getLaunchStickmanThread(final StageStickman fx) {
        return new Thread() {
            public void run() {
                fx.lauchStickman();
            }

        };
    }

    public static boolean isRunning() {
        return isRunning;
    }

    public static synchronized void setIsRunning(){
        isRunning = true;
    }
}