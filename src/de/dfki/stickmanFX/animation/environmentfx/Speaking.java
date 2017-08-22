/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;
import de.dfki.stickmanFX.environmentfx.SpeechBubbleStickman2D;

import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class Speaking extends AnimationStickman2D
{

    public Speaking(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        if (mParameter instanceof String)
        {
            agent.getSpeechBubble().mSpeechBubbleText = (String) mParameter;
        }

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(agent.getSpeechBubble(), "shape", SpeechBubbleStickman2D.SHAPE.SPEAK.name()));
        playAnimationPart(mDuration);

        mAnimationPart.add(new AnimationContent(agent.getSpeechBubble(), "shape", SpeechBubbleStickman2D.SHAPE.DEFAULT.name()));
        playAnimationPart(20);

    }
}
