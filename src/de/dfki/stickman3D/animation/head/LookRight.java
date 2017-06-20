package de.dfki.stickman3D.animation.head;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LookRight extends Animation3D {

    public LookRight() {
        mAnimType = ANIMTYPE.ON;
    }

    public LookRight(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "LOOKRIGHT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "LOOKRIGHT"));
        playAnimationPart(100);

        pauseAnimation(100);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "LOOKRIGHTEND"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "LOOKRIGHTEND"));
        playAnimationPart(100);

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);
    }
}
