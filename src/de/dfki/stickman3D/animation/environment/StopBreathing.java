package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

/**
 *
 * @author Robbie
 *
 */
public class StopBreathing extends Animation3D {

    public StopBreathing(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        if(mStickmanFX.mBreathing != null)
            mStickmanFX.mBreathing.stopBreathAktion();
    }
}
