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
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mBodyFX, "yrotate", -90));
//            playAnimationPart(200);
////            
//            pauseAnimation(1000);
            
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger1, "zrotate", 90));
            playAnimationPart(300);
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger2, "zrotate", 90));
            playAnimationPart(300);
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger3, "zrotate", 90));
            playAnimationPart(300);
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger4, "zrotate", 90));
            playAnimationPart(300);
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger5, "zrotate", 90));
            playAnimationPart(300);
            
//            mAnimationPartFX = new ArrayList<>();
//            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "zrotate", 40));
//            playAnimationPart(300);
//                
                
                pauseAnimation(500);
                
                mStickmanFX.mBodyFX.bodyPart = "body";
                
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger1, "zrotate", -90));
                playAnimationPart(300);
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger2, "zrotate", -90));
                playAnimationPart(300);
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger3, "zrotate", -90));
                playAnimationPart(300);
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger4, "zrotate", -90));
                playAnimationPart(300);
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger5, "zrotate", -90));
                playAnimationPart(300);
                
//                mAnimationPartFX = new ArrayList<>();
//                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "zrotate", -40));
//                playAnimationPart(300);
                
                
//                
//                mAnimationPartFX = new ArrayList<>();
//                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mBodyFX, "yrotate", 90));
//                playAnimationPart(200);

	}
}
