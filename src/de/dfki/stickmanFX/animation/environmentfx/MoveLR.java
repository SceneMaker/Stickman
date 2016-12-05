/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;
import javafx.application.Platform;

/**
 *
 * @author Robbie
 *
 */
public class MoveLR extends AnimationFX {

    private StickmanFX mStickmanFX;
    private double hdistance = 0;

    public MoveLR(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    @Override
    public void playAnimation() {

        String sParameter = (String) mParameter;
        sParameter = sParameter.trim();

        try {
            hdistance = Double.parseDouble(sParameter);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        //move down slowly
        double speedUnit = (hdistance - mStickmanFX.hoffset) / 10;

        if (speedUnit >= 0) {
            for (int i = 0; i < 10; i++) {
                mStickmanFX.hoffset = mStickmanFX.hoffset + speedUnit;
                if (mStickmanFX.hoffset >= hdistance) {
                    mStickmanFX.hoffset = hdistance;
                }
                Platform.runLater(() -> mStickmanFX.update());
                pauseAnimation(40);
            }

            if (mStickmanFX.hoffset < hdistance) {
                mStickmanFX.hoffset = hdistance;
                Platform.runLater(() -> mStickmanFX.update());
            }
        }

        if (speedUnit < 0) {
            for (int i = 0; i < 10; i++) {
                mStickmanFX.hoffset = mStickmanFX.hoffset + speedUnit;
                if (mStickmanFX.hoffset <= hdistance) {
                    mStickmanFX.hoffset = hdistance;
                }
                Platform.runLater(() -> mStickmanFX.update());
                pauseAnimation(40);
            }

            if (mStickmanFX.hoffset > hdistance) {
                mStickmanFX.hoffset = hdistance;
                Platform.runLater(() -> mStickmanFX.update());
            }
        }

    }

}
