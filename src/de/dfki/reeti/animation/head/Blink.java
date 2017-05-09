/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.head;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;

import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Blink extends AnimationReeti {

    public Blink() {
        mAnimType = ANIMTYPE.ON;
    }

    public Blink(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentReeti(mReeti.mLeftEyelid, "rotate", 100));
        mAnimationPart.add(new AnimationContentReeti(mReeti.mRightEyelid, "rotate", 100));
//        mAnimationPart.add(new AnimationContentReeti(mReeti.mRightEyeFX, "shape", "BLINK"));
        playAnimationPart(500);

        pauseAnimation(300);

        //blink up
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentReeti(mReeti.mLeftEyelid, "rotate", -100));
        mAnimationPart.add(new AnimationContentReeti(mReeti.mRightEyelid, "rotate", -100));
//        mAnimationPart.add(new AnimationContentReeti(mReeti.mRightEyeFX, "shape", "BLINKEND"));
        playAnimationPart(500);

        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
