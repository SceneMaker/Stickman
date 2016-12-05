package de.dfki.stickmanFX.animationlogic;

import de.dfki.stickmanFX.StickmanFX;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AnimationSchedulerFX extends Thread {

    StickmanFX mStickmanFX;
    boolean mRunning = true;
    public LinkedBlockingQueue<AnimationFX> mAnimationQueue = new LinkedBlockingQueue<>();
    public Semaphore mTheBlockOfHell = new Semaphore(1);

    public AnimationSchedulerFX(StickmanFX s) {
        setName(s.mName + "'s AnimationScheduler");
        mStickmanFX = s;
    }

    public void introduce(AnimationFX a) {
        try {
            mAnimationQueue.put(a);
        } catch (InterruptedException ex) {
            mStickmanFX.mLogger.severe(ex.getMessage());
        }
    }

    public void proceed(AnimationFX a) {
        removeAnimation(a);
        mTheBlockOfHell.release();
    }

    public void removeAnimation(AnimationFX a) {
        mAnimationQueue.remove(a);
    }

    public synchronized void end() {
        mRunning = false;

        // throw in a last animation that unblocks the scheduler letting him end
        try {
            mAnimationQueue.put(new AnimationFX(mStickmanFX, 1, false) {
            });
        } catch (InterruptedException ex) {
            Logger.getLogger(AnimationSchedulerFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (mRunning) {
            try {
                // serialize all animations here ...
                mTheBlockOfHell.acquire(1);

                // get the next animation in the animation queue
                AnimationFX animationFX = mAnimationQueue.take();

                // tell the animation to render itself
                animationFX.mAnimationStart.release();

                // unblock the scheduler if animation is not blocking
                if (!animationFX.mBlocking) {
                    mTheBlockOfHell.release();
                    removeAnimation(animationFX);
                }
            } catch (InterruptedException ex) {
                mStickmanFX.mLogger.severe(ex.getMessage());
            }
        }
    }
}
