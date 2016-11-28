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
public class ExcitedStart extends Animation {

	public ExcitedStart(StickmanSwing sm, int duration, boolean block) {
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
