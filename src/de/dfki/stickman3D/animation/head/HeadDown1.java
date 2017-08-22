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
public class HeadDown1 extends AnimationStickman3D
{

    public HeadDown1()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public HeadDown1(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", 15));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "LOOKDOWN"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "LOOKDOWN"));
        playAnimationPart(mDuration);

        pauseAnimation(1000);

        // blink up
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", -15));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "LOOKDOWNEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "LOOKDOWNEND"));
        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);
    }
}
