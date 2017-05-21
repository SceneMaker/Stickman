package de.dfki.stickman3D.animation.environment;

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
        mStickmanFX.mIdleRun = false;
        mStickmanFX.mIdleBehavior = null;
        System.out.println("de.dfki.stickman3D.animation.environmentfx.StopIdle.playAnimation()");
    }
}
