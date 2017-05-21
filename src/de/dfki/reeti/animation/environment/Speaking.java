/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.environment;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.environment.SpeechBubbleFX;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Speaking extends AnimationReeti {

    public Speaking() {
        mAnimType = ANIMTYPE.ON;
    }

    public Speaking(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        if (mParameter instanceof String) {
            mReeti.mSpeechBubble.mText = (String) mParameter;
//            mReeti.mSpeechBubble.mText = "dadasdsad ";
        }

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentReeti(mReeti.mSpeechBubble, "shape", SpeechBubbleFX.SHAPE.SPEAK.name()));
        playAnimationPart(mDuration);

        mAnimationPart.add(new AnimationContentReeti(mReeti.mSpeechBubble, "shape", SpeechBubbleFX.SHAPE.DEFAULT.name()));
        playAnimationPart(20);

        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }

    }
}
