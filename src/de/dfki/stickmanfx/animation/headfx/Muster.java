/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.headfx;

import de.dfki.stickman.animationlogic.AnimationContent;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import java.util.ArrayList;
import javafx.application.Platform;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Muster extends AnimationFX 
{

   
	public Muster(StickmanFX sm, int duration, boolean block) 
        {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
            int rotationUnit = 10;
            
            
//            mAnimationPartFX = new ArrayList<>();
////          mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -90));
//          mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mBodyFX, "yrotate", 90));
//          playAnimationPart(500);
//////          
//          pauseAnimation(1000);
            
            
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "rotate", 90));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", 90));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -90));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger1, "rotate", -90));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", -110));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger1, "rotate", -30));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger4, "rotate", -360));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger3, "rotate", -60));
            playAnimationPart(500);
            
            pauseAnimation(1000);
            
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "rotate", -90));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", -90));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", 90));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger1, "rotate", 90));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", 110));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger1, "rotate", 30));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger4, "rotate", 360));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger3, "rotate", 60));
            playAnimationPart(500);
            
//            pauseAnimation(1000);
//            
//            mAnimationPartFX = new ArrayList<>();
//          mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mBodyFX, "yrotate", -90));
//          playAnimationPart(500);
                

	}
}
