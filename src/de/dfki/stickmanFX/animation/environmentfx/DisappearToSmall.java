/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;
import javafx.application.Platform;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class DisappearToSmall extends AnimationStickman2D
{

    public DisappearToSmall(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    // WaveLeft
    @Override
    public void playAnimation()
    {
        ((StickmanFX) agent).mScaleOriginal = agent.mScale;
        ((StickmanFX) agent).starShowControler = false;
        int rotationUnit = 5;

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftUpperArmFX, "rotate", rotationUnit * 2));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", rotationUnit * 32));
        playAnimationPart(200);
        pauseAnimation(100);

        // wave right
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", -rotationUnit * 8));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", -rotationUnit * 8));
        playAnimationPart(180);

        // wave left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", rotationUnit * 8));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", rotationUnit * 8));
        playAnimationPart(180);

        for (int i = 0; i < 1; i++)
        {
            // wave right
            for (int j = 0; j < 9; j++)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", -rotationUnit));

                agent.mScale = agent.mScale * 0.95f;
                playAnimationPart(20);
                Platform.runLater(() -> ((StickmanFX) agent).update());
            }

            // wave left
            for (int j = 0; j < 9; j++)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", rotationUnit));

                agent.mScale = agent.mScale * 0.95f;
                playAnimationPart(20);
                Platform.runLater(() -> ((StickmanFX) agent).update());
            }
        }

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftUpperArmFX, "rotate", -rotationUnit * 2));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", -rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", -rotationUnit * 32));
        playAnimationPart(20);

        // show stars
        ((StickmanFX) agent).starShowControler = true;
        ((StickmanFX) agent).hideAllPartsWithout(((StickmanFX) agent).mStarsFX);
        agent.mScale = ((StickmanFX) agent).mScaleOriginal;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mStarsFX, "shape", "STARSDISAPPEAR"));
        playAnimationPart(1000);
    }
}
