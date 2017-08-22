package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class SmileEnd extends AnimationStickman3D
{

    public SmileEnd()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public SmileEnd(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // smile end
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "SMILEEND"));
        playAnimationPart(mDuration);
        AnimationStickman3D.isSmileInAction = false;
        pauseAnimation(10);
    }
}
