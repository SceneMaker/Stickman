package de.dfki.stickman3D.animation.face;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class ThinkOfLove extends Animation3D {

//	public ThinkOfLove() {
//		mAnimType = ANIMTYPE.ON;
//	}
    public ThinkOfLove(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        int rotationUnit = 10;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mThinkFX, "shape", "THINKOFLOVE"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouthFX, "shape", "SMILE"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyeFX, "shape", "BLINK"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyeFX, "shape", "BLINK"));

        playAnimationPart(mDuration);
        pauseAnimation(2000);

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mThinkFX, "shape", "THINKOFLOVEEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouthFX, "shape", "SMILEEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyeFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyeFX, "shape", "DEFAULT"));
        playAnimationPart(mDuration);

    }
}
