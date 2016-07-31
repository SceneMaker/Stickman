package de.dfki.stickmanfx.bodyfx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import de.dfki.stickmanfx.StickmanFX;
import java.awt.Dimension;
import java.awt.Point;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class BodyFX extends Group {

    NeckFX mNeckFX;

    Dimension mSize = new Dimension(120, 300);
    int mHalfSizeX = mSize.width / 2;
    int mHalfSizeY = mSize.height / 2;
    int mDrawOffset = 20;
    Point mStart;

    public Color mFemaleColor = Color.rgb(154, 83, 198, (240 * 100 / 255) / 100f);    // The color is changed in paintComponent
    public Color mMaleColor = Color.rgb(14, 134, 122, (240 * 100 / 255) / 100f);
    public Color mColor = mFemaleColor;
    public Color currentColor = null;

    Path mFemaleBodyFront, mFemaleBodyLeft, mFemaleBodyRight;
    Path mMaleBodyFront, mMaleBodyLeft, mMaleBodyRight;

    public BodyFX(NeckFX neck) {
        mNeckFX = neck;
        mStart = mNeckFX.getBodyStartPosition();
        mColor = (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) ? mFemaleColor : mMaleColor;
        init();
    }

    private void init() 
    {
        this.prefHeight(mSize.height);
        this.prefWidth(mSize.width);
    }

    private void calculate() 
    {
        mStart = mNeckFX.getBodyStartPosition();

        mFemaleBodyFront = new Path();
        mFemaleBodyFront.getElements().add(new MoveTo(mStart.x, mStart.y));
        mFemaleBodyFront.getElements().add(new QuadCurveTo(mStart.x, mHalfSizeY + mDrawOffset, mStart.x + mHalfSizeX, mSize.height + 10));
        mFemaleBodyFront.getElements().add(new CubicCurveTo(mStart.x + mHalfSizeX - 40, mSize.height - 10, mStart.x - mHalfSizeX + 40, mSize.height + 20, mStart.x - mHalfSizeX, mSize.height));
        mFemaleBodyFront.getElements().add(new QuadCurveTo(mStart.x, mHalfSizeY + mDrawOffset, mStart.x, mStart.y));

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
        mMaleBodyFront.getElements().add(new QuadCurveTo(mStart.x, mHalfSizeY + mDrawOffset, mStart.x + mHalfSizeX - mDrawOffset, mSize.height));
        mMaleBodyFront.getElements().add(new LineTo(mStart.x - mHalfSizeX + mDrawOffset, mSize.height));
        mMaleBodyFront.getElements().add(new QuadCurveTo(mStart.x, mHalfSizeY + mDrawOffset, mStart.x, mStart.y));

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
    }

    public Point getLeftArmStartPostion() 
    {
        return new Point(mStart.x + 1, mStart.y + 4);
    }

    public Point getRightArmStartPostion() 
    {
        return new Point(mStart.x - 1, mStart.y + 4);
    }

    public Point getLeftLegStartPostion() 
    {
        if (mNeckFX.mHeadFX.mStickmanFX.mOrientation == StickmanFX.ORIENTATION.LEFT) 
        {
            return new Point(mStart.x + mHalfSizeX - mDrawOffset, mSize.height);
        } 
        else 
        {
            return new Point(mStart.x + mHalfSizeX - mDrawOffset,
                    (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) ? mSize.height + 3 : mSize.height);
        }
    }

    public Point getRightLegStartPostion() 
    {
        if (mNeckFX.mHeadFX.mStickmanFX.mOrientation == StickmanFX.ORIENTATION.RIGHT) {
            return new Point(mStart.x, mSize.height);
        } 
        else 
        {
            return new Point(mStart.x - mHalfSizeX + mDrawOffset,
                    (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) ? mSize.height + 5 : mSize.height);
        }
    }

    private void paintLeftOrientation(Color c) 
    {
        if (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) 
        {
            mFemaleBodyLeft.setFill(c);
            this.getChildren().add(mFemaleBodyLeft);
        } 
        else 
        {
            mMaleBodyLeft.setFill(c);
            this.getChildren().add(mMaleBodyLeft);
        }

        // draw outlines
        if (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) 
        {
            mFemaleBodyLeft.setStroke(c.darker());
            mFemaleBodyLeft.setStrokeWidth(2);
        } 
        else 
        {
            mMaleBodyLeft.setStroke(c.darker());
            mMaleBodyLeft.setStrokeWidth(2);
        }
    }

    private void paintRightOrientation(Color c) 
    {
        if (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) 
        {
            mFemaleBodyRight.setFill(c);
            this.getChildren().add(mFemaleBodyRight);
        } 
        else 
        {
            mMaleBodyRight.setFill(c);
            this.getChildren().add(mMaleBodyRight);
        }

        // draw outlines
        if (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) 
        {
            mFemaleBodyRight.setStroke(c.darker());
            mFemaleBodyRight.setStrokeWidth(2);
        } 
        else 
        {
            mMaleBodyRight.setStroke(c.darker());
            mMaleBodyRight.setStrokeWidth(2);
        }
    }

    private void paintFrontOrientation(Color c) 
    {
        if (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) 
        {
            mFemaleBodyFront.setFill(c);
            this.getChildren().add(mFemaleBodyFront);
        } 
        else 
        {
            mMaleBodyFront.setFill(c);
            this.getChildren().add(mMaleBodyFront);
        }

        // draw outlines
        if (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) 
        {
            mFemaleBodyFront.setStroke(c.darker());
            mFemaleBodyFront.setStrokeWidth(2);
        } 
        else 
        {
            mMaleBodyFront.setStroke(c.darker());
            mMaleBodyFront.setStrokeWidth(2);
        }
    }

    public void update() {

        calculate();

        if (mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) 
        {
            if (mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
                if (fadeFactor <= 24) 
                {
                    fadeFactor = 0;
                }
                mFemaleColor = Color.rgb(154, 83, 198, (fadeFactor * 100 / 255) / 100f);
                mMaleColor = Color.rgb(14, 134, 122, (fadeFactor * 100 / 255) / 100f);
            } 
            else 
            {
                int fadeFactor = (20 - mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
                if (fadeFactor >= 160) 
                {
                    fadeFactor = 240;
                }
                mFemaleColor = Color.rgb(154, 83, 198, (fadeFactor * 100 / 255) / 100f);
                mMaleColor = Color.rgb(14, 134, 122, (fadeFactor * 100 / 255) / 100f);
            }
        }

        if (mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE) 
        {
            currentColor = mFemaleColor;
        } 
        else 
        {
            currentColor = mMaleColor;
        }

        if (mNeckFX.mHeadFX.mStickmanFX.mOrientation == StickmanFX.ORIENTATION.LEFT) 
        {
            paintLeftOrientation(currentColor);
        } 
        else if (mNeckFX.mHeadFX.mStickmanFX.mOrientation == StickmanFX.ORIENTATION.RIGHT) 
        {
            paintRightOrientation(currentColor);
        } 
        else 
        {
            paintFrontOrientation(currentColor);
        }
    }

}
