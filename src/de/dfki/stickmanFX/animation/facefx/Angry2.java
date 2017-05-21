/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.facefx;

import de.dfki.common.Gender;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;
import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Angry2 extends AnimationFX {

    StickmanFX mStickmanFX;
    int rotationUnit;

    public Angry2() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    /**
     *
     * @param sm StickmanSwing
     * @param duration Control the speed of the movement from one emotion state
     * to another emotion state.
     * @param block block or not the others movements, when one movement is not
     * finished.
     */
    public Angry2(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation() {
        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            rotationUnit = 20;
        } else {
            rotationUnit = 30;
        }
        // angry
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "ANGRY"));   ///Add by Robbie
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRY"));

        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -(rotationUnit + 3)));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit));
        } else {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit - 20));
        }

        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit));

        playAnimationPart(mDuration);

        //foot
        for (int i = 0; i < 8; i++) {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFootFX, "rotate", 40));
            playAnimationPart(200);

            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFootFX, "rotate", -40));
            playAnimationPart(100);
        }

        pauseAnimation(1200);

        // no angry
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "ANGRYEND"));   ///Add by Robbie
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));

        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit + 3));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit));
        } else {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -(rotationUnit - 20)));
        }

        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit));

        playAnimationPart(20);
    }
}
