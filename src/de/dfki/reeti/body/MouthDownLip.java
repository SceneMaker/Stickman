package de.dfki.reeti.body;

import de.dfki.reeti.animationlogic.AnimatorReeti;

import java.awt.geom.Point2D;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class MouthDownLip extends BodyPart
{

    public static enum SHAPE {
        DEFAULT, DOWNLIPACTION
    };

    public Point2D downPoint;
    Mouth mMouth;
    Path mLips;

    private double downLipRegulator = 0;

    private double recorDownLipRegulator;

    public MouthDownLip.SHAPE mShape = MouthDownLip.SHAPE.DEFAULT;

    public MouthDownLip(Mouth mouth) {
        mMouth = mouth;
        mLips = mMouth.getmLips();
        downPoint = mMouth.getDownPoint();
    }

    @Override
    public void setShape(String s) {
        MouthDownLip.SHAPE shape = MouthDownLip.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : MouthDownLip.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = MouthDownLip.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step) {

        switch (mShape) {
            case DEFAULT:
                break;

            case DOWNLIPACTION:
                if (step == 20) {
                    recorDownLipRegulator = downLipRegulator;
                    downLipRegulator = downPoint.getY();
                }

                downLipRegulator += recorDownLipRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                downPoint.setLocation(downPoint.getX(), downLipRegulator);

                QuadCurveTo quadCurveTo = (QuadCurveTo) mLips.getElements().get(2);

                quadCurveTo.setControlX(downPoint.getX());
                quadCurveTo.setControlY(downPoint.getY());
                mLips.getElements().set(2, quadCurveTo);
//                if (step == 2) {
//                    upperPoint.setLocation(upperPoint.getX(), upperLipRegulator);
//                }
                break;
        }
    }

    public double getDownLipRegulator() {
        return downLipRegulator;
    }

    public void setDownLipRegulator(double downLipRegulator) {
        this.downLipRegulator = downLipRegulator;
    }

    public Point2D getDownPoint() {
        return downPoint;
    }

    public double getRecordDownLipRegulator() {
        return recorDownLipRegulator;
    }

}
