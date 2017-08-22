/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the
 * angry state to the default state, and stays in the default state until it
 * receives a new command.
 *
 * @author Beka Aptsiauri
 */
public class AngryEnd extends AnimationStickman3D
{

    /**
     * @param sm       StickmanSwing
     * @param duration Control the speed of the movement from one emotion state
     *                 to another emotion state.
     * @param block    block or not the others movements, when one movement is not
     *                 finished.
     */
    public AngryEnd(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation()
    {
        // angry end
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mFaceWrinkle, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "ANGRYEND"));
        playAnimationPart(mDuration);
        AnimationStickman3D.isAngryInAction = false;
        pauseAnimation(10);

    }
}
