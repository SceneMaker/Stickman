/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class ContemptEnd extends AnimationSwing {

    public ContemptEnd(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // Contempt end
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "CONTEMPTEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "CONTEMPTEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "CONTEMPTEND"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
