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
 *
 * @author Beka
 *
 */
public class Clap extends Animation3D {

	public Clap() {
		mAnimType = ANIMTYPE.ON;
	}

	public Clap(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "rotate", -30));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", -30));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "rotate", -70));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", -90));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", -120));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", -10));
		playAnimationPart(500);

		for (int i = 0; i < 10; i++) {
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "zrotate", 10));
			mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "zrotate", -15));
			mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", 17));
			playAnimationPart(200);

			pauseAnimation(100);

			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "zrotate", -10));
			mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "zrotate", 15));
			mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", -17));
			playAnimationPart(200);
		}

		pauseAnimation(1000);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "rotate", 30));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", 30));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "rotate", 70));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", 90));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", 120));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", 10));
		playAnimationPart(500);

                if(StickmanStageController.currentRadioButton!=null)
                    StickmanStageController.currentRadioButton.setSelected(false);

	}

}
