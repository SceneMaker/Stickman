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
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Angry extends AnimationStickman2D
{

    /**
     * @param sm       StickmanSwing
     * @param duration Control the speed of the movement from one emotion state
     *                 to another emotion state.
     * @param block    block or not the others movements, when one movement is not
     *                 finished.
     */
    public Angry()
    {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Angry(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation()
    {
        // angry
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyeFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mFaceWrinkleFX, "shape", "ANGRY"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyeFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "shape", "ANGRY"));
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no angry
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyeFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mFaceWrinkleFX, "shape", "ANGRYEND"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyeFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "shape", "ANGRYEND"));
        playAnimationPart(20);
    }
}
