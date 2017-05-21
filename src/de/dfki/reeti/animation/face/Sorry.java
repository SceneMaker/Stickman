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
public class Sorry extends AnimationReeti {

    public Sorry() {
        mAnimType = ANIMTYPE.ON;
    }

    public Sorry(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        mReeti.neckPan(20);
        mReeti.neckTilt(30);
        mReeti.leftEyeLid(30);
        mReeti.rightEyeLid(30);
        mReeti.leftEyeTilt(20);
        mReeti.rightEyeTilt(20);
        mReeti.setLedColor("lightGreen");
        mReeti.leftEar(20);
        mReeti.rightEar(30);
        mReeti.rightLC(10);
        mReeti.leftLC(10);



        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
