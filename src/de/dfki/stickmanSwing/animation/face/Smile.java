package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Smile extends AnimationSwing {

    public Smile() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Smile(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // smile
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "SMILE"));
//		playAnimationPart(20);
        playAnimationPart(mDuration);
        pauseAnimation(1200);

        // no smile
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "SMILEEND"));

        playAnimationPart(20);
    }
}
