/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.headfx;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.enums.Gender;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class HeadShake extends AnimationStickman2D
{

    public HeadShake(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        int rotationUnit = 10;

        // Its action is strange for the first time!
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyeFX, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyeFX, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mHeadFX, "rotate", -rotationUnit));

        if (agent.mType == Gender.TYPE.MALE)
        {
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMaleHairFX, "rotate", -rotationUnit));
        } else
        {
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mFemaleHairFX, "rotate", -rotationUnit));
        }

        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "rotate", -rotationUnit));
        playAnimationPart(200);
        pauseAnimation(100);

        // shaking head 5 times from Robbie
        for (int i = 0; i < 3; i++)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyeFX, "rotate", rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "rotate", rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyeFX, "rotate", rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "rotate", rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mHeadFX, "rotate", rotationUnit * 2));

            if (agent.mType == Gender.TYPE.MALE)
            {
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMaleHairFX, "rotate", rotationUnit * 2));
            } else
            {
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mFemaleHairFX, "rotate", rotationUnit * 2));
            }

            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "rotate", rotationUnit * 2));
            playAnimationPart(200);
            pauseAnimation(100);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyeFX, "rotate", -rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "rotate", -rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyeFX, "rotate", -rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "rotate", -rotationUnit * 2));
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mHeadFX, "rotate", -rotationUnit * 2));

            if (agent.mType == Gender.TYPE.MALE)
            {
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMaleHairFX, "rotate", -rotationUnit * 2));
            } else
            {
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mFemaleHairFX, "rotate", -rotationUnit * 2));
            }

            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "rotate", -rotationUnit * 2));
            playAnimationPart(200);
            pauseAnimation(100);
        }

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyeFX, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyeFX, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mHeadFX, "rotate", rotationUnit));

        if (agent.mType == Gender.TYPE.MALE)
        {
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMaleHairFX, "rotate", rotationUnit));
        } else
        {
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mFemaleHairFX, "rotate", rotationUnit));
        }

        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "rotate", rotationUnit));

        playAnimationPart(200);
        pauseAnimation(100);

    }

}
