package de.dfki.reeti.animation.face;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.animationlogic.AnimationContentReeti;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class SmileStart extends AnimationReeti {

    public SmileStart(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // smile start
        AnimationReeti.isSmileInAction = true;
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentReeti(mReeti.mMouth, "shape", "SMILE"));
        playAnimationPart(mDuration);
        pauseAnimation(10);

    }
}
