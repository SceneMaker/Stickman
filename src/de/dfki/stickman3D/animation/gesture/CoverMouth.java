package de.dfki.stickman3D.animation.gesture;

import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;

/**
 *
 * @author Beka
 *
 */
public class CoverMouth extends Animation {

	public CoverMouth() {
		mAnimType = ANIMTYPE.ON;
	}

	public CoverMouth(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		int rotationUnit = 16;

		// bring upper arm and fore arm in position
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "rotate", -30));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "rotate", -150));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", 140));
		playAnimationPart(500);

		pauseAnimation(1200);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "rotate", 30));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "rotate", 150));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", -140));
		playAnimationPart(500);

		if (StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);

	}
}
