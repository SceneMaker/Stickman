/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.gesture;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class StartMeditation extends Animation
{

	public StartMeditation(Stickman sm, int duration, boolean block)
	{
		super(sm, duration, block);
	}

	@Override
	public void playAnimation()
	{
		int rotationsUnit = 1;

		for (int i = 0; i < 15; i++)
		{
			// start Meditation
			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickman.mRightUpperLeg, "rotate", rotationsUnit * 4));
			mAnimationPart.add(new AnimationContent(mStickman.mRightForeLeg, "rotate", -rotationsUnit * 6));
			mAnimationPart.add(new AnimationContent(mStickman.mRightFoot, "rotate", -rotationsUnit * 6));

			mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperLeg, "rotate", -rotationsUnit * 4));
			mAnimationPart.add(new AnimationContent(mStickman.mLeftForeLeg, "rotate", rotationsUnit * 6));
			mAnimationPart.add(new AnimationContent(mStickman.mLeftFoot, "rotate", rotationsUnit * 6));

			mAnimationPart.add(new AnimationContent(mStickman.mRightUpperArm, "rotate", rotationsUnit * 4));
			mAnimationPart.add(new AnimationContent(mStickman.mRightForeArm, "rotate", -rotationsUnit * 12));

			mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_1, "shape", "DEFAULT"));
			mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_2, "shape", "DEFAULT"));
			mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_3, "shape", "DEFAULT"));
                        mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_4, "shape", "DEFAULT"));

			mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperArm, "rotate", -rotationsUnit * 4));
			mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationsUnit * 12));
			//mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", rotationsUnit * 14));
                        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger1, "rotate", rotationsUnit * 14));
                        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger2, "rotate", rotationsUnit * 14));
                        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger3, "rotate", rotationsUnit * 14));
                        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", rotationsUnit * 14));

			mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "O"));

			mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "BLINK"));
			mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "BLINK"));

			playComeSpeed(-1);
			playAnimationPart(1);
		}

		pauseAnimation(500);
	}
	
	private void playComeSpeed(int Speed)
	{
		mStickman.leaveSpeed = mStickman.leaveSpeed + Speed;
	}
	
}
