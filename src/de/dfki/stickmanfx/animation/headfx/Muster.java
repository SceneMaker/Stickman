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
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "ytranslate", 50));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mDownBody, "ytranslate", 50));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mNeckFX, "ytranslate", 50));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "ytranslate", 50));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", -80));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", 90));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "rotate", -80));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "rotate", 90));
            playAnimationPart(500);
            
            pauseAnimation(1000);
            
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "ytranslate", -50));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mDownBody, "ytranslate", -50));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mNeckFX, "ytranslate", -50));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "ytranslate", -50));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", 80));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", -90));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "rotate", 80));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "rotate", -90));
            playAnimationPart(500);
            

	}
}
