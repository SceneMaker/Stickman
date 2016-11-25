package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class Mouth_SEVEN extends Animation {

	public Mouth_SEVEN(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// smile
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "SEVEN"));
		playAnimationPart(20);
	}
}
