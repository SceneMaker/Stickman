/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;
import de.dfki.stickman3D.environment.SpeechBubbleStickman3D;

import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
public class Speaking extends AnimationStickman3D
{

    public Speaking()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Speaking(Stickman3D sm, int duration, boolean block)
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
        mAnimationPart.add(new AnimationContent(agent.getSpeechBubble(), "shape", SpeechBubbleStickman3D.SHAPE.SPEAK.name()));
        playAnimationPart(mDuration);

        mAnimationPart.add(new AnimationContent(agent.getSpeechBubble(), "shape", SpeechBubbleStickman3D.SHAPE.DEFAULT.name()));
        playAnimationPart(20);

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }

    }
}
