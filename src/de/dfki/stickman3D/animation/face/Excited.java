package de.dfki.stickman3D.animation.face;

import de.dfki.common.animationlogic.AnimationContent;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationStickman3D;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class Excited extends AnimationStickman3D
{

    public Excited()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Excited(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // excited
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "EXCITED"));
        playAnimationPart(mDuration);

        pauseAnimation(1200);

        // no excited
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mMouth, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEye, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEye, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftEyebrow, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mRightEyebrow, "shape", "EXCITEDEND"));
        playAnimationPart(mDuration);

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
