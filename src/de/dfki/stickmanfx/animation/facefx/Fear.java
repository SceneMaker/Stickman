/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.facefx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanStageController;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class Fear extends AnimationFX {

	public Fear() {
		mAnimType = ANIMTYPE.ON;
	}
	
    public Fear(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // fear
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "FEAR"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "SAD"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "SAD"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", 20));
        
        if(mStickmanFX.mType == StickmanFX.TYPE.MALE)
        {
        	//Left Hand
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -60));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "zrotate", -80));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -107));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", -30));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "yrotate", -180));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "rotate", 20));
	        
	        //Right Hand
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", -60));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "zrotate", 80));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", -95));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", 30));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", 180));
	        
        }
        else
        {
        	//Left Hand
        	mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -60));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "zrotate", -60));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -110));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", -25));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "yrotate", -250));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "rotate", 20));
	        
	        //Right Hand
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", -60));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "zrotate", 60));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", -100));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", 25));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", 250));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", 20));
        }
        playAnimationPart(mDuration);
        
        
//        pauseAnimation(1200);
//        mAnimationPartFX = new ArrayList<>();
//        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "yrotate", 90));
//        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "yrotate", 90));
//        playAnimationPart(500);

        pauseAnimation(1200);

        // no fear
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "FEAREND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "SADEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "SADEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", -20));
        
        if(mStickmanFX.mType == StickmanFX.TYPE.MALE)
        {
        	//Left Hand
        	mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", 60));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "zrotate", 80));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", 107));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", 30));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "yrotate", 180));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "rotate", -20));
            
            //Right Hand
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", 60));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "zrotate", -80));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", 95));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", -30));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", -180));
        }
        else
        {
        	//Left Hand
        	mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", 60));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "zrotate", 60));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", 110));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", 25));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "yrotate", 250));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "rotate", -20));
            
          //Right Hand
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", 60));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "zrotate", -60));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", 100));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", -25));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", -250));
	        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", -20));
	        
        }
        playAnimationPart(mDuration);
        
        
//        pauseAnimation(1200);
//        mAnimationPartFX = new ArrayList<>();
//        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "yrotate", -90));
//        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "yrotate", -90));
//        playAnimationPart(500);
        
        if(StickmanStageController.currentRadioButton != null)
        	StickmanStageController.currentRadioButton.setSelected(false);
    }
}
