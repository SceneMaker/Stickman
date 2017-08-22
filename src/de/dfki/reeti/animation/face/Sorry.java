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
public class Sorry extends AnimationReeti
{

    public Sorry()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Sorry(Reeti sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        ((Reeti) agent).neckPan(20);
        ((Reeti) agent).neckTilt(30);
        ((Reeti) agent).leftEyeLid(30);
        ((Reeti) agent).rightEyeLid(30);
        ((Reeti) agent).leftEyeTilt(20);
        ((Reeti) agent).rightEyeTilt(20);
        ((Reeti) agent).setLedColor("lightGreen");
        ((Reeti) agent).leftEar(20);
        ((Reeti) agent).rightEar(30);
        ((Reeti) agent).rightLC(10);
        ((Reeti) agent).leftLC(10);


        if (ReetiStageController.currentRadioButton != null)
        {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
