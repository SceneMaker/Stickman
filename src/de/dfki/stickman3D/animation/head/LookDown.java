package de.dfki.stickman3D.animation.head;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LookDown extends Animation3D {

    public LookDown() {
        mAnimType = ANIMTYPE.ON;
    }

    public LookDown(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyeFX, "shape", "LOOKDOWN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyeFX, "shape", "LOOKDOWN"));
        playAnimationPart(100);

        pauseAnimation(100);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyeFX, "shape", "LOOKDOWNEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyeFX, "shape", "LOOKDOWNEND"));
        playAnimationPart(100);

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);
    }
}
