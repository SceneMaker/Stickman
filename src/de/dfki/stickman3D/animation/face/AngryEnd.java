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
 * An angry facial movement is created in this class. The face moves from the
 * angry state to the default state, and stays in the default state until it
 * receives a new command.
 *
 * @author Beka Aptsiauri
 *
 */
public class AngryEnd extends Animation3D {

    /**
     * @param sm StickmanSwing
     * @param duration Control the speed of the movement from one emotion state
     * to another emotion state.
     * @param block block or not the others movements, when one movement is not
     * finished.
     */
    public AngryEnd(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation() {
        // angry end
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mFaceWrinkle, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyebrow, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyebrow, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "ANGRYEND"));
        playAnimationPart(mDuration);
        Animation3D.isAngryInAction = false;
        pauseAnimation(10);

    }
}
