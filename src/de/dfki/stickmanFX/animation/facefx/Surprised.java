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
 * @author Beka
 *
 */
public class Surprised extends AnimationFX {

    public Surprised() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Surprised(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        // surprised
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SURPRISED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "SURPRISED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "SURPRISED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "SURPRISED"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "SURPRISED"));
        playAnimationPart(mDuration);
        pauseAnimation(1200);

        // no surprised
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SURPRISEDEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "SURPRISEDEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "SURPRISEDEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "SURPRISEDEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "SURPRISEDEND"));
        playAnimationPart(20);
    }
}
