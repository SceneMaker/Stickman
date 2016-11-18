package de.dfki.stickmanfx.animation.environmentfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;

/**
 *
 * @author Robbie
 *
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */

public class StartIdle extends AnimationFX {

	public StartIdle(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
		mStickmanFX = sm;
	}

	@Override
	public void playAnimation() {
		if (mStickmanFX.mIdleBehavior == null) {
			mStickmanFX.mIdleRun = true;
			mStickmanFX.mIdleBehavior = new IdleBehavior(mStickmanFX);
			mStickmanFX.mIdleBehavior.start();
		}
	}
}
