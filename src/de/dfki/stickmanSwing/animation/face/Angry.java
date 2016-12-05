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
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Patrick Gebhard
 */
public class Angry extends AnimationSwing {

    /**
     *
     * @param sm StickmanSwing
     * @param duration Control the speed of the movement from one emotion state
     * to another emotion state.
     * @param block block or not the others movements, when one movement is not
     * finished.
     *
     */
    public Angry() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Angry(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation() {
        // angry
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mFaceWrinkle, "shape", "ANGRY"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "ANGRY"));
//		playAnimationPart(20);
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no angry
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mFaceWrinkle, "shape", "ANGRYEND"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "ANGRYEND"));
        playAnimationPart(20);
    }
}
