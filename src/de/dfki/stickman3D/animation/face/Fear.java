/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.common.Gender;
import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

/**
 *
 * @author Beka
 *
 */
public class Fear extends Animation3D {

    public Fear() {
        mAnimType = ANIMTYPE.ON;
    }

    public Fear(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // fear
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouthFX, "shape", "FEAR"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyebrowFX, "shape", "SAD"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyebrowFX, "shape", "SAD"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "rotate", 20));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            // Left Hand
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "rotate", -60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "zrotate", -80));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "rotate", -105));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "zrotate", -30));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", -130));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "rotate", 20));

            // Right Hand
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", -60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "zrotate", 80));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", -95));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "zrotate", 30));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", 130));

        } else {
            // Left Hand
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "rotate", -60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "zrotate", -60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "rotate", -105));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "zrotate", -25));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", -200));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "rotate", 20));

            // Right Hand
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", -60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "zrotate", 60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", -100));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "zrotate", 25));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", 200));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", 20));
        }
        playAnimationPart(mDuration);

        // pauseAnimation(1200);
        // mAnimationPartFX = new ArrayList<>();
        // mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX,
        // "yrotate", 90));
        // mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody,
        // "yrotate", 90));
        // playAnimationPart(500);
        pauseAnimation(1200);

        // no fear
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouthFX, "shape", "FEAREND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyebrowFX, "shape", "SADEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyebrowFX, "shape", "SADEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "rotate", -20));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            // Left Hand
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "rotate", 60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "zrotate", 80));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "rotate", 105));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "zrotate", 30));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", 130));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "rotate", -20));

            // Right Hand
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", 60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "zrotate", -80));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", 95));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "zrotate", -30));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", -130));
        } else {
            // Left Hand
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "rotate", 60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "zrotate", 60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "rotate", 105));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "zrotate", 25));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", 200));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "rotate", -20));

            // Right Hand
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", 60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "zrotate", -60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", 100));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "zrotate", -25));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", -200));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", -20));

        }
        playAnimationPart(mDuration);

        // pauseAnimation(1200);
        // mAnimationPartFX = new ArrayList<>();
        // mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX,
        // "yrotate", -90));
        // mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody,
        // "yrotate", -90));
        // playAnimationPart(500);
        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
