/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class WaveRight extends Animation3D {

    public WaveRight() {
        mAnimType = ANIMTYPE.ON;
    }

    public WaveRight(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "rotate", -35));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "rotate", -120));
        playAnimationPart(200);

        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", -10));
                playAnimationPart(200);
            } else if (i == 5) {
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", 10));
                playAnimationPart(200);
            } else if (i % 2 == 1) {
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", 20));
                playAnimationPart(200);
            } else {
                mAnimationPartFX = new ArrayList<>();
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "zrotate", -20));
                playAnimationPart(200);
            }
        }

        pauseAnimation(1000);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "rotate", 35));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "rotate", 120));
        playAnimationPart(200);

    }

}
