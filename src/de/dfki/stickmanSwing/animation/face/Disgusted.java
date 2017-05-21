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
public class Disgusted extends AnimationSwing {

    public Disgusted() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Disgusted(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // disgusted
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "DISGUSTED"));
//		playAnimationPart(20);
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no disgusted
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "DISGUSTEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "DISGUSTEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "DISGUSTEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "DISGUSTEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "DISGUSTEDEND"));
        playAnimationPart(20);
    }
}
