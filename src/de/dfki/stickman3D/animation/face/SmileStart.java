package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class SmileStart extends Animation3D {

    public SmileStart() {
        mAnimType = ANIMTYPE.ON;
    }

    public SmileStart(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // smile start
        Animation3D.isSmileInAction = true;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "SMILE"));
        playAnimationPart(mDuration);
        pauseAnimation(10);

    }
}
