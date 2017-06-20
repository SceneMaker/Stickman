package de.dfki.stickmanFX.bodyfx;

import de.dfki.stickmanFX.StickmanFX;

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
public class MaleHairFX extends BodyPartFX {

    public Dimension mSize = new Dimension(120, 100);
    public StickmanFX mStickmanFX;

    int mHalfHeight = mSize.height / 2;
    int mHalfWidth = mSize.width / 2;
    int mEarWidth = 10;

    Path mMaleHair;

    public MaleHairFX(StickmanFX sm) {
        mStickmanFX = sm;
        mDefaultRotationPoint = new Point(mSize.width / 2, mSize.height);
        mColor = Color.rgb(97, 58, 0, 1);

        mMaleHair = new Path();
        this.getChildren().add(mMaleHair);

        init();

        calculate(0);
    }

    public void calculate(int step) {
        Affine af = new Affine();
        clearChildren(this);

        // male hair
        mMaleHair = new Path();
        mMaleHair.getElements().add(new MoveTo(mEarWidth, mHalfHeight));
        mMaleHair.getElements().add(new QuadCurveTo(mHalfWidth - 30, -mHalfHeight / 3, mHalfWidth + 20, mHalfHeight - 30));
        mMaleHair.getElements().add(new QuadCurveTo((mHalfWidth + 40 + mSize.width) / 2, 0, mSize.width, mHalfHeight));
        mMaleHair.getElements().add(new CubicCurveTo(mSize.width, -mHalfHeight / 2, mEarWidth, -mHalfHeight / 2, mEarWidth, mHalfHeight));

        // move it downwards a bit
        af = new Affine();
        af.appendRotation(mRotation, mDefaultRotationPoint.x, mDefaultRotationPoint.y);
        af.appendTranslation(0, 2 + mTranslation);
        mMaleHair.getTransforms().clear();
        mMaleHair.getTransforms().add(af);

        // TODO - This schould be done in all bodyparts
        //????????????????????????????????????????
//        resizeRelocate(mHead.getLayoutX() + new Float(mStickman.mGeneralXTranslation).intValue(),
//                mHead.getLayoutY() + new Float(mStickman.mGeneralYTranslation).intValue(),
//                new Float(mHead.prefWidth(-1) * mStickman.mScale).intValue(),
//                new Float(mHead.prefHeight(-1) * mStickman.mScale).intValue());
        this.getChildren().add(mMaleHair);

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
                //mColor = Color.rgb(97, 58, 0, (fadeFactor * 100 / 255) / 100f);
            } else {
                int fadeFactor = (20 - mStickmanFX.mMouthFX.mShapeAnimationStep) * 9;
                if (fadeFactor >= 160) {
                    mColor = mColorRecorder;
                } else {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                }
                //mColor = Color.rgb(97, 58, 0, (fadeFactor * 100 / 255) / 100f);
            }
        }

        mMaleHair.setFill(mColor);
        // draw outlines
        mMaleHair.setStroke(mColor.darker());
        mMaleHair.setStrokeWidth(2);

    }
}
