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
public class ExcitedEnd extends Animation {

	public ExcitedEnd(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// excited end
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "EXCITEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "EXCITEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "EXCITEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "EXCITEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "EXCITEDEND"));
		playAnimationPart(mDuration);

		pauseAnimation(10);
	}
}
