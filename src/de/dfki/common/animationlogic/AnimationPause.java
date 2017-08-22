package de.dfki.common.animationlogic;

import de.dfki.common.agent.Agent;

import java.util.concurrent.Semaphore;

/**
 * Created by EmpaT on 01.08.2017.
 */
public class AnimationPause
{
    private final Agent agent;
    private final Animation animation;
    public Semaphore pauseEnd = new Semaphore(0);

    public AnimationPause(Agent agent, Animation animation, int duration)
    {
        this.agent = agent;
        this.animation = animation;

        new WaitThread(duration).start();

        // block this until WaitThread will unblock
        try
        {
            pauseEnd.acquire(1);
        } catch (InterruptedException ex)
        {
            this.agent.mLogger.severe(ex.getMessage());
        }

        // tell animation to proceed
        this.animation.mAnimationPartStart.release();
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
            } catch (InterruptedException ex)
            {
                agent.mLogger.severe(ex.getMessage());
            }
            pauseEnd.release();
        }
    }
}
