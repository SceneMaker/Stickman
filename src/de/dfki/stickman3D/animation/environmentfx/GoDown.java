/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environmentfx;

import de.dfki.stickman3D.StickmanFX;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContentFX;
import de.dfki.stickman3D.animationlogic.AnimationFX;
import javafx.application.Platform;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class GoDown extends AnimationFX {

	public GoDown() {
		mAnimType = ANIMTYPE.ON;
	}
	double recordOriginLeaveSpeed;
	public GoDown(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
		mStickmanFX = sm;
		recordOriginLeaveSpeed = mStickmanFX.leaveSpeedAndStickmanYPosition;
	}

	// WaveLeft
	@Override
	public void playAnimation() {
		int rotationUnit = 5;
		int speed = 5;

		// bring upper arm and fore arm in position
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit * 2));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 32));
		playAnimationPart(200);

		for (int i = 0; i < 8; i++) {
			// wave right
			for (int j = 0; j < 8; j++) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", -rotationUnit));

				mStickmanFX.leaveSpeedAndStickmanYPosition = mStickmanFX.leaveSpeedAndStickmanYPosition + speed;
				Platform.runLater(() -> mStickmanFX.update());
				playAnimationPart(20);
			}

			// wave left
			for (int j = 0; j < 8; j++) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", rotationUnit));

				mStickmanFX.leaveSpeedAndStickmanYPosition = mStickmanFX.leaveSpeedAndStickmanYPosition + speed;
				Platform.runLater(() -> mStickmanFX.update());
				playAnimationPart(20);
			}
		}

		// go back in the default position
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit * 2));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 32));
		playAnimationPart(20);
		mStickmanFX.leaveSpeedAndStickmanYPosition = recordOriginLeaveSpeed;
		StickmanStageController.currentRadioButton.setSelected(false);
	}

}
