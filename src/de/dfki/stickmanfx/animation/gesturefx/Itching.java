package de.dfki.stickmanfx.animation.gesturefx;

import java.util.ArrayList;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanStageController;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;

/**
 *
 * @author Beka
 *
 */
public class Itching extends AnimationFX {
   
	
	public Itching() {
		mAnimType = ANIMTYPE.ON;
	}
	
	public Itching(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		int rotationUnit = 16;

		
		// bring upper arm and fore arm in position
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "zrotate", -30));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -40));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", 70));
		
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "yrotate", -40));
		playAnimationPart(mDuration);
		
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger2, "zrotate", 8));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger4, "zrotate", -8));
		playAnimationPart(50);
		
		for(int i = 0; i<4; i++)
		{
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "rotate", 10));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger2, "rotate", 60));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger3, "rotate", 70));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger4, "rotate", 80));
			playAnimationPart(200);
			
			pauseAnimation(200);
			
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "rotate", -10));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger2, "rotate", -60));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger3, "rotate", -70));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger4, "rotate", -80));
			playAnimationPart(200);
		}
		
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger2, "zrotate", -8));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger4, "zrotate", 8));
		playAnimationPart(50);

		
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "zrotate", 30));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", 40));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", -70));
		
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "yrotate", 40));
		
		playAnimationPart(mDuration);
		
		if(StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);

	}
}
