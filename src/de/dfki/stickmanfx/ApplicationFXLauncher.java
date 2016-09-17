package de.dfki.stickmanfx;

public class ApplicationFXLauncher {
    public ApplicationFXLauncher() {
    }

    void launchStickmanAndWait() {
        StickmanStageFX fx = new StickmanStageFX();
        getLaunchStickmanThread(fx).start();
        waitForApplicationToStart();
    }

    void waitForApplicationToStart() {
        while (!StickmanStageFX.isRunning) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Thread getLaunchStickmanThread(final StickmanStageFX fx) {
        Thread t = new Thread() {
            public void run() {
                fx.lauchStickman();
            }

        };
        return t;
    }
}