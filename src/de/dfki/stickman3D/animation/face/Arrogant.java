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
public class Arrogant extends AnimationStickman3D
{

    public Arrogant()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Arrogant(Stickman3D sm, int duration, boolean block)
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
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", -10));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "ANGRYSMALLMOUTH"));

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

        pauseAnimation(1000);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", 10));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "ANGRYSMALLMOUTHEND"));

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
