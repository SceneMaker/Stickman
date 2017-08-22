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
import javafx.application.Platform;

import java.util.ArrayList;

/**
 * @author Beka
 */
public class ComeUp extends AnimationStickman3D
{

    double recordOriginLeaveSpeed;

    public ComeUp()
    {
        mAnimType = ANIMTYPE.ON;
    }

    public ComeUp(Stickman3D sm, int duration, boolean block)
    {
        super(sm, duration, block);
        agent = sm;
        recordOriginLeaveSpeed = ((Stickman3D) agent).leaveSpeed;
    }

    // WaveLeft
    @Override
    public void playAnimation()
    {
        int rotationUnit = 5;
        int speed = 4;

        ((Stickman3D) agent).leaveSpeed = 480;

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", -rotationUnit * 30));
        playAnimationPart(100);

        for (int i = 0; i < 8; i++)
        {
            // wave right
            for (int j = 0; j < 10; j++)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", -rotationUnit));
                playComeSpeed(speed);
                playAnimationPart(20);
            }
            // wave left
            for (int j = 0; j < 10; j++)
            {
                mAnimationPart = new ArrayList<>();
                mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "zrotate", rotationUnit));
                playComeSpeed(speed);
                playAnimationPart(20);
            }
        }

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftUpperArm, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContent(((Stickman3D) agent).mLeftForeArm, "rotate", rotationUnit * 30));
        playAnimationPart(200);

        if (StickmanStageController.currentRadioButton != null)
        {
            StickmanStageController.currentRadioButton.setSelected(false);
        }

    }

    private void playComeSpeed(int Speed)
    {
        if (((Stickman3D) agent).leaveSpeed > recordOriginLeaveSpeed)
        {
            ((Stickman3D) agent).leaveSpeed = ((Stickman3D) agent).leaveSpeed - Speed;
        } else
        {
            ((Stickman3D) agent).leaveSpeed = recordOriginLeaveSpeed;
        }
        Platform.runLater(() -> ((Stickman3D) agent).update());
    }
}
