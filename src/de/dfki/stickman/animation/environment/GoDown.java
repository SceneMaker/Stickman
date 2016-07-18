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
public class GoDown extends Animation {

    private Stickman mStickman;

    public GoDown(Stickman sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickman = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation() {
        int rotationUnit = 5;
        int speed = 4;

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperArm, "rotate", rotationUnit * 2));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationUnit * 32));
        //mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger1, "rotate", rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger2, "rotate", rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger3, "rotate", rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", rotationUnit * 32));
        
        playAnimationPart(200);

        for (int i = 0; i < 8; i++) {
            // wave right		
            for (int j = 0; j < 8; j++) {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", -rotationUnit));
                //mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger1, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger2, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger3, "rotate", -rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", -rotationUnit));

                mStickman.leaveSpeed = mStickman.leaveSpeed + speed;
                playAnimationPart(20);
            }

            // wave left
            for (int j = 0; j < 8; j++) {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationUnit));
                //mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger1, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger2, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger3, "rotate", rotationUnit));
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", rotationUnit));

                mStickman.leaveSpeed = mStickman.leaveSpeed + speed;
                playAnimationPart(20);
            }
        }

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperArm, "rotate", -rotationUnit * 2));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", -rotationUnit * 32));
        //mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", -rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger1, "rotate", -rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger2, "rotate", -rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger3, "rotate", -rotationUnit * 32));
        mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", -rotationUnit * 32));
        playAnimationPart(20);
    }

}
