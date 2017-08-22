/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.head;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author Patrick Gebhard
 */
////////////nod 3 time by Guo
public class Nod2 extends AnimationStickman3D
{

    public Nod2()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Nod2(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        for (int i = 0; i < 6; i++)
        {
            if (i == 0)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", 10));
                playAnimationPart(200);
            } else if (i == 5)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", -10));
                playAnimationPart(200);
            } else if (i % 2 == 1)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", -20));
                playAnimationPart(200);
            } else
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mHead, "rotate", 20));
                playAnimationPart(200);
            }
        }

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
