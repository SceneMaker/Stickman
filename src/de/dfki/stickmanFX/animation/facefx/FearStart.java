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
 * @author Patrick Gebhard
 */
public class FearStart extends AnimationStickman2D
{

    public FearStart()
    {
        super();
    }

    public FearStart(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // fear
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "shape", "FEAR"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyeFX, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "shape", "DISGUSTED"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyeFX, "shape", "SURPRISED"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "shape", "DISGUSTED"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
