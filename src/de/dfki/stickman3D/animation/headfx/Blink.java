/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.headfx;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContentFX;
import de.dfki.stickman3D.animationlogic.AnimationFX;

import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Blink extends AnimationFX 
{

	public Blink() {
		mAnimType = ANIMTYPE.ON;
	}
	
	public Blink(Stickman3D sm, int duration, boolean block)
        {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "BLINK"));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "BLINK"));
		playAnimationPart(20);
		
		 pauseAnimation(300);

		 //blink up
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "BLINKEND"));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "BLINKEND"));
		playAnimationPart(20);
		
		StickmanStageController.currentRadioButton.setSelected(false);
	}
}
