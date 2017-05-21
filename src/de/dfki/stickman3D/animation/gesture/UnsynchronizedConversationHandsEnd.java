/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class UnsynchronizedConversationHandsEnd extends AbstractConversationHands {



    public UnsynchronizedConversationHandsEnd(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
        intensity = 10;
    }
    public UnsynchronizedConversationHandsEnd(Stickman3D sm, int duration, boolean block, int intensity) {
        super(sm, duration, block);
        this.intensity = intensity;
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
        return rightForeArmZ * -1;
    }

}
