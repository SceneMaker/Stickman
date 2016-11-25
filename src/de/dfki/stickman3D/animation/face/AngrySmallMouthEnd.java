/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;

import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AngrySmallMouthEnd extends Animation {

	public AngrySmallMouthEnd(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// angry with small mouth end
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "ANGRYSMALLMOUTHEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRYEND"));
		// mAnimationPartFX.add(new AnimationContent(mStickmanFX.mFaceWrinkle,
		// "shape", "ANGRYEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "ANGRYEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "ANGRYEND"));
		playAnimationPart(mDuration);

		pauseAnimation(10);
	}
}
