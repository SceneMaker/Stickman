/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import java.util.ArrayList;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;
import javafx.application.Platform;

/**
 *
 * @author Beka
 *
 */
public class ComeBackFromSmall extends AnimationFX {

    private StickmanFX mStickmanFX;

    public ComeBackFromSmall(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    @Override
    public void playAnimation() {
        mStickmanFX.mScaleOriginal = mStickmanFX.mScale;
        float mScaleRecord = mStickmanFX.mScale;
        for (int j = 0; j < 19; j++) {
            mScaleRecord = mScaleRecord * 0.95f;
        }

//		mScaleRecord = mStickman.mScale;
        mStickmanFX.starShowControler = true;

        // show stars
//		mStickman.mScale = mStickman.mScaleOriginal;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mStarsFX, "shape", "STARSDISAPPEAR"));
        playAnimationPart(1000);

        // disappeared words or stars
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mStarsFX, "shape", "DEFAULT"));
        playAnimationPart(2);

        mStickmanFX.starShowControler = false;
        mStickmanFX.mScale = mScaleRecord;

        int rotationUnit = 5;

        // bring upper arm and fore arm in position
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit * 2));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 32));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 32));
        playAnimationPart(20);
        pauseAnimation(20);

        for (int i = 0; i < 2; i++) {
            // wave right
            for (int j = 0; j < 9; j++) {
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit));
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit));

                mScaleRecord = mScaleRecord * 1.05f;
                if (mScaleRecord < mStickmanFX.mScaleOriginal) {
                    mStickmanFX.mScale = mScaleRecord;
                } else {
                    mStickmanFX.mScale = mStickmanFX.mScaleOriginal;
                }
                playAnimationPart(20);
                Platform.runLater(() -> mStickmanFX.update());
                mStickmanFX.showAllParts();
            }

            // wave left
            for (int j = 0; j < 9; j++) {
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit));
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit));

                mScaleRecord = mScaleRecord * 1.05f;
                if (mScaleRecord < mStickmanFX.mScaleOriginal) {
                    mStickmanFX.mScale = mScaleRecord;
                } else {
                    mStickmanFX.mScale = mStickmanFX.mScaleOriginal;
                }

                playAnimationPart(20);
                Platform.runLater(() -> mStickmanFX.update());
                mStickmanFX.showAllParts();
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
