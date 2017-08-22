package de.dfki.reeti.body;

import de.dfki.common.part.Part3D;
import de.dfki.reeti.animationlogic.AnimatorReeti;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author Beka Aptsiauri
 */
public class Mouth extends PartReeti
{

    private final int mouthLength = 32;
    public Point2D leftCorner;
    public Point2D rightCorner;
    public Point2D upperPoint;
    public Point2D downPoint;
    public Mouth.SHAPE mShape = Mouth.SHAPE.DEFAULT;
    private Path mLips;
    private boolean openMouth = false;

    private double rightCornerRegulator = 0;
    private double leftCornerRegulator = 0;
    private double upRegulator = 0;
    private double downRegulator = 0;

    private double recordLeftCornerRegulator;
    private double recordRightCornerRegulator;
    private double recordUpRegulator;
    private double recordDownRegulator;

    public Mouth(Part3D head)
    {
        mSize = new Dimension(mLength * 2, 5);
        mColor = Color.DARKGREY;
        mLips = new Path();
        mStart = ((Head) head).getMouthPostion();

        rightCorner = new Point2D.Double(-9, 35);
        leftCorner = new Point2D.Double(rightCorner.getX() + mouthLength, rightCorner.getY());
        upperPoint = new Point2D.Double(rightCorner.getX() + mouthLength / 2, rightCorner.getY());
        downPoint = new Point2D.Double(upperPoint.getX(), upperPoint.getY());

        init();
        ((Head) head).getHeadGroup().getChildren().addAll(mLips);
    }

    @Override
    public void init()
    {
        super.init();
        mLips.setTranslateX(mStart.getX() - 7);
        mLips.setTranslateY(mStart.getY() + 28);
        mLips.setTranslateZ(-135.5);
    }

    @Override
    public void setShape(String s)
    {
        Mouth.SHAPE shape = Mouth.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : Mouth.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = Mouth.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        switch (mShape)
        {
            case DEFAULT:
                closeMouth();
                break;

            case MOUTHACTION:
                if (step == 20)
                {
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
                if (step == 2)
                {
                    downRegulator = 0;
                    upRegulator = 0;
                    rightCornerRegulator = 0;
                    leftCornerRegulator = 0;
                }
                break;

            case MOUTHACTIONEND:
                if (step == 20)
                {
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

                if (step == 2)
                {
                    downRegulator = 0;
                    upRegulator = 0;
                    rightCornerRegulator = 0;
                    leftCornerRegulator = 0;
                }
                break;

            case LEFTCORNERACTION:
                if (step == 20)
                {
                    recordLeftCornerRegulator = leftCornerRegulator;
                    leftCornerRegulator = leftCorner.getY();
                }

                leftCornerRegulator += recordLeftCornerRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                mLips.getElements().clear();
                mLips.getElements().add(new MoveTo(rightCorner.getX(), rightCorner.getY()));
                mLips.getElements().add(new QuadCurveTo(upperPoint.getX(), upperPoint.getY(), leftCorner.getX(), leftCornerRegulator));
                mLips.getElements().add(new QuadCurveTo(downPoint.getX(), downPoint.getY(), rightCorner.getX(), rightCorner.getY()));
                mLips.getElements().add(new ClosePath());

                if (step == 2)
                {
                    leftCornerRegulator = 0;
                }
                break;

            case RIGHTCORNERACTION:
                if (step == 20)
                {
                    recordRightCornerRegulator = rightCornerRegulator;
                    rightCornerRegulator = rightCorner.getY();
                }
                rightCornerRegulator += recordRightCornerRegulator / AnimatorReeti.sMAX_ANIM_STEPS;
                mLips.getElements().clear();
                mLips.getElements().add(new MoveTo(rightCorner.getX(), rightCornerRegulator));
                mLips.getElements().add(new QuadCurveTo(upperPoint.getX(), upperPoint.getY(), leftCorner.getX(), leftCorner.getY()));
                mLips.getElements().add(new QuadCurveTo(downPoint.getX(), downPoint.getY(), rightCorner.getX(), rightCornerRegulator));
                mLips.getElements().add(new ClosePath());

                if (step == 2)
                {
                    rightCornerRegulator = 0;
                }
                break;

            case OPEN:
                openMouth(1);
                break;
            case ONE:
                openMouth(0.5);
                break;
            case SIX:
            case FOURTEEN:
                openMouth(1);
                break;
            case NINETEEN:
                openMouth(0.7);
                break;
            case TWO:
                openMouth(1);
                break;
            case THREE:
            case TWENTY:
                openMouth(0.8);
                break;
            case FOUR:
                openMouth(0.9);
                break;
            case FIVE:
            case EIGHT:
                openMouth(0.9);
                break;
            case SEVEN:
                closeMouth();
                break;
            case NINE:
                openMouth(1);
                break;
            case TEN:
                openMouth(0.9);
                break;
            case ELEVEN:
                openMouth(0.9);
                break;
            case THIRTEEN:
            case TWELVE:
                openMouth(0.9);
                break;

        }
    }

    private void openMouth(double factor)
    {
        mLips.getElements().clear();
        mLips.getElements().add(new MoveTo(leftCorner.getX(), leftCorner.getY()));
        mLips.getElements().add(new QuadCurveTo(upperPoint.getX(), upperPoint.getY() - 10 * factor, rightCorner.getX(), rightCorner.getY()));
        mLips.getElements().add(new QuadCurveTo(downPoint.getX(), downPoint.getY() + 10 * factor, leftCorner.getX(), leftCorner.getY()));
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
        mLips.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 );");
    }

    public void setUpRegulator(int upRegler)
    {
        this.upRegulator = upRegler;
    }

    public void setDownRegulator(int downRegler)
    {
        this.downRegulator = downRegler;
    }

    public Path getLips()
    {
        return mLips;
    }

    public Point2D getLeftCorner()
    {
        return leftCorner;
    }

    public Point2D getRightCorner()
    {
        return rightCorner;
    }

    public Point2D getUpperPoint()
    {
        return upperPoint;
    }

    public Point2D getDownPoint()
    {
        return downPoint;
    }

    public enum SHAPE
    {
        DEFAULT, MOUTHACTION, MOUTHACTIONEND, LEFTCORNERACTION, LEFTCORNERACTIONEND, RIGHTCORNERACTION, RIGHTCORNERACTIONEND, OPEN,
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, NINETEEN, TWENTY
    }


}
