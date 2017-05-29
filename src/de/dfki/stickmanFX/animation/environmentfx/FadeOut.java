/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import java.util.ArrayList;

import de.dfki.common.Gender;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;

/**
 *
 * @author Beka
 *
 */
public class FadeOut extends AnimationFX {

    private StickmanFX mStickmanFX;

    public FadeOut(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation() {
        // bring upper arm and fore arm in position
        int rotationUnit = 10;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 16));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 16));
        playAnimationPart(200);
        pauseAnimation(100);

        // wave right
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 4));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 4));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        // wave right
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 4));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 4));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        // star fade in
        mStickmanFX.starShowC = true;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mStarsFX, "shape", "STARSFADEIN"));
        playAnimationPart(200);

        // make body fade out
        mStickmanFX.setCharacterInvisible = true;
        mStickmanFX.fadeControler = true;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "shape", "DEFAULT"));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "shape", "DEFAULT"));
        } else {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "shape", "DEFAULT"));
        }

        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mNeckFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightShoulderFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftShoulderFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightHandFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "shape", "DEFAULT"));
//		mAnimationPart.add(new AnimationContent3D(mStickman.mRightLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFootFX, "shape", "DEFAULT"));
        //mAnimationPart.add(new AnimationContent3D(mStickman.mLeftLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "shape", "DEFAULT"));
        //Platform.runLater(() -> mStickman.mBodyFX.update());
        playAnimationPart(1000);

        // stars fade out
        mStickmanFX.starShowControler = true;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mStarsFX, "shape", "STARSFADEOUT"));
        playAnimationPart(1000);

        // arm go back in the default position
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 16));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 16));
        playAnimationPart(2);

        // mStickman.setCharacterInvisible = false;
        mStickmanFX.starShowControler = false;
        mStickmanFX.starShowC = false;
    }
}
