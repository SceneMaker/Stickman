package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;

/**
 * @author Robbie
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class StartIdle extends AnimationStickman2D
{

    public StartIdle(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        if (!((StickmanFX) agent).mIdleBehavior.isAlive())
        {
            ((StickmanFX) agent).mIdleRun = true;
            ((StickmanFX) agent).mIdleBehavior = new IdleBehavior(((StickmanFX) agent), ((StickmanFX) agent).simplexNoise);
            ((StickmanFX) agent).mIdleBehavior.start();
        }
    }
}
