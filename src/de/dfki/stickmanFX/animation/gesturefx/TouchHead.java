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
public class TouchHead extends AnimationStickman2D
{

    public TouchHead()
    {
        mAnimType = ANIMTYPE.Gesture;
    }

    public TouchHead(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        int rotationUnit = 10;

        // bring Shoulder, upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightShoulderFX, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightUpperArmFX, "rotate", rotationUnit * 8));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightForeArmFX, "rotate", -rotationUnit * 14));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightHandFX, "rotate", -rotationUnit * 2));
        playAnimationPart(200);

        pauseAnimation(200);

        // wave hands
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);
        pauseAnimation(200);

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightShoulderFX, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightUpperArmFX, "rotate", -rotationUnit * 8));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightForeArmFX, "rotate", rotationUnit * 14)); //14
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightHandFX, "rotate", rotationUnit * 2));
        playAnimationPart(200);
    }
}
