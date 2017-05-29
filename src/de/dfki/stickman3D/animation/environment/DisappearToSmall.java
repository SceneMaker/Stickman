/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;
import javafx.application.Platform;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class DisappearToSmall extends Animation3D {

    public DisappearToSmall() {
        mAnimType = ANIMTYPE.ON;
    }

    public DisappearToSmall(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation() {
        float recordOriginScale = mStickmanFX.mScale;
        mStickmanFX.starShowControler = false;
        int rotationUnit = 5;

        // bring upper arm and fore arm in position
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "rotate", -rotationUnit ));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "rotate", -rotationUnit * 30));
        playAnimationPart(200);
        pauseAnimation(100);

        // wave right
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "zrotate", -rotationUnit * 8));
        playAnimationPart(180);

        // wave left
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "zrotate", rotationUnit * 8));
        playAnimationPart(180);

        for (int i = 0; i < 1; i++) {
            // wave right
            for (int j = 0; j < 9; j++) {
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "zrotate", -rotationUnit));

                mStickmanFX.mScale = mStickmanFX.mScale * 0.95f;
                playAnimationPart(20);
                Platform.runLater(() -> mStickmanFX.update());
            }

            // wave left
            for (int j = 0; j < 9; j++) {
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "zrotate", rotationUnit));

                mStickmanFX.mScale = mStickmanFX.mScale * 0.95f;
                playAnimationPart(20);
                Platform.runLater(() -> mStickmanFX.update());
            }
        }

        // go back in the default position
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "rotate", rotationUnit ));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "rotate", rotationUnit * 30));
        playAnimationPart(20);

        // show stars
        mStickmanFX.hideAllPartsWithout(mStickmanFX.mStars);
        mStickmanFX.mScale = recordOriginScale;

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
