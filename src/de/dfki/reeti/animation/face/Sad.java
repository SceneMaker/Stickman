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
public class Sad extends AnimationReeti {

    public Sad() {
        mAnimType = ANIMTYPE.ON;
    }

    public Sad(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        mReeti.leftEyeLid(60);
        mReeti.rightEyeLid(60);
        mReeti.leftEyeTilt(15);
        mReeti.rightEyeTilt(15);
        mReeti.setLedColor("violet");
        mReeti.leftEar(0);
        mReeti.rightEar(0);
        mReeti.rightLC(0);
        mReeti.leftLC(0);
        mReeti.neckTilt(0);


        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
