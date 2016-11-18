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
public class HeadShake extends AnimationFX {
	public HeadShake() {
		mAnimType = ANIMTYPE.ON;
	}

	public HeadShake(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
		this.mStickmanFX = sm;
	}

	@Override
	public void playAnimation() {

		// shaking head 4 times
		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "zrotate", -10));
				playAnimationPart(200);
			} else if (i == 5) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "zrotate", 10));
				playAnimationPart(200);
			} else if (i % 2 == 1) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "zrotate", 20));
				playAnimationPart(400);
			} else {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "zrotate", -20));
				playAnimationPart(400);
			}
		}

		if (StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);
	}

}
