/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class ContemptStart extends AnimationSwing {

    public ContemptStart(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // Contempt start
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "CONTEMPT"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "CONTEMPT"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "CONTEMPT"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
