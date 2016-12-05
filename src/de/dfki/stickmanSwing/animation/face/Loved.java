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
public class Loved extends AnimationSwing {

    public Loved() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Loved(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // loved
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "SMILE"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "LOVED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "LOVED"));
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no loved
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "SMILEEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "LOVEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "LOVEDEND"));
        playAnimationPart(20);
    }
}
