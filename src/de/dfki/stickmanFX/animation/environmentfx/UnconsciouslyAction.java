package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.stickmanFX.StickmanFX;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class UnconsciouslyAction extends Thread {

    private StickmanFX mStickmanFX;
    private SimplexNoise mSimplexNoise;  // generate perlin noise Array 2d
    private int count1 = 1;    			// index of perlin noise Array
    private int count2 = 1;    			// index of perlin noise Array
    private int countCoverMouth = 0;
    private int countTouchHead = 0;
    private int countBlink = 0;
    private int countTileHead = 0;
    private int NoiseNumber;
    private int mSleepTime = 0;

    public UnconsciouslyAction(StickmanFX s, SimplexNoise noise) {
        mStickmanFX = s;
        mSimplexNoise = noise;
        mSleepTime = 60;
    }

    private void coverMouth() {
        if (NoiseNumber == 1) {
            countCoverMouth++;
            if (countCoverMouth == 20) {
                countCoverMouth = 0;
                countTouchHead = 0;
                countTileHead = 0;
                if (mStickmanFX.mAnimationSchedulerFX.mAnimationQueue.isEmpty()) // to ignore to many actions put in mAnimationQueue
                {
                    mStickmanFX.doAnimation("CoverMouth", 500, true);
                }
            } else {
                try {
                    sleep(mSleepTime, 0);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }
            }
        }
    }

    private void touchHead() {
        if (NoiseNumber == 2) {
            countTouchHead++;
            if (countTouchHead == 20) {
                countCoverMouth = 0;
                countTouchHead = 0;
                countTileHead = 0;
                if (mStickmanFX.mAnimationSchedulerFX.mAnimationQueue.isEmpty()) {
                    mStickmanFX.doAnimation("TouchHead", 500, true);
                }
            } else {
                try {
                    sleep(mSleepTime, 0);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }
            }
        }
    }

    private void blink() {
        if (NoiseNumber == 3) {
            countBlink++;
            if (countBlink == 8) {
                countBlink = 0;
                if (mStickmanFX.mAnimationSchedulerFX.mAnimationQueue.isEmpty()) {
                    mStickmanFX.doAnimation("Blink", 500, true);
                }
            } else {
                try {
                    sleep(mSleepTime, 0);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }
            }
        }
    }

    private void tileHead() {
        if (NoiseNumber == 4) {
            countTileHead++;
            if (countTileHead == 25) {
                countCoverMouth = 0;
                countTouchHead = 0;
                countTileHead = 0;
                if (mStickmanFX.mAnimationSchedulerFX.mAnimationQueue.isEmpty()) {
                    mStickmanFX.doAnimation("HeadTilt", 500, true);
                }
            } else {
                try {
                    sleep(mSleepTime, 0);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }
            }
        }
    }

    @Override
    public void run() {
        while (mStickmanFX.mIdleRun) {
            count1++;
            if (count1 == 200) {
                count1 = 0;
                count2++;
            }

            if (count2 == 200) {
                count2 = 1;
            }

            NoiseNumber = (int) (mSimplexNoise.getNoise(count2, count1) * 100);

            if ((NoiseNumber != 1) && (NoiseNumber != 2) && (NoiseNumber != 3) && (NoiseNumber != 4)) {
                try {
                    sleep(mSleepTime, 0);
                } catch (InterruptedException ex) {
                    mStickmanFX.mLogger.severe(ex.getMessage());
                }
            } else {
                coverMouth();
                touchHead();
                blink();
                tileHead();
            }

        }
    }
}
