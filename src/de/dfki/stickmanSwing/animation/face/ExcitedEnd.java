package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.Animation;
import de.dfki.stickmanSwing.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class ExcitedEnd extends Animation {

	public ExcitedEnd(StickmanSwing sm, int duration, boolean block) {
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
