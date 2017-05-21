package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;

import java.util.ArrayList;

/**
 *
 * @author Robbie
 *
 */
public class Happy extends AnimationSwing {

    public Happy() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Happy(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // happy
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "HAPPY"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "HAPPY"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "HAPPY"));
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no happy
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "HAPPYEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "HAPPYEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "HAPPYEND"));

        playAnimationPart(20);
    }
}
