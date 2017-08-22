package de.dfki.stickmanFX.bodyfx;

import de.dfki.common.enums.Gender;
import de.dfki.common.part.Part2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Affine;

import java.awt.*;

/**
 * @author Patrick Gebhard
 */
public class RightShoulderFX extends PartStickman2D
{

    BodyFX mBodyFX;

    int mShoulderLength = 15;
    Dimension mSize = new Dimension(mShoulderLength, mShoulderLength);

    Point mStart;
    Point mEnd;

    Path mShoulder;

    public RightShoulderFX(Part2D body)
    {
        mBodyFX = (BodyFX) body;
        if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == Gender.TYPE.MALE)
        {
            mShoulderLength = 25;
        } else
        {
            mShoulderLength = 15;
        }
        mColor = Color.rgb(80, 80, 80);

        mDefaultRotation = 70;
        mRotation = mDefaultRotation;
        mToDegree = mDefaultRotation;
        mRotationStep = 0.0f;
        mShoulder = new Path();
        this.getChildren().add(mShoulder);
        init();

        calculate(0);
    }

    public Point getRightShoulderEndPosition()
    {
        //return (mShoulder != null) ? new Point((int) (mShoulder.boundsInParentProperty().get().getMinX()+ 2), (int) mShoulder.boundsInParentProperty().get().getMaxY()-1) : new Point(0, 0);
        if (mRotation >= 0 && mRotation <= 90)
        {
            return (mShoulder != null) ? new Point((int) (mShoulder.boundsInParentProperty().get().getMinX() + 2), (int) mShoulder.boundsInParentProperty().get().getMaxY() - 2) : new Point(0, 0);
        } else if (mRotation > 90 && mRotation <= 180)
        {
            return (mShoulder != null) ? new Point((int) (mShoulder.boundsInParentProperty().get().getMinX()), (int) mShoulder.boundsInParentProperty().get().getMinY()) : new Point(0, 0);
        } else if (mRotation < 0 && mRotation >= -90)
        {
            return (mShoulder != null) ? new Point((int) (mShoulder.boundsInParentProperty().get().getMaxX()), (int) mShoulder.boundsInParentProperty().get().getMaxY()) : new Point(0, 0);
        } else
        {
            return (mShoulder != null) ? new Point((int) (mShoulder.boundsInParentProperty().get().getMaxX()), (int) mShoulder.boundsInParentProperty().get().getMinY()) : new Point(0, 0);
        }
    }

    @Override
    public void calculate(int step)
    {
        mStart = mBodyFX.getRightArmStartPostion();
        mEnd = new Point(mStart.x, mStart.y + mShoulderLength);
        this.getChildren().clear();

        mShoulder.getElements().add(new MoveTo(mStart.x, mStart.y + 2));
        mShoulder.getElements().add(new QuadCurveTo(mStart.x, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y));

        Affine af = new Affine();
        af.appendRotation(mRotation, mStart.x, mStart.y);
        mShoulder.getTransforms().clear();
        mShoulder.getTransforms().add(af);

        this.getChildren().add(mShoulder);
        update();

        //calculate and update bodyfx (right shoulder area)
        if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mRightShoulderFX != null)
        {
            mBodyFX.calculate(0);
        }
    }

    @Override
    public void setShape(String s)
    {

    }

    @Override
    public void update()
    {
        if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
        {
            mColorRecorder = mColor;
        }
        if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true)
        {
            if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
                if (fadeFactor <= 24)
                {
                    fadeFactor = 0;
                }
                mColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);
            } else
            {
                int fadeFactor = (20 - mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216)
                {
                    mColor = mColorRecorder;
                } else
                {
                    mColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);
                }
                //g2.setColor(new Color(80, 80, 80,fadeFactor));
            }
        }

        if (mBodyFX.currentColor != null) //mShoulder.setStroke(mColor);
        {
            mShoulder.setStroke(mBodyFX.currentColor);
        }
        mShoulder.setStrokeWidth(3);
        mShoulder.setStrokeLineCap(StrokeLineCap.ROUND);
        mShoulder.setStrokeLineJoin(StrokeLineJoin.ROUND);
    }
}
