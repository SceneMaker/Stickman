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
        // sad
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mMouthFX, "shape", "SAD"));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mLeftEyebrowFX, "shape", "SAD"));  // add by Robbie
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEyebrowFX, "shape", "SAD")); // add by Robbie
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no sad
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mMouthFX, "shape", "SADEND"));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mLeftEyebrowFX, "shape", "SADEND"));  // add by Robbie
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEyebrowFX, "shape", "SADEND")); // add by Robbie
        playAnimationPart(mDuration);

        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
