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
 * @author Beka
 */
public class Sad extends AnimationStickman2D
{

    public Sad()
    {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public Sad(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // sad
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "shape", "SAD"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "shape", "DISGUSTED"));  // add by Robbie
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "shape", "DISGUSTED")); // add by Robbie
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no sad
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "shape", "SADEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "shape", "DISGUSTEDEND"));  // add by Robbie
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "shape", "DISGUSTEDEND")); // add by Robbie
        playAnimationPart(20);
    }
}
