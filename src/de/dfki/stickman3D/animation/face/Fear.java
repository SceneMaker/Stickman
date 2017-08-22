/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.common.enums.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class Fear extends AnimationStickman3D
{

    public Fear()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Fear(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // fear
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "FEAR"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "SAD"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "SAD"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", 10));

        if (((Stickman3D) agent).mType == Gender.TYPE.MALE)
        {
            // Left Hand
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "rotate", -60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "zrotate", -70));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", -100));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", -30));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "yrotate", -130));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "rotate", 20));

            // Right Hand
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", -60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "zrotate", 70));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", -95));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", 30));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", 130));

        } else
        {
            // Left Hand
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "rotate", -55));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "zrotate", -60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", -105));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", -25));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "yrotate", -200));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "rotate", 20));

            // Right Hand
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", -60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "zrotate", 60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", -100));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", 25));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", 200));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", 20));
        }
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no fear
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "FEAREND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "SADEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "SADEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", -10));

        if (((Stickman3D) agent).mType == Gender.TYPE.MALE)
        {
            // Left Hand
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "rotate", 60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "zrotate", 70));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", 100));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", 30));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "yrotate", 130));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "rotate", -20));

            // Right Hand
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", 60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "zrotate", -70));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", 95));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", -30));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", -130));
        } else
        {
            // Left Hand
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "rotate", 55));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "zrotate", 60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", 105));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", 25));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "yrotate", 200));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "rotate", -20));

            // Right Hand
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", 60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "zrotate", -60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", 100));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", -25));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", -200));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", -20));

        }
        playAnimationPart(mDuration);

        // pauseAnimation(1200);
        // mAnimationPart = new ArrayList<>();
        // mAnimationPart.add(new AnimationContent(mStickman.mHead,
        // "yrotate", -90));
        // mAnimationPart.add(new AnimationContent(mStickman.mUpperBody,
        // "yrotate", -90));
        // playAnimationPart(500);
        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
