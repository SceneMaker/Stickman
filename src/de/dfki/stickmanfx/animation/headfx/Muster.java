/*
100 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.headfx;

import java.util.ArrayList;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;

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
            
            
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "yrotate", -90));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "BLINK"));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "BLINK"));
            playAnimationPart(500);
            
            pauseAnimation(100);
            
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "yrotate", 90));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "BLINKEND"));
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "BLINKEND"));
            playAnimationPart(500);
            
//            mAnimationPartFX = new ArrayList<>();
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "yrotate", 90));
//            playAnimationPart(500);
//            
//            pauseAnimation(1000);
//            
//            mAnimationPartFX = new ArrayList<>();
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "yrotate", -90));
//            playAnimationPart(500);
            
                

	}
}
