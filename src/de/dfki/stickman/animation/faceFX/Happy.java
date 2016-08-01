package de.dfki.stickman.animation.faceFX;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Robbie
 *
 */
public class Happy extends Animation {
	
	public Happy() {
		mAnimType = ANIMTYPE.EmotionExpression;
	}

	public Happy(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// happy
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "HAPPY"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "HAPPY"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "HAPPY"));		
		playAnimationPart(mDuration);

		pauseAnimation(1200);
		
		// no happy
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "HAPPYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "HAPPYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "HAPPYEND"));
		
		playAnimationPart(20);
	}
}
