/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.Animation;
import de.dfki.stickmanSwing.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class SadStart extends Animation {

	public SadStart(StickmanSwing sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// sad start
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "SAD"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "DISGUSTED"));  
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "DISGUSTED")); 
		playAnimationPart(mDuration);

		pauseAnimation(10);
	}
}
