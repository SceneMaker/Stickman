package de.dfki.reeti.animation.environment;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationReeti;

/**
 * @author Robbie
 */
public class StopBlinking extends AnimationReeti
{

    public StopBlinking()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public StopBlinking(Reeti sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        if (((Reeti) agent).mBlinking != null)
        {
            ((Reeti) agent).mBlinking.stopBlinkAktion();
        }

        if (ReetiStageController.currentRadioButton != null)
        {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
