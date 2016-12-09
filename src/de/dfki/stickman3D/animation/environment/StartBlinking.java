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
public class StartBlinking extends Animation {
	
	public StartBlinking() {
		mAnimType = ANIMTYPE.ON;
	}

	int frequent;
	int actionDuration;

	public StartBlinking(Stickman3D sm, int frequent, int actionDuration, boolean block) {
		super(sm, frequent, actionDuration, block);
		mStickmanFX = sm;
		this.frequent = frequent;
		this.actionDuration = actionDuration;
	}
	
	public StartBlinking(Stickman3D sm, int actionDuration, boolean block) {
		super(sm, actionDuration, block);
		mStickmanFX = sm;
		this.frequent = frequent;
		this.actionDuration = actionDuration;
	}

	@Override
	public void playAnimation() {
		if(StickmanStageController.currentRadioButton != null)
		{
			if(StickmanStageController.currentRadioButton.isSelected())
			{
				frequent = 2000;
				actionDuration = 20;
			}
		}
		mStickmanFX.mBlinking = new Blinking(mStickmanFX, frequent, actionDuration);
	}
}
