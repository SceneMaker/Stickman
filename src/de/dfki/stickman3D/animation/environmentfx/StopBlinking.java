package de.dfki.stickman3D.animation.environmentfx;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

/**
 *
 * @author Robbie
 *
 */
public class StopBlinking extends Animation3D {

    public StopBlinking(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        if(mStickmanFX.mBlinking != null)
            mStickmanFX.mBlinking.stopBlinkAktion();
    }
}
