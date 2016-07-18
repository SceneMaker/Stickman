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
 * @author Patrick Gebhard
 *
 */
public class TouchHead extends Animation {

	public TouchHead(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		int rotationUnit = 10;
		
		// bring Shoulder, upper arm and fore arm in position
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mRightShoulder, "rotate", rotationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mRightUpperArm, "rotate", rotationUnit* 8));
		mAnimationPart.add(new AnimationContent(mStickman.mRightForeArm, "rotate", -rotationUnit*14));
		//mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "rotate",-rotationUnit*2 ));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_1, "rotate", -rotationUnit*2));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_2, "rotate", -rotationUnit*2));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_3, "rotate", -rotationUnit*2));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_4, "rotate", -rotationUnit*2));
		playAnimationPart(200);

		pauseAnimation(200);

		// wave hands
		mAnimationPart = new ArrayList<>();
		//mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "rotate", rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_1, "rotate", rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_2, "rotate", rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_3, "rotate", rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_4, "rotate", rotationUnit * 4));
		playAnimationPart(100);

		mAnimationPart = new ArrayList<>();
		//mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "rotate", -rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_1, "rotate", -rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_2, "rotate", -rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_3, "rotate", -rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_4, "rotate", -rotationUnit * 4));
		playAnimationPart(100);
		
		mAnimationPart = new ArrayList<>();
		//mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "rotate", rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_1, "rotate", rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_2, "rotate", rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_3, "rotate", rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_4, "rotate", rotationUnit * 4));
		playAnimationPart(100);

		mAnimationPart = new ArrayList<>();
		//mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "rotate", -rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_1, "rotate", -rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_2, "rotate", -rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_3, "rotate", -rotationUnit * 4));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_4, "rotate", -rotationUnit * 4));
		playAnimationPart(100);
		pauseAnimation(200);

		// go back in the default position
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mRightShoulder, "rotate", -rotationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mRightUpperArm, "rotate", -rotationUnit* 8));
		mAnimationPart.add(new AnimationContent(mStickman.mRightForeArm, "rotate", rotationUnit*14)); //14
		//mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "rotate", rotationUnit*2 ));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_1, "rotate", rotationUnit * 2));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_2, "rotate", rotationUnit * 2));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_3, "rotate", rotationUnit * 2));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_4, "rotate", rotationUnit * 2));
		playAnimationPart(200);
	}
}
