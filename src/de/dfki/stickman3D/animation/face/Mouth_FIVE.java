package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;

import java.util.ArrayList;
import javafx.application.Platform;

/**
 *
 * @author Beka
 *
 */
public class Mouth_FIVE extends Animation {

	public Mouth_FIVE(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	public void playAnimation() {
		// smile
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "FIVE"));
		playAnimationPart(20);
	}
}
