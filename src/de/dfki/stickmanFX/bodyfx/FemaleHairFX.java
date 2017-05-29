package de.dfki.stickmanFX.bodyfx;

import de.dfki.stickmanFX.StickmanFX;

import java.awt.Dimension;
import java.awt.Point;

import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.transform.Affine;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class FemaleHairFX extends BodyPartFX {

    public Dimension mSize = new Dimension(120, 100);
    public StickmanFX mStickmanFX;

    int mHalfHeight = mSize.height / 2;
    int mHalfWidth = mSize.width / 2;
    int mEarWidth = 10;

    int mDrawOffset = 10;
    int mXCenterOffset = mEarWidth / 2;
    int mYCenterOffset = mEarWidth / 2;

    Path mFemaleHair;

    public FemaleHairFX(StickmanFX sm) {
        mStickmanFX = sm;
        mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);
        mColor = Color.rgb(240, 212, 0, 1);
        mFemaleHair = new Path();
        this.getChildren().add(mFemaleHair);

        init();

        calculate(0);
    }

    public void calculate(int step) {
        Affine af = new Affine();
        clearChildren(this);
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

    public void update() {
        if (mStickmanFX.setCharacterInvisible == false) {
            mColorRecorder = mColor;
        }

        if (mStickmanFX.setCharacterInvisible == true) {
            if (mStickmanFX.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mStickmanFX.mMouthFX.mShapeAnimationStep * 10;
                if (fadeFactor <= 20) {
                    fadeFactor = 0;
                }
                mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(240, 212, 0, (fadeFactor * 100 / 255) / 100f);
            } else {
                int fadeFactor = (20 - mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
                if (fadeFactor >= 160) {
                    mColor = mColorRecorder;
                } else {
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

    private void drawFemaleHair1() {
        mStart = new Point(mStickmanFX.mHeadFX.getLeftEyebrowPostion().x - 10, mStickmanFX.mHeadFX.getLeftEyebrowPostion().y - 14);
        mFemaleHair = new Path();

        mFemaleHair.getElements().add(new MoveTo(mStart.x, mStart.y));
        mFemaleHair.getElements().add(new QuadCurveTo(mStart.x - 3, mStart.y - 8, mStart.x + 6, mStart.y - 15));
        mStart.x = mStart.x + 6;
        mStart.y = mStart.y - 15;
        mFemaleHair.getElements().add(new QuadCurveTo(mStart.x + 15, mStart.y - 4, mStart.x + 30, mStart.y + 6));
        mStart.x = mStart.x + 30;
        mStart.y = mStart.y + 6;
        mFemaleHair.getElements().add(new QuadCurveTo(mStart.x + 40, mStart.y + 40, mStart.x + 15, mStart.y + 80));
        mStart.x = mStart.x + 15;
        mStart.y = mStart.y + 80;
        mFemaleHair.getElements().add(new QuadCurveTo(mStart.x - 5, mStart.y + 25, mStart.x + 2, mStart.y + 30));
        mStart.x = mStart.x + 2;
        mStart.y = mStart.y + 30;
        mFemaleHair.getElements().add(new QuadCurveTo(mStart.x - 1, mStart.y + 3, mStart.x - 2, mStart.y + 2));
        mStart.x = mStart.x - 2;
        mStart.y = mStart.y + 2;

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                mFemaleHair.getElements().add(new LineTo(mStart.x - 1, mStart.y - 2));
                mStart.x = mStart.x - 1;
                mStart.y = mStart.y - 2;
            } else {
                mFemaleHair.getElements().add(new LineTo(mStart.x - 1, mStart.y + 2));
                mStart.x = mStart.x - 1;
                mStart.y = mStart.y + 2;
            }
        }
        mFemaleHair.getElements().add(new QuadCurveTo(mStart.x + 3, mStart.y - 25, mStart.x + 10, mStart.y - 60));
        mStart.y = mStart.y - 60;
        mFemaleHair.getElements().add(new QuadCurveTo(mStart.x + 1, mStart.y - 15, mStart.x - 10, mStart.y - 20));
        mStart.x = mStart.x - 10;
        mStart.y = mStart.y - 20;

        mFemaleHair.getElements().add(new QuadCurveTo(mStart.x - 15, mStart.y + 3, mStickmanFX.mHeadFX.getLeftEyebrowPostion().x - 10, mStickmanFX.mHeadFX.getLeftEyebrowPostion().y - 14));
        mFemaleHair.getElements().add(new MoveTo(mStickmanFX.mHeadFX.getLeftEyebrowPostion().x - 8, mStickmanFX.mHeadFX.getLeftEyebrowPostion().y - 9));
        mStart.x = mStickmanFX.mHeadFX.getLeftEyebrowPostion().x - 7;
        mStart.y = mStickmanFX.mHeadFX.getLeftEyebrowPostion().y - 9;
        mFemaleHair.getElements().add(new QuadCurveTo(mStart.x - 15, mStart.y + 10, mStart.x - 20, mStart.y + 20));
        mStart.x = mStart.x - 20;
        mStart.y = mStart.y + 20;
        mFemaleHair.getElements().add(new QuadCurveTo(mStart.x - 3, mStart.y - 5, mStart.x - 3, mStart.y - 10));
        mStart.x = mStart.x - 3;
        mStart.y = mStart.y - 10;
        mFemaleHair.getElements().add(new LineTo(mStart.x - 5, mStart.y + 10));
        mStart.x = mStart.x - 5;
        mStart.y = mStart.y + 10;
        mFemaleHair.getElements().add(new LineTo(mStart.x - 3, mStart.y - 9));
        mStart.x = mStart.x - 3;
        mStart.y = mStart.y - 6;
        mFemaleHair.getElements().add(new LineTo(mStart.x - 3, mStart.y + 6));
        mStart.x = mStart.x - 3;
        mStart.y = mStart.y + 6;
        mFemaleHair.getElements().add(new LineTo(mStart.x - 5, mStart.y - 9));
        mStart.x = mStart.x - 5;
        mStart.y = mStart.y - 6;

        //aqedan ragac airia
        mFemaleHair.getElements().add(new QuadCurveTo(mStart.x - 30, mStart.y + 20, mStart.x - 10, mStart.y + 40));
        mStart.x = mStart.x - 10;
        mStart.y = mStart.y + 40;
        mFemaleHair.getElements().add(new QuadCurveTo(mStart.x + 5, mStart.y + 20, mStart.x + 10, mStart.y + 30));
        mStart.x = mStart.x + 15;
        mStart.y = mStart.y + 40;

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                mFemaleHair.getElements().add(new LineTo(mStart.x - 2, mStart.y - 2));
                mStart.x = mStart.x - 1;
                mStart.y = mStart.y - 2;
            } else {
                mFemaleHair.getElements().add(new LineTo(mStart.x - 1, mStart.y + 2));
                mStart.x = mStart.x - 1;
                mStart.y = mStart.y + 2;
            }
        }

        mFemaleHair.getElements().add(new QuadCurveTo(mStart.x - 19, mStart.y - 30, mStart.x - 20, mStart.y - 60));
        mStart.x = mStart.x - 25;
        mStart.y = mStart.y - 60;
        mFemaleHair.getElements().add(new QuadCurveTo(mStart.x + 20, mStart.y - 70, mStart.x + 78, mStart.y - 50));
    }
}
