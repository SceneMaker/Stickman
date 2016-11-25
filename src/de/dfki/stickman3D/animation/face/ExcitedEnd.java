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
public class ExcitedEnd extends Animation {

	public ExcitedEnd(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// no excited
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "EXCITEDEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "EXCITEDEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "EXCITEDEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "EXCITEDEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "EXCITEDEND"));
		playAnimationPart(mDuration);

		pauseAnimation(10);
	}
}
