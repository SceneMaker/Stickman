package de.dfki.stickmanFX.bodyfx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import de.dfki.common.enums.Gender;
import de.dfki.common.enums.Orientation;
import de.dfki.common.part.Part2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Affine;

import java.awt.*;

/**
 * @author Beka Aptsiauri
 */
public class BodyFX extends PartStickman2D
{

    public Color currentColor = null;
    NeckFX mNeckFX;
    Dimension mSize = new Dimension(120, 300);
    int mHalfSizeX = mSize.width / 2;
    int mHalfSizeY = mSize.height / 2;
    int mDrawOffset = 20;
    Point mStart;
    Point mLefShoulderPosition;     //Added by Beka
    Point mRightShoulderPosition;   //Added by Beka
    Path mFemaleBodyFront, mFemaleBodyLeft, mFemaleBodyRight;
    Path mMaleBodyFront, mMaleBodyLeft, mMaleBodyRight;
    private Color mFemaleColorRecorder = mFemaleColor;
    private Color mMaleColorRecorder = mMaleColor;

    public BodyFX(Part2D neck)
    {
        mNeckFX = (NeckFX) neck;
        mStart = mNeckFX.getBodyStartPosition();
        mFemaleColor = Color.rgb(154, 83, 198, mColoropacity);
        mMaleColor = Color.rgb(14, 134, 122, mColoropacity);
        // used by RestButton.
        mColoropacityRest = (240 * 100 / 255) / 100f;
        mFemaleColorRest = Color.rgb(154, 83, 198, mColoropacity);
        mMaleColorRest = Color.rgb(14, 134, 122, mColoropacity);

        mColor = (mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.FEMALE) ? mFemaleColor : mMaleColor;
        mFemaleBodyFront = new Path();
        mFemaleBodyLeft = new Path();
        mFemaleBodyRight = new Path();
        mMaleBodyFront = new Path();
        mMaleBodyLeft = new Path();
        mMaleBodyRight = new Path();

        init();
    }

    @Override
    public void init()
    {
        this.setPrefHeight(mSize.height);
        this.setPrefWidth(mSize.width);
    }

    @Override
    public void calculate(int step)
    {
        mStart = mNeckFX.getBodyStartPosition();
        this.getChildren().clear();

        LeftShoulderFX leftShoulderFX = (LeftShoulderFX) mNeckFX.mHeadFX.mStickmanFX.mLeftShoulderFX;
        RightShoulderFX rightShoulderFX = (RightShoulderFX) mNeckFX.mHeadFX.mStickmanFX.mRightShoulderFX;
        this.mLefShoulderPosition = leftShoulderFX.getLeftShoulderEndPosition();       //Added by Beka
        this.mRightShoulderPosition = rightShoulderFX.getRightShoulderEndPosition();

        mFemaleBodyFront = new Path();
        mFemaleBodyFront.getElements().add(new MoveTo(mStart.x, mStart.y));
        mFemaleBodyFront.getElements().add(new LineTo(mLefShoulderPosition.x + 1, mLefShoulderPosition.y + 1));
        mFemaleBodyFront.getElements().add(new QuadCurveTo(mStart.x, mHalfSizeY + mDrawOffset, mStart.x + mHalfSizeX, mSize.height + 10));
        mFemaleBodyFront.getElements().add(new CubicCurveTo(mStart.x + mHalfSizeX - 40, mSize.height - 10, mStart.x - mHalfSizeX + 40, mSize.height + 20, mStart.x - mHalfSizeX, mSize.height));
        mFemaleBodyFront.getElements().add(new QuadCurveTo(mStart.x, mHalfSizeY + mDrawOffset, mRightShoulderPosition.x, mRightShoulderPosition.y));

        mFemaleBodyLeft = new Path();
        mFemaleBodyLeft.getElements().add(new MoveTo(mStart.x, mStart.y));
        mFemaleBodyLeft.getElements().add(new QuadCurveTo(mStart.x + mDrawOffset, mSize.height / 3 * 2, mStart.x, mSize.height));
        mFemaleBodyLeft.getElements().add(new LineTo(mStart.x - mHalfSizeX, mSize.height));
        mFemaleBodyLeft.getElements().add(new QuadCurveTo(mStart.x, mHalfSizeY + mDrawOffset, mStart.x, mStart.y));

        mFemaleBodyRight = new Path();
        mFemaleBodyRight.getElements().add(new MoveTo(mStart.x, mStart.y));
        mFemaleBodyRight.getElements().add(new QuadCurveTo(mStart.x - mDrawOffset, mSize.height / 3 * 2, mStart.x, mSize.height));
        mFemaleBodyRight.getElements().add(new LineTo(mStart.x + mHalfSizeX, mSize.height));
        mFemaleBodyRight.getElements().add(new QuadCurveTo(mStart.x, mHalfSizeY + mDrawOffset, mStart.x, mStart.y));

        mMaleBodyFront = new Path();
        mMaleBodyFront.getElements().add(new MoveTo(mStart.x, mStart.y));
        mMaleBodyFront.getElements().add(new LineTo(mLefShoulderPosition.x + 1, mLefShoulderPosition.y + 1));
        mMaleBodyFront.getElements().add(new QuadCurveTo(mStart.x, mHalfSizeY + mDrawOffset, mStart.x + mHalfSizeX - mDrawOffset - 10, mSize.height));
        mMaleBodyFront.getElements().add(new LineTo(mStart.x - mHalfSizeX + mDrawOffset + 10, mSize.height));
        mMaleBodyFront.getElements().add(new QuadCurveTo(mStart.x, mHalfSizeY + mDrawOffset, mRightShoulderPosition.x, mRightShoulderPosition.y));

        mMaleBodyLeft = new Path();
        mMaleBodyLeft.getElements().add(new MoveTo(mStart.x, mStart.y));
        mMaleBodyLeft.getElements().add(new QuadCurveTo(mStart.x + mDrawOffset, mSize.height / 3 * 2, mStart.x, mSize.height));
        mMaleBodyLeft.getElements().add(new LineTo(mStart.x - mHalfSizeX + mDrawOffset, mSize.height));
        mMaleBodyLeft.getElements().add(new QuadCurveTo(mStart.x, mHalfSizeY + mDrawOffset, mStart.x, mStart.y));

        mMaleBodyRight = new Path();
        mMaleBodyRight.getElements().add(new MoveTo(mStart.x, mStart.y));
        mMaleBodyRight.getElements().add(new QuadCurveTo(mStart.x - mDrawOffset, mSize.height / 3 * 2, mStart.x, mSize.height));
        mMaleBodyRight.getElements().add(new LineTo(mStart.x + mHalfSizeX - mDrawOffset, mSize.height));
        mMaleBodyRight.getElements().add(new QuadCurveTo(mStart.x, mHalfSizeY + mDrawOffset, mStart.x, mStart.y));

        update();
    }

    @Override
    public void setShape(String s)
    {

    }

    public Point getLeftArmStartPostion()
    {
        return new Point(mStart.x + 1, mStart.y);
    }

    public Point getRightArmStartPostion()
    {
        return new Point(mStart.x - 1, mStart.y);
    }

    public Point getLeftLegStartPostion()
    {
        if (mNeckFX.mHeadFX.mStickmanFX.mOrientation == Orientation.LEFT)
        {
            return new Point(mStart.x + mHalfSizeX - mDrawOffset, mSize.height);
        } else
        {
            return new Point(mStart.x + mHalfSizeX - mDrawOffset - 20,
                    (mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.FEMALE) ? mSize.height + 3 : mSize.height);
        }
    }

    public Point getRightLegStartPostion()
    {
        if (mNeckFX.mHeadFX.mStickmanFX.mOrientation == Orientation.RIGHT)
        {
            return new Point(mStart.x, mSize.height);
        } else
        {
            return new Point(mStart.x - mHalfSizeX + mDrawOffset + 20,
                    (mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.FEMALE) ? mSize.height + 5 : mSize.height);
        }
    }

    private void paintLeftOrientation(Color c)
    {
        if (mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.FEMALE)
        {
            this.getChildren().remove(mFemaleBodyLeft);
            mFemaleBodyLeft.setFill(c);
            this.getChildren().add(mFemaleBodyLeft);
        } else
        {
            this.getChildren().remove(mMaleBodyLeft);
            mMaleBodyLeft.setFill(c);
            this.getChildren().add(mMaleBodyLeft);
        }

        // draw outlines
        if (mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.FEMALE)
        {
            mFemaleBodyLeft.setStroke(c.darker());
            mFemaleBodyLeft.setStrokeLineCap(StrokeLineCap.ROUND);
            mFemaleBodyLeft.setStrokeLineJoin(StrokeLineJoin.ROUND);
            mFemaleBodyLeft.setStrokeWidth(2);
        } else
        {
            mMaleBodyLeft.setStroke(c.darker());
            mMaleBodyLeft.setStrokeLineCap(StrokeLineCap.ROUND);
            mMaleBodyLeft.setStrokeLineJoin(StrokeLineJoin.ROUND);
            mMaleBodyLeft.setStrokeWidth(2);
        }
    }

    private void paintRightOrientation(Color c)
    {
        if (mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.FEMALE)
        {
            this.getChildren().remove(mFemaleBodyRight);
            mFemaleBodyRight.setFill(c);
            this.getChildren().add(mFemaleBodyRight);
        } else
        {
            this.getChildren().remove(mMaleBodyRight);
            mMaleBodyRight.setFill(c);
            this.getChildren().add(mMaleBodyRight);
        }

        // draw outlines
        if (mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.FEMALE)
        {
            mFemaleBodyRight.setStroke(c.darker());
            mFemaleBodyRight.setStrokeLineCap(StrokeLineCap.ROUND);
            mFemaleBodyRight.setStrokeLineJoin(StrokeLineJoin.ROUND);
            mFemaleBodyRight.setStrokeWidth(2);
        } else
        {
            mMaleBodyRight.setStroke(c.darker());
            mMaleBodyRight.setStrokeLineCap(StrokeLineCap.ROUND);
            mMaleBodyRight.setStrokeLineJoin(StrokeLineJoin.ROUND);
            mMaleBodyRight.setStrokeWidth(2);
        }
    }

    public void paintFrontOrientation(Color c)
    {
        if (mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.FEMALE)
        {
            this.getChildren().clear();
            mFemaleBodyFront.setFill(c);
            this.getChildren().add(mFemaleBodyFront);
        } else
        {
            this.getChildren().clear();
            mMaleBodyFront.setFill(c);
            this.getChildren().add(mMaleBodyFront);
        }

        // draw outlines
        if (mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.FEMALE)
        {
            mFemaleBodyFront.setStroke(c.darker());
            mFemaleBodyFront.setStrokeLineCap(StrokeLineCap.ROUND);
            mFemaleBodyFront.setStrokeLineJoin(StrokeLineJoin.ROUND);
            mFemaleBodyFront.setStrokeWidth(2);
        } else
        {
            mMaleBodyFront.setStroke(c.darker());
            mMaleBodyFront.setStrokeLineCap(StrokeLineCap.ROUND);
            mMaleBodyFront.setStrokeLineJoin(StrokeLineJoin.ROUND);
            mMaleBodyFront.setStrokeWidth(2);
        }
    }

    public void update()
    {

        if (mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
        {
            mFemaleColorRecorder = mFemaleColor;
            mMaleColorRecorder = mMaleColor;
        }

        //calculate();
        if (mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true)
        {
            if (mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
                if (fadeFactor <= 24)
                {
                    fadeFactor = 0;
                }
                mFemaleColor = new Color(mFemaleColor.getRed(), mFemaleColor.getGreen(), mFemaleColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                mMaleColor = new Color(mMaleColor.getRed(), mMaleColor.getGreen(), mMaleColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
//                mFemaleColor = Color.rgb(154, 83, 198, (fadeFactor * 100 / 255) / 100f);
//                mMaleColor = Color.rgb(14, 134, 122, (fadeFactor * 100 / 255) / 100f);
            } else
            {
                int fadeFactor = (20 - mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
                if (fadeFactor >= 160)
                {
                    mFemaleColor = mFemaleColorRecorder;
                    mMaleColor = mMaleColorRecorder;
                } else
                {
                    mFemaleColor = new Color(mFemaleColor.getRed(), mFemaleColor.getGreen(), mFemaleColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                    mMaleColor = new Color(mMaleColor.getRed(), mMaleColor.getGreen(), mMaleColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                }
//                mFemaleColor = Color.rgb(154, 83, 198, (fadeFactor * 100 / 255) / 100f);
//                mMaleColor = Color.rgb(14, 134, 122, (fadeFactor * 100 / 255) / 100f);
            }
        }

        if (mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.FEMALE)
        {
            currentColor = mFemaleColor;
        } else
        {
            currentColor = mMaleColor;
        }

        if (mNeckFX.mHeadFX.mStickmanFX.mOrientation == Orientation.LEFT)
        {
            paintLeftOrientation(currentColor);
        } else if (mNeckFX.mHeadFX.mStickmanFX.mOrientation == Orientation.RIGHT)
        {
            paintRightOrientation(currentColor);
        } else
        {
            paintFrontOrientation(currentColor);
        }
    }

    public void rotatePerlinNoise(double mWobble, int x, int y)
    {
        Affine af = new Affine();
        //Out put perlin noise
        af.appendRotation(Math.toRadians(mWobble), x, y);
        this.getTransforms().clear();
        this.getTransforms().add(af);

    }

}
