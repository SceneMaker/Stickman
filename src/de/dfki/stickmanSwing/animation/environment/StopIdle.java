package de.dfki.stickmanSwing.animation.environment;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.Animation;

/**
 *
 * @author Robbie
 *
 */
public class StopIdle extends Animation {

	public StopIdle(StickmanSwing sm, int duration, boolean block) {
		super(sm, duration, block);
	}


	@Override
	public void playAnimation() {
		mStickman.mIdleRun = false;
		while (mStickman.mIdleBehavior.isAlive());
	}
}
