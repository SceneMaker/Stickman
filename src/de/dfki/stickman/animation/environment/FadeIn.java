/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.environment;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class FadeIn extends Animation {

    private Stickman mStickman;

    public FadeIn(Stickman sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickman = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation() {
//		star fade in
        mStickman.starShowControler = true;
        mStickman.starShowC = true;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mStars, "shape", "STARSFADEIN"));
        playAnimationPart(1000);

//		character fade in
		mStickman.starShowControler = false;		
		mStickman.setCharacterInvisible = true;
		mStickman.fadeControler = false;
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "shape", "DEFAULT"));
		//mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "shape", "DEFAULT"));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_1, "shape", "DEFAULT"));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_2, "shape", "DEFAULT"));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_3, "shape", "DEFAULT"));
                mAnimationPart.add(new AnimationContent(mStickman.mRightHandFinger_4, "shape", "DEFAULT"));
//		mAnimationPart.add(new AnimationContent(mStickman.mRightLeg, "shape", "DEFAULT"));
		//mAnimationPart.add(new AnimationContent(mStickman.mLeftLeg, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mNeck, "shape", "DEFAULT"));
		playAnimationPart(1000);	
		mStickman.setCharacterInvisible = false;
		


//		stars fade out
        mStickman.starShowC = true;
        mStickman.setCharacterInvisible = false;
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mStars, "shape", "STARSFADEOUT"));
        playAnimationPart(500);

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
        pauseAnimation(200);

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperArm, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", -rotationUnit * 16));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", -rotationUnit * 16));
        playAnimationPart(20);

        mStickman.setCharacterInvisible = false;
        mStickman.starShowControler = false;
        mStickman.starShowC = false;

    }
}
