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
public class OneTwoThree extends AnimationStickman3D
{

    public OneTwoThree()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public OneTwoThree(Stickman3D sm, int duration, boolean block)
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
        // LeftHand Up
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", -30));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", 23));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "yrotate", -105));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger4, "rotate", 130));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger3, "rotate", 130));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger1, "zrotate", 20));

        // RightHand Up
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", -58));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", -5));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", 10));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "rotate", -10));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", 25));
        playAnimationPart(500);

        // One
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", -3));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", 30));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger4, "rotate", 130));
        playAnimationPart(500);
        pauseAnimation(500);
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", 3));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", -30));
        playAnimationPart(500);

        pauseAnimation(200);

        // Two
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", -7));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", 30));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger3, "rotate", 130));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "LOOKUP"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "LOOKUP"));
        playAnimationPart(500);
        pauseAnimation(500);
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", 7));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", -30));
        playAnimationPart(500);

        pauseAnimation(200);

        // Three
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", -10));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", 30));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger2, "rotate", 130));
        playAnimationPart(500);
        pauseAnimation(500);
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", 10));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", -30));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "LOOKUPEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "LOOKUPEND"));
        playAnimationPart(500);

        pauseAnimation(500);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger4, "rotate", -130));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger3, "rotate", -130));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger2, "rotate", -130));
        // LeftHand Down
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", 30));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", -23));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "yrotate", 105));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger4, "rotate", -130));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger3, "rotate", -130));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger1, "zrotate", -20));
        // RightHand Down
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", 60));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", 5));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", -10));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "rotate", 10));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", -25));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);
    }
}
