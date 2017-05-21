/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.head;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Blink extends AnimationSwing {

    public Blink(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "BLINK"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "BLINK"));
        playAnimationPart(20);

        pauseAnimation(300);

        // blink up
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "DEFAULT"));
        playAnimationPart(20);
    }
}
