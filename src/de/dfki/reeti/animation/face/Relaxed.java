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
public class Relaxed extends AnimationReeti {

    public Relaxed() {
        mAnimType = ANIMTYPE.ON;
    }

    public Relaxed(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }


    @Override
    public void playAnimation() {
        mReeti.neckTilt(75);
        mReeti.leftEyeLid(25);
        mReeti.rightEyeLid(25);
        mReeti.leftEyeTilt(15);
        mReeti.rightEyeTilt(20);
        mReeti.setLedColor("green");
        mReeti.leftEar(0);
        mReeti.rightEar(0);
        mReeti.leftLC(75);
        mReeti.rightLC(60);
        mReeti.bottomLip(10);
        mReeti.topLip(3);


        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
