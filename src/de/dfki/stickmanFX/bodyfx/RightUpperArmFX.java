/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.bodyfx;

import java.awt.Dimension;
import java.awt.Point;

import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;

/**
 *
 * @author Beka
 *
 */
public class RightUpperArmFX extends BodyPartFX {

    RightShoulderFX mRightShoulderFX;

    int mArmLength = 70;
    Dimension mSize = new Dimension(mArmLength, mArmLength);

    Point mStart;
    Point mEnd;

    Path mArm;

    public RightUpperArmFX(RightShoulderFX shoulder) {
        mRightShoulderFX = shoulder;
        mColor = Color.rgb(80, 80, 80);
        mDefaultRotation = 23;
        mRotation = mDefaultRotation;
        mToDegree = mDefaultRotation;
        mRotationStep = 0.0f;
        mArm = new Path();
        this.getChildren().add(mArm);

        init();

        calculate(0);
    }

    public Point getRightUpperArmEndPosition() {
        //return (mArm != null) ? new Point((int) mArm.boundsInParentProperty().get().getMinX(), (int) mArm.boundsInParentProperty().get().getMaxY()) : new Point(0, 0);
        if (mRotation >= 0 && mRotation <= 90) {
            return (mArm != null) ? new Point((int) (mArm.boundsInParentProperty().get().getMinX() + 2), (int) mArm.boundsInParentProperty().get().getMaxY() - 1) : new Point(0, 0);
        } else if (mRotation > 90 && mRotation <= 180) {
            return (mArm != null) ? new Point((int) (mArm.boundsInParentProperty().get().getMinX()), (int) mArm.boundsInParentProperty().get().getMinY() + 3) : new Point(0, 0);
        } else if (mRotation < 0 && mRotation >= -90) {
            return (mArm != null) ? new Point((int) (mArm.boundsInParentProperty().get().getMaxX()), (int) mArm.boundsInParentProperty().get().getMaxY()) : new Point(0, 0);
        } else {
            return (mArm != null) ? new Point((int) (mArm.boundsInParentProperty().get().getMaxX()), (int) mArm.boundsInParentProperty().get().getMinY()) : new Point(0, 0);
        }
    }

    @Override
    public void calculate(int step) {
        clearChildren(this);

        mArm = new Path();
        mStart = mRightShoulderFX.getRightShoulderEndPosition();
        mEnd = new Point(mStart.x, mStart.y + mArmLength);

        mArm.getElements().add(new MoveTo(mStart.x, mStart.y + 2));
        mArm.getElements().add(new QuadCurveTo(mStart.x - 5, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y));

        Affine af = new Affine();
        af.appendRotation(mRotation, mStart.x, mStart.y);
        mArm.getTransforms().clear();
        mArm.getTransforms().add(af);
        // AffineTransform t = new AffineTransform();
        // t.rotate(Math.toRadians(mRotation), mStart.x, mStart.y);
        // mArm.transform(t);
        this.getChildren().add(mArm);
        this.update();
    }

    @Override
    public void update() {
//		Color currentColor = Color.rgb(80, 80, 80);
        // draw outlines
        if (mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false) {
            mColorRecorder = mColor;
        }
        if (mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
            if (mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added by Robbie
            {
                int fadeFactor = mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
                if (fadeFactor <= 24) {
                    fadeFactor = 0;
                }
                mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);
                // g2.setColor(new Color(80, 80, 80, fadeFactor));
            } else {
                int fadeFactor = (20 - mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216) {
                    mColor = mColorRecorder;
                } else {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                }
                //mColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);
                // g2.setColor(new Color(80, 80, 80, fadeFactor));
            }
        }

        mArm.setStroke(mColor);
        mArm.setStrokeWidth(3);
        mArm.setStrokeLineCap(StrokeLineCap.ROUND);
        mArm.setStrokeLineJoin(StrokeLineJoin.ROUND);
        // g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND,
        // BasicStroke.JOIN_ROUND));
        //
        // g2.draw(mArm);
    }
}
