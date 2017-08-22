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
public class FadeOut extends AnimationStickman3D
{

    public FadeOut()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public FadeOut(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
        agent = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation()
    {

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mStars, "shape", "STARSFADEIN"));
        playAnimationPart(500);

        pauseAnimation(500);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mNose, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEar, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEar, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "shape", "FADEOUT"));
        if (((Stickman3D) agent).mType == Gender.TYPE.MALE)
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHair, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mNeck, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mUpperBody, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mDownBody, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger1, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger2, "shape", "FADEOUT"));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mStars, "shape", "STARSFADEOUT"));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger3, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger4, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger1, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger2, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger3, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger4, "shape", "FADEOUT"));
        if (((Stickman3D) agent).mType == Gender.TYPE.FEMALE)
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHair, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperLeg, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeLeg, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFoot, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperLeg, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeLeg, "shape", "FADEOUT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFoot, "shape", "FADEOUT"));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
