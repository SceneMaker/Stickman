package de.dfki.reeti.body;

import de.dfki.reeti.animationlogic.AnimatorReeti;

import java.awt.geom.Point2D;

import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class MouthRightCorner extends BodyPart
{

    public static enum SHAPE {
        DEFAULT, RIGHTCORNERACTION 
    };
    
    Mouth mMouth;
    Path mLips;

    public Point2D rightCorner;

    private double rightCornerRegulator = 0;

    private double recordRightCornerRegulator;

    public MouthRightCorner.SHAPE mShape = MouthRightCorner.SHAPE.DEFAULT;

    public MouthRightCorner(Mouth mouth) {
        mMouth = mouth;
        mLips = mMouth.getmLips();
        rightCorner = mMouth.getRightCorner();
    }

    @Override
    public void setShape(String s) {
        MouthRightCorner.SHAPE shape = MouthRightCorner.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : MouthRightCorner.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = MouthRightCorner.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step) {

        switch (mShape) {
            case DEFAULT:
                break;

            case RIGHTCORNERACTION:
                if (step == 20) {
                    recordRightCornerRegulator = rightCornerRegulator;
                    rightCornerRegulator = rightCorner.getY();
                }
                
                rightCornerRegulator += recordRightCornerRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                rightCorner.setLocation(rightCorner.getX(), rightCornerRegulator);
                QuadCurveTo rightQuadCurveTo = (QuadCurveTo) mLips.getElements().get(2);
                MoveTo rightMoveTo = (MoveTo) mLips.getElements().get(0);
                
                rightQuadCurveTo.setX(rightCorner.getX());
                rightQuadCurveTo.setY(rightCorner.getY());
                rightMoveTo.setX(rightCorner.getX());
                rightMoveTo.setY(rightCorner.getY());
                mLips.getElements().set(2, rightQuadCurveTo);
                mLips.getElements().set(0, rightMoveTo);
//                if (step == 2) {
//                    rightCornerRegulator = 0;
//                }
                break;
        }
    }

    public double getRightCornerRegulator() {
        return rightCornerRegulator;
    }

    public void setRightCornerRegulator(double rightCornerRegler) {
        this.rightCornerRegulator = rightCornerRegler;
    }
}
