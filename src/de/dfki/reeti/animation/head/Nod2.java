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
 * @author Patrick Gebhard
 *
 */
////////////nod 3 time by Guo
public class Nod2 extends AnimationReeti {

    public Nod2() {
        mAnimType = ANIMTYPE.ON;
    }

    public Nod2(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContentReeti(mReeti.mHead, "rotate", 10));
                playAnimationPart(200);
            } else if (i == 5) {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContentReeti(mReeti.mHead, "rotate", -10));
                playAnimationPart(200);
            } else if (i % 2 == 1) {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContentReeti(mReeti.mHead, "rotate", -20));
                playAnimationPart(200);
            } else {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContentReeti(mReeti.mHead, "rotate", 20));
                playAnimationPart(200);
            }
        }

        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
