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
public class HappyStart extends Animation {

	public HappyStart(Stickman sm, int duration, boolean block) {
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
