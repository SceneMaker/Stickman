package de.dfki.stickmanSwing.animation.environment;

import de.dfki.stickmanSwing.StickmanSwing;

/**
 *
 * @author Robbie
 *
 */
public class IdleBehavior extends Thread {

    private int mSleepTime = 100;  // control the duration after one segment. control the speed of the wobble
    private StickmanSwing mStickman;
    private SimplexNoise mSimplexNoise;  // generate perlin noise Array 2d
    private int count1 = 1;    // index of perlin noise Array
    private int count2 = 1;    // index of perlin noise Array
    private UnconsciouslyAction mUnconsciouslyAction;

    public IdleBehavior(StickmanSwing s, SimplexNoise noise) {
        mSleepTime = 100;
        mStickman = s;
        mSimplexNoise = noise;
        mUnconsciouslyAction = new UnconsciouslyAction(mStickman, mSimplexNoise);
        mUnconsciouslyAction.start();
    }

    @Override
    public void run() {
        while (mStickman.mIdleRun) {
            // to generate index of perlin noise Array
            count1++;
            if (count1 == 200) {
                count1 = 0;
                count2++;
            }
            if (count2 == 200) {
                count2 = 1;
            }

            mStickman.mWobble = ((mSimplexNoise.getNoise(count2, count1) * 10)) / 20;
//        System.out.printf("%.5f",mSimplexNoise.getNoise(count1,count2));
//        System.out.println();
            double mAdjust = mStickman.mWobble;

            // 40 segments to achieve the wobble: come and back
            for (int i = 0; i < 19; i++) {
                mStickman.mWobble = mStickman.mWobble + mAdjust;
                mStickman.repaint();
                try {
                    sleep(mSleepTime, 0);
                } catch (InterruptedException ex) {
                    mStickman.mLogger.severe(ex.getMessage());
                }
            }

            for (int i = 0; i < 19; i++) {
                mStickman.mWobble = mStickman.mWobble - mAdjust;
                if (i == 18) {
                    mStickman.mWobble = 0;
                }
                mStickman.repaint();

                try {
                    sleep(mSleepTime, 0);
                } catch (InterruptedException ex) {
                    mStickman.mLogger.severe(ex.getMessage());
                }
            }
        }
        while (mUnconsciouslyAction.isAlive());
    }
}
