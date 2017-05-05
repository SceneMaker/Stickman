/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.face;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationReeti;

/**
 *
 * @author Beka
 *
 */
public class Sad2 extends AnimationReeti {

    public Sad2() {
        mAnimType = ANIMTYPE.ON;
    }

    public Sad2(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        mReeti.leftEyeLid(45);
        mReeti.rightEyeLid(45);
        mReeti.leftEyeTilt(55);
        mReeti.leftEyePan(25);
        mReeti.rightEyeTilt(55);
        mReeti.rightEyePan(75);
        mReeti.leftEar(0);
        mReeti.rightEar(0);
        mReeti.rightLC(0);
        mReeti.leftLC(0);

        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
