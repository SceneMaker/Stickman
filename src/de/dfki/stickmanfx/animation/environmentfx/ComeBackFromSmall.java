/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.environmentfx;

import java.util.ArrayList;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanStageController;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX.ANIMTYPE;
import javafx.application.Platform;

/**
 *
 * @author Beka
 *
 */
public class ComeBackFromSmall extends AnimationFX {

	public ComeBackFromSmall() {
		mAnimType = ANIMTYPE.ON;
	}

	public ComeBackFromSmall(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
		mStickmanFX = sm;
	}

	@Override
	public void playAnimation() {

		int rotationUnit = 5;

		float recordOriginScale = mStickmanFX.mScale;

		for (int j = 0; j < 19; j++) {
			mStickmanFX.mScale = mStickmanFX.mScale * 0.95f;
		}

		// bring upper arm and fore arm in position
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit * 2));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 32));
		playAnimationPart(20);

		pauseAnimation(20);

		for (int i = 0; i < 2; i++) {
			// wave right
			for (int j = 0; j < 9; j++) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", -rotationUnit));

				mStickmanFX.mScale = mStickmanFX.mScale * 1.05f;
				if (mStickmanFX.mScale >= recordOriginScale) {
					mStickmanFX.mScale = recordOriginScale;
				}
				playAnimationPart(20);
				Platform.runLater(() -> mStickmanFX.update());
				mStickmanFX.showAllParts();
			}

			// wave left
			for (int j = 0; j < 9; j++) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", rotationUnit));

				mStickmanFX.mScale = mStickmanFX.mScale * 1.05f;
				if (mStickmanFX.mScale >= recordOriginScale) {
					mStickmanFX.mScale = recordOriginScale;
				}
				playAnimationPart(20);
				Platform.runLater(() -> mStickmanFX.update());
				mStickmanFX.showAllParts();
			}
		}

		// go back in the default position
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit * 2));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 32));
		playAnimationPart(20);

		StickmanStageController.currentRadioButton.setSelected(false);
	}
}
