/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.headfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;
import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Muster extends AnimationFX {

    public Muster(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        int rotationUnit = 10;
        for (int i = 0; i < 8; i++) {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", 40));
            playAnimationPart(200);

            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", -40));
            playAnimationPart(100);
        }

    }
}
