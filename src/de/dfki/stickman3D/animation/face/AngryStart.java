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
 * @author Beka Aptsiauri
 */
public class AngryStart extends Animation3D {

    public AngryStart(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // angry start
        Animation3D.isAngryInAction = true;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mFaceWrinkle, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyebrow, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyebrow, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "ANGRY"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
