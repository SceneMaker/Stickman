/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environmentfx.event;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContentFX;
import de.dfki.stickman3D.animationlogic.EventAnimationFX;
import de.dfki.stickman3D.environmentfx.SpeechBubbleFX;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class Speaking extends EventAnimationFX {
	
	public Speaking() {
		super();
	}

	public Speaking(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		if (mParameter instanceof WordTimeMarkSequence) {
			mWTS = (WordTimeMarkSequence) mParameter;
		}

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mSpeechBubbleFX, "shape", SpeechBubbleFX.SHAPE.SPEAK.name(), mWTS));

		playEventAnimationPart();

		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mSpeechBubbleFX, "shape", SpeechBubbleFX.SHAPE.DEFAULT.name()));
		playAnimationPart(20);

	}
}
