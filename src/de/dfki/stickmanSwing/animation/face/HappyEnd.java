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
public class HappyEnd extends Animation {

	public HappyEnd(StickmanSwing sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// happy end
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "HAPPYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "HAPPYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "HAPPYEND"));		
		playAnimationPart(mDuration);

		pauseAnimation(10);
	}
}
