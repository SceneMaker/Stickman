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
public class Sad2 extends AnimationReeti
{

    public Sad2()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Sad2(Reeti sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        ((Reeti) agent).leftEyeLid(45);
        ((Reeti) agent).rightEyeLid(45);
        ((Reeti) agent).leftEyeTilt(55);
        ((Reeti) agent).leftEyePan(25);
        ((Reeti) agent).rightEyeTilt(55);
        ((Reeti) agent).rightEyePan(75);
        ((Reeti) agent).leftEar(0);
        ((Reeti) agent).rightEar(0);
        ((Reeti) agent).rightLC(0);
        ((Reeti) agent).leftLC(0);

        if (ReetiStageController.currentRadioButton != null)
        {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
