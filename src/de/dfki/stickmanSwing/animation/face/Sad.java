/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Sad extends AnimationSwing {

    public Sad() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Sad(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // sad
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "SAD"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "DISGUSTED"));  // add by Robbie
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "DISGUSTED")); // add by Robbie
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no sad
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "SADEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "DISGUSTEDEND"));  // add by Robbie
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "DISGUSTEDEND")); // add by Robbie
        playAnimationPart(20);
    }
}
