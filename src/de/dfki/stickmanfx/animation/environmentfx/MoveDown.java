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
 *
 */
public class MoveDown extends AnimationFX {

    private StickmanFX mStickmanFX;

    public MoveDown(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    @Override
    public void playAnimation() {
        int speed = 4;

        //move down slowly
        for (int i = 0; i < 16; i++) {
                mStickmanFX.leaveSpeed = mStickmanFX.leaveSpeed + speed;
                Platform.runLater(() -> mStickmanFX.update());
                pauseAnimation(40);
        }
    }

}
