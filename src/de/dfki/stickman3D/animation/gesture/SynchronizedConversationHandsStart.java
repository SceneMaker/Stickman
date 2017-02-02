/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Beka
 *
 */
public class SynchronizedConversationHandsStart extends AbstractConversationHands {

    private  static   boolean movementStarted = false;


    public SynchronizedConversationHandsStart(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
        intensity = 10;
    }
    public SynchronizedConversationHandsStart(Stickman3D sm, int duration, boolean block, HashMap<String, String> extraParams) {
        super(sm, duration, block, extraParams);
    }

    @Override
    public void playAnimation() {
        if(!movementStarted) {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "rotate", -38));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "yrotate", 13));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "zrotate", -18));

            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "rotate", -76));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "yrotate", 35));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "zrotate", START_LEFT_FORE_ARM_POSITION));

            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "rotate", 0));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", -54));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "zrotate", 7));



            //Right Part
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", -56));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "yrotate", 28));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "zrotate", 27));

            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", -19));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "yrotate", 27));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "zrotate", START_RIGHT_FORE_ARM_POSITION));

            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", -8));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", 34));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "zrotate", 0));
            playAnimationPart(200);
            pauseAnimation(mDuration);
            movementStarted = true;
        }

        mAnimationPartFX = new ArrayList<>();
        moveConversationHands();
        playAnimationPart(200);
    }


    protected int getLeftArmMovement(){
        int leftForeArmZ;
        leftForeArmZ = START_LEFT_FORE_ARM_POSITION - getMovementDistance();
        return leftForeArmZ;
    }

    protected int getRightArmMovement(){
        int rightForeArmZ;
        rightForeArmZ = START_RIGHT_FORE_ARM_POSITION + getMovementDistance();
        return rightForeArmZ *-1;
    }


}
