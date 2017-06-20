package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import static java.lang.Thread.sleep;
import javafx.application.Platform;

/**
 *
 * @author Robbie
 *
 */
public class IdleBehavior extends Thread {

    private int mSleepTime = 100; // control the duration after one segment.
    // control the speed of the wobble
    private Stickman3D mStickmanFX;
    private SimplexNoise mSimplexNoise; // generate perlin noise Array 2d
    private int count1 = 1; // index of perlin noise Array
    private int count2 = 1; // index of perlin noise Array
    public UnconsciouslyAction mUnconsciouslyAction;

    public IdleBehavior(Stickman3D s, SimplexNoise noise) {
        mSleepTime = 100;
        mStickmanFX = s;
        mSimplexNoise = noise;
        mUnconsciouslyAction = new UnconsciouslyAction(mStickmanFX);
        mUnconsciouslyAction.start();
    }

    public IdleBehavior(Stickman3D stickmanFX) {
        this.mStickmanFX = stickmanFX;
        this.mUnconsciouslyAction = new UnconsciouslyAction(stickmanFX);
        this.mUnconsciouslyAction.start();
    }

    @Override
    public void run() {
        while (mStickmanFX.mIdleRun) {
            // to generate index of perlin noise Array
            count1++;
            if (count1 == 200) {
                count1 = 0;
                count2++;
            }
            if (count2 == 200) {
                count2 = 1;
            }

            // mStickman.mWobble = ((mSimplexNoise.getNoise(count2, count1) *
            // 600)) / 20;
            //// System.out.printf("%.5f",mSimplexNoise.getNoise(count1,count2));
            //// System.out.println();
            double mAdjust = mStickmanFX.mWobble;

            // 40 segments to achieve the wobble: come and back
            for (int i = 0; i < 19; i++) {
                mStickmanFX.mWobble = mStickmanFX.mWobble + mAdjust;
                Platform.runLater(() -> {
                    mStickmanFX.update();
                });

                try {
                    sleep(mSleepTime, 0);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }
            }

            for (int i = 0; i < 19; i++) {
                mStickmanFX.mWobble = mStickmanFX.mWobble - mAdjust;
                if (i == 18) {
                    mStickmanFX.mWobble = 0;
                }
                Platform.runLater(() -> {
                    mStickmanFX.update();
                });

                try {
                    sleep(mSleepTime, 0);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }
            }
        }
        while (mUnconsciouslyAction.isAlive())
			;
    }
}
