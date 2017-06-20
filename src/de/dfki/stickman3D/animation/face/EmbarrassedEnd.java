/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class EmbarrassedEnd extends Animation3D {

    public EmbarrassedEnd(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        // no embarrassed
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "EMBARRASSEDEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "EMBARRASSEDEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyebrow, "shape", "EMBARRASSEDEND"));
//        mAnimationPart.add(new AnimationContent3D(mStickman.mFaceWrinkle, "shape", "EMBARRASSEDEND"));   ///Add by Robbie
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "EMBARRASSEDEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyebrow, "shape", "EMBARRASSEDEND"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
