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
public class AngryStart extends AnimationStickman3D
{

    public AngryStart(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // angry start
        AnimationStickman3D.isAngryInAction = true;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mFaceWrinkle, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "ANGRY"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
