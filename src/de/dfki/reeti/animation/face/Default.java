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
public class Default extends AnimationReeti
{

    public Default()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Default(Reeti sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        ((Reeti) agent).neckRotat(50);
        ((Reeti) agent).neckPan(50);
        ((Reeti) agent).neckTilt(50);
        ((Reeti) agent).rightLC(50);
        ((Reeti) agent).leftLC(50);
        ((Reeti) agent).topLip(0);
        ((Reeti) agent).bottomLip(100);
        ((Reeti) agent).rightEyePan(60);
        ((Reeti) agent).rightEyeTilt(42);
        ((Reeti) agent).leftEyePan(40);
        ((Reeti) agent).leftEyeTilt(42);
        ((Reeti) agent).leftEyeLid(100);
        ((Reeti) agent).rightEyeLid(100);
        ((Reeti) agent).rightEar(50);
        ((Reeti) agent).leftEar(50);
        ((Reeti) agent).setLedColor("stop");
        if (ReetiStageController.currentRadioButton != null)
        {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
