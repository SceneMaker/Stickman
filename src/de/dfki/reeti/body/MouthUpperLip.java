package de.dfki.reeti.body;

import de.dfki.reeti.animationlogic.AnimatorReeti;

import java.awt.*;
import java.awt.geom.Point2D;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class MouthUpperLip extends BodyPartFX {

    public static enum SHAPE {
        DEFAULT, UPPERLIPACTION
    };

    public Point2D upperPoint;
    Mouth mMouth;
    Path mLips;

    private double upperLipRegulator = 0;

    private double recordupperLipRegulator;

    public MouthUpperLip.SHAPE mShape = MouthUpperLip.SHAPE.DEFAULT;

    public MouthUpperLip(Mouth mouth) {
        mMouth = mouth;
        mLips = mMouth.getmLips();
        upperPoint = mMouth.getUpperPoint();
    }

    @Override
    public void setShape(String s) {
        MouthUpperLip.SHAPE shape = MouthUpperLip.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : MouthUpperLip.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = MouthUpperLip.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step) {

        switch (mShape) {
            case DEFAULT:
                break;

            case UPPERLIPACTION:
                if (step == 20) {
                    recordupperLipRegulator = upperLipRegulator;
                    upperLipRegulator = upperPoint.getY();
                }

                upperLipRegulator += recordupperLipRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                upperPoint.setLocation(upperPoint.getX(), upperLipRegulator);

                QuadCurveTo quadCurveTo = (QuadCurveTo) mLips.getElements().get(1);

                quadCurveTo.setControlX(upperPoint.getX());
                quadCurveTo.setControlY(upperPoint.getY());
                mLips.getElements().set(1, quadCurveTo);
//                if (step == 2) {
//                    upperPoint.setLocation(upperPoint.getX(), upperLipRegulator);
//                }
                break;
        }
    }

    public double getUpperLipRegulator() {
        return upperLipRegulator;
    }

    public void setUpperLipRegulator(double upperLipRegulator) {
        this.upperLipRegulator = upperLipRegulator;
    }

    public Point2D getUpperPoint() {
        return upperPoint;
    }

    public double getRecordupperLipRegulator() {
        return recordupperLipRegulator;
    }

}
