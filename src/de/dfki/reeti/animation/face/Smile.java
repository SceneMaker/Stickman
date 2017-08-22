package de.dfki.reeti.animation.face;

import de.dfki.common.enums.Led;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationReeti;

/**
 * @author Beka
 */
public class Smile extends AnimationReeti
{

    public Smile()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Smile(Reeti sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {

        ((Reeti) agent).bottomLip(50);
        ((Reeti) agent).leftLC(70);
        ((Reeti) agent).rightLC(70);
        ((Reeti) agent).setLedColor("green", Led.LEFTLED);
        ((Reeti) agent).setLedColor("red", Led.RIGHTLED);
        ((Reeti) agent).leftEar(100);
        ((Reeti) agent).rightEar(100);


        if (ReetiStageController.currentRadioButton != null)
        {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
