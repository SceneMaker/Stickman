/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.head;

import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class HeadDown extends Animation3D {

	public HeadDown() {
		mAnimType = ANIMTYPE.ON;
	}

	public HeadDown(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "rotate", 15));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperLeg, "rotate", 30));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFoot, "yrotate", 20));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "LOOKDOWN"));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "LOOKDOWN"));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeLeg, "rotate", 20));
		playAnimationPart(mDuration);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperLeg, "rotate", -35));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeLeg, "rotate", -25));
		playAnimationPart(mDuration);

		pauseAnimation(500);

		// blink up
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "rotate", -15));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperLeg, "rotate", 5));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFoot, "yrotate", -20));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "LOOKDOWNEND"));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "LOOKDOWNEND"));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeLeg, "rotate", 5));
		playAnimationPart(mDuration);

		if (StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);
	}
}
