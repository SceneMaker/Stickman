package de.dfki.stickman3D.animation.environmentfx;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

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

public class StartIdle extends Animation3D {

	public StartIdle(Stickman3D sm, int duration, boolean block) {
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
