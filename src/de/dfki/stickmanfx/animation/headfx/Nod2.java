/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.headfx;

import java.util.ArrayList;

import de.dfki.stickman.Stickman;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;

/**
 *
 * @author Patrick Gebhard
 *
 */
////////////nod 3 time by Guo
public class Nod2 extends AnimationFX
{

	public Nod2(StickmanFX sm, int duration, boolean block)
	{
		super(sm, duration, block);
	}

	@Override
	public void playAnimation()
	{
		int translationUnit = 3;


		for (int i = 0; i < 3; i++)
		{
			// head down
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "translate", translationUnit));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "translate", translationUnit));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "translate", translationUnit));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "translate", translationUnit));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "translate", translationUnit));
			
			if(mStickmanFX.mType == Stickman.TYPE.MALE)
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "translate", translationUnit));
			else
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "translate", translationUnit));
			
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "translate", translationUnit));
			playAnimationPart(200);
			pauseAnimation(200);
			
			// head up
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "translate", -translationUnit));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "translate", -translationUnit));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "translate", -translationUnit));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "translate", -translationUnit));
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "translate", -translationUnit));
			
			if(mStickmanFX.mType == Stickman.TYPE.MALE)
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "translate", -translationUnit));
			else
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "translate", -translationUnit));
			
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "translate", -translationUnit));

			playAnimationPart(200);
			pauseAnimation(200);
		}
	}
}
