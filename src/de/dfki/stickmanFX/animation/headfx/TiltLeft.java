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
public class TiltLeft extends AnimationStickman2D
{

    public TiltLeft(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        int translationUnit = 8;

        // head down
        mAnimationPart = new ArrayList<>();
        // which bodyparts are involved - check dependencies
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyeFX, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyeFX, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mHeadFX, "tilt", translationUnit));

        if (((StickmanFX) agent).mType == Gender.TYPE.MALE)
        {
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMaleHairFX, "tilt", translationUnit));
        } else
        {
            mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mFemaleHairFX, "tilt", translationUnit));
        }

        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "tilt", translationUnit));

        playAnimationPart(200);
    }
}
