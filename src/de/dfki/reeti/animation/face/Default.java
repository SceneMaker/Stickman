/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.face;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.animationlogic.AnimationContentReeti;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author Beka
 *
 */
public class Default extends AnimationReeti {

    public Default() {
        mAnimType = ANIMTYPE.ON;
    }

    public Default(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        mReeti.neckRotat(50);
        mReeti.neckPan(50);
        mReeti.neckTilt(50);
        mReeti.rightLC(50);        
        mReeti.leftLC(50);
        mReeti.topLip(0); 
        mReeti.bottomLip(100);
        mReeti.rightEyePan(30);
        mReeti.rightEyeTilt(60);
        mReeti.leftEyePan(30);
        mReeti.leftEyeTilt(40);
        mReeti.leftEyeLid(100);
        mReeti.rightEyeLid(100);
        mReeti.rightEar(50);
        mReeti.leftEar(50);
        mReeti.setLedColor("stop");
        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
