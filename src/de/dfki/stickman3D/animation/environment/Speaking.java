/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.environment.SpeechBubble3D;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Speaking extends Animation3D {

    public Speaking() {
        mAnimType = ANIMTYPE.ON;
    }

    public Speaking(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        if (mParameter instanceof String) {
            mStickmanFX.mSpeechBubble.mText = (String) mParameter;
        }

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mSpeechBubble, "shape", SpeechBubble3D.SHAPE.SPEAK.name()));
        playAnimationPart(mDuration);

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mSpeechBubble, "shape", SpeechBubble3D.SHAPE.DEFAULT.name()));
        playAnimationPart(20);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }

    }
}
