package de.dfki.reeti.body;

import de.dfki.reeti.animationlogic.AnimatorReeti;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.awt.*;
import java.awt.geom.Point2D;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineJoin;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Mouth extends BodyPartFX {

    public static enum SHAPE {
        DEFAULT, MOUTHACTION, MOUTHACTIONEND, LEFTCORNERACTION, LEFTCORNERACTIONEND, RIGHTCORNERACTION, RIGHTCORNERACTIONEND, OPEN,
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, NINETEEN, TWENTY
    };

    Head mHeadFX;

    public Polygon currentDownLipPolygon;
    public Polygon currentUpperLipPolygon;
    Path mLips;

    public Point2D leftCorner;
    public Point2D rightCorner;
    public Point2D upperPoint;
    public Point2D downPoint;
    private final int mouthLength = 32;

    private double rightCornerRegulator = 0;
    private double leftCornerRegulator = 0;
    private double upRegulator = 0;
    private double downRegulator = 0;

    private double recordLeftCornerRegulator;
    private double recordRightCornerRegulator;
    private double recordUpRegulator;
    private double recordDownRegulator;

    public Mouth.SHAPE mShape = Mouth.SHAPE.DEFAULT;

    public Mouth(Head head) {
        mHeadFX = head;
        mSize = new Dimension(mLength * 2, 5);

        mColor = Color.DARKGREY;

        currentUpperLipPolygon = new Polygon();
        currentDownLipPolygon = new Polygon();

        mLips = new Path();
        mLips.setId("upperLip");

        mStart = mHeadFX.getMouthPostion();
        rightCorner = new Point2D.Double(-9, 35);
        leftCorner = new Point2D.Double(rightCorner.getX() + mouthLength, rightCorner.getY());
        upperPoint = new Point2D.Double(rightCorner.getX() + mouthLength / 2, rightCorner.getY());
        downPoint = new Point2D.Double(upperPoint.getX(), upperPoint.getY());
        Distant light = new Distant();
        light.setAzimuth(-135.0f);

        Lighting l = new Lighting();
        l.setLight(light);
        l.setSurfaceScale(5.0f);

        mLips.setEffect(l);

        init();

        mHeadFX.mHead.getChildren().addAll(mLips);
    }

    @Override
    public void init() {
        super.init();
        mLips.setTranslateX(mStart.getX() - 7);
        mLips.setTranslateY(mStart.getY() + 28);
        mLips.setTranslateZ(-135.5);
    }

    @Override
    public void setShape(String s) {
        Mouth.SHAPE shape = Mouth.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : Mouth.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = Mouth.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step) {

        int x;
        int y;

        double movement;

        switch (mShape) {
            case DEFAULT:
                closeMouth();
                break;

            case MOUTHACTION:
                if (step == 20) {
                    recordDownRegulator = downRegulator;
                    recordUpRegulator = upRegulator;
                    recordLeftCornerRegulator = leftCornerRegulator;
                    recordRightCornerRegulator = rightCornerRegulator;
                    downRegulator = downPoint.getY();
                    upRegulator = upperPoint.getY();
                    rightCornerRegulator = rightCorner.getY();
                    leftCornerRegulator = leftCorner.getY();
                }
                
                downRegulator += recordDownRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                upRegulator += recordUpRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                rightCornerRegulator += recordRightCornerRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                leftCornerRegulator += recordLeftCornerRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                mLips.getElements().clear();
                mLips.getElements().add(new MoveTo(rightCorner.getX(), rightCornerRegulator));
                mLips.getElements().add(new QuadCurveTo(upperPoint.getX(), upRegulator, leftCorner.getX(), leftCornerRegulator));
                mLips.getElements().add(new QuadCurveTo(downPoint.getX(), downRegulator, rightCorner.getX(), rightCornerRegulator));
                mLips.getElements().add(new ClosePath());
                if (step == 2) {
                    downRegulator = 0;
                    upRegulator = 0;
                    rightCornerRegulator = 0;
                    leftCornerRegulator = 0;
                }
                break;

            case MOUTHACTIONEND:
                if (step == 20) {
                    downRegulator = recordDownRegulator + downPoint.getY();
                    upRegulator = recordUpRegulator + upperPoint.getY();
                    rightCornerRegulator = recordRightCornerRegulator + leftCorner.getY();
                    leftCornerRegulator = recordLeftCornerRegulator + rightCorner.getY();
                }

                downRegulator -= recordDownRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                upRegulator -= recordUpRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                rightCornerRegulator -= recordRightCornerRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                leftCornerRegulator -= recordLeftCornerRegulator / AnimatorReeti.sMAX_ANIM_STEPS;

                mLips.getElements().clear();
                mLips.getElements().add(new MoveTo(rightCorner.getX(), rightCornerRegulator));
                mLips.getElements().add(new QuadCurveTo(upperPoint.getX(), upRegulator, leftCorner.getX(), leftCornerRegulator));
                mLips.getElements().add(new QuadCurveTo(downPoint.getX(), downRegulator, rightCorner.getX(), rightCornerRegulator));
                mLips.getElements().add(new ClosePath());

                if (step == 2) {
                    downRegulator = 0;
                    upRegulator = 0;
                    rightCornerRegulator = 0;
                    leftCornerRegulator = 0;
                }
                break;

            case LEFTCORNERACTION:
                if (step == 20) {
                    recordLeftCornerRegulator = leftCornerRegulator;
                    leftCornerRegulator = leftCorner.getY();
                }

                leftCornerRegulator += recordLeftCornerRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                mLips.getElements().clear();
                mLips.getElements().add(new MoveTo(rightCorner.getX(), rightCorner.getY()));
                mLips.getElements().add(new QuadCurveTo(upperPoint.getX(), upperPoint.getY(), leftCorner.getX(), leftCornerRegulator));
                mLips.getElements().add(new QuadCurveTo(downPoint.getX(), downPoint.getY(), rightCorner.getX(), rightCorner.getY()));
                mLips.getElements().add(new ClosePath());

                if (step == 2) {
                    leftCornerRegulator = 0;
                }
                break;

            case RIGHTCORNERACTION:
                if (step == 20) {
                    recordRightCornerRegulator = rightCornerRegulator;
                    rightCornerRegulator = rightCorner.getY();
                }
                rightCornerRegulator += recordRightCornerRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                mLips.getElements().clear();
                mLips.getElements().add(new MoveTo(rightCorner.getX(), rightCornerRegulator));
                mLips.getElements().add(new QuadCurveTo(upperPoint.getX(), upperPoint.getY(), leftCorner.getX(), leftCorner.getY()));
                mLips.getElements().add(new QuadCurveTo(downPoint.getX(), downPoint.getY(), rightCorner.getX(), rightCornerRegulator));
                mLips.getElements().add(new ClosePath());

                if (step == 2) {
                    rightCornerRegulator = 0;
                }
                break;

            case OPEN:
                openMouth();
                break;
            case ONE:
            case THREE:
            case FIVE:
            case SEVEN:
            case NINE:
            case ELEVEN:
            case THIRTEEN:
            case NINETEEN:
                openMouth();
                break;
            case TWO:
            case FOUR:
            case SIX:
            case EIGHT:
            case TEN:
            case TWELVE:
            case FOURTEEN:
            case TWENTY:
                closeMouth();
                break;

        }
    }

    private void openMouth()
    {
        mLips.getElements().clear();
        mLips.getElements().add(new MoveTo(leftCorner.getX(), leftCorner.getY()));
        mLips.getElements().add(new QuadCurveTo(upperPoint.getX(), upperPoint.getY() - 10, rightCorner.getX(), rightCorner.getY()));
        mLips.getElements().add(new QuadCurveTo(downPoint.getX(), downPoint.getY() + 10, leftCorner.getX(), leftCorner.getY()));
        mLips.getElements().add(new ClosePath());
    }

    private void closeMouth()
    {
        mLips.getElements().clear();
        mLips.setStrokeLineJoin(StrokeLineJoin.ROUND);
        mLips.setStrokeWidth(3);
        mLips.setStroke(mColor);
        mLips.getElements().add(new MoveTo(rightCorner.getX(), rightCorner.getY()));
        mLips.getElements().add(new QuadCurveTo(upperPoint.getX(), upperPoint.getY(), leftCorner.getX(), leftCorner.getY()));
        mLips.getElements().add(new QuadCurveTo(downPoint.getX(), downPoint.getY(), rightCorner.getX(), rightCorner.getY()));
        mLips.getElements().add(new ClosePath());
        mLips.setStyle("-fx-color: red");
    }

    public double getRightCornerRegulator() {
        return rightCornerRegulator;
    }

    public void setRightCornerRegulator(int leftCornerRegler) {
        this.rightCornerRegulator = leftCornerRegler;
    }

    public double getLeftCornerRegulator() {
        return leftCornerRegulator;
    }

    public void setLeftCornerRegulator(int rightCornerRegler) {
        this.leftCornerRegulator = rightCornerRegler;
    }

    public double getUpRegulator() {
        return upRegulator;
    }

    public void setUpRegulator(int upRegler) {
        this.upRegulator = upRegler;
    }

    public double getDownRegulator() {
        return downRegulator;
    }

    public void setDownRegulator(int downRegler) {
        this.downRegulator = downRegler;
    }

    public Path getmLips() {
        return mLips;
    }

    public Point2D getLeftCorner() {
        return leftCorner;
    }

    public Point2D getRightCorner() {
        return rightCorner;
    }

    public Point2D getUpperPoint() {
        return upperPoint;
    }

    public Point2D getDownPoint() {
        return downPoint;
    }
    
    
    
    
    
    
    
    
}
