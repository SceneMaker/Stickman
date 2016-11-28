/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.environment;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.Animation;
import de.dfki.stickmanSwing.animationlogic.AnimationContent;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class FadeOut extends Animation {

    private StickmanSwing mStickman;

    public FadeOut(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickman = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation() {
        // bring upper arm and fore arm in position	
        int rotationUnit = 10;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperArm, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationUnit * 16));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", rotationUnit * 16));
        playAnimationPart(200);
        pauseAnimation(100);

        // wave right
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", -rotationUnit * 4));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationUnit * 4));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        // wave right
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", -rotationUnit * 4));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationUnit * 4));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", rotationUnit * 4));
        playAnimationPart(100);

//		star fade in
        mStickman.starShowC = true;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mStars, "shape", "STARSFADEIN"));
        playAnimationPart(200);

        //make body fade out
        mStickman.setCharacterInvisible = true;
        mStickman.fadeControler = true;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickman.mRightLeg, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftLeg, "shape", "DEFAULT"));
        mAnimationPart.add(new AnimationContent(mStickman.mNeck, "shape", "DEFAULT"));
        playAnimationPart(1000);

        // stars fade out
        mStickman.starShowControler = true;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mStars, "shape", "STARSFADEOUT"));
        playAnimationPart(1000);

        // arm go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperArm, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", -rotationUnit * 16));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", -rotationUnit * 16));
        playAnimationPart(2);

//		mStickman.setCharacterInvisible = false;
        mStickman.starShowControler = false;
        mStickman.starShowC = false;
    }
}
