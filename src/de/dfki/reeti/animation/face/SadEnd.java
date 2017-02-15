/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.face;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.animationlogic.AnimationContentReeti;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class SadEnd extends AnimationReeti {

    public SadEnd(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // no sad
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mMouthFX, "shape", "SADEND"));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mLeftEyebrowFX, "shape", "DISGUSTEDEND"));  // add by Robbie
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEyebrowFX, "shape", "DISGUSTEDEND")); // add by Robbie
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
