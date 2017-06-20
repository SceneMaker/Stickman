/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class EmbarrassedStart extends Animation3D {

    public EmbarrassedStart(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        // embarrassed
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "EMBARRASSED"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "EMBARRASSED"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyebrow, "shape", "EMBARRASSED"));
        //mAnimationPart.add(new AnimationContent3D(mStickman.mFaceWrinkle, "shape", "EMBARRASSED"));   ///Add by Robbie
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "EMBARRASSED"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyebrow, "shape", "EMBARRASSED"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
