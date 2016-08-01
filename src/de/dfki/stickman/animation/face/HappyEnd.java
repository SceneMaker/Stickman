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
public class HappyEnd extends Animation {

	public HappyEnd(Stickman sm, int duration, boolean block) {
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
