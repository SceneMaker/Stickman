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
public class LookUp extends AnimationFX {

	public LookUp() {
		mAnimType = ANIMTYPE.ON;
	}
	
	public LookUp(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "LOOKUP"));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "LOOKUP"));
		playAnimationPart(100);

		pauseAnimation(100);
		
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "LOOKUPEND"));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "LOOKUPEND"));
		playAnimationPart(100);
		
		StickmanStageController.currentRadioButton.setSelected(false);
	}
}
