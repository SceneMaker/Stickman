/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Beka
 */
public class SynchronizedConversationHandsStart extends AbstractConversationHands
{

    private static boolean movementStarted = false;


    public SynchronizedConversationHandsStart(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
        intensity = 10;
    }

    public SynchronizedConversationHandsStart(Stickman3D sm, int duration, boolean block, HashMap<String, String> extraParams)
    {
        super(sm, duration, block, extraParams);
    }

    @Override
    public void playAnimation()
    {
        if (!movementStarted)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "rotate", -38));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "yrotate", 13));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "zrotate", -18));

            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", -76));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "yrotate", 35));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", START_LEFT_FORE_ARM_POSITION));

            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "rotate", 0));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "yrotate", -54));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "zrotate", 7));


            //Right Part
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", -56));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "yrotate", 28));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "zrotate", 27));

            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", -19));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "yrotate", 27));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", START_RIGHT_FORE_ARM_POSITION));

            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "rotate", -8));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "yrotate", 34));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightWrist, "zrotate", 0));
            playAnimationPart(200);
            pauseAnimation(mDuration);
            movementStarted = true;
        }

        mAnimationPart = new ArrayList<>();
        moveConversationHands();
        playAnimationPart(200);
    }


    protected int getLeftArmMovement()
    {
        int leftForeArmZ;
        leftForeArmZ = START_LEFT_FORE_ARM_POSITION - getMovementDistance();
        return leftForeArmZ;
    }

    protected int getRightArmMovement()
    {
        int rightForeArmZ;
        rightForeArmZ = START_RIGHT_FORE_ARM_POSITION + getMovementDistance();
        return rightForeArmZ * -1;
    }


}
