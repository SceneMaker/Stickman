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
import javafx.application.Platform;
import javafx.scene.paint.Color;

/**
 *
 * @author Beka
 *
 */
public class BombeExplosion extends AnimationFX {

    public BombeExplosion(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    @Override
    public void playAnimation() {
        int translationUnit = 8;
        int rotationUnit = 10;

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mBombeFX, "shape", "BOMBETRANSITION"));
        playAnimationPart(mDuration);

        // headTilt
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "tilt", translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "tilt", translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "tilt", translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "tilt", translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "tilt", translationUnit));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "tilt", translationUnit));
        } else {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "tilt", translationUnit));
        }

        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "tilt", translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "tilt", translationUnit));

        // embarrassed
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "EMBARRASSED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "EMBARRASSED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "EMBARRASSED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "EMBARRASSED"));   ///Add by Robbie
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "EMBARRASSED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "EMBARRASSED"));
        playAnimationPart(mDuration);

        pauseAnimation(2000);

        //end HeadTilt
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "tilt", -translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "tilt", -translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "tilt", -translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "tilt", -translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "tilt", -translationUnit));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "tilt", -translationUnit));
        } else {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "tilt", -translationUnit));
        }

        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "tilt", -translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "tilt", -translationUnit));

        //change embarrassed with angry
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "SURPRISED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "SURPRISED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "SURPRISED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "SURPRISED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SURPRISED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "EMBARRASSEDEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "SURPRISED"));
        playAnimationPart(mDuration);

        pauseAnimation(1000);

        //Blink
        for (int i = 0; i < 3; i++) {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "SURPRISED"));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "SURPRISED"));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "BLINK"));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "BLINK"));
            playAnimationPart(100);

            pauseAnimation(300);

            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "SURPRISED"));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "SURPRISED"));
            playAnimationPart(100);

        }

        pauseAnimation(1500);

        // headTilt
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "tilt", translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "tilt", translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "tilt", translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "tilt", translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "tilt", translationUnit));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "tilt", translationUnit));
        } else {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "tilt", translationUnit));
        }

        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "tilt", translationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "tilt", translationUnit));
        // embarrassed
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "EMBARRASSED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "EMBARRASSED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "EMBARRASSED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFaceWrinkleFX, "shape", "EMBARRASSED"));   ///Add by Robbie
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "EMBARRASSED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "EMBARRASSED"));
        playAnimationPart(mDuration);

        //playAnimationPart(mDuration);
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", -rotationUnit * 5));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", rotationUnit * 2));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "rotate", rotationUnit * 3));
        playAnimationPart(mDuration);

        for (int i = 0; i < 3; i++) {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", -rotationUnit));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "rotate", -rotationUnit * 3));
            playAnimationPart(200);

            pauseAnimation(150);

            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", rotationUnit));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "rotate", rotationUnit * 3));
            playAnimationPart(200);
        }

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mBombeFX, "shape", "BOMBEEXPLOSION"));
        playAnimationPart(mDuration);

        //mStickman.mBodyFX.currentColor = Color.BLACK;
        Platform.runLater(() -> mStickmanFX.mBodyFX.paintFrontOrientation(Color.BLACK));
        mStickmanFX.mHeadFX.mColor = Color.BLACK;

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mBombeFX, "shape", "DEFAULT"));
        playAnimationPart(20);

        mStickmanFX.mLeftHandFX.setVisible(false);
        mStickmanFX.mLeftForeArmFX.setVisible(false);
        mStickmanFX.mLeftUpperArmFX.setVisible(false);

        mStickmanFX.mRightHandFX.setVisible(false);
        mStickmanFX.mRightForeArmFX.setVisible(false);
        mStickmanFX.mRightUpperArmFX.setVisible(false);

        mStickmanFX.mRightShoulderFX.setVisible(false);
        mStickmanFX.mLeftShoulderFX.setVisible(false);
        mStickmanFX.mNeckFX.setVisible(false);
        mStickmanFX.mLeftEyebrowFX.setVisible(false);
        mStickmanFX.mRightEyebrowFX.setVisible(false);
        mStickmanFX.mMouthFX.setVisible(false);
        mStickmanFX.mFaceWrinkleFX.setVisible(false);

        mAnimationPartFX = new ArrayList<>();
        mStickmanFX.mHeadFX.translateRight = true;
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "Translate", -2000));
        if (mStickmanFX.mType == Gender.TYPE.FEMALE) {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "Translate", -2000));
        } else {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "Translate", -2000));
        }
        mStickmanFX.mBodyFX.setVisible(false);
        playAnimationPart(mDuration);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "rotate", 90));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "translate", 100));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", 70));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "translate", 120));
        playAnimationPart(100);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "rotate", 90));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "translate", 155));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", 120));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "translate", 160));
        playAnimationPart(100);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "rotate", 90));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "rotate", 170));
        playAnimationPart(100);

        mStickmanFX.mLeftEyeFX.setVisible(false);
        mStickmanFX.mRightEyeFX.setVisible(false);

    }
}
