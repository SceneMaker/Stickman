/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.face;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import de.dfki.stickman.body.LeftEyebrow;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class.
 * The face moves from the default state to the angry state, and then comes back to the default state.
 * 
 * @author Patrick Gebhard
 */
public class Muster extends Animation {
/**
 * 
 * @param sm Stickman
 * @param duration Control the speed of the movement from one emotion state to another emotion state.
 * @param block block or not the others movements, when one movement is not finished.
 */
	public Muster(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}
	/**
	 * This method creates the angry facial movement.
	 */
	@Override
	public void playAnimation() {
            int rotationUnit = 10;
		// angry
                
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", 20));
                
                playAnimationPart(20);
                
                
                
               pauseAnimation(1200);
              
               
//
//		// no angry
		mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(mStickman.mLeftHandFinger4, "rotate", -20));
//		mStickman.mRightFinger4LengthController = false;
		playAnimationPart(20);
	}
}
