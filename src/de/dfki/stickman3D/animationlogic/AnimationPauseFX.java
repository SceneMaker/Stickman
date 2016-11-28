package de.dfki.stickman3D.animationlogic;


import de.dfki.stickman3D.Stickman3D;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AnimationPauseFX  
{
    private final Stickman3D mStickmanFX;
    private final AnimationFX mAnimationFX;
    public Semaphore mPauseEnd = new Semaphore(0);

    public AnimationPauseFX(Stickman3D sm, AnimationFX a, int duration)
    {
        mStickmanFX = sm;
        mAnimationFX = a;

        new WaitThread(duration).start();

        // block this until WaitThread will unblock 
        try 
        {
            mPauseEnd.acquire(1);
        } 
        catch (InterruptedException ex) 
        {
            mStickmanFX.mLogger.severe(ex.getMessage());
        }

        // tell animation to proceed
        mAnimationFX.mAnimationPartStart.release();
    }

    private class WaitThread extends Thread 
    {
        int mSleepTime = 0;

        public WaitThread(int time) 
        {
            mSleepTime = time;
        }

        @Override
        public void run() 
        {
            // directly go to sleep
            try 
            {
                sleep(mSleepTime);
            } 
            catch (InterruptedException ex) 
            {
                mStickmanFX.mLogger.severe(ex.getMessage());
            }
            mPauseEnd.release();
        }
    }
}
