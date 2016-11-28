/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.facefx;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class ContemptEnd extends Animation3D
{

	public ContemptEnd(Stickman3D sm, int duration, boolean block)
        {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// Contempt end
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouthFX, "shape", "CONTEMPTEND"));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyeFX, "shape", "CONTEMPTEND"));
		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyeFX, "shape", "CONTEMPTEND"));
		playAnimationPart(mDuration);

		pauseAnimation(10);
	}
}
