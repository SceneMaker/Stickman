/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.enums.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class FadeIn extends AnimationStickman2D
{

    public FadeIn(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    // WaveLeft
    @Override
    public void playAnimation()
    {
//		star fade in
        ((StickmanFX) agent).starShowControler = true;
        ((StickmanFX) agent).starShowC = true;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mStarsFX, "shape", "STARSFADEIN"));
        playAnimationPart(1000);

//		character fade in
        ((StickmanFX) agent).starShowControler = false;
        ((StickmanFX) agent).setCharacterInvisible = true;
        ((StickmanFX) agent).fadeControler = false;

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mHeadFX, "shape", "DEFAULT"));

        if (((StickmanFX) agent).mType == Gender.TYPE.MALE)
        {
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMaleHairFX, "shape", "DEFAULT"));
        } else
        {
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mFemaleHairFX, "shape", "DEFAULT"));
        }

        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyeFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyeFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mNeckFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightShoulderFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftShoulderFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightUpperArmFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftUpperArmFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightForeArmFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightHandFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "shape", "DEFAULT"));
        //mAnimationPart.add(new AnimationContent(mStickman.mRightLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightUpperLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightForeLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightFootFX, "shape", "DEFAULT"));
        //mAnimationPart.add(new AnimationContent(mStickman.mLeftLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftUpperLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeLegFX, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftFootFX, "shape", "DEFAULT"));
        playAnimationPart(1000);
        ((StickmanFX) agent).setCharacterInvisible = false;

//		stars fade out
        ((StickmanFX) agent).starShowC = true;
        ((StickmanFX) agent).setCharacterInvisible = false;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mStarsFX, "shape", "STARSFADEOUT"));
        playAnimationPart(500);

        // bring upper arm and fore arm in position
        int rotationUnit = 10;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftUpperArmFX, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", rotationUnit * 16));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", rotationUnit * 16));
        playAnimationPart(200);
        pauseAnimation(100);

        // wave right
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", -rotationUnit * 4));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", rotationUnit * 4));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        // wave right
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", -rotationUnit * 4));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", rotationUnit * 4));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);
        pauseAnimation(200);

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftUpperArmFX, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", -rotationUnit * 16));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", -rotationUnit * 16));
        playAnimationPart(20);

        ((StickmanFX) agent).setCharacterInvisible = false;
        ((StickmanFX) agent).starShowControler = false;
        ((StickmanFX) agent).starShowC = false;

    }
}
