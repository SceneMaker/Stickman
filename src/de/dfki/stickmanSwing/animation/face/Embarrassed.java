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
public class Embarrassed extends AnimationSwing {

    public Embarrassed() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Embarrassed(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        // embarrassed
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mFaceWrinkle, "shape", "EMBARRASSED"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "EMBARRASSED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "EMBARRASSED"));
        playAnimationPart(mDuration);
//		playAnimationPart(20);

        pauseAnimation(1200);

        // no embarrassed
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "EMBARRASSEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "EMBARRASSEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "EMBARRASSEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mFaceWrinkle, "shape", "EMBARRASSEDEND"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "EMBARRASSEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "EMBARRASSEDEND"));
        playAnimationPart(20);
    }
}
