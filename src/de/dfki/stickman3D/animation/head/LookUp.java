package de.dfki.stickman3D.animation.head;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LookUp extends Animation {

	public LookUp() {
		mAnimType = ANIMTYPE.ON;
	}

	public LookUp(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "LOOKUP"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "LOOKUP"));
		playAnimationPart(100);

		pauseAnimation(100);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "LOOKUPEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "LOOKUPEND"));
		playAnimationPart(100);

		StickmanStageController.currentRadioButton.setSelected(false);
	}
}
