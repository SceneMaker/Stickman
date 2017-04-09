package de.dfki.reeti.animation.face;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationContentReeti;
import de.dfki.reeti.animationlogic.AnimationReeti;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class Smile extends AnimationReeti {

    public Smile() {
        mAnimType = ANIMTYPE.ON;
    }

    public Smile(Reeti sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {

        mReeti.bottomLip(50);
        mReeti.leftLC(70);
        mReeti.rightLC(70);
        mReeti.setLedColor("green", Reeti.LED.LEFTLED);
        mReeti.setLedColor("red", Reeti.LED.RIGHTLED);
        mReeti.leftEar(100);
        mReeti.rightEar(100);


        if (ReetiStageController.currentRadioButton != null) {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
