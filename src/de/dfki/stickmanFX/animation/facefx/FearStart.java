/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.facefx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class FearStart extends AnimationFX {

    public FearStart() {
        super();
    }

    public FearStart(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // fear
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "FEAR"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "SURPRISED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "DISGUSTED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "SURPRISED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "DISGUSTED"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
