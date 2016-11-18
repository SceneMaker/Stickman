package de.dfki.stickman.animation.head;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LookLeft extends Animation {

	public LookLeft(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		int translationUnit = 3;

		// look left
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "LOOKLEFT"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "LOOKLEFT"));
		playAnimationPart(20);

		// // blink up
		// mAnimationPart = new ArrayList<>();
		// mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape",
		// "DEFAULT"));
		// mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape",
		// "DEFAULT"));
		// playAnimationPart(2);
	}
}
