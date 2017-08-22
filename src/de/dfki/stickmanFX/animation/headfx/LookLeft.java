package de.dfki.stickmanFX.animation.headfx;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;

import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class LookLeft extends AnimationStickman2D
{

    public LookLeft(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        int translationUnit = 3;

        // look left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyeFX, "shape", "LOOKLEFT"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyeFX, "shape", "LOOKLEFT"));
        playAnimationPart(20);

//		// blink up
//		mAnimationPart = new ArrayList<>();
//		mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "DEFAULT"));
//		mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "DEFAULT"));
//		playAnimationPart(2);
    }
}
