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
public class Itching extends Animation {

	public Itching() {
		mAnimType = ANIMTYPE.ON;
	}

	public Itching(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		int rotationUnit = 16;

		// bring upper arm and fore arm in position
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "zrotate", -30));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -40));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "zrotate", 70));

		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", 10));
		playAnimationPart(mDuration);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger2, "zrotate", 8));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger4, "zrotate", -8));
		playAnimationPart(50);

		for (int i = 0; i < 4; i++) {
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "rotate", 10));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger2, "rotate", 60));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger3, "rotate", 70));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger4, "rotate", 80));
			playAnimationPart(200);

			pauseAnimation(200);

			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "rotate", -10));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger2, "rotate", -60));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger3, "rotate", -70));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger4, "rotate", -80));
			playAnimationPart(200);
		}

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger2, "zrotate", -8));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger4, "zrotate", 8));
		playAnimationPart(50);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "zrotate", 30));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", 40));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "zrotate", -70));

		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", -10));

		playAnimationPart(mDuration);

		if (StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);

	}
}
