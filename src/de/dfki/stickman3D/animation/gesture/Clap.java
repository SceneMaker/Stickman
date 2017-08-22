/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class Clap extends AnimationStickman3D
{

    public Clap()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Clap(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "rotate", -30));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", -30));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", -70));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", -90));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "yrotate", -120));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", -10));
        playAnimationPart(500);

        for (int i = 0; i < 10; i++)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", 10));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", -15));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", 17));
            playAnimationPart(200);

            pauseAnimation(100);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", -10));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", 15));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", -17));
            playAnimationPart(200);
        }

        pauseAnimation(1000);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "rotate", 30));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", 30));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", 70));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", 90));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "yrotate", 120));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", 10));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);

    }

}
