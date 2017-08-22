/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.environment.event;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.animationlogic.EventAnimationReeti;
import de.dfki.reeti.environment.SpeechBubbleReeti;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class Speaking extends EventAnimationReeti
{

    public Speaking()
    {
        super();
    }

    public Speaking(Reeti sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        if (mParameter instanceof WordTimeMarkSequence)
        {
            mWTS = (WordTimeMarkSequence) mParameter;
        }

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(agent.getSpeechBubble(), "shape", SpeechBubbleReeti.SHAPE.SPEAK.name(), mWTS));

        playEventAnimationPart();

        mAnimationPart.add(new AnimationContent(agent.getSpeechBubble(), "shape", SpeechBubbleReeti.SHAPE.DEFAULT.name()));
        playAnimationPart(20);

    }
}
