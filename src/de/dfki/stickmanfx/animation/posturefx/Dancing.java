/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.posturefx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanFX.TYPE;
import de.dfki.stickmanfx.StickmanStageController;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import java.util.ArrayList;
import javafx.application.Platform;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Dancing extends AnimationFX {

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

	public Dancing() {
		mAnimType = ANIMTYPE.ON;
	}

	public Dancing(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	/**
	 * This method creates the angry facial movement.
	 */
	@Override
	public void playAnimation() {

		// mAnimationPartFX = new ArrayList<>();
		// mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody,
		// "yrotate", -90));
		// playAnimationPart(500);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -40));
		if (mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "zrotate", -110));
		else
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "zrotate", -30));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", -40));
		if (mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "zrotate", 110));
		else
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "zrotate", 30));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", -60));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", 40));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", -60));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", -40));

		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", 110));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "yrotate", -110));

		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger1, "rotate", 20));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger1, "zrotate", -50));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger4, "rotate", 130));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger4, "zrotate", 45));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger3, "zrotate", -10));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger2, "zrotate", 10));

		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger1, "rotate", 20));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger1, "zrotate", 50));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger4, "rotate", 130));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger4, "zrotate", -45));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger3, "zrotate", 10));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger2, "zrotate", -10));
		playAnimationPart(500);

		pauseAnimation(500);

		for (int i = 0; i < 20; i++) {
			mAnimationPartFX = new ArrayList<>();
			if (mStickmanFX.mType == StickmanFX.TYPE.MALE) {
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", -30));
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -30));
			} else {
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", -10));
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", -10));
			}
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "rotate", 5));
			if (i == 3)
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "yrotate", 30));
			if (i > 3) {
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", 10));
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", -50));
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", 50));
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mDownBody, "rotate", 10));
			}

			if (i == 6) {
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "TWO"));
			}
			if (i == 13) {
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SMILE"));
			}
			playAnimationPart(200);

			mAnimationPartFX = new ArrayList<>();
			if (mStickmanFX.mType == StickmanFX.TYPE.MALE) {
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", 30));
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", 30));
			} else {
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", 10));
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", 10));
			}
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "rotate", -5));
			if (i > 3) {
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", -10));
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", 50));
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", -50));
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mDownBody, "rotate", -10));
			}
			if (i == 12) {
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "DEFAULT"));
			}
			if (i == 17) {
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SMILEEND"));
			}
			if (i == 19)
				mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "yrotate", -30));
			playAnimationPart(200);

		}

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "rotate", 40));
		if (mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "zrotate", 110));
		else
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "zrotate", 30));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", 40));
		if (mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "zrotate", -110));
		else
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "zrotate", -30));

		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", 60));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "zrotate", -40));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "rotate", 60));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "zrotate", 40));

		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "yrotate", -110));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "yrotate", 110));

		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger1, "rotate", -20));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger1, "zrotate", 50));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger4, "rotate", -130));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger4, "zrotate", -45));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger3, "zrotate", 10));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger2, "zrotate", -10));

		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger1, "rotate", -20));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger1, "zrotate", -50));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger4, "rotate", -130));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger4, "zrotate", 45));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger3, "zrotate", -10));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger2, "zrotate", 10));
		playAnimationPart(500);

		// mAnimationPartFX = new ArrayList<>();
		// mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody,
		// "yrotate", 90));
		// playAnimationPart(500);

		StickmanStageController.currentRadioButton.setSelected(false);
	}
}
