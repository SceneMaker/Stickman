/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.enums.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class TouchHead extends AnimationStickman3D
{

    public TouchHead()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public TouchHead(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {

        if (((Stickman3D) agent).mType == Gender.TYPE.MALE)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", -100));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "zrotate", 100));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", -82));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", 130));
            playAnimationPart(500);
        } else
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", -100));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "zrotate", 50));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", -82));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", 170));
            playAnimationPart(500);
        }

        for (int i = 0; i < 4; i++)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", -5));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger4, "rotate", 40));
            playAnimationPart(100);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", -5));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger3, "rotate", 70));
            playAnimationPart(100);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", -5));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger2, "rotate", 70));
            playAnimationPart(100);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", 5));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger3, "rotate", -70));
            playAnimationPart(100);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", 5));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger2, "rotate", -70));
            playAnimationPart(100);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", 5));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger4, "rotate", -40));
            playAnimationPart(100);
        }

        if (((Stickman3D) agent).mType == Gender.TYPE.MALE)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", 100));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "zrotate", -100));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", 82));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", -130));
            playAnimationPart(500);
        } else
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", 100));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "zrotate", -50));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", 82));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", -170));
            playAnimationPart(500);
        }

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);
    }
}
