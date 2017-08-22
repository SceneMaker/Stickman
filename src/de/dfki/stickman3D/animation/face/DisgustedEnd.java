/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class DisgustedEnd extends AnimationStickman3D
{

    public DisgustedEnd(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // no disgusted
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "DISGUSTEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "DISGUSTEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "DISGUSTEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "DISGUSTEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "DISGUSTEDEND"));
        playAnimationPart(20);

        pauseAnimation(10);
    }
}
