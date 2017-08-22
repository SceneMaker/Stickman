/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.facefx;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the
 * angry state to the default state, and stays in the default state until it
 * receives a new command.
 *
 * @author Beka Aptsiauri
 */
public class AngryEnd extends AnimationStickman2D
{

    public AngryEnd()
    {
        super();
    }

    public AngryEnd(StickmanFX sm, int duration, boolean block)
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
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyeFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "shape", "ANGRYEND"));
        //mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyeFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "shape", "ANGRYEND"));
        playAnimationPart(mDuration);
        pauseAnimation(10);

    }
}
