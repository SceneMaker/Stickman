/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.gesturefx;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class WaveLeft extends AnimationStickman2D
{

    public WaveLeft()
    {
        mAnimType = ANIMTYPE.Gesture;
    }

    public WaveLeft(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // mStickman.stopIdleBehavior();
        // mStickman.startIdleBehavior("TouchHead");
        int rotationUnit = 10;

        // 50 is the sum of all animation parts
        float timeFactor = (mDuration > 0) ? mDuration / 50 : 1;

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftUpperArmFX, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", rotationUnit * 16));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", rotationUnit * 16));

        playAnimationPart(200);

        pauseAnimation(200);

        // wave right
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", -rotationUnit * 4));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", rotationUnit * 4));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        pauseAnimation(200);

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftUpperArmFX, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", -rotationUnit * 16));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", -rotationUnit * 16));
        playAnimationPart(200);

        // mStickman.stopIdleBehavior();
        // mStickman.startIdleBehavior("TouchHead");
    }
}
