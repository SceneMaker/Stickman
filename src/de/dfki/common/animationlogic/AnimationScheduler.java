package de.dfki.common.animationlogic;

import de.dfki.common.agent.IAgent;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * Created by EmpaT on 27.07.2017.
 */
public class AnimationScheduler extends Thread
{
    public IAgent mAgent;
    public boolean mRunning = true;
    public Semaphore mTheBlockOfHell = new Semaphore(1);
    public LinkedBlockingQueue<Animation> mAnimationQueue = new LinkedBlockingQueue<>();

    public AnimationScheduler(IAgent agent)
    {
        setName(agent.getName() + "'s AnimationScheduler");
        mAgent = agent;
    }

    public void introduce(Animation animation)
    {
        try
        {
            mAnimationQueue.put(animation);
        } catch (InterruptedException ex)
        {
            ex.printStackTrace();
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

    public synchronized void end()
    {
        mRunning = false;

        // throw in a last animation that unblocks the scheduler letting him end
        try
        {
            mAnimationQueue.put(new Animation(mAgent, 1, false)
            {
            });
        } catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
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
                ex.printStackTrace();
            }
        }
    }
}
