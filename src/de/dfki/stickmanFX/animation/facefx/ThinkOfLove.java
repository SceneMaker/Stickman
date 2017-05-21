package de.dfki.stickmanFX.animation.facefx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;

import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class ThinkOfLove extends AnimationFX {

    public ThinkOfLove() {
        mAnimType = ANIMTYPE.EmotionExpression;
    }

    public ThinkOfLove(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        int rotationUnit = 10;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mThinkFX, "shape", "THINKOFLOVE"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SMILE"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "BLINK"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "BLINK"));

        playAnimationPart(mDuration);
        pauseAnimation(2000);

        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mThinkFX, "shape", "THINKOFLOVEEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SMILEEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "DEFAULT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "DEFAULT"));
        playAnimationPart(mDuration);

    }
}
