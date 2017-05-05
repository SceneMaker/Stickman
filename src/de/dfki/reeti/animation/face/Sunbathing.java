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
public class Sunbathing extends AnimationReeti {

    public Sunbathing() {
        mAnimType = ANIMTYPE.ON;
    }

    public Sunbathing(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        mReeti.leftEyeLid(0);
        mReeti.rightEyeLid(0);
        mReeti.setLedColor("red");
        mReeti.leftEar(0);
        mReeti.rightEar(0);
        mReeti.rightLC(40);
        mReeti.leftLC(80);
        mReeti.neckTilt(85);
        mReeti.topLip(20);
        mReeti.bottomLip(50);


        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
