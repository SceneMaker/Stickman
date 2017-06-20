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
 * @author Beka
 *
 */
public class HeadRight extends Animation3D {
	public HeadRight() {
		mAnimType = ANIMTYPE.ON;
	}

	public HeadRight(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "yrotate", 30));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "LOOKRIGHT"));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "LOOKRIGHT"));
		playAnimationPart(mDuration);

		pauseAnimation(1000);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "yrotate", -30));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "LOOKRIGHTEND"));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "LOOKRIGHTEND"));
		playAnimationPart(mDuration);

		if (StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);
	}
}
