/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.facefx;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContentFX;
import de.dfki.stickman3D.animationlogic.AnimationFX;

import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 */
public class AngryStart extends AnimationFX {

    public AngryStart(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // angry start
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRY"));
//        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFaceWrinkle, "shape", "ANGRY"));   ///Add by Robbie
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "ANGRY"));
        playAnimationPart(mDuration);
        pauseAnimation(10);
    }
}
