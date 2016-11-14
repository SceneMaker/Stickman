/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.headfx;

import java.util.ArrayList;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanStageController;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;

/**
 *
 * @author Beka
 *
 */
public class HeadTilt extends AnimationFX 
{
	public HeadTilt() {
		mAnimType = ANIMTYPE.ON;
	}

    public HeadTilt(StickmanFX sm, int duration, boolean block) 
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
    	
    	mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "zrotate", -10));
		playAnimationPart(mDuration);
		
		pauseAnimation(1000);
		
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "zrotate", 10));
		playAnimationPart(mDuration);
		
		if(StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);
    }
}
