/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.facefx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import java.util.ArrayList;
import javafx.application.Platform;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class DisgustedEnd extends AnimationFX 
{

    public DisgustedEnd(StickmanFX sm, int duration, boolean block) 
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
         // no disgusted
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "DISGUSTEDEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "DISGUSTEDEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "DISGUSTEDEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "DISGUSTEDEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "DISGUSTEDEND"));
        Platform.runLater(() -> playAnimationPart(20));

        pauseAnimation(10);
    }
}