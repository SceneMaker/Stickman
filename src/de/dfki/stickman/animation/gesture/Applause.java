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
public class Applause extends Animation 
{
        int translationUnit = 2;

	public Applause(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		int rotationUnit = 10;
		
		//RightArm up
		mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(mStickman.mRightShoulder, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mRightUpperArm, "rotate", rotationUnit*-1));
		mAnimationPart.add(new AnimationContent(mStickman.mRightForeArm, "rotate", -rotationUnit*13-5));
                //mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "rotate", -rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_1, "rotate", -rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_2, "rotate", -rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_3, "rotate", -rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_4, "rotate", -rotationUnit*3));
              
                //playAnimationPart(200);
                
                //LeftArm up
                //mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(mStickman.mLeftShoulder, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperArm, "rotate", -rotationUnit*-1));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationUnit*13+5));
                //mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger1, "rotate", rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger2, "rotate", rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger3, "rotate", rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", rotationUnit*3));
		playAnimationPart(200);
                
                
                for(int i = 0; i<8; i++)
                {
                    //start applause
                    mAnimationPart = new ArrayList<>();
                    mAnimationPart.add(new AnimationContent(mStickman.mRightForeArm, "rotate", -rotationUnit));
                    //mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "rotate", -rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_1, "rotate", -rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_2, "rotate", -rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_3, "rotate", -rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_4, "rotate", -rotationUnit));

                    mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationUnit));
                    //mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger1, "rotate", rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger2, "rotate", rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger3, "rotate", rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", rotationUnit));
                    
                    //Head down
                    mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "translate", translationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "translate", translationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "translate", translationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "translate", translationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mHead, "translate", translationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mMouth, "translate", translationUnit));
                    
                    playAnimationPart(200);
                    
                    //end applause
                    mAnimationPart = new ArrayList<>();
                    mAnimationPart.add(new AnimationContent(mStickman.mRightForeArm, "rotate", rotationUnit));
                    //mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "rotate", rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_1, "rotate", rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_2, "rotate", rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_3, "rotate", rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_4, "rotate", rotationUnit));

                    mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", -rotationUnit));
                    //mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", -rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger1, "rotate", -rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger2, "rotate", -rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger3, "rotate", -rotationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", -rotationUnit));
                    
                    //Head up
                    mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "translate", -translationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "translate", -translationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "translate", -translationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "translate", -translationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mHead, "translate", -translationUnit));
                    mAnimationPart.add(new AnimationContent(mStickman.mMouth, "translate", -translationUnit));
                    
                    playAnimationPart(200);
                }
                
		pauseAnimation(200);
		
		//RightArm down
		mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(mStickman.mRightShoulder, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mRightUpperArm, "rotate", -rotationUnit*-1));
		mAnimationPart.add(new AnimationContent(mStickman.mRightForeArm, "rotate", rotationUnit*13+5));
                //mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "rotate", rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_1, "rotate", rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_2, "rotate", rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_3, "rotate", rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_4, "rotate", rotationUnit*3));
                
                //LeftArm down
                mAnimationPart.add(new AnimationContent(mStickman.mLeftShoulder, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperArm, "rotate", rotationUnit*-1));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", -rotationUnit*13-5));
                //mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", -rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger1, "rotate", -rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger2, "rotate", -rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger3, "rotate", -rotationUnit*3));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", -rotationUnit*3));
                
		playAnimationPart(200);
		
	}
}
