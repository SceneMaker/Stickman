/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.face;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import de.dfki.stickman.body.LeftEyebrow;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class.
 * The face moves from the default state to the angry state, and then comes back to the default state.
 * 
 * @author Patrick Gebhard
 */
public class Muster extends Animation {
/**
 * 
 * @param sm Stickman
 * @param duration Control the speed of the movement from one emotion state to another emotion state.
 * @param block block or not the others movements, when one movement is not finished.
 */
	public Muster(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}
	/**
	 * This method creates the angry facial movement.
	 */
	@Override
	public void playAnimation() {
            int rotationUnit = 10;
		// angry
                
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mRightUpperArm, "rotate", -rotationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mRightForeArm, "rotate", -rotationUnit * 16));
		//mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "rotate", -rotationUnit * 16));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_1, "rotate", -rotationUnit * 16));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_2, "rotate", -rotationUnit * 16));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_3, "rotate", -rotationUnit * 16));
                
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_4, "rotate", -rotationUnit * 16));
		 //mStickman.mRightFinger1LengthController = true;
               //mStickman.mRightFinger2LengthController = true;
               //mStickman.mRightFinger3LengthController = true;
               //mStickman.mRightFinger4LengthController = true;
                playAnimationPart(1000);
                
                
                
               pauseAnimation(1200);
              
               
//
//		// no angry
//		mAnimationPart = new ArrayList<>();
//		mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_4, "rotate", -40));
//		mStickman.mRightFinger4LengthController = false;
//		playAnimationPart(20);
	}
}
