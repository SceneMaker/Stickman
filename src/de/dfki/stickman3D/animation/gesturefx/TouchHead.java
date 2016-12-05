/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesturefx;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class TouchHead extends Animation3D {

    public TouchHead() {
        mAnimType = ANIMTYPE.ON;
    }

    public TouchHead(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

//		mAnimationPartFX = new ArrayList<>();
//		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody, "yrotate", -90));
//		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "yrotate", -90));
//		playAnimationPart(500);
        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", -100));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "zrotate", 100));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", -88));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", 180));
            playAnimationPart(500);
        } else {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", -100));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "zrotate", 65));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", -88));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", 240));
            playAnimationPart(500);
        }

        for (int i = 0; i < 4; i++) {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", -5));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "rotate", 40));
            playAnimationPart(100);

            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", -5));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger3, "rotate", 70));
            playAnimationPart(100);

            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", -5));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger2, "rotate", 70));
            playAnimationPart(100);

            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", 5));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger3, "rotate", -70));
            playAnimationPart(100);

            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", 5));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger2, "rotate", -70));
            playAnimationPart(100);

            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", 5));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "rotate", -40));
            playAnimationPart(100);
        }

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", 100));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "zrotate", -100));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", 88));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", -180));
            playAnimationPart(500);
        } else {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", 100));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "zrotate", -65));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "rotate", 88));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", -240));
            playAnimationPart(500);
        }

//		mAnimationPartFX = new ArrayList<>();
//		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody, "yrotate", 90));
//		mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "yrotate", 90));
//		playAnimationPart(500);
    }
}
