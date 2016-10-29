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
import de.dfki.stickmanfx.environmentfx.SpeechBubbleFX;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Speaking extends AnimationFX {

	public Speaking() {
		mAnimType = ANIMTYPE.ON;
	}
	
	public Speaking(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		if (mParameter instanceof String) {
			mStickmanFX.mSpeechBubbleFX.mText = (String) mParameter;
		}
		// nur zum Testen. Im Normalfall diese Zeile loeschen
		mStickmanFX.mSpeechBubbleFX.mText = "Ich bin in 3D-Welt geborener und mit JavaFX ausgeruesteter Stickman " + mStickmanFX.mName + ". Deswegen sehe ich so toll aus";
		
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mSpeechBubbleFX, "shape", SpeechBubbleFX.SHAPE.SPEAK.name()));
		playAnimationPart(4000);

		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mSpeechBubbleFX, "shape", SpeechBubbleFX.SHAPE.DEFAULT.name()));
		playAnimationPart(20);

		StickmanStageController.currentRadioButton.setSelected(false); // nur zum Testen. Im Normalfall diese Zeile loeschen
	}
}
