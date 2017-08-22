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
public class ComeUp extends AnimationStickman2D
{


    public ComeUp(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    // WaveLeft
    @Override
    public void playAnimation()
    {
        int rotationUnit = 5;
        int speed = 7;

        ((StickmanFX) agent).voffset = 480;

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftUpperArmFX, "rotate", rotationUnit * 2));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", rotationUnit * 32));
        playAnimationPart(100);

        for (int i = 0; i < 6; i++)
        {
            // wave right
            for (int j = 0; j < 8; j++)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", -rotationUnit));

                playComeSpeed(speed);
                playAnimationPart(20);
            }

            // wave left
            for (int j = 0; j < 8; j++)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", rotationUnit));

                playComeSpeed(speed);
                playAnimationPart(20);
            }
        }

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftUpperArmFX, "rotate", -rotationUnit * 2));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftForeArmFX, "rotate", -rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftHandFX, "rotate", -rotationUnit * 32));
        playAnimationPart(200);
    }

    private void playComeSpeed(int Speed)
    {
        if (((StickmanFX) agent).voffset > 0)
        {
            ((StickmanFX) agent).voffset = ((StickmanFX) agent).voffset - Speed;
        } else
        {
            ((StickmanFX) agent).voffset = 0;
        }
        Platform.runLater(() -> ((StickmanFX) agent).update());
    }
}
