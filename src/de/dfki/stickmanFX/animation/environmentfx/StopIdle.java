package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;

/**
 * @author Robbie
 */
public class StopIdle extends AnimationStickman2D
{

    public StopIdle(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        ((StickmanFX) agent).mIdleRun = false;
        while (((StickmanFX) agent).mIdleBehavior.isAlive()) ;
    }
}
