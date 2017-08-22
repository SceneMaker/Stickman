/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animationlogic;

import de.dfki.common.agent.IAgent;
import de.dfki.common.animationlogic.Animation2D;

/**
 * @author Patrick Gebhard
 * @modified Beka Aptsiauri
 */
public class AnimationStickman2D extends Animation2D
{
    public AnimationStickman2D()
    {
        super();
    }

    public AnimationStickman2D(IAgent iAgent, int duration, boolean block)
    {
        super(iAgent, duration, block);
    }


    @Override
    public void playAnimationPart(int duration)
    {
        animator = new AnimatorStickman2D(agent, this, mAnimationPart, duration);

        try
        {
            mAnimationPartStart.acquire();
        } catch (InterruptedException ex)
        {
            agent.mLogger.severe(ex.getMessage());
        }

    }

    @Override
    public void run()
    {
        waitForClearance();
        play();
        finalizeAnimation();
    }

    @Override
    public String toString()
    {
        return mName + ", " + getName();
    }
}
