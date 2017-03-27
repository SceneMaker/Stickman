/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.face;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.animationlogic.AnimationContentReeti;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author Beka
 *
 */
public class Sad extends AnimationReeti {

    public Sad() {
        mAnimType = ANIMTYPE.ON;
    }

    public Sad(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // sad
//        Color c1 = Color.rgb(102, 0, 154);
//        Color c2 = Color.rgb(102, 0, 154);
//        Color c3 = Color.rgb(102, 0, 154);
//        mReeti.setLedColor("violet");
//        
//        mReeti.mMouth.setUpRegulator(-8);
//        mReeti.mMouth.setDownRegulator(-4);
//        mReeti.mRightEar.setRegulator(-50);
//        mReeti.mLeftEar.setRegulator(50);
//        
//        mAnimationPartFX = new ArrayList<>();
        mReeti.leftEyeLid(60);
        mReeti.rightEyeLid(60);
        mReeti.leftEyePan(15);
        mReeti.rightEyePan(15);
        mReeti.setLedColor("violet");
        mReeti.leftEar(0);
        mReeti.rightEar(0);
        mReeti.rightLC(0);
        mReeti.leftLC(0);
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mLeftEyelid, "rotate", 60));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEyelid, "rotate", 60));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mLeftEye, "rotate", 15));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEye, "rotate", 15));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEar, "zrotate", mReeti.mRightEar.getRegulator()));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mLeftEar, "zrotate", mReeti.mLeftEar.getRegulator()));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mMouth, "shape", "MOUTHACTION"));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mHead, "rotate", 10));
//        playAnimationPart(500);
        
//        pauseAnimation(2000);
//        // no sad
//        mReeti.setLedColor("stop");
//        mAnimationPartFX = new ArrayList<>();
//        mReeti.leftEyeLid(100);
//        mReeti.rightEyeLid(100);
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mLeftEyelid, "rotate", -60));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEyelid, "rotate", -60));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mLeftEye, "rotate", -15));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEye, "rotate", -15));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEar, "zrotate", -mReeti.mRightEar.getRegulator()));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mLeftEar, "zrotate", -mReeti.mLeftEar.getRegulator()));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mMouth, "shape", "MOUTHACTIONEND"));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mHead, "rotate", -10));
//        playAnimationPart(500);
        

        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
