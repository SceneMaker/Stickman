package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;

/**
 *
 * @author Robbie
 *
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class StartIdle extends AnimationFX {

    public StartIdle(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        if (!mStickmanFX.mIdleBehavior.isAlive()) {
            mStickmanFX.mIdleRun = true;
            mStickmanFX.mIdleBehavior = new IdleBehavior(mStickmanFX, mStickmanFX.simplexNoise);
            mStickmanFX.mIdleBehavior.start();
        }
    }
}
