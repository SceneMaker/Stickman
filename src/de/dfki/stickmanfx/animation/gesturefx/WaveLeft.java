/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.gesturefx;

import java.util.ArrayList;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanStageController;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX.ANIMTYPE;

/**
 *
 * @author Beka
 *
 */
public class WaveLeft extends AnimationFX {
	public WaveLeft() {
		mAnimType = ANIMTYPE.ON;
	}

	public WaveLeft(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// mStickmanFX.stopIdleBehavior();
		// mStickmanFX.startIdleBehavior("TouchHead");

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -35));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -120));
		playAnimationPart(200);

		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", -10));
				playAnimationPart(200);
			} else if (i == 5) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", 10));
				playAnimationPart(200);
			} else if (i % 2 == 1) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", 20));
				playAnimationPart(200);
			} else {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", -20));
				playAnimationPart(200);
			}
		}

		pauseAnimation(1000);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", 35));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", 120));
		playAnimationPart(200);

		StickmanStageController.currentRadioButton.setSelected(false);

	}
}
