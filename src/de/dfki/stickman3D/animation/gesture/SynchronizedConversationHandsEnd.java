/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import de.dfki.stickman3D.Stickman3D;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Beka
 *
 */
public class SynchronizedConversationHandsEnd extends AbstractConversationHands {


    public SynchronizedConversationHandsEnd() {
        mAnimType = ANIMTYPE.ON;
    }

    public SynchronizedConversationHandsEnd(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
        intensity = 10;
    }
    public SynchronizedConversationHandsEnd(Stickman3D sm, int duration, boolean block,  HashMap<String, String> extraParams) {
        super(sm, duration, block, extraParams);

    }

    @Override
    public void playAnimation() {
        mAnimationPartFX = new ArrayList<>();
        moveConversationHands();
        playAnimationPart(200);
    }

    protected int getLeftArmMovement(){
        int leftForeArmZ = 0;
        leftForeArmZ = START_LEFT_FORE_ARM_POSITION - getMovementDistance();
        return leftForeArmZ * -1;
    }

    protected int getRightArmMovement(){
        int rightForeArmZ = 0;
        rightForeArmZ = START_RIGHT_FORE_ARM_POSITION + getMovementDistance();
        return rightForeArmZ ;
    }

}
