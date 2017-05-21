package de.dfki.stickmanFX.animation.facefx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;
import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class Excited extends AnimationFX {

    public Excited() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Excited(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // excited
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "EXCITED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "EXCITED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "EXCITED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "EXCITED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "EXCITED"));
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no excited
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "EXCITEDEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "EXCITEDEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "EXCITEDEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "EXCITEDEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "EXCITEDEND"));
        playAnimationPart(20);
    }
}
