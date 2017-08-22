package de.dfki.reeti.animationlogic;

import de.dfki.common.agent.Agent;
import de.dfki.common.animationlogic.EventAnimationScheduler;

/**
 * @author Beka Aptsiauri
 */
public class EventAnimationSchedulerReeti extends EventAnimationScheduler
{


    public EventAnimationSchedulerReeti(Agent agent)
    {
        super(agent);
    }


    @Override
    public synchronized void end()
    {
        mRunning = false;

        // throw in a last animationFX that unblocks the scheduler letting him end
        try
        {
            mAnimationQueue.put(new AnimationReeti(agent, 1, false));
        } catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}
