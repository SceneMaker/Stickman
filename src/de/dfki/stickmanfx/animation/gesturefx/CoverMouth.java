package de.dfki.stickmanfx.animation.gesturefx;

import java.util.ArrayList;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;

/**
 *
 * @author Beka
 *
 */
public class CoverMouth extends AnimationFX {
   
	
	public CoverMouth() {
		mAnimType = ANIMTYPE.ON;
	}
	
	public CoverMouth(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		int rotationUnit = 16;

		// bring upper arm and fore arm in position
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftShoulderFX, "rotate", -rotationUnit * 3));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", rotationUnit));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", rotationUnit * 9));
//		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", rotationUnit * 9));
		playAnimationPart(200);

		pauseAnimation(1200);

		// go back in the default position
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftShoulderFX, "rotate", +rotationUnit * 3));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -rotationUnit));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -rotationUnit * 9));
//		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftHandFX, "rotate", -rotationUnit * 9));
		playAnimationPart(300);
	}
}
