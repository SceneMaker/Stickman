package de.dfki.stickmanfx.animation.headfx;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanStageController;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX.ANIMTYPE;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LookRight extends AnimationFX {

	public LookRight() {
		mAnimType = ANIMTYPE.ON;
	}
	
	public LookRight(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "LOOKRIGHT"));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "LOOKRIGHT"));
		playAnimationPart(100);

		pauseAnimation(100);
		
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "LOOKRIGHTEND"));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "LOOKRIGHTEND"));
		playAnimationPart(100);
		
		StickmanStageController.currentRadioButton.setSelected(false);
	}
}
