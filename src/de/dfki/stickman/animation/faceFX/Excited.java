package de.dfki.stickman.animation.faceFX;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Excited extends Animation {
	
	public Excited() {
		mAnimType = ANIMTYPE.EmotionExpression;
	}

	public Excited(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// excited
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "EXCITED"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "EXCITED"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "EXCITED"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "EXCITED"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "EXCITED"));		
		playAnimationPart(mDuration);

		pauseAnimation(1200);
		
		// no excited
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "EXCITEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "EXCITEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "EXCITEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "EXCITEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "EXCITEDEND"));
		
		playAnimationPart(20);
	}
}
