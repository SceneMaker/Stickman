/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.posture;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class TurnLeftEnd extends Animation3D {

    public TurnLeftEnd(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    /**
     * This method creates the angry facial movement.
     */
    @Override
    public void playAnimation() {
        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", 40));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody, "yrotate", 60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "yrotate", 40));
            playAnimationPart(500);
        } else {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "yrotate", 70));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody, "yrotate", 60));
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "yrotate", 40));
            playAnimationPart(500);
        }
    }
}
