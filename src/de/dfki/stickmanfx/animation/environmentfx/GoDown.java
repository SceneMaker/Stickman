/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.environmentfx;

import java.util.ArrayList;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import javafx.application.Platform;

/**
 *
 * @author Beka
 *
 */
public class GoDown extends AnimationFX {

    private StickmanFX mStickmanFX;

    public GoDown(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation() {
        int rotationUnit = 5;
        int speed = 4;

        // bring upper arm and fore arm in position
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit * 2));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 32));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 32));
        playAnimationPart(200);

        for (int i = 0; i < 8; i++) {
            // wave right		
            for (int j = 0; j < 8; j++) {
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit));
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit));

                mStickmanFX.leaveSpeed = mStickmanFX.leaveSpeed + speed;
                Platform.runLater(() -> mStickmanFX.update());
                playAnimationPart(20);
            }

            // wave left
            for (int j = 0; j < 8; j++) {
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit));
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit));

                mStickmanFX.leaveSpeed = mStickmanFX.leaveSpeed + speed;
                Platform.runLater(() -> mStickmanFX.update());
                playAnimationPart(20);
            }
        }

        // go back in the default position
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit * 2));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 32));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 32));
        playAnimationPart(20);
    }

}