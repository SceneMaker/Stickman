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
//            for(int i = 0; i<8; i++)
//            {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "zrotate", -120));
            playAnimationPart(500);
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "rotate", -60));
            playAnimationPart(500);
           
////                
//                mAnimationPartFX = new ArrayList<>();
//                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFootFX, "zrotate", -20));
//                playAnimationPart(500);
//                
//                mAnimationPartFX = new ArrayList<>();
//                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "yrotate", -360));
//                playAnimationPart(500);
                
//                mAnimationPartFX = new ArrayList<>();
//                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -360));
//                playAnimationPart(300);
                
                
                pauseAnimation(500);
                
                
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "zrotate", 120));
                playAnimationPart(500);
                
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "rotate", 60));
                playAnimationPart(500);
                
               
//                mAnimationPartFX = new ArrayList<>();
//                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "zrotate", -50));
//                playAnimationPart(500);
//                
//                mAnimationPartFX = new ArrayList<>();
//                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFootFX, "zrotate", 20));
//                playAnimationPart(500);
//                
//                mAnimationPartFX = new ArrayList<>();
//                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", 90));
//                playAnimationPart(500);
//                
//                mAnimationPartFX = new ArrayList<>();
//                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "yrotate", 360));
//                playAnimationPart(500);
                
//                mAnimationPartFX = new ArrayList<>();
//                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", 360));
//                playAnimationPart(300);
//                
                
//            }
                 

	}
}
