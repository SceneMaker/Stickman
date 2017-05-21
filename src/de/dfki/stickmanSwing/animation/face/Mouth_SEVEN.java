package de.dfki.stickmanSwing.animation.face;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Mouth_SEVEN extends AnimationSwing {

    public Mouth_SEVEN(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // smile
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "SEVEN"));
        playAnimationPart(20);
    }
}
