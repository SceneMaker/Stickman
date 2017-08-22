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
import de.dfki.reeti.body.Mouth;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * @author Beka Aptsiauri
 */
public class Muster extends AnimationReeti
{

    public Muster()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public Muster(Reeti sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        Color c1 = Color.rgb(255, 255, 255);
        Color c2 = Color.rgb(255, 0, 255);
        Color c3 = Color.rgb(0, 0, 255);
        ((Reeti) agent).ledON(c1, c2, c3, 0.7f, 0.9f, 0.4f, "B");

        Mouth mMouth = (Mouth) ((Reeti) agent).mMouth;
        mMouth.setUpRegulator(-20);
        mMouth.setDownRegulator(-10);
//        ((Reeti)agent).mMouth.setLeftCornerRegulator(-20);

        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent(((Reeti)agent).mLeftEar, "rotate", 60));
//        mAnimationPart.add(new AnimationContent(((Reeti)agent).mRightEar, "yrotate", 60));
        mAnimationPart.add(new AnimationContent(((Reeti) agent).mMouth, "shape", "MOUTHACTION"));
//        mAnimationPart.add(new AnimationContent(((Reeti)agent).mRightEar, "yrotate", 60));
        playAnimationPart(mDuration);

        pauseAnimation(2000);
        ((Reeti) agent).ledOFF("B");
        mAnimationPart = new ArrayList<>();
//        mAnimationPart.add(new AnimationContent(((Reeti)agent).mLeftEar, "rotate", -60));
//        mAnimationPart.add(new AnimationContent(((Reeti)agent).mRightEar, "yrotate", -60));
        mAnimationPart.add(new AnimationContent(((Reeti) agent).mMouth, "shape", "MOUTHACTIONEND"));
        playAnimationPart(mDuration);

        if (ReetiStageController.currentRadioButton != null)
        {
            ReetiStageController.currentRadioButton.setSelected(false);
        }
    }
}
