package de.dfki.reeti.body;

import de.dfki.common.part.Part3D;
import de.dfki.reeti.animationlogic.AnimatorReeti;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

import java.awt.geom.Point2D;

/**
 * @author Beka Aptsiauri
 */
public class MouthDownLip extends PartReeti
{

    public MouthDownLip.SHAPE mShape = MouthDownLip.SHAPE.DEFAULT;
    private Point2D downPoint;
    private Path mLips;

    private double downLipRegulator = 0;
    private double recorDownLipRegulator;

    public MouthDownLip(Part3D mouth)
    {
        mLips = ((Mouth) mouth).getLips();
        downPoint = ((Mouth) mouth).getDownPoint();
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

    public enum SHAPE
    {
        DEFAULT, DOWNLIPACTION
    }
}
