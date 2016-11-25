/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class Sad extends Animation {

	public Sad() {
		mAnimType = ANIMTYPE.ON;
	}

	public Sad(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// sad
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "SAD"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "SAD")); // add
																								// by
																								// Robbie
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "SAD")); // add
																									// by
																									// Robbie
		playAnimationPart(mDuration);

		pauseAnimation(1200);

		// no sad
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "SADEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "SADEND")); // add
																									// by
																									// Robbie
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "SADEND")); // add
																									// by
																									// Robbie
		playAnimationPart(mDuration);

		if (StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);
	}
}
