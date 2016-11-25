/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.head;

import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;

/**
 *
 * @author Patrick Gebhard
 *
 */
//////////// nod 3 time by Beka
public class No extends Animation {

	public No() {
		mAnimType = ANIMTYPE.ON;
	}

	public No(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "yrotate", 10));
				playAnimationPart(200);
			} else if (i == 5) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "yrotate", -10));
				playAnimationPart(200);
			} else if (i % 2 == 1) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "yrotate", -20));
				playAnimationPart(200);
			} else {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "yrotate", 20));
				playAnimationPart(200);
			}
		}

		if (StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);
	}
}
