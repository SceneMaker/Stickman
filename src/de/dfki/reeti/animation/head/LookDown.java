package de.dfki.reeti.animation.head;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LookDown extends AnimationReeti {

    public LookDown() {
        mAnimType = ANIMTYPE.ON;
    }

    public LookDown(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mLeftEye, "rotate", 20));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEye, "rotate", 20));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEyeFX, "shape", "LOOKDOWN"));
        playAnimationPart(100);

        pauseAnimation(100);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mLeftEye, "rotate", -20));
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEye, "rotate", -20));
//        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mRightEyeFX, "shape", "LOOKDOWNEND"));
        playAnimationPart(100);

        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
