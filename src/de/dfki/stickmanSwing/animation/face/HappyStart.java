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
public class HappyStart extends Animation {

	public HappyStart(StickmanSwing sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// happy start
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "HAPPY"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "HAPPY"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "HAPPY"));		
		playAnimationPart(mDuration);

		pauseAnimation(10);
	}
}
