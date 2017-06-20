package de.dfki.reeti.body;

import de.dfki.reeti.animationlogic.AnimatorReeti;

import java.awt.geom.Point2D;

import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 * @author Beka Aptsiauri
 */
public class MouthDownLip extends Parts
{

    public enum SHAPE
    {
        DEFAULT, DOWNLIPACTION
    }

    private Point2D downPoint;
    private Path mLips;

    private double downLipRegulator = 0;
    private double recorDownLipRegulator;

    public MouthDownLip.SHAPE mShape = MouthDownLip.SHAPE.DEFAULT;

    public MouthDownLip(Mouth mouth)
    {
        mLips = mouth.getLips();
        downPoint = mouth.getDownPoint();
    }

    @Override
    public void setShape(String s)
    {
        MouthDownLip.SHAPE shape = MouthDownLip.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : MouthDownLip.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = MouthDownLip.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {

        switch (mShape)
        {
            case DEFAULT:
                break;

            case DOWNLIPACTION:
                if (step == 20)
                {
                    recorDownLipRegulator = downLipRegulator;
                    downLipRegulator = downPoint.getY();
                }

                downLipRegulator += recorDownLipRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                downPoint.setLocation(downPoint.getX(), downLipRegulator);

                QuadCurveTo quadCurveTo = (QuadCurveTo) mLips.getElements().get(2);

                quadCurveTo.setControlX(downPoint.getX());
                quadCurveTo.setControlY(downPoint.getY());
                mLips.getElements().set(2, quadCurveTo);
                break;
        }
    }

    public void setDownLipRegulator(double downLipRegulator)
    {
        this.downLipRegulator = downLipRegulator;
    }
}
