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
 * An angry facial movement is created in this class. The face moves from the
 * angry state to the default state, and stays in the default state until it
 * receives a new command.
 *
 * @author Beka Aptsiauri
 *
 */
public class AngryEnd extends AnimationFX {

    /**
     * @param sm StickmanSwing
     * @param duration Control the speed of the movement from one emotion state
     * to another emotion state.
     * @param block block or not the others movements, when one movement is not
     * finished.
     */
    public AngryEnd() {
        super();
    }

    public AngryEnd(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation() {
        // angry end
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRYEND"));
        //mAnimationPart.add(new AnimationContent3D(mStickman.mFaceWrinkle, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "ANGRYEND"));
        playAnimationPart(mDuration);
        pauseAnimation(10);

    }
}
