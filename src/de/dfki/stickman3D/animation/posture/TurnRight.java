/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.posture;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.enums.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

public class TurnRight extends AnimationStickman3D
{

    public TurnRight()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public TurnRight(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "yrotate", 20));
        playAnimationPart(100);

        if (((Stickman3D) agent).mType == Gender.TYPE.MALE)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", 40));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mUpperBody, "yrotate", 60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "yrotate", 20));
            playAnimationPart(500);
        } else
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", 70));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mUpperBody, "yrotate", 60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "yrotate", 20));
            playAnimationPart(500);
        }

        pauseAnimation(1000);

        if (((Stickman3D) agent).mType == Gender.TYPE.MALE)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", -40));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mUpperBody, "yrotate", -60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "yrotate", -40));
            playAnimationPart(500);
        } else
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", -70));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mUpperBody, "yrotate", -60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "yrotate", -40));
            playAnimationPart(500);
        }

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
