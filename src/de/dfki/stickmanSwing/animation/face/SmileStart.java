package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class SmileStart extends AnimationSwing {

    public SmileStart(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // smile start
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "SMILE"));
//		playAnimationPart(20);
        playAnimationPart(mDuration);
        pauseAnimation(10);

    }
}
