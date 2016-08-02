package de.dfki.stickmanfx.animation.facefx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import java.util.ArrayList;
import javafx.application.Platform;

/**
 *
 * @author Beka
 *
 */
public class Mouth_FIVE extends AnimationFX {

	public Mouth_FIVE(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	public void playAnimation() {
		// smile
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "FIVE"));
		playAnimationPart(20);
	}
}
