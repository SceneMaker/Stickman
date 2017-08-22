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
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class NoNoNo extends AnimationStickman3D
{

    /**
     * @param sm       I((Stickman3D)agent)
     * @param duration Control the speed of the movement from one emotion state to
     *                 another emotion state.
     * @param block    block or not the others movements, when one movement is not
     *                 finished.
     */

    public NoNoNo()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public NoNoNo(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation()
    {
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", -100));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", -60));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", -50));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger4, "rotate", 135));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger3, "rotate", 135));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger1, "zrotate", 40));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger1, "rotate", 35));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "ANGRY"));
        playAnimationPart(500);

        pauseAnimation(200);

        for (int i = 0; i < 6; i++)
        {
            if (i == 0)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "zrotate", -30));
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "yrotate", 10));
                playAnimationPart(500);
            } else if (i == 5)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "zrotate", 30));
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "yrotate", -10));
                playAnimationPart(500);
            } else if (i % 2 == 1)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "zrotate", 60));
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "yrotate", -20));
                playAnimationPart(500);
            } else
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "zrotate", -60));
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "yrotate", 20));
                playAnimationPart(500);
            }

        }

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", 100));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", 60));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", 50));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger4, "rotate", -135));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger3, "rotate", -135));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger1, "zrotate", -40));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger1, "rotate", -35));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "ANGRYEND"));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);
    }
}
