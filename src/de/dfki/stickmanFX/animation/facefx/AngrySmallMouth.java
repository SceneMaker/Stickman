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
 * @author Beka Aptsiauri
 */
public class AngrySmallMouth extends AnimationStickman2D
{

    public AngrySmallMouth()
    {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public AngrySmallMouth(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // angry
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "shape", "ANGRYSMALLMOUTH"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyeFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "shape", "ANGRY"));
        //mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkleFX, "shape", "ANGRY"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyeFX, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "shape", "ANGRY"));
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no angry
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "shape", "ANGRYSMALLMOUTHEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyeFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "shape", "ANGRYEND"));
        //mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkleFX, "shape", "ANGRYEND"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyeFX, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "shape", "ANGRYEND"));
        playAnimationPart(20);
    }
}
