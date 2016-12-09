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
public class StopBreathing extends Animation {
	
	public StopBreathing() {
		mAnimType = ANIMTYPE.ON;
	}

	public StopBreathing(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		if (mStickmanFX.mBreathing != null)
			mStickmanFX.mBreathing.stopBreathAktion();
		
		if(StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);
	}
}
