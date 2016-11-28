package de.dfki.stickman3D.animation.gesturefx;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContentFX;
import de.dfki.stickman3D.animationlogic.AnimationFX;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class CoverMouth extends AnimationFX {
   
	
	public CoverMouth() {
		mAnimType = ANIMTYPE.ON;
	}
	
	public CoverMouth(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		int rotationUnit = 16;

		
		// bring upper arm and fore arm in position
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", -30));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", -155));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", 180));
		playAnimationPart(500);

		pauseAnimation(1200);
		
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", 30));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", 155));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", -180));
		playAnimationPart(500);
		
		StickmanStageController.currentRadioButton.setSelected(false);

	}
}
