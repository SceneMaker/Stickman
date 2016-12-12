/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.facefx;

import de.dfki.common.Gender;
import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class Angry3 extends Animation3D {

    Stickman3D mStickmanFX;
    int rotationUnit;

    public Angry3() {
        mAnimType = ANIMTYPE.ON;
    }

    /**
     *
     * @param sm Stickman
     * @param duration Control the speed of the movement from one emotion state
     * to another emotion state.
     * @param block block or not the others movements, when one movement is not
     * finished.
     */
    public Angry3(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation() {
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mFaceWrinkleFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyeFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyebrowFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyeFX, "shape", "ANGRY"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouthFX, "shape", "ANGRY"));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "rotate", -45));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "zrotate", -10));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "rotate", -20));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "yrotate", -25));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "zrotate", 110));

        if (mStickmanFX.mType == Gender.TYPE.FEMALE) {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "rotate", 20));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger1, "zrotate", -20));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger2, "rotate", 90));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger3, "rotate", 90));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger4, "rotate", 90));
        } else {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger1, "zrotate", -20));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger2, "rotate", 70));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger3, "rotate", 70));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger4, "rotate", 70));

        }

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", -40));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "zrotate", 10));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "yrotate", 10));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "zrotate", -120));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", -60));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", -30));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "zrotate", 20));

        if (mStickmanFX.mType == Gender.TYPE.FEMALE) {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger2, "rotate", 120));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger3, "rotate", 120));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "rotate", 120));
        } else {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger2, "rotate", 50));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger3, "rotate", 50));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "rotate", 50));
        }

        playAnimationPart(500);

        // foot
        for (int i = 0; i < 8; i++) {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFootFX, "rotate", 40));
            playAnimationPart(200);

            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFootFX, "rotate", -40));
            playAnimationPart(200);
        }

        // Head
        for (int i = 0; i < 7; i++) {
            mAnimationPartFX = new ArrayList<>();
            if (i == 0 || i == 6) {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "yrotate", -10));
            } else if (i % 2 == 1) {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "yrotate", 20));
            } else if (i % 2 == 0) {
                mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "yrotate", -20));
            }
            playAnimationPart(200);
        }

        pauseAnimation(1000);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mFaceWrinkleFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyebrowFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyeFX, "shape", "ANGRYEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouthFX, "shape", "ANGRYEND"));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "rotate", 45));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "zrotate", 10));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "rotate", 20));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "yrotate", 25));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "zrotate", -110));

        if (mStickmanFX.mType == Gender.TYPE.FEMALE) {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "rotate", -20));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger1, "zrotate", 20));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger2, "rotate", -90));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger3, "rotate", -90));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger4, "rotate", -90));
        } else {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger1, "zrotate", 20));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger2, "rotate", -70));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger3, "rotate", -70));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger4, "rotate", -70));
        }

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "rotate", 40));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "zrotate", -10));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "yrotate", -10));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "zrotate", 120));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "rotate", 60));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "yrotate", 30));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "zrotate", -20));

        if (mStickmanFX.mType == Gender.TYPE.FEMALE) {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger2, "rotate", -120));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger3, "rotate", -120));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "rotate", -120));
        } else {
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger2, "rotate", -50));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger3, "rotate", -50));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "rotate", -50));
        }
        playAnimationPart(500);
    }
}
