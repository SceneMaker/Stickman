package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

/**
 * @author Beka
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
public class StartBlinking extends AnimationStickman3D
{

    int frequent;
    int actionDuration;

    public StartBlinking()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public StartBlinking(Stickman3D sm, int frequent, int actionDuration, boolean block)
    {
        super(sm, frequent, actionDuration, block);
        agent = sm;
        this.frequent = frequent;
        this.actionDuration = actionDuration;
    }

    public StartBlinking(Stickman3D sm, int frequent, boolean block)
    {
        super(sm, frequent, block);
        agent = sm;
        this.frequent = 5000;
        this.actionDuration = 50;
    }

    @Override
    public void playAnimation()
    {
        ((Stickman3D) agent).mBlinking = new Blinking(((Stickman3D) agent), frequent, actionDuration);

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
