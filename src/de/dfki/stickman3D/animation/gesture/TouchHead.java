/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;

/**
 *
 * @author Beka
 *
 */
public class TouchHead extends Animation {

	public TouchHead() {
		mAnimType = ANIMTYPE.ON;
	}

	public TouchHead(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {

		// mAnimationPartFX = new ArrayList<>();
		// mAnimationPartFX.add(new AnimationContent(mStickmanFX.mUpperBody,
		// "yrotate", -90));
		// mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX,
		// "yrotate", -90));
		// playAnimationPart(500);

		if (mStickmanFX.mType == Stickman3D.TYPE.MALE) {
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "rotate", -100));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "zrotate", 100));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "rotate", -88));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", 130));
			playAnimationPart(500);
		} else {
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "rotate", -100));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "zrotate", 65));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "rotate", -88));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", 190));
			playAnimationPart(500);
		}

		for (int i = 0; i < 4; i++) {
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", -5));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", 40));
			playAnimationPart(100);

			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", -5));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger3, "rotate", 70));
			playAnimationPart(100);

			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", -5));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger2, "rotate", 70));
			playAnimationPart(100);

			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", 5));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger3, "rotate", -70));
			playAnimationPart(100);

			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", 5));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger2, "rotate", -70));
			playAnimationPart(100);

			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", 5));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", -40));
			playAnimationPart(100);
		}

		if (mStickmanFX.mType == Stickman3D.TYPE.MALE) {
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "rotate", 100));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "zrotate", -100));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "rotate", 88));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", -130));
			playAnimationPart(500);
		} else {
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "rotate", 100));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "zrotate", -65));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "rotate", 88));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", -190));
			playAnimationPart(500);
		}

		// mAnimationPartFX = new ArrayList<>();
		// mAnimationPartFX.add(new AnimationContent(mStickmanFX.mUpperBody,
		// "yrotate", 90));
		// mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX,
		// "yrotate", 90));
		// playAnimationPart(500);

		if (StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);
	}
}
