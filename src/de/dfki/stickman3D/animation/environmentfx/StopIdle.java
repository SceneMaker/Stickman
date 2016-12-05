package de.dfki.stickman3D.animation.environmentfx;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

/**
 *
 * @author Robbie
 *
 */
public class StopIdle extends Animation3D {

    public StopIdle(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
//		mStickmanFX.mIdleRun = false;
//		while (mStickmanFX.mIdleBehavior.isAlive());
    }
}
