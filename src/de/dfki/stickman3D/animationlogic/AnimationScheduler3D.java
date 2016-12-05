package de.dfki.stickman3D.animationlogic;

import de.dfki.stickman3D.Stickman3D;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AnimationScheduler3D extends Thread {

    Stickman3D mStickmanFX;
    boolean mRunning = true;
    public LinkedBlockingQueue<Animation3D> mAnimationQueue = new LinkedBlockingQueue<>();
    public Semaphore mTheBlockOfHell = new Semaphore(1);

    public AnimationScheduler3D(Stickman3D s) {
        setName(s.mName + "'s AnimationScheduler");
        mStickmanFX = s;
    }

    public void introduce(Animation3D a) {
        try {
            mAnimationQueue.put(a);
        } catch (InterruptedException ex) {
            mStickmanFX.mLogger.severe(ex.getMessage());
        }
    }

    public void proceed(Animation3D a) {
        removeAnimation(a);
        mTheBlockOfHell.release();
    }

    public void removeAnimation(Animation3D a) {
        mAnimationQueue.remove(a);
    }

    public synchronized void end() {
        mRunning = false;

        // throw in a last animation that unblocks the scheduler letting him end
        try {
            mAnimationQueue.put(new Animation3D(mStickmanFX, 1, false) {
            });
        } catch (InterruptedException ex) {
            Logger.getLogger(AnimationScheduler3D.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (mRunning) {
            try {
                // serialize all animations here ...
                mTheBlockOfHell.acquire(1);

                // get the next animation in the animation queue
                Animation3D animationFX = mAnimationQueue.take();

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
