/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.gesture;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class WaveRight extends AnimationStickman3D
{

    public WaveRight()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public WaveRight(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", -35));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", -120));
        playAnimationPart(200);

        for (int i = 0; i < 6; i++)
        {
            if (i == 0)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", -10));
                playAnimationPart(200);
            } else if (i == 5)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", 10));
                playAnimationPart(200);
            } else if (i % 2 == 1)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", 20));
                playAnimationPart(200);
            } else
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "zrotate", -20));
                playAnimationPart(200);
            }
        }

        pauseAnimation(1000);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightUpperArm, "rotate", 35));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightForeArm, "rotate", 120));
        playAnimationPart(200);

    }

}
