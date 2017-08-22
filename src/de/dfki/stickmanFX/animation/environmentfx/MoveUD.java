/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;
import javafx.application.Platform;

/**
 * @author Robbie This is used when ZoomIn is used to only show a head of the
 *         stickmanSwing
 */
public class MoveUD extends AnimationStickman2D
{

    private StickmanFX mStickmanFX;
    private double vdistance = 0;

    public MoveUD(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    @Override
    public void playAnimation()
    {
        //move down slowly
//        for (int i = 0; i < 16; i++) {
//                mStickman.voffset = mStickman.voffset + speed;
//                Platform.runLater(() -> mStickman.update());
//                pauseAnimation(40);
//        }

        String sParameter = (String) mParameter;
        sParameter = sParameter.trim();

        try
        {
            vdistance = Double.parseDouble(sParameter);
        } catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

        //move down slowly
        double speedUnit = (vdistance - mStickmanFX.voffset) / 10;

        if (speedUnit >= 0)
        {
            for (int i = 0; i < 10; i++)
            {
                mStickmanFX.voffset = mStickmanFX.voffset + speedUnit;
                if (mStickmanFX.voffset >= vdistance)
                {
                    mStickmanFX.voffset = vdistance;
                }
                Platform.runLater(() -> mStickmanFX.update());
                pauseAnimation(40);
            }

            if (mStickmanFX.voffset < vdistance)
            {
                mStickmanFX.voffset = vdistance;
                Platform.runLater(() -> mStickmanFX.update());
            }
        }

        if (speedUnit < 0)
        {
            for (int i = 0; i < 10; i++)
            {
                mStickmanFX.voffset = mStickmanFX.voffset + speedUnit;
                if (mStickmanFX.voffset <= vdistance)
                {
                    mStickmanFX.voffset = vdistance;
                }
                Platform.runLater(() -> mStickmanFX.update());
                pauseAnimation(40);
            }

            if (mStickmanFX.voffset > vdistance)
            {
                mStickmanFX.voffset = vdistance;
                Platform.runLater(() -> mStickmanFX.update());
            }
        }

    }

}
