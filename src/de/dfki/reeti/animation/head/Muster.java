/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.head;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Muster extends AnimationReeti {

    public Muster() {
        mAnimType = ANIMTYPE.ON;
    }

    public Muster(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        Color c1 = Color.rgb(255, 255, 255);
        Color c2 = Color.rgb(255, 0, 255);
        Color c3 = Color.rgb(0, 0, 255);
        mReeti.ledON(c1, c2, c3, 0.7f, 0.9f, 0.4f, "B");
        
        mReeti.mMouth.setUpRegulator(-20);
        mReeti.mMouth.setDownRegulator(-10);
//        mReeti.mMouth.setLeftCornerRegulator(-20);
        
        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContentReeti(mReeti.mLeftEar, "rotate", 60));
//        mAnimationPart.add(new AnimationContentReeti(mReeti.mRightEar, "yrotate", 60));
        mAnimationPart.add(new AnimationContentReeti(mReeti.mMouth, "shape", "MOUTHACTION"));
//        mAnimationPart.add(new AnimationContentReeti(mReeti.mRightEar, "yrotate", 60));
        playAnimationPart(mDuration);

        pauseAnimation(2000);
        mReeti.ledOFF("B");
        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContentReeti(mReeti.mLeftEar, "rotate", -60));
//        mAnimationPart.add(new AnimationContentReeti(mReeti.mRightEar, "yrotate", -60));
        mAnimationPart.add(new AnimationContentReeti(mReeti.mMouth, "shape", "MOUTHACTIONEND"));
        playAnimationPart(mDuration);

        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
