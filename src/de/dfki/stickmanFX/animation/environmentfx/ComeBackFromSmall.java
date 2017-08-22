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
public class ComeBackFromSmall extends AnimationStickman2D
{

    public ComeBackFromSmall(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        ((StickmanFX) agent).mScaleOriginal = agent.mScale;
        float mScaleRecord = agent.mScale;
        for (int j = 0; j < 19; j++)
        {
            mScaleRecord = mScaleRecord * 0.95f;
        }

//		mScaleRecord = mStickman.mScale;
        ((StickmanFX) agent).starShowControler = true;

        // show stars
//		mStickman.mScale = mStickman.mScaleOriginal;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mStarsFX, "shape", "STARSDISAPPEAR"));
        playAnimationPart(1000);

        // disappeared words or stars
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mStarsFX, "shape", "DEFAULT"));
        playAnimationPart(2);

        ((StickmanFX) agent).starShowControler = false;
        agent.mScale = mScaleRecord;

        int rotationUnit = 5;

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftUpperArmFX, "rotate", rotationUnit * 2));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", rotationUnit * 32));
        playAnimationPart(20);
        pauseAnimation(20);

        for (int i = 0; i < 2; i++)
        {
            // wave right
            for (int j = 0; j < 9; j++)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", -rotationUnit));

                mScaleRecord = mScaleRecord * 1.05f;
                if (mScaleRecord < ((StickmanFX) agent).mScaleOriginal)
                {
                    agent.mScale = mScaleRecord;
                } else
                {
                    agent.mScale = ((StickmanFX) agent).mScaleOriginal;
                }
                playAnimationPart(20);
                Platform.runLater(() -> ((StickmanFX) agent).update());
                ((StickmanFX) agent).showAllParts();
            }

            // wave left
            for (int j = 0; j < 9; j++)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", rotationUnit));

                mScaleRecord = mScaleRecord * 1.05f;
                if (mScaleRecord < ((StickmanFX) agent).mScaleOriginal)
                {
                    agent.mScale = mScaleRecord;
                } else
                {
                    agent.mScale = ((StickmanFX) agent).mScaleOriginal;
                }

                playAnimationPart(20);
                Platform.runLater(() -> ((StickmanFX) agent).update());
                ((StickmanFX) agent).showAllParts();
            }
        }

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftUpperArmFX, "rotate", -rotationUnit * 2));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", -rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", -rotationUnit * 32));
        playAnimationPart(20);
    }
}
