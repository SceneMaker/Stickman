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
public class Sunbathing extends AnimationReeti
{

    public Sunbathing()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Sunbathing(Reeti sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        ((Reeti) agent).leftEyeLid(0);
        ((Reeti) agent).rightEyeLid(0);
        ((Reeti) agent).setLedColor("red");
        ((Reeti) agent).leftEar(0);
        ((Reeti) agent).rightEar(0);
        ((Reeti) agent).rightLC(40);
        ((Reeti) agent).leftLC(80);
        ((Reeti) agent).neckTilt(85);
        ((Reeti) agent).topLip(20);
        ((Reeti) agent).bottomLip(50);


        if (ReetiStageController.currentRadioButton != null)
        {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
