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
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class NoNoNo extends Animation {

	/**
	 *
	 * @param sm
	 *            Stickman
	 * @param duration
	 *            Control the speed of the movement from one emotion state to
	 *            another emotion state.
	 * @param block
	 *            block or not the others movements, when one movement is not
	 *            finished.
	 */

	public NoNoNo() {
		mAnimType = ANIMTYPE.ON;
	}

	public NoNoNo(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	/**
	 * This method creates the angry facial movement.
	 */
	@Override
	public void playAnimation() {
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "rotate", -100));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", -60));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", -50));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", 135));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger3, "rotate", 135));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger1, "zrotate", 40));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger1, "rotate", 35));

		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRY"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "ANGRY"));
		playAnimationPart(500);

		pauseAnimation(200);

		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "zrotate", -30));
				mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "yrotate", 10));
				playAnimationPart(500);
			} else if (i == 5) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "zrotate", 30));
				mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "yrotate", -10));
				playAnimationPart(500);
			} else if (i % 2 == 1) {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "zrotate", 60));
				mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "yrotate", -20));
				playAnimationPart(500);
			} else {
				mAnimationPartFX = new ArrayList<>();
				mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "zrotate", -60));
				mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "yrotate", 20));
				playAnimationPart(500);
			}

		}

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "rotate", 100));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", 60));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", 50));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", -135));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger3, "rotate", -135));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger1, "zrotate", -40));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger1, "rotate", -35));

		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRYEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "ANGRYEND"));
		playAnimationPart(500);

		StickmanStageController.currentRadioButton.setSelected(false);
	}
}