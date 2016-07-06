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
public class Trouble extends Animation {

	public Trouble(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		int rotationUnit = 10;
		
		// RightForeArm rotate to right
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mRightForeArm, "rotate", rotationUnit*8));
		playAnimationPart(200);

		pauseAnimation(200);
		
		// RightForeArm rotate to left
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mRightForeArm, "rotate", -rotationUnit*8));
		playAnimationPart(200);
		
		// LeftForeArm rotate to left
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", -rotationUnit*8));
		playAnimationPart(200);

		pauseAnimation(200);
		
		// LeftForeArm rotate to right
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationUnit*8));
		playAnimationPart(200);
		
		
	}
}
