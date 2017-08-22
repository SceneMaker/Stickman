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
 * @author Beka
 */
public class HeadRight extends AnimationStickman3D
{
    public HeadRight()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public HeadRight(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "yrotate", 30));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "LOOKRIGHT"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "LOOKRIGHT"));
        playAnimationPart(mDuration);

        pauseAnimation(1000);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "yrotate", -30));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "LOOKRIGHTEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "LOOKRIGHTEND"));
        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);
    }
}
