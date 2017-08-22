/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.enums.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class FadeIn extends AnimationStickman3D
{

    public FadeIn()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public FadeIn(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
        agent = sm;
    }

    @Override
    public void playAnimation()
    {

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mStars, "shape", "STARSFADEIN"));
        playAnimationPart(500);

        pauseAnimation(500);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mNose, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEar, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEar, "shape", "FADEIN"));
        if (((Stickman3D) agent).mType == Gender.TYPE.MALE)
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHair, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mNeck, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mUpperBody, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mDownBody, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "shape", "FADEIN"));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mStars, "shape", "STARSFADEOUT"));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger1, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger2, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger3, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger4, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger1, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger2, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger3, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger4, "shape", "FADEIN"));
        if (((Stickman3D) agent).mType == Gender.TYPE.FEMALE)
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHair, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperLeg, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeLeg, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFoot, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperLeg, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeLeg, "shape", "FADEIN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFoot, "shape", "FADEIN"));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
