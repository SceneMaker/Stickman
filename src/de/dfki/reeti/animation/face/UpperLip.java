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
public class UpperLip extends AnimationReeti {

    public UpperLip() {
        mAnimType = ANIMTYPE.ON;
    }

    public UpperLip(Reeti sm, int duration, int pos, boolean block) {
        super(sm, duration, pos, block);
    }

    @Override
    public void playAnimation() {
        
        
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mMouthUpperLip, "shape", "UPPERLIPACTION"));
        playAnimationPart(mDuration);
        
        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
