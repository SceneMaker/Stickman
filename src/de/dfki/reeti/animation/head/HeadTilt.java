/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.head;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.animationlogic.AnimationContentReeti;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class HeadTilt extends AnimationReeti {

    public HeadTilt() {
        mAnimType = ANIMTYPE.ON;
    }

    public HeadTilt(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentReeti(mReeti.mHead, "zrotate", -10));
        playAnimationPart(200);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentReeti(mReeti.mHead, "zrotate", 10));
        playAnimationPart(200);

        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }

    }
}
