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
public class Sad extends AnimationReeti
{

    public Sad()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Sad(Reeti sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        ((Reeti) agent).leftEyeLid(60);
        ((Reeti) agent).rightEyeLid(60);
        ((Reeti) agent).leftEyeTilt(15);
        ((Reeti) agent).rightEyeTilt(15);
        ((Reeti) agent).setLedColor("violet");
        ((Reeti) agent).leftEar(0);
        ((Reeti) agent).rightEar(0);
        ((Reeti) agent).rightLC(0);
        ((Reeti) agent).leftLC(0);
        ((Reeti) agent).neckTilt(0);


        if (ReetiStageController.currentRadioButton != null)
        {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
