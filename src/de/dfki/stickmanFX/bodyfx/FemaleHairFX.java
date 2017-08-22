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
public class FemaleHairFX extends PartStickman2D
{

    public Dimension mSize = new Dimension(120, 100);
    public StickmanFX mStickmanFX;

    int mHalfHeight = mSize.height / 2;
    int mHalfWidth = mSize.width / 2;
    int mEarWidth = 10;

    int mDrawOffset = 10;
    int mXCenterOffset = mEarWidth / 2;
    int mYCenterOffset = mEarWidth / 2;

    Path mFemaleHair;

    public FemaleHairFX(StickmanFX sm)
    {
        mStickmanFX = sm;
        mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);
        mColor = Color.rgb(240, 212, 0, 1);
        mFemaleHair = new Path();
        this.getChildren().add(mFemaleHair);

        init();

        calculate(0);
    }

    public void calculate(int step)
    {
        Affine af = new Affine();
        this.getChildren().clear();
        ;
        //drawFemaleHair1();
        //female hair
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

        // move it upwards a bit
        af = new Affine();
        af.appendRotation(mRotation, mDefaultRotationPoint.x, mDefaultRotationPoint.y);
        af.appendTranslation(0, -15 + mTranslation);
        mFemaleHair.getTransforms().clear();
        mFemaleHair.getTransforms().add(af);

        // TODO - This schould be done in all bodyparts
        //????????????????????????????????????????
//        resizeRelocate(mHead.getLayoutX() + new Float(mStickman.mGeneralXTranslation).intValue(),
//                mHead.getLayoutY() + new Float(mStickman.mGeneralYTranslation).intValue(),
//                new Float(mHead.prefWidth(-1) * mStickman.mScale).intValue(),
//                new Float(mHead.prefHeight(-1) * mStickman.mScale).intValue());
        this.getChildren().add(mFemaleHair);

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
                //mColor = Color.rgb(240, 212, 0, (fadeFactor * 100 / 255) / 100f);
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
                //mColor = Color.rgb(240, 212, 0, (fadeFactor * 100 / 255) / 100f);
            }
        }

        mFemaleHair.setFill(mColor);
        // draw outlines
        mFemaleHair.setStroke(mColor.darker());
        mFemaleHair.setStrokeWidth(2);

    }
}
