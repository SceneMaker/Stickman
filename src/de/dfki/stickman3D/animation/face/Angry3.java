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
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Angry3 extends AnimationStickman3D
{

    int rotationUnit;

    public Angry3()
    {
        mAnimType = ANIMTYPE.ON;
    }

    /**
     * @param sm       IAgent
     * @param duration Control the speed of the movement from one emotion state
     *                 to another emotion state.
     * @param block    block or not the others movements, when one movement is not
     *                 finished.
     */
    public Angry3(Stickman3D sm, int duration, boolean block)
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
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mFaceWrinkle, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "ANGRY"));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "rotate", -45));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "zrotate", -10));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", -20));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "yrotate", -25));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", 110));

        if (((Stickman3D) agent).mType == Gender.TYPE.FEMALE)
        {
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger1, "zrotate", -20));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger2, "rotate", 90));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger3, "rotate", 90));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger4, "rotate", 90));
        } else
        {
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "rotate", -20));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger1, "zrotate", -20));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger2, "rotate", 70));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger3, "rotate", 70));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger4, "rotate", 70));

        }

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", -40));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "zrotate", 10));

        if (((Stickman3D) agent).mType == Gender.TYPE.FEMALE)
        {
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "yrotate", 13));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", -120));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", -70));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", -20));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "zrotate", 10));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger2, "rotate", 120));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger3, "rotate", 120));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger4, "rotate", 120));
        } else
        {
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "yrotate", 10));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", -120));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", -60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", -30));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "zrotate", 20));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger2, "rotate", 50));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger3, "rotate", 50));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger4, "rotate", 50));
        }

        playAnimationPart(500);

        // foot
        for (int i = 0; i < 8; i++)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFoot, "rotate", 40));
            playAnimationPart(200);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFoot, "rotate", -40));
            playAnimationPart(200);
        }

        // Head3D
        for (int i = 0; i < 7; i++)
        {
            mAnimationPart = new ArrayList<>();
            if (i == 0 || i == 6)
            {
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "yrotate", -10));
            } else if (i % 2 == 1)
            {
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "yrotate", 20));
            } else if (i % 2 == 0)
            {
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "yrotate", -20));
            }
            playAnimationPart(200);
        }

        pauseAnimation(1000);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mFaceWrinkle, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "ANGRYEND"));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "rotate", 45));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "zrotate", 10));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", 20));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "yrotate", 25));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", -110));

        if (((Stickman3D) agent).mType == Gender.TYPE.FEMALE)
        {
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger1, "zrotate", 20));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger2, "rotate", -90));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger3, "rotate", -90));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger4, "rotate", -90));
        } else
        {
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "rotate", 20));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger1, "zrotate", 20));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger2, "rotate", -70));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger3, "rotate", -70));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger4, "rotate", -70));
        }

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", 40));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "zrotate", -10));

        if (((Stickman3D) agent).mType == Gender.TYPE.FEMALE)
        {
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "yrotate", -13));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", 120));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", 70));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", 20));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "zrotate", -10));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger2, "rotate", -120));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger3, "rotate", -120));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger4, "rotate", -120));
        } else
        {
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "yrotate", -10));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", 120));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", 60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", 30));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "zrotate", -20));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger2, "rotate", -50));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger3, "rotate", -50));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightFinger4, "rotate", -50));
        }

        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
