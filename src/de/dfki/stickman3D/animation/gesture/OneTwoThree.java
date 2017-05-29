/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class OneTwoThree extends Animation3D {

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

	public OneTwoThree() {
		mAnimType = ANIMTYPE.ON;
	}

	public OneTwoThree(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	/**
	 * This method creates the angry facial movement.
	 */
	@Override
	public void playAnimation() {

		mAnimationPartFX = new ArrayList<>();
		// LeftHand Up
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "rotate", -30));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "zrotate", 23));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", -105));

		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "rotate", 130));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger3, "rotate", 130));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger1, "zrotate", 20));

		// RightHand Up
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "rotate", -58));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", -5));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", 10));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "rotate", -10));

		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "rotate", 25));
		playAnimationPart(500);

		// One
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", -3));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", 30));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger4, "rotate", 130));
		playAnimationPart(500);
		pauseAnimation(500);
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", 3));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", -30));
		playAnimationPart(500);

		pauseAnimation(200);

		// Two
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", -7));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", 30));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger3, "rotate", 130));

		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "LOOKUP"));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "LOOKUP"));
		playAnimationPart(500);
		pauseAnimation(500);
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", 7));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", -30));
		playAnimationPart(500);

		pauseAnimation(200);

		// Three
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", -10));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", 30));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger2, "rotate", 130));
		playAnimationPart(500);
		pauseAnimation(500);
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", 10));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", -30));

		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "LOOKUPEND"));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "LOOKUPEND"));
		playAnimationPart(500);

		pauseAnimation(500);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger4, "rotate", -130));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger3, "rotate", -130));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger2, "rotate", -130));
		// LeftHand Down
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "rotate", 30));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "zrotate", -23));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", 105));

		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "rotate", -130));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger3, "rotate", -130));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger1, "zrotate", -20));
		// RightHand Down
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "rotate", 60));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", 5));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", -10));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "rotate", 10));

		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "rotate", -25));
		playAnimationPart(500);

                if(StickmanStageController.currentRadioButton != null)
                    StickmanStageController.currentRadioButton.setSelected(false);
	}
}
