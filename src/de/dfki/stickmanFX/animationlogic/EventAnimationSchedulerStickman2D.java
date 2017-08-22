package de.dfki.stickmanFX.animationlogic;

import de.dfki.common.agent.Agent;
import de.dfki.common.animationlogic.EventAnimationScheduler;

/**
 * @author Beka Aptsiauri
 */
public class EventAnimationSchedulerStickman2D extends EventAnimationScheduler
{

    public EventAnimationSchedulerStickman2D(Agent agent)
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
            mAnimationQueue.put(new AnimationStickman2D(agent, 1, false));
        } catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}
