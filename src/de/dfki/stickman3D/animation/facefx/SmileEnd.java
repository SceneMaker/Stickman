package de.dfki.stickman3D.animation.facefx;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContentFX;
import de.dfki.stickman3D.animationlogic.AnimationFX;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class SmileEnd extends AnimationFX {

    public SmileEnd(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // smile end
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SMILEEND"));
        playAnimationPart(mDuration);
        pauseAnimation(10);
    }
}
