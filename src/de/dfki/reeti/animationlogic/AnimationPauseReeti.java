package de.dfki.reeti.animationlogic;

import de.dfki.reeti.Reeti;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AnimationPauseReeti {

    private final Reeti mReeti;
    private final AnimationReeti mAnimation;
    public Semaphore mPauseEnd = new Semaphore(0);

    public AnimationPauseReeti(Reeti reeti, AnimationReeti a, int duration) {
        mReeti = reeti;
        mAnimation = a;

        new WaitThread(duration).start();

        // block this until WaitThread will unblock 
        try {
            mPauseEnd.acquire(1);
        } catch (InterruptedException ex) {
            mReeti.mLogger.severe(ex.getMessage());
        }

        // tell animation to proceed
        mAnimation.mAnimationPartStart.release();
    }

    private class WaitThread extends Thread {

        int mSleepTime = 0;

        public WaitThread(int time) {
            mSleepTime = time;
        }

        @Override
        public void run() {
            // directly go to sleep
            try {
                sleep(mSleepTime);
            } catch (InterruptedException ex) {
                mReeti.mLogger.severe(ex.getMessage());
            }
            mPauseEnd.release();
        }
    }
}
