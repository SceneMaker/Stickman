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
            
            
            mAnimationPartFX = new ArrayList<>();
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "yrotate", -90));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "DISGUSTED"));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "DISGUSTED"));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "DISGUSTED"));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "DISGUSTED"));
            playAnimationPart(500);
            
            pauseAnimation(1000);
            
            mAnimationPartFX = new ArrayList<>();
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "yrotate", 90));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "DISGUSTEDEND"));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "DISGUSTEDEND"));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "DISGUSTEDEND"));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "DISGUSTEDEND"));
            playAnimationPart(500);
                

	}
}
