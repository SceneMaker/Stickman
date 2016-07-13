package de.dfki.stickman.animation.environment;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;

/**
 *
 * @author Robbie
 *
 */
public class StopIdle extends Animation {

	public StopIdle(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}


	@Override
	public void playAnimation() {
		mStickman.mIdleRun = false;
		while (mStickman.mIdleBehavior.isAlive());
	}
}
