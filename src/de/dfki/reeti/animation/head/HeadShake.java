/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.head;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import de.dfki.reeti.animationlogic.AnimationReeti;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class HeadShake extends AnimationReeti
{

    public HeadShake()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public HeadShake(Reeti sm, int duration, boolean block)
    {
        super(sm, duration, block);
        this.agent = sm;
    }

    @Override
    public void playAnimation()
    {

        // shaking head 4 times
        for (int i = 0; i < 6; i++)
        {
            if (i == 0)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Reeti) agent).mHead, "zrotate", -10));
                playAnimationPart(200);
            } else if (i == 5)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Reeti) agent).mHead, "zrotate", 10));
                playAnimationPart(200);
            } else if (i % 2 == 1)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Reeti) agent).mHead, "zrotate", 20));
                playAnimationPart(400);
            } else
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Reeti) agent).mHead, "zrotate", -20));
                playAnimationPart(400);
            }
        }

        if (ReetiStageController.currentRadioButton != null)
        {
            ReetiStageController.currentRadioButton.setSelected(false);
        }

    }

}
