/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.head;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;
import de.dfki.stickman3D.animationlogic.Animation3D;

import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Muster extends Animation3D {

    public Muster() {
        mAnimType = ANIMTYPE.ON;
    }

    public Muster(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        mAnimationPartFX = new ArrayList<>(); 
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"yrotate",0)); 
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"zrotate",-10));
mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX,"rotate",-55)); 
 
playAnimationPart(mDuration);
    }
}
