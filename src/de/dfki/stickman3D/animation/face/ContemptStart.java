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
 *
 */
public class ContemptStart extends Animation3D {

    public ContemptStart(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // Contempt start
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "CONTEMPT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "CONTEMPT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "CONTEMPT"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
