/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.headfx;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class HeadShake extends Animation3D
{
	public HeadShake() {
		mAnimType = ANIMTYPE.ON;
	}
	public HeadShake(Stickman3D sm, int duration, boolean block)
	{
		super(sm, duration, block);
		this.mStickmanFX = sm;
	}

	@Override
	public void playAnimation() {

		// shaking head 4 times
		for (int i = 0; i < 6; i++) {
			if(i == 0)
			{
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "zrotate", -10));
				playAnimationPart(200);
			}
			else if(i == 5)
			{
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "zrotate", 10));
				playAnimationPart(200);
			}
			else if(i % 2 == 1)
			{
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "zrotate", 20));
				playAnimationPart(400);
			}
			else 
			{
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "zrotate", -20));
				playAnimationPart(400);
			}
		}


	}

}
