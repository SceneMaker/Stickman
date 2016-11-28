package de.dfki.stickmanSwing.animation.head;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.Animation;
import de.dfki.stickmanSwing.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LookRight extends Animation {

	public LookRight(StickmanSwing sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		int translationUnit = 3;

		// look left
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "LOOKRIGHT"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "LOOKRIGHT"));
		playAnimationPart(20);

//		// blink up
//		mAnimationPart = new ArrayList<>();
//		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "DEFAULT"));
//		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "DEFAULT"));
//		playAnimationPart(2);
	}
}
