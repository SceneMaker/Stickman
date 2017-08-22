/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Angry extends AnimationStickman3D
{

    public Angry()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Angry(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation()
    {
        // angry
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mFaceWrinkle, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "ANGRY"));
        playAnimationPart(mDuration);

        pauseAnimation(1000);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mFaceWrinkle, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "ANGRYEND"));
        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
