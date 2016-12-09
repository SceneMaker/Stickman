package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.Animation;
import de.dfki.stickman3D.animationlogic.Animation.ANIMTYPE;

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
public class StartBreathing extends Animation {
	
	public StartBreathing() {
		mAnimType = ANIMTYPE.ON;
	}

	int frequent;
	int actionDuration;

	public StartBreathing(Stickman3D sm, int frequent, int actionDuration, boolean block) {
		super(sm, frequent, actionDuration, block);
		mStickmanFX = sm;
		this.frequent = frequent;
		this.actionDuration = actionDuration;
	}

	public StartBreathing(Stickman3D sm, int frequent, boolean block) {
		super(sm, frequent, block);
		mStickmanFX = sm;
		this.frequent = frequent;
		this.actionDuration = 500;
	}

	@Override
	public void playAnimation() {
		if(StickmanStageController.currentRadioButton != null)
		{
			if(StickmanStageController.currentRadioButton.isSelected())
			{
				frequent = 5000;
				actionDuration = 2000;
			}
		}
		mStickmanFX.mBreathing = new Breathing(mStickmanFX, frequent, actionDuration);
	}
}
