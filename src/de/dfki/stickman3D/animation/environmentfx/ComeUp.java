/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environmentfx;

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
public class ComeUp extends Animation3D {

	public ComeUp() {
		mAnimType = ANIMTYPE.ON;
	}
	double recordOriginLeaveSpeed;
	public ComeUp(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
		mStickmanFX = sm;
		recordOriginLeaveSpeed = mStickmanFX.leaveSpeedAndStickmanYPosition;
	}

	// WaveLeft
	@Override
	public void playAnimation() {
		int rotationUnit = 5;
		int speed = 4;

		mStickmanFX.leaveSpeedAndStickmanYPosition = 480;

		// bring upper arm and fore arm in position
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit * 2));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 32));
		playAnimationPart(100);

		for (int i = 0; i < 8; i++) {
			// wave right
			for (int j = 0; j < 10; j++) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "zrotate", -rotationUnit));
				playComeSpeed(speed);
				playAnimationPart(20);
			}
			// wave left
			for (int j = 0; j < 10; j++) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "zrotate", rotationUnit));
				playComeSpeed(speed);
				playAnimationPart(20);
			}
		}

		// go back in the default position
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit * 2));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 32));
		playAnimationPart(200);

	}

	private void playComeSpeed(int Speed) {
		if (mStickmanFX.leaveSpeedAndStickmanYPosition > recordOriginLeaveSpeed) {
			mStickmanFX.leaveSpeedAndStickmanYPosition = mStickmanFX.leaveSpeedAndStickmanYPosition - Speed;
		} else {
			mStickmanFX.leaveSpeedAndStickmanYPosition = recordOriginLeaveSpeed;
		}
		Platform.runLater(() -> mStickmanFX.update());
	}
}
