/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.environment;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class ComeBackFromSmall extends Animation {

    private Stickman mStickman;

    public ComeBackFromSmall(Stickman sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickman = sm;
    }

    @Override
    public void playAnimation() {
        float mScaleRecord = 0.0f;

        for (int j = 0; j < 19; j++) {
            mStickman.mScale = mStickman.mScale * 0.95f;
        }

        mScaleRecord = mStickman.mScale;
        mStickman.starShowControler = true;

//		Show words		
//		for(int i=0; i<15;i++)
//		{
//			mStickman.mScale = mStickman.mScale*1.05f;
//			if(mStickman.mScale >= 1)
//				mStickman.mScale = 1;
//			mAnimationPart = new ArrayList<>();
//			mAnimationPart.add(new AnimationContent(mStickman.mWordShow, "shape", "SAYHI"));
//			playAnimationPart(2);	
//		}
//		show stars
        mStickman.mScale = 1.334445f;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mStars, "shape", "STARSDISAPPEAR"));
        playAnimationPart(1000);

//		disappeared words or stars
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mStars, "shape", "DEFAULT"));
        playAnimationPart(2);

        mStickman.starShowControler = false;
        mStickman.mScale = mScaleRecord;

        int rotationUnit = 5;

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperArm, "rotate", rotationUnit * 2));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationUnit * 32));
        //mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger1, "rotate", rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger2, "rotate", rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger3, "rotate", rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", rotationUnit * 32));
        playAnimationPart(20);
        pauseAnimation(20);

        for (int i = 0; i < 2; i++) {
            // wave right		
            for (int j = 0; j < 9; j++) {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", -rotationUnit));
                //mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger1, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger2, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger3, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", -rotationUnit));
                

                mStickman.mScale = mStickman.mScale * 1.05f;
                if (mStickman.mScale >= 1.3) {
                    mStickman.mScale = 1.334445f;
                }
                playAnimationPart(20);
            }

            // wave left
            for (int j = 0; j < 9; j++) {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationUnit));
                //mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger1, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger2, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger3, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", rotationUnit));
                

                mStickman.mScale = mStickman.mScale * 1.05f;
                if (mStickman.mScale >= 1.3) {
                    mStickman.mScale = 1.334445f;
                }
                playAnimationPart(20);
            }
        }

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperArm, "rotate", -rotationUnit * 2));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", -rotationUnit * 32));
        //mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", -rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger1, "rotate", -rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger2, "rotate", -rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger3, "rotate", -rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", -rotationUnit * 32));
        playAnimationPart(20);
    }
}
