/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.environmentfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import javafx.application.Platform;

/**
 *
 * @author Robbie
 *This is used when ZoomIn is used to only show a head of the stickman
 */
public class MoveRight extends AnimationFX {

    private StickmanFX mStickmanFX;

    public MoveRight(StickmanFX sm, int duration, boolean block) {
	super(sm, duration, block);
	mStickmanFX = sm;
    }

    @Override
    public void playAnimation() {
	int speed = -4;
	//distance to move up
	mStickmanFX.leftSpeed = -64;
	
	// Move up slowly
	for (int i = 0; i < 16; i++) {
	    playMoveSpeed(speed);
	    pauseAnimation(40);
	}
    }

    private void playMoveSpeed(int Speed) {
	if (mStickmanFX.leftSpeed < 0) {
	    mStickmanFX.leftSpeed = mStickmanFX.leftSpeed - Speed;
	} else {
	    mStickmanFX.leftSpeed = 0;
	}
	Platform.runLater(() -> mStickmanFX.update());
    }
}
