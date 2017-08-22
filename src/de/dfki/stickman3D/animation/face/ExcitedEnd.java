package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class ExcitedEnd extends AnimationStickman3D
{

    public ExcitedEnd(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // no excited
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "EXCITEDEND"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
