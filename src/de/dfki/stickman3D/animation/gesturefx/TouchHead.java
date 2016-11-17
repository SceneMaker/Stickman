/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesturefx;

import de.dfki.stickman3D.StickmanFX;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContentFX;
import de.dfki.stickman3D.animationlogic.AnimationFX;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class TouchHead extends AnimationFX {

	public TouchHead() {
		mAnimType = ANIMTYPE.ON;
	}
	
	public TouchHead(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		
//		mAnimationPartFX = new ArrayList<>();
//		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "yrotate", -90));
//		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "yrotate", -90));
//		playAnimationPart(500);
		
		if(mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", -100));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "zrotate", 100));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", -88));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", 180));
			playAnimationPart(500);
		}
		else
		{
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", -100));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "zrotate", 65));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", -88));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", 240));
			playAnimationPart(500);
		}
		
		
		for(int i = 0; i<4; i++)
		{
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", -5));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger4, "rotate", 40));
			playAnimationPart(100);
			
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", -5));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger3, "rotate", 70));
			playAnimationPart(100);
			
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", -5));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger2, "rotate", 70));
			playAnimationPart(100);
			
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", 5));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger3, "rotate", -70));
			playAnimationPart(100);
			
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", 5));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger2, "rotate", -70));
			playAnimationPart(100);
			
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", 5));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger4, "rotate", -40));
			playAnimationPart(100);
		}
		
		
		if(mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", 100));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "zrotate", -100));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", 88));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", -180));
			playAnimationPart(500);
		}
		else
		{
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", 100));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "zrotate", -65));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", 88));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", -240));
			playAnimationPart(500);
		}
		
//		mAnimationPartFX = new ArrayList<>();
//		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "yrotate", 90));
//		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "yrotate", 90));
//		playAnimationPart(500);
		
		StickmanStageController.currentRadioButton.setSelected(false);
	}
}