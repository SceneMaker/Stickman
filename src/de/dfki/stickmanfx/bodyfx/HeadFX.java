package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.StickmanFX;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.transform.Affine;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class HeadFX extends BodyPartFX 
{
    public Dimension mSize = new Dimension(120, 100);
    public StickmanFX mStickmanFX;

    int mHalfHeight = mSize.height / 2;
    int mHalfWidth = mSize.width / 2;
    int mEarWidth = 10;

    int mDrawOffset = 10;
    int mXCenterOffset = mEarWidth / 2;
    int mYCenterOffset = mEarWidth / 2;

    Path mHead, mLeftEar, mRightEar, mFemaleHair, mMaleHair;

    public HeadFX(StickmanFX sm) 
    {
        mStickmanFX = sm;
        mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);
        mStroke = new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        init();

        calculate(0);
    }

    public Point getLeftEyebrowPostion() 
    {
        return new Point(mHalfWidth + 23, mHalfHeight - 16);
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
        return new Point(mSize.width / 2 + mXCenterOffset, mSize.height + mYCenterOffset - 3);
    }

    public void calculate(int step) 
    {
        clearChildren(this);
        // head
        mHead = new Path();
        mHead.getElements().add(new MoveTo(mEarWidth, mHalfHeight));
        mHead.getElements().add(new CubicCurveTo(mEarWidth, -mHalfHeight / 5, mSize.width, -mHalfHeight / 5, mSize.width, mHalfHeight));
        mHead.getElements().add(new CubicCurveTo(mSize.width, 120, mEarWidth, 120, mEarWidth, mHalfHeight));
        this.getChildren().add(mHead);

        Affine af = new Affine();
        af.appendRotation(mRotation, mDefaultRotationPoint.x, mDefaultRotationPoint.y);
        af.appendTranslation(0, mTranslation);
        mHead.getTransforms().add(af);

        //left ear
        mLeftEar = new Path();
        mLeftEar.getElements().add(new MoveTo(10, mSize.height / 2 + 10));
        mLeftEar.getElements().add(new QuadCurveTo(7, mSize.height / 2, 10, mSize.height / 2 - 10));
        mLeftEar.getElements().add(new CubicCurveTo(0, mSize.height / 2 - 10, 0, mSize.height / 2 + 10, 10, mSize.height / 2 + 10));
        this.getChildren().add(mLeftEar);

        af = new Affine();
        af.appendRotation(mRotation, mDefaultRotationPoint.x, mDefaultRotationPoint.y);
        af.appendTranslation(1, 3 + mTranslation);
        mLeftEar.getTransforms().add(af);

        //right ear
        mRightEar = new Path();
        mRightEar.getElements().add(new MoveTo(mSize.width, mSize.height / 2 + 10));
        mRightEar.getElements().add(new QuadCurveTo(mSize.width + 3, mSize.height / 2, mSize.width, mSize.height / 2 - 10));
        mRightEar.getElements().add(new CubicCurveTo(mSize.width + 10, mSize.height / 2 - 10, mSize.width + 10, mSize.height / 2 + 10, mSize.width, mSize.height / 2 + 10));
        this.getChildren().add(mRightEar);

        af = new Affine();
        af.appendRotation(mRotation, mDefaultRotationPoint.x, mDefaultRotationPoint.y);
        af.appendTranslation(-1, 3 + mTranslation);
        mRightEar.getTransforms().add(af);

        // female hair
        mFemaleHair = new Path();
        mFemaleHair.getElements().add(new MoveTo(mStart.x, mSize.height + 20));
        // right top locke
        mFemaleHair.getElements().add(new QuadCurveTo(mEarWidth + 10, mSize.height, mEarWidth, mHalfHeight));
        // top hair
        mFemaleHair.getElements().add(new CubicCurveTo(mEarWidth + 20, -mHalfHeight / 8, mSize.width - 20, -mHalfHeight / 8, mSize.width, mHalfHeight));
        // left top locke
        mFemaleHair.getElements().add(new QuadCurveTo(mEarWidth + mSize.width - 20, mSize.height, mSize.width + mEarWidth, mSize.height + 20));
        // left down locke
        mFemaleHair.getElements().add(new QuadCurveTo(mSize.width - 10, mSize.height + 30, mSize.width - 10, mSize.height + 20));
        // forehead hair
        mFemaleHair.getElements().add(new CubicCurveTo(mSize.width + 30, -mHalfHeight / 4, mStart.x - 20, -mHalfHeight / 4, mEarWidth + 10, mSize.height + 20));
        // right down locke
        mFemaleHair.getElements().add(new QuadCurveTo(20, mSize.height + 30, mStart.x, mSize.height + 20));
        
        if (mStickmanFX.mType == StickmanFX.TYPE.FEMALE) 
        {
            this.getChildren().add(mFemaleHair);
        }
        // move it upwards a bit
        af = new Affine();
        af.appendRotation(mRotation, mDefaultRotationPoint.x, mDefaultRotationPoint.y);
        af.appendTranslation(0, -15 + mTranslation);
        mFemaleHair.getTransforms().add(af);

        // male hair
        mMaleHair = new Path();
        mMaleHair.getElements().add(new MoveTo(mEarWidth, mHalfHeight));
        mMaleHair.getElements().add(new QuadCurveTo(mHalfWidth - 30, -mHalfHeight / 3, mHalfWidth + 20, mHalfHeight - 30));
        mMaleHair.getElements().add(new QuadCurveTo((mHalfWidth + 40 + mSize.width) / 2, 0, mSize.width, mHalfHeight));
        mMaleHair.getElements().add(new CubicCurveTo(mSize.width, -mHalfHeight / 2, mEarWidth, -mHalfHeight / 2, mEarWidth, mHalfHeight));
        
        if (mStickmanFX.mType == StickmanFX.TYPE.MALE) 
        {
            this.getChildren().add(mMaleHair);
        }

        // move it downwards a bit
        af = new Affine();
        af.appendRotation(mRotation, mDefaultRotationPoint.x, mDefaultRotationPoint.y);
        af.appendTranslation(0, 2 + mTranslation);
        mMaleHair.getTransforms().add(af);

        // TODO - This schould be done in all bodyparts
        //????????????????????????????????????????
//        resizeRelocate(mHead.getLayoutX() + new Float(mStickmanFX.mGeneralXTranslation).intValue(),
//                mHead.getLayoutY() + new Float(mStickmanFX.mGeneralYTranslation).intValue(),
//                new Float(mHead.prefWidth(-1) * mStickmanFX.mScale).intValue(),
//                new Float(mHead.prefHeight(-1) * mStickmanFX.mScale).intValue());
update();

    }

    public void update() 
    {
        Color c;
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
                c = Color.rgb(242, 227, 217, (fadeFactor * 100 / 255) / 100f); //fadeFactor Interval [0 - 1]
            } 
            else 
            {
                int fadeFactor = (20 - mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
                if (fadeFactor >= 160) 
                {
                    fadeFactor = 200;
                }
                c = Color.rgb(242, 227, 217, (fadeFactor * 100 / 255) / 100f); //fadeFactor Interval [0 - 1]
            }
        } 
        else 
        {
            c = Color.rgb(242, 227, 217, 1);
        }

        // head
        mHead.setFill(c);
        // ears
        mLeftEar.setFill(c);
        mRightEar.setFill(c);
        // draw outlines
        //head
        mHead.setStroke(c.darker());
        mHead.setStrokeWidth(2);
        // ears
        mLeftEar.setStroke(c.darker());
        mLeftEar.setStrokeWidth(2);
        mRightEar.setStroke(c.darker());
        mRightEar.setStrokeWidth(2);

        // hair
        if (mStickmanFX.mType == StickmanFX.TYPE.FEMALE) 
        {
            if (mStickmanFX.setCharacterInvisible == true) 
            {
                if (mStickmanFX.fadeControler == true) //Added by Robbie
                {
                    int fadeFactor = mStickmanFX.mMouthFX.mShapeAnimationStep * 10;
                    if (fadeFactor <= 20) 
                    {
                        fadeFactor = 0;
                    }
                    c = Color.rgb(240, 212, 0, (fadeFactor * 100 / 255) / 100f);
                } 
                else 
                {
                    int fadeFactor = (20 - mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
                    if (fadeFactor >= 160) 
                    {
                        fadeFactor = 255;
                    }
                    c = Color.rgb(240, 212, 0, (fadeFactor * 100 / 255) / 100f);
                }
            } 
            else 
            {
                c = Color.rgb(240, 212, 0, 1);
            }

            mFemaleHair.setFill(c);
            // draw outlines
            mFemaleHair.setStroke(c.darker());
            mFemaleHair.setStrokeWidth(2);
        } 
        else 
        {
            if (mStickmanFX.setCharacterInvisible == true) 
            {
                if (mStickmanFX.fadeControler == true) //Added by Robbie
                {
                    int fadeFactor = mStickmanFX.mMouthFX.mShapeAnimationStep * 10;
                    if (fadeFactor <= 20) 
                    {
                        fadeFactor = 0;
                    }
                    c = Color.rgb(97, 58, 0, (fadeFactor * 100 / 255) / 100f);
                } 
                else 
                {
                    int fadeFactor = (20 - mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
                    if (fadeFactor >= 160) 
                    {
                        fadeFactor = 255;
                    }
                    c = Color.rgb(97, 58, 0, (fadeFactor * 100 / 255) / 100f);
                }
            } 
            else 
            {
                c = Color.rgb(97, 58, 0, 1);
            }

            mMaleHair.setFill(c);
            // draw outlines
            mMaleHair.setStroke(c.darker());
            mMaleHair.setStrokeWidth(2);
        }
    }
}
