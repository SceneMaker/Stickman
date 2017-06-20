/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.bodyfx;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;

import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.transform.Affine;

/**
 *
 * @author Beka
 *
 */
public class RightHandFX extends BodyPartFX {

    RightForeArmFX mRightForeArmFX;
    Path mHand;
    Affine af;

    public RightHandFX(RightForeArmFX rfa) {
        mRightForeArmFX = rfa;
        mLength = 10;
        mSize = new Dimension(mLength, mLength);

        mColor = Color.rgb(80, 80, 80);
        mStroke = new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        af = new Affine();

        setDefaulRotation(-30);
        mHand = new Path();
        this.getChildren().add(mHand);

        init();
    }

    @Override
    public void createShape() {
        mStart = mRightForeArmFX.getHandStartPosition();
        mEnd = new Point(mStart.x, mStart.y + mLength);

        clearDrawObjects();
        clearChildren(this);
        mHand = new Path();

//		if (mRightForeArm.mUpperArmFX.mRightShoulderFX.mBodyFX.mNeck.mHead.mStickman.setCharacterInvisible == false)
//			mColorRecorder = mColor;
        if (mRightForeArmFX.mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
            if (mRightForeArmFX.mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added by Robbie
            {
                int fadeFactor = mRightForeArmFX.mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
                if (fadeFactor <= 24) {
                    fadeFactor = 0;
                }
                mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);
            } else {
                int fadeFactor = (20 - mRightForeArmFX.mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216) {
                    mColor = mColorRecorder;
                } else {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                }
                //mColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);
            }
        }

        mHand.getElements().add(new MoveTo(mStart.x, mStart.y));
        mHand.getElements().add(new LineTo(mStart.x + 5, mStart.y));
        mHand.getElements().add(new MoveTo(mStart.x, mStart.y));
        mHand.getElements().add(new LineTo(mEnd.x, mEnd.y));
        mHand.getElements().add(new MoveTo(mStart.x + 1, mStart.y));
        mHand.getElements().add(new LineTo(mEnd.x + 4, mEnd.y - 2f));
        mHand.getElements().add(new MoveTo(mStart.x - 1, mStart.y));
        mHand.getElements().add(new LineTo(mEnd.x - 3, mEnd.y - 2f));

        this.getChildren().add(mHand);
        addToDrawObjects(mHand);
        this.toFront();
        update();
    }

    @Override
    public void calculate(int step) {
        createShape();

        Affine af = new Affine();
        // AffineTransform t = new AffineTransform();
        // flip hand when rotation is more than 60 degrees
        if (mRotation < -60) {
            af.appendScale(-1.0, 1.0);
            af.appendTranslation(-mStart.x * 2, 0);
            // t.scale(-1.0, 1.0);
            // t.translate(-mStart.x * 2, 0);
        }

        af.appendRotation(mRotation, mStart.x, mStart.y);
        // t.rotate(Math.toRadians(mRotation), mStart.x, mStart.y);
        for (Path g : mGraphicPaths) {
            g.getTransforms().clear();
            g.getTransforms().add(af);
            // g.transform(t);
        }
    }

    protected void recordColor() {
        if (mRightForeArmFX.mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false) {
            mColorRecorder = mColor;
        }
    }
}
