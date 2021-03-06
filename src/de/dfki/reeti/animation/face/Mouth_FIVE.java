package de.dfki.reeti.animation.face;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import de.dfki.reeti.Reeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.animationlogic.AnimationContentReeti;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class Mouth_FIVE extends AnimationReeti {

    public Mouth_FIVE(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    public void playAnimation() {
        // smile
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentReeti(mReeti.mMouth, "shape", "FIVE"));
        playAnimationPart(20);
    }
}
