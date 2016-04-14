package de.dfki.stickman.animation.face;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;


import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Mouth_FIVE extends Animation {

	public Mouth_FIVE(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	public void playAnimation() {
		// smile
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "FIVE"));
		playAnimationPart(20);
	}
}
