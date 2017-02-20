/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.face;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class SadStart extends AnimationReeti {

    public SadStart(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // sad
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mMouth, "shape", "SAD"));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mLeftEyelid, "shape", "DISGUSTED"));  // add by Robbie
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEyelid, "shape", "DISGUSTED")); // add by Robbie
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
