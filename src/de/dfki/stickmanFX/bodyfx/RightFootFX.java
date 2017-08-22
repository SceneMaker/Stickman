/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.bodyfx;

import de.dfki.common.part.Part2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Affine;

import java.awt.*;

/**
 * @author Beka
 */
public class RightFootFX extends PartStickman2D
{

    RightForeLegFX mRightForeLegFX;

    Point mStart;
    Point mEnd;

    Path mLeg;

    public RightFootFX(Part2D rightForeLeg)
    {
        mRightForeLegFX = (RightForeLegFX) rightForeLeg;
        mLength = 10;
        mColor = Color.rgb(80, 80, 80);
        setDefaulRotation(0);

        mLeg = new Path();
        this.getChildren().add(mLeg);

        init();

        calculate(0);
    }

    public Point getLegStartPosition()
    {
        if (mRotation >= 0 && mRotation <= 90)
        {
            return (mLeg != null) ? new Point((int) (mLeg.boundsInParentProperty().get().getMinX() + 2), (int) mLeg.boundsInParentProperty().get().getMaxY() - 1) : new Point(0, 0);
        } else if (mRotation > 90 && mRotation <= 180)
        {
            return (mLeg != null) ? new Point((int) (mLeg.boundsInParentProperty().get().getMinX()), (int) mLeg.boundsInParentProperty().get().getMinY() + 3) : new Point(0, 0);
        } else if (mRotation < 0 && mRotation >= -90)
        {
            return (mLeg != null) ? new Point((int) (mLeg.boundsInParentProperty().get().getMaxX()), (int) mLeg.boundsInParentProperty().get().getMaxY()) : new Point(0, 0);
        } else
        {
            return (mLeg != null) ? new Point((int) (mLeg.boundsInParentProperty().get().getMaxX()), (int) mLeg.boundsInParentProperty().get().getMinY()) : new Point(0, 0);
        }
    }

    @Override
    public void calculate(int step)
    {
        this.getChildren().clear();
        ;

        mLeg = new Path();

        mStart = mRightForeLegFX.getLegStartPosition();
        mEnd = new Point(mStart.x, mStart.y);

        mLeg.getElements().add(new MoveTo(mEnd.x + 2, mEnd.y + 4));
        mLeg.getElements().add(new QuadCurveTo(mEnd.x - 2, mEnd.y + 2, mEnd.x - 12, mEnd.y + 4));

        Affine af = new Affine();
        af.appendRotation(mRotation, mStart.x, mStart.y);
        mLeg.getTransforms().clear();
        mLeg.getTransforms().add(af);

        this.getChildren().add(mLeg);
        this.update();
    }

    @Override
    public void setShape(String s)
    {

    }

    @Override
    public void update()
    {
        if (mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
        {
            mColorRecorder = mColor;
        }
        if (mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true)
        {
            if (mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
                if (fadeFactor <= 24)
                {
                    fadeFactor = 0;
                }
                mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
            } else
            {
                int fadeFactor = (20 - mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216)
                {
                    mColor = mColorRecorder;
                } else
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                }
                //mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
            }
        }

        mLeg.setStroke(mColor);
        mLeg.setStrokeWidth(3);
        mLeg.setStrokeLineCap(StrokeLineCap.ROUND);
        mLeg.setStrokeLineJoin(StrokeLineJoin.ROUND);
    }
}
