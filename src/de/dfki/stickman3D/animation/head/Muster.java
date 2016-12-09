/*
100 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.head;

import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Muster extends Animation {

	public Muster(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "rotate", -10));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "ANGRY"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "ANGRY"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "ANGRYSMALLMOUTH"));

		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "rotate", -45));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "zrotate", -10));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", -20));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "yrotate", -25));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "zrotate", 110));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger1, "zrotate", -20));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger2, "rotate", 70));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger3, "rotate", 70));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger4, "rotate", 70));

		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "rotate", -40));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "zrotate", 10));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "yrotate", 10));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "zrotate", -120));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", -60));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", -30));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "zrotate", 20));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger2, "rotate", 50));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger3, "rotate", 50));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", 50));
		playAnimationPart(500);

		pauseAnimation(1000);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "rotate", 10));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "ANGRYEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "ANGRYSMALLMOUTHEND"));

		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "rotate", 45));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "zrotate", 10));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "rotate", 20));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "yrotate", 25));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "zrotate", -110));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger1, "zrotate", 20));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger2, "rotate", -70));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger3, "rotate", -70));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger4, "rotate", -70));

		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "rotate", 40));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "zrotate", -10));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "yrotate", -10));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "zrotate", 120));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "rotate", 60));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "yrotate", 30));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "zrotate", -20));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger2, "rotate", -50));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger3, "rotate", -50));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger4, "rotate", -50));
		playAnimationPart(500);

	}
}
