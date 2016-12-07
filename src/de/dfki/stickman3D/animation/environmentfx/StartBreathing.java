package de.dfki.stickman3D.animation.environmentfx;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

/**
 *
 * @author Beka
 *
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
public class StartBreathing extends Animation3D {

    int frequent;
    int actionDuration;

    public StartBreathing(Stickman3D sm, int frequent, int actionDuration, boolean block) {
        super(sm, frequent, actionDuration, block);
        mStickmanFX = sm;
        this.frequent = frequent;
        this.actionDuration = actionDuration;
    }

    @Override
    public void playAnimation() {
        mStickmanFX.mBreathing = new Breathing(mStickmanFX, frequent, actionDuration);
    }
}
