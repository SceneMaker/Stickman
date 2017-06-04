package de.dfki.reeti.body;

import de.dfki.reeti.animationlogic.AnimatorReeti;

import java.awt.geom.Point2D;

import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 * @author Beka Aptsiauri
 */
public class MouthLeftCorner extends Parts
{

    public enum SHAPE
    {
        DEFAULT, LEFTCORNERACTION
    }

    private Path mLips;
    private Point2D leftCorner;

    private double leftCornerRegulator = 0;
    private double recordLeftCornerRegulator;

    public MouthLeftCorner.SHAPE mShape = MouthLeftCorner.SHAPE.DEFAULT;

    public MouthLeftCorner(Mouth mouth)
    {
        mLips = mouth.getLips();
        leftCorner = mouth.getLeftCorner();
    }

    @Override
    public void setShape(String s)
    {
        MouthLeftCorner.SHAPE shape = MouthLeftCorner.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : MouthLeftCorner.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = MouthLeftCorner.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        switch (mShape)
        {
            case DEFAULT:
                break;

            case LEFTCORNERACTION:
                if (step == 20)
                {
                    recordLeftCornerRegulator = leftCornerRegulator;
                    leftCornerRegulator = leftCorner.getY();
                }

                leftCornerRegulator += recordLeftCornerRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                leftCorner.setLocation(leftCorner.getX(), leftCornerRegulator);
                QuadCurveTo leftQuadCurveTo = (QuadCurveTo) mLips.getElements().get(1);

                leftQuadCurveTo.setX(leftCorner.getX());
                leftQuadCurveTo.setY(leftCornerRegulator);
                mLips.getElements().set(1, leftQuadCurveTo);
                break;
        }
    }

    public void setLeftCornerRegulator(double rightCornerRegler)
    {
        this.leftCornerRegulator = rightCornerRegler;
    }
}
