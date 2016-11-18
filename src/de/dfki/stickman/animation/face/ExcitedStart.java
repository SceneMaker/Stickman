package de.dfki.stickman.animation.face;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class ExcitedStart extends Animation {

	public ExcitedStart(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// excited start
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "EXCITED"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "EXCITED"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "EXCITED"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "EXCITED"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "EXCITED"));
		playAnimationPart(mDuration);

		pauseAnimation(10);
	}
}
