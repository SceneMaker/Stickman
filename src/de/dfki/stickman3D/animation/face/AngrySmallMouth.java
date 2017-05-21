/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class AngrySmallMouth extends Animation3D {

    public AngrySmallMouth() {
        mAnimType = ANIMTYPE.ON;
    }

    public AngrySmallMouth(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // angry
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouthFX, "shape", "ANGRYSMALLMOUTH"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyeFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mFaceWrinkleFX, "shape", "ANGRY"));   ///Add by Robbie
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyeFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyebrowFX, "shape", "ANGRY"));
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no angry
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouthFX, "shape", "ANGRYSMALLMOUTHEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mFaceWrinkleFX, "shape", "ANGRYEND"));   ///Add by Robbie
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyeFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyebrowFX, "shape", "ANGRYEND"));
        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
