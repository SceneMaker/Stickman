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
public class Grimace extends AnimationReeti {

    public Grimace() {
        mAnimType = ANIMTYPE.ON;
    }

    public Grimace(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }


    @Override
    public void playAnimation() {
        mReeti.neckPan(25);
        mReeti.neckTilt(20);
        mReeti.leftEyePan(60);
        mReeti.leftEyeTilt(60);
        mReeti.rightEyePan(15);
        mReeti.rightEyeTilt(40);
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
