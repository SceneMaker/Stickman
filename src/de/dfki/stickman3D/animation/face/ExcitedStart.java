package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class ExcitedStart extends Animation {

	public ExcitedStart(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// excited
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "EXCITED"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "EXCITED"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "EXCITED"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "EXCITED"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "EXCITED"));
		playAnimationPart(mDuration);

		pauseAnimation(10);
	}
}
