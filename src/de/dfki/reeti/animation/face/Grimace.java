/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.face;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationReeti;

/**
 * @author Beka
 */
public class Grimace extends AnimationReeti
{

    public Grimace()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Grimace(Reeti sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }


    @Override
    public void playAnimation()
    {
        ((Reeti) agent).neckPan(25);
        ((Reeti) agent).neckTilt(20);
        ((Reeti) agent).leftEyePan(60);
        ((Reeti) agent).leftEyeTilt(60);
        ((Reeti) agent).rightEyePan(15);
        ((Reeti) agent).rightEyeTilt(40);
        ((Reeti) agent).rightEar(0);
        ((Reeti) agent).leftLC(75);
        ((Reeti) agent).rightLC(60);
        ((Reeti) agent).bottomLip(10);
        ((Reeti) agent).topLip(3);


        if (ReetiStageController.currentRadioButton != null)
        {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
