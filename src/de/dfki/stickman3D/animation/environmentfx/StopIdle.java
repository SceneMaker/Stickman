package de.dfki.stickman3D.animation.environmentfx;

import de.dfki.stickman3D.StickmanFX;
import de.dfki.stickman3D.animationlogic.AnimationFX;

/**
 *
 * @author Robbie
 *
 */
public class StopIdle extends AnimationFX {

	public StopIdle(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}


	@Override
	public void playAnimation() {
//		mStickmanFX.mIdleRun = false;
//		while (mStickmanFX.mIdleBehavior.isAlive());
	}
}
