package de.dfki.common.animationlogic;

import de.dfki.common.agent.Agent;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * Created by EmpaT on 01.08.2017.
 */
public abstract class EventAnimationScheduler extends Thread
{
    public LinkedBlockingQueue<Animation> mAnimationQueue = new LinkedBlockingQueue<>();
    public Semaphore mTheBlockOfHell = new Semaphore(1);
    protected Agent agent;
    protected boolean mRunning = true;

    public EventAnimationScheduler(Agent agent)
    {
        setName(agent.mName + "'s Event AnimationScheduler");
        this.agent = agent;
    }

    public void introduce(Animation animation)
    {
        try
        {
            agent.mLogger.info("AnimationSwing " + animation + " added to event animation scheduler");
            mAnimationQueue.put(animation);
        } catch (InterruptedException ex)
        {
            agent.mLogger.severe(ex.getMessage());
        }
    }

    public void proceed(Animation animation)
    {
        removeAnimation(animation);
        mTheBlockOfHell.release();
    }

    public void removeAnimation(Animation animation)
    {
        mAnimationQueue.remove(animation);
    }

    @Override
    public void run()
    {
        while (mRunning)
        {
            try
            {
                // serialize all animations here ...
                mTheBlockOfHell.acquire(1);

                // get the next animation in the animation queue
                Animation animation = mAnimationQueue.take();

                // tell the animation to render itself
                animation.mAnimationStart.release();

                // unblock the scheduler if animation is not blocking
                if (!animation.mBlocking)
                {
                    mTheBlockOfHell.release();
                    removeAnimation(animation);
                }
            } catch (InterruptedException ex)
            {
                agent.mLogger.severe(ex.getMessage());
            }
        }
    }

    public abstract void end();
}
