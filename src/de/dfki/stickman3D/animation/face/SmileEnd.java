package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class SmileEnd extends Animation3D {

    public SmileEnd() {
        mAnimType = ANIMTYPE.ON;
    }

    public SmileEnd(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // smile end
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "SMILEEND"));
        playAnimationPart(mDuration);
        Animation3D.isSmileInAction = false;
        pauseAnimation(10);
    }
}
