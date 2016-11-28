/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesturefx;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContentFX;
import de.dfki.stickman3D.animationlogic.AnimationFX;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class OneTwoThree extends AnimationFX 
{

    /**
     *
     * @param sm StickmanSwing
     * @param duration Control the speed of the movement from one emotion state
     * to another emotion state.
     * @param block block or not the others movements, when one movement is not
     * finished.
     */
	
	public OneTwoThree() {
		mAnimType = ANIMTYPE.ON;
	}
	
    public OneTwoThree(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation() 
    {
        
    	mAnimationPartFX = new ArrayList<>();
    	//LeftHand Up
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -30));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", 25));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "yrotate", -160));
        
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger4, "rotate", 130));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger3, "rotate", 130));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger1, "zrotate", 20));
        
        //RightHand Up
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", -60));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", -5));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", 60));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -10));
        
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", 25));
        playAnimationPart(500);
        
        //One
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", -3));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", 30));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger4, "rotate", 130));
        playAnimationPart(500);
        pauseAnimation(500);
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", 3));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", -30));
        playAnimationPart(500);
        
        pauseAnimation(200);
        
        //Two
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", -7));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", 30));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger3, "rotate", 130));
        
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "LOOKUP"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "LOOKUP"));
        playAnimationPart(500);
        pauseAnimation(500);
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", 7));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", -30));
        playAnimationPart(500);
        
        pauseAnimation(200);
        
        //Three
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", -10));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", 30));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger2, "rotate", 130));
        playAnimationPart(500);
        pauseAnimation(500);
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", 10));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "rotate", -30));
        
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "LOOKUPEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "LOOKUPEND"));
        playAnimationPart(500);
        
        pauseAnimation(500);
        
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger4, "rotate", -130));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger3, "rotate", -130));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger2, "rotate", -130));
        //LeftHand Down
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", 30));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", -25));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "yrotate", 160));
        
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger4, "rotate", -130));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger3, "rotate", -130));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger1, "zrotate", -20));
        //RightHand Down
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", 60));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", 5));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", -60));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", 10));
        
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", -25));
        playAnimationPart(500);
        
        StickmanStageController.currentRadioButton.setSelected(false);
    }
}
