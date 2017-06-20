package de.dfki.stickman3D.animation.environment;///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package de.dfki.stickman3D.animation.environmentfx;
//
//import java.util.ArrayList;
//
//import de.dfki.stickman3D.Stickman3D;
//import de.dfki.stickman3D.animationlogic.AnimationContent3D;
//import de.dfki.stickman3D.animationlogic.Animation3D;
//import javafx.application.Platform;
//import javafx.scene.paint.Color;
//
///**
// *
// * @author Beka
// *
// */
//public class BombeExplosion extends Animation3D
//{
//
//	public BombeExplosion(Stickman3D sm, int duration, boolean block)
//	{
//		super(sm, duration, block);
//		mStickman = sm;
//	}
//
//	@Override
//	public void playAnimation() 
//	{
//		int translationUnit = 8;
//		int rotationUnit = 10;
//            
//		mAnimationPartFX = new ArrayList<>();
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mBombeFX, "shape", "BOMBETRANSITION"));
//        playAnimationPart(mDuration);
//        
//     // headTilt
//        mAnimationPartFX = new ArrayList<>();
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEye, "tilt", translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEyebrow, "tilt", translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyeFX, "tilt", translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyebrowFX, "tilt", translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mHeadFX, "tilt", translationUnit));
//        
//        if(mStickman.mType == Gender.TYPE.MALE)
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mMaleHairFX, "tilt", translationUnit));
//        else
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mFemaleHairFX, "tilt", translationUnit));
//        
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mMouth, "tilt", translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mFaceWrinkleFX, "tilt", translationUnit));
//        
//     // embarrassed
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mMouth, "shape", "EMBARRASSED"));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyeFX, "shape", "EMBARRASSED"));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyebrowFX, "shape", "EMBARRASSED"));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mFaceWrinkleFX, "shape", "EMBARRASSED"));   ///Add by Robbie
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEye, "shape", "EMBARRASSED"));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEyebrow, "shape", "EMBARRASSED"));
//        playAnimationPart(mDuration);
//        
//        pauseAnimation(2000);
//        
//        //end HeadTilt
//        mAnimationPartFX = new ArrayList<>();
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEye, "tilt", -translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEyebrow, "tilt", -translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyeFX, "tilt", -translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyebrowFX, "tilt", -translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mHeadFX, "tilt", -translationUnit));
//        
//        if(mStickman.mType == Gender.TYPE.MALE)
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mMaleHairFX, "tilt", -translationUnit));
//        else
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mFemaleHairFX, "tilt", -translationUnit));
//        
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mMouth, "tilt", -translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mFaceWrinkleFX, "tilt", -translationUnit));
//        
//        //change embarrassed with angry
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyeFX, "shape", "SURPRISED"));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyebrowFX, "shape", "SURPRISED"));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEye, "shape", "SURPRISED"));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEyebrow, "shape", "SURPRISED"));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mMouth, "shape", "SURPRISED"));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mFaceWrinkleFX, "shape", "EMBARRASSEDEND"));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mFaceWrinkleFX, "shape", "SURPRISED"));
//        playAnimationPart(mDuration);
//        
//        pauseAnimation(1000);
//        
//        //Blink
//        for(int i = 0; i<3; i++)
//        {
//        	mAnimationPartFX = new ArrayList<>();
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyebrowFX, "shape", "SURPRISED"));
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEyebrow, "shape", "SURPRISED"));
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyeFX, "shape", "BLINK"));
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEye, "shape", "BLINK"));
//        	playAnimationPart(100);
//        	
//        	pauseAnimation(300);
//        	
//        	mAnimationPartFX = new ArrayList<>();
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyeFX, "shape", "SURPRISED"));
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEye, "shape", "SURPRISED"));
//        	playAnimationPart(100);
//        	
//        }
//        
//        pauseAnimation(1500);
//        
//     // headTilt
//        mAnimationPartFX = new ArrayList<>();
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEye, "tilt", translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEyebrow, "tilt", translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyeFX, "tilt", translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyebrowFX, "tilt", translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mHeadFX, "tilt", translationUnit));
//        
//        if(mStickman.mType == Gender.TYPE.MALE)
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mMaleHairFX, "tilt", translationUnit));
//        else
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mFemaleHairFX, "tilt", translationUnit));
//        
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mMouth, "tilt", translationUnit));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mFaceWrinkleFX, "tilt", translationUnit));
//     // embarrassed
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mMouth, "shape", "EMBARRASSED"));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyeFX, "shape", "EMBARRASSED"));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyebrowFX, "shape", "EMBARRASSED"));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mFaceWrinkleFX, "shape", "EMBARRASSED"));   ///Add by Robbie
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEye, "shape", "EMBARRASSED"));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEyebrow, "shape", "EMBARRASSED"));
//        playAnimationPart(mDuration);
//        
//        //playAnimationPart(mDuration);
//        
//        mAnimationPartFX = new ArrayList<>();
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftUpperLegFX, "rotate", -rotationUnit * 5));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftForeLegFX, "rotate", rotationUnit*2));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftFootFX, "rotate", rotationUnit*3));
//        playAnimationPart(mDuration);
//        
//        for(int i = 0; i<3; i++)
//        {
//        	mAnimationPartFX = new ArrayList<>();
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftForeLegFX, "rotate", -rotationUnit));
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftFootFX, "rotate", -rotationUnit*3));
//        	playAnimationPart(200);
//        	
//        	pauseAnimation(150);
//        	
//        	mAnimationPartFX = new ArrayList<>();
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftForeLegFX, "rotate", rotationUnit));
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftFootFX, "rotate", rotationUnit*3));
//        	playAnimationPart(200);
//        }
//        
//        mAnimationPartFX = new ArrayList<>();
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mBombeFX, "shape", "BOMBEEXPLOSION"));
//        playAnimationPart(mDuration);
//        
//        //mStickman.mBodyFX.currentColor = Color.BLACK;
////        Platform.runLater(() -> mStickman.mBodyFX.paintFrontOrientation(Color.BLACK));
//        mStickman.mHeadFX.mColor = Color.BLACK;
//        
//        
//        
//        mAnimationPartFX = new ArrayList<>();
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mBombeFX, "shape", "DEFAULT"));
//        playAnimationPart(20);
//        
//		mStickman.mLeftHandFX.setVisible(false);
//		mStickman.mLeftForeArmFX.setVisible(false);
//		mStickman.mLeftUpperArmFX.setVisible(false);
//		
//		mStickman.mRightHandFX.setVisible(false);
//		mStickman.mRightForeArmFX.setVisible(false);
//		mStickman.mRightUpperArmFX.setVisible(false);
//		
//		mStickman.mRightShoulderFX.setVisible(false);
//		mStickman.mLeftShoulderFX.setVisible(false);
//		mStickman.mNeck.setVisible(false);
//		mStickman.mLeftEyebrowFX.setVisible(false);
//		mStickman.mRightEyebrow.setVisible(false);
//		mStickman.mMouth.setVisible(false);
//		mStickman.mFaceWrinkleFX.setVisible(false);
//		
//        mAnimationPartFX = new ArrayList<>();
//        mStickman.mHeadFX.translateRight = true;
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mHeadFX, "Translate", -2000));
//        if(mStickman.mType == Gender.TYPE.FEMALE)
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mFemaleHairFX, "Translate", -2000));
//        else
//        	mAnimationPartFX.add(new AnimationContent3D(mStickman.mMaleHairFX, "Translate", -2000));
//        mStickman.mBodyFX.setVisible(false);
//        playAnimationPart(mDuration);
//        
//        mAnimationPartFX = new ArrayList<>();
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightForeLegFX, "rotate", 90));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightForeLegFX, "translate", 100));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftForeLegFX, "rotate", 70));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftForeLegFX, "translate", 120));
//        playAnimationPart(100);
//        
//        mAnimationPartFX = new ArrayList<>();
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightUpperLegFX, "rotate", 90));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightUpperLegFX, "translate", 155));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftUpperLegFX, "rotate", 120));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftUpperLegFX, "translate", 160));
//        playAnimationPart(100);
//        
//        mAnimationPartFX = new ArrayList<>();
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mLeftEyeFX, "rotate", 90));
//        mAnimationPartFX.add(new AnimationContent3D(mStickman.mRightEye, "rotate", 170));
//        playAnimationPart(100);
//        
//        mStickman.mLeftEyeFX.setVisible(false);
//        mStickman.mRightEye.setVisible(false);
//        
//
//	}
//}
