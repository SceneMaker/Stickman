/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.environmentfx;

import java.util.ArrayList;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanStageController;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX.ANIMTYPE;
import javafx.application.Platform;

/**
 *
 * @author Beka
 *
 */
public class FadeOut extends AnimationFX {

	public FadeOut() {
		mAnimType = ANIMTYPE.ON;
	}
	public FadeOut(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
		mStickmanFX = sm;
	}

	// WaveLeft
	@Override
	public void playAnimation() {
		
		mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "FADEIN"));
        playAnimationPart(500);
		StickmanStageController.currentRadioButton.setSelected(false);
	}
}
