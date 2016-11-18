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

/**
 *
 * @author Beka
 *
 */
public class Clap extends AnimationFX {

	public Clap() {
		mAnimType = ANIMTYPE.ON;
	}

	public Clap(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -30));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", -30));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -70));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", -90));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "yrotate", -170));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", 40));
		playAnimationPart(500);

		for (int i = 0; i < 10; i++) {
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", 15));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", -15));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", 17));
			playAnimationPart(200);

			pauseAnimation(100);

			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", -15));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", 15));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", -17));
			playAnimationPart(200);
		}

		pauseAnimation(1000);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", 30));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", 30));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", 70));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", 90));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "yrotate", 170));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", -40));
		playAnimationPart(500);

		StickmanStageController.currentRadioButton.setSelected(false);

	}

}
