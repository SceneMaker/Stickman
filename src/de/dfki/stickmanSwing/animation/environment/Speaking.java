/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.environment;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import de.dfki.stickmanSwing.environment.SpeechBubble;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Speaking extends AnimationSwing {

    public Speaking(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        if (mParameter instanceof String) {
            mStickman.mSpeechBubble.mText = (String) mParameter;
        }

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mSpeechBubble, "shape", SpeechBubble.SHAPE.SPEAK.name()));
        playAnimationPart(mDuration);

        mAnimationPart.add(new AnimationContentSwing(mStickman.mSpeechBubble, "shape", SpeechBubble.SHAPE.DEFAULT.name()));
        playAnimationPart(20);

    }
}
