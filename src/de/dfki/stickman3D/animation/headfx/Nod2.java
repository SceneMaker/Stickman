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
 * @author Patrick Gebhard
 *
 */
////////////nod 3 time by Guo
public class Nod2 extends AnimationFX
{

	public Nod2() {
		mAnimType = ANIMTYPE.ON;
	}
	
	public Nod2(Stickman3D sm, int duration, boolean block)
	{
		super(sm, duration, block);
	}

	@Override
	public void playAnimation()
	{
		for (int i = 0; i < 6; i++)
		{
			if(i == 0)
			{
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", 10));
				playAnimationPart(200);
			}
			else if(i == 5)
			{
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", -10));
				playAnimationPart(200);
			}
			else if(i % 2 == 1)
			{
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", -20));
				playAnimationPart(200);
			}
			else
			{
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", 20));
				playAnimationPart(200);
			}
		}
		
		StickmanStageController.currentRadioButton.setSelected(false);
	}
}
