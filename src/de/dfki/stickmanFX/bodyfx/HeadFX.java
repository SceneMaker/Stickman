package de.dfki.stickmanFX.bodyfx;

import de.dfki.stickmanFX.StickmanFX;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.transform.Affine;

import java.awt.*;

/**
 * @author Beka Aptsiauri
 */
public class HeadFX extends PartStickman2D
{

    public Dimension mSize = new Dimension(120, 100);
    public StickmanFX mStickmanFX;
    public boolean translateRight = false;
    int mHalfHeight = mSize.height / 2;
    int mHalfWidth = mSize.width / 2;
    int mEarWidth = 10;
    int mDrawOffset = 10;
    int mXCenterOffset = mEarWidth / 2;
    int mYCenterOffset = mEarWidth / 2;
    Path mHead, mLeftEar, mRightEar;

    public HeadFX(StickmanFX sm)
    {
        mStickmanFX = sm;
        mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);
        mStroke = new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        mHead = new Path();
        mLeftEar = new Path();
        mRightEar = new Path();
        mColoropacity = 1f;
        mColor = Color.rgb(242, 227, 217, mColoropacity);
//        mColor = Color.rgb(242, 227, 217, 1);
        this.getChildren().addAll(mHead, mLeftEar, mRightEar);

        init();

        calculate(0);
    }

    public Point getLeftEyebrowPostion()
    {
        return new Point(mHalfWidth + 23, mHalfHeight - 16);
    }

    public Point getNosePostion()
    {
        return new Point(mHalfWidth + 5, mHalfHeight - 5);
    }

    public Point getRightEyebrowPostion()
    {
        return new Point(mHalfWidth - 11, mHalfHeight - 16);
    }

    public Point getLeftEyePostion()
    {
        return new Point(mHalfWidth + 32, mHalfHeight - 8);
    }

    public Point getRightEyePostion()
    {
        return new Point(mHalfWidth - 20, mHalfHeight - 8);
    }

    public Point getMouthPostion()
    {
        return new Point(mHalfWidth + mEarWidth / 2, mHalfHeight + mDrawOffset * 3);
    }

    public Point getSpeechBubbleStartPosition()
    {
        return new Point(mHalfWidth + 20, mHalfHeight + 30);
    }

    public Point getNeckStartPosition()
    {
        return new Point(mSize.width / 2 + mXCenterOffset, mSize.height + mYCenterOffset);
    }

    public void calculate(int step)
    {
        Affine af = new Affine();
        this.getChildren().clear();
        ;

        mHead = new Path();
        // head
        mHead.getElements().add(new MoveTo(mEarWidth, mHalfHeight));
        mHead.getElements().add(new CubicCurveTo(mEarWidth, -mHalfHeight / 5, mSize.width, -mHalfHeight / 5, mSize.width, mHalfHeight));
        mHead.getElements().add(new CubicCurveTo(mSize.width, 120, mEarWidth, 120, mEarWidth, mHalfHeight));

        af.appendRotation(mRotation, mDefaultRotationPoint.x, mDefaultRotationPoint.y);
        if (translateRight)
        {
            af.appendTranslation(mTranslation - 45, -45);
        } else
        {
            af.appendTranslation(0, mTranslation);
        }
        mHead.getTransforms().clear();
        mHead.getTransforms().add(af);

        //left ear
        mLeftEar = new Path();
        mLeftEar.getElements().add(new MoveTo(10, mSize.height / 2 + 10));
        mLeftEar.getElements().add(new QuadCurveTo(7, mSize.height / 2, 10, mSize.height / 2 - 10));
        mLeftEar.getElements().add(new CubicCurveTo(0, mSize.height / 2 - 10, 0, mSize.height / 2 + 10, 10, mSize.height / 2 + 10));

        af = new Affine();
        af.appendRotation(mRotation, mDefaultRotationPoint.x, mDefaultRotationPoint.y);
        if (translateRight)
        {
            af.appendTranslation(mTranslation - 45, -45);
        } else
        {
            af.appendTranslation(1, 3 + mTranslation);
        }
        mLeftEar.getTransforms().clear();
        mLeftEar.getTransforms().add(af);
//
        //right ear
        mRightEar = new Path();
        mRightEar.getElements().add(new MoveTo(mSize.width, mSize.height / 2 + 10));
        mRightEar.getElements().add(new QuadCurveTo(mSize.width + 3, mSize.height / 2, mSize.width, mSize.height / 2 - 10));
        mRightEar.getElements().add(new CubicCurveTo(mSize.width + 10, mSize.height / 2 - 10, mSize.width + 10, mSize.height / 2 + 10, mSize.width, mSize.height / 2 + 10));

        af = new Affine();
        af.appendRotation(mRotation, mDefaultRotationPoint.x, mDefaultRotationPoint.y);
        if (translateRight)
        {
            af.appendTranslation(mTranslation - 45, -45);
        } else
        {
            af.appendTranslation(-1, 3 + mTranslation);
        }
        mRightEar.getTransforms().clear();
        mRightEar.getTransforms().add(af);

        // TODO - This schould be done in all bodyparts
        //????????????????????????????????????????
//        resizeRelocate(mHeadGroup.getLayoutX() + new Float(mStickman.mGeneralXTranslation).intValue(),
//                mHeadGroup.getLayoutY() + new Float(mStickman.mGeneralYTranslation).intValue(),
//                new Float(mHeadGroup.prefWidth(-1) * mStickman.mScale).intValue(),
//                new Float(mHeadGroup.prefHeight(-1) * mStickman.mScale).intValue());
        this.getChildren().addAll(mHead, mLeftEar, mRightEar);

        update();

    }

    @Override
    public void setShape(String s)
    {

    }

    public void update()
    {
        if (mStickmanFX.setCharacterInvisible == false)
        {
            mColorRecorder = mColor;
        }
        // fill
        if (mStickmanFX.setCharacterInvisible == true)
        {
            if (mStickmanFX.fadeControler == true) //Added by Robbie
            {

                int fadeFactor = mStickmanFX.mMouthFX.mShapeAnimationStep * 10;
                if (fadeFactor <= 20)
                {
                    fadeFactor = 0;
                }
                mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(242, 227, 217, (fadeFactor * 100 / 255) / 100f); //fadeFactor Interval [0 - 1]
            } else
            {
                int fadeFactor = (20 - mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
                if (fadeFactor >= 160)
                {
                    mColor = mColorRecorder;
                } else
                {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                }
                //mColor = Color.rgb(242, 227, 217, (fadeFactor * 100 / 255) / 100f); //fadeFactor Interval [0 - 1]
            }

            //not good. FixMe
            //update Body (FadeIn, FadeOut)
            mStickmanFX.mBodyFX.update();
        }

        // head
        mHead.setFill(mColor);
        // ears
        mLeftEar.setFill(mColor);
        mRightEar.setFill(mColor);
        // draw outlines
        //head
        mHead.setStroke(mColor.darker());
        mHead.setStrokeWidth(2);
        // ears
        mLeftEar.setStroke(mColor.darker());
        mLeftEar.setStrokeWidth(2);
        mRightEar.setStroke(mColor.darker());
        mRightEar.setStrokeWidth(2);

    }
}
