package de.dfki.stickman3D.animation.gesture;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class Itching extends AnimationStickman3D
{

    public Itching()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Itching(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "zrotate", -25));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", -35));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", 65));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "yrotate", 10));
        playAnimationPart(mDuration);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger2, "zrotate", 8));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger4, "zrotate", -8));
        playAnimationPart(50);

        for (int i = 0; i < 4; i++)
        {
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "rotate", 10));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger2, "rotate", 60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger3, "rotate", 70));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger4, "rotate", 80));
            playAnimationPart(200);

            pauseAnimation(200);

            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "rotate", -10));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger2, "rotate", -60));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger3, "rotate", -70));
            mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger4, "rotate", -80));
            playAnimationPart(200);
        }

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger2, "zrotate", -8));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftFinger4, "zrotate", 8));
        playAnimationPart(50);

        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "zrotate", 25));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", 35));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", -65));

        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftWrist, "yrotate", -10));

        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null)
            StickmanStageController.currentRadioButton.setSelected(false);

    }
}
