package de.dfki.stickmanfx.animation.environmentfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;

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
		mStickmanFX.mIdleRun = false;
		while (mStickmanFX.mIdleBehavior.isAlive());
		mStickmanFX.mIdleBehavior.mUnconsciouslyAction.stopBlinkAktion();
		mStickmanFX.mIdleBehavior = null;
		
	}
}
