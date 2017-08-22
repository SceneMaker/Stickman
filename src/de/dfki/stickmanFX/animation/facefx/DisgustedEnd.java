/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.facefx;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;

import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class DisgustedEnd extends AnimationStickman2D
{

    public DisgustedEnd()
    {
        super();
    }

    public DisgustedEnd(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // no disgusted
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mMouthFX, "shape", "DISGUSTEDEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyeFX, "shape", "DISGUSTEDEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mLeftEyebrowFX, "shape", "DISGUSTEDEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyeFX, "shape", "DISGUSTEDEND"));
        mAnimationPart.add(new AnimationContent(((StickmanFX) agent).mRightEyebrowFX, "shape", "DISGUSTEDEND"));
        playAnimationPart(20);

        pauseAnimation(10);
    }
}
