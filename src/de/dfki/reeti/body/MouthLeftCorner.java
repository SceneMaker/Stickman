package de.dfki.reeti.body;

import de.dfki.reeti.animationlogic.AnimatorReeti;

import java.awt.*;
import java.awt.geom.Point2D;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class MouthLeftCorner extends BodyPartFX {

    public static enum SHAPE {
        DEFAULT, LEFTCORNERACTION 
    };
    
    Mouth mMouth;
    Path mLips;

    public Point2D leftCorner;

    private double leftCornerRegulator = 0;

    private double recordLeftCornerRegulator;

    public MouthLeftCorner.SHAPE mShape = MouthLeftCorner.SHAPE.DEFAULT;

    public MouthLeftCorner(Mouth mouth) {
        mMouth = mouth;
        mLips = mMouth.getmLips();
        leftCorner = mMouth.getLeftCorner();
    }

    @Override
    public void setShape(String s) {
        MouthLeftCorner.SHAPE shape = MouthLeftCorner.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : MouthLeftCorner.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = MouthLeftCorner.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step) {

        int x;
        int y;

        double movement;

        switch (mShape) {
            case DEFAULT:
                break;

            case LEFTCORNERACTION:
                if (step == 20) {
                    recordLeftCornerRegulator = leftCornerRegulator;
                    leftCornerRegulator = leftCorner.getY();
                }
                
                leftCornerRegulator += recordLeftCornerRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                QuadCurveTo leftQuadCurveTo = (QuadCurveTo) mLips.getElements().get(1);
                
                leftQuadCurveTo.setX(leftCorner.getX());
                leftQuadCurveTo.setY(leftCornerRegulator);
                mLips.getElements().set(1, leftQuadCurveTo);
                if (step == 2) {
                    leftCornerRegulator = 0;
                }
                break;
        }
    }

    public double getLeftCornerRegulator() {
        return leftCornerRegulator;
    }

    public void setLeftCornerRegulator(int rightCornerRegler) {
        this.leftCornerRegulator = rightCornerRegler;
    }
}
