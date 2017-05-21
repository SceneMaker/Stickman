/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import java.util.ArrayList;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;
import de.dfki.stickmanFX.environmentfx.SpeechBubbleFX;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Speaking extends AnimationFX {

    public Speaking(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        if (mParameter instanceof String) {
            mStickmanFX.mSpeechBubbleFX.mText = (String) mParameter;
        }

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mSpeechBubbleFX, "shape", SpeechBubbleFX.SHAPE.SPEAK.name()));
        playAnimationPart(mDuration);

        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mSpeechBubbleFX, "shape", SpeechBubbleFX.SHAPE.DEFAULT.name()));
        playAnimationPart(20);

    }
}
