package de.dfki.stickman3D.animation.gesturefx;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class CoverMouth extends Animation3D {
   
	
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
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", -30));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", -155));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", 180));
		playAnimationPart(500);

		pauseAnimation(1200);
		
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", 30));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", 155));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", -180));
		playAnimationPart(500);
		


	}
}
