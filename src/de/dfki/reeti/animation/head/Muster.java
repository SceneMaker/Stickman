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
 * @author Beka Aptsiauri
 *
 */
public class Muster extends AnimationReeti {

    public Muster() {
        mAnimType = ANIMTYPE.ON;
    }

    public Muster(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        mReeti.mMouthFX.setUpRegulator(-20);
        mReeti.mMouthFX.setDownRegulator(-10);
//        mReeti.mMouthFX.setLeftCornerRegulator(-20);
        
        mAnimationPartFX = new ArrayList<>();
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mLeftEar, "rotate", 60));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEar, "yrotate", 60));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mMouthFX, "shape", "MOUTHACTION"));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEar, "yrotate", 60));
        playAnimationPart(mDuration);

        pauseAnimation(1000);

        mAnimationPartFX = new ArrayList<>();
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mLeftEar, "rotate", -60));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEar, "yrotate", -60));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mMouthFX, "shape", "MOUTHACTIONEND"));
        playAnimationPart(mDuration);

        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
