package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;

import java.util.ArrayList;

/**
 *
 * @author beka
 *
 */
public class HappyEnd extends Animation {

	public HappyEnd(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// no happy
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "HAPPYEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "HAPPYEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "HAPPYEND"));
		playAnimationPart(mDuration);

		pauseAnimation(10);
	}
}
