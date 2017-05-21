package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Excited extends AnimationSwing {

    public Excited() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Excited(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // excited
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "EXCITED"));
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no excited
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "EXCITEDEND"));

        playAnimationPart(20);
    }
}
