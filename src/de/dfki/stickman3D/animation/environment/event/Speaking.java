/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment.event;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.EventAnimation3D;
import de.dfki.stickman3D.environment.SpeechBubbleStickman3D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class Speaking extends EventAnimation3D
{

    public Speaking()
    {
        super();
    }

    public Speaking(Stickman3D sm, int duration, boolean block)
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
        mAnimationPart.add(new AnimationContent(agent.getSpeechBubble(), "shape", SpeechBubbleStickman3D.SHAPE.SPEAK.name(), mWTS));

        playEventAnimationPart();

        mAnimationPart.add(new AnimationContent(agent.getSpeechBubble(), "shape", SpeechBubbleStickman3D.SHAPE.DEFAULT.name()));
        playAnimationPart(20);

    }
}
