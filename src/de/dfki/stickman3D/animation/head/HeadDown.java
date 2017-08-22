/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.head;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class HeadDown extends AnimationStickman3D
{

    public HeadDown()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public HeadDown(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", 15));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperLeg, "rotate", 30));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFoot, "yrotate", 20));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "LOOKDOWN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "LOOKDOWN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeLeg, "rotate", 20));
        playAnimationPart(mDuration);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperLeg, "rotate", -35));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeLeg, "rotate", -25));
        playAnimationPart(mDuration);

        pauseAnimation(500);

        // blink up
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", -15));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperLeg, "rotate", 5));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFoot, "yrotate", -20));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "LOOKDOWNEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "LOOKDOWNEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeLeg, "rotate", 5));
        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);
    }
}
