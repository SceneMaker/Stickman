/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment.event;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.EventAnimation;
import de.dfki.stickman3D.environment.SpeechBubble;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class Speaking extends EventAnimation {

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
		mAnimationPartFX.add(
				new AnimationContent(mStickmanFX.mSpeechBubbleFX, "shape", SpeechBubble.SHAPE.SPEAK.name(), mWTS));

		playEventAnimationPart();

		mAnimationPartFX
				.add(new AnimationContent(mStickmanFX.mSpeechBubbleFX, "shape", SpeechBubble.SHAPE.DEFAULT.name()));
		playAnimationPart(20);

	}
}
