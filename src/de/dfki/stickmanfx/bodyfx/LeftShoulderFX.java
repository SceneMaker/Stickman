/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;
import java.awt.Point;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;
import javafx.util.Duration;

/**
 *
 * @author Beka
 *
 */
public class LeftShoulderFX extends BodyPartFX {

    BodyFX mBodyFX;

    int mShoulderLength = 15;
    Dimension mSize = new Dimension(mShoulderLength, mShoulderLength);

    Point mStart;
    Point mEnd;

    Path mShoulder;

    public LeftShoulderFX(BodyFX body) 
    {
        mBodyFX = body;
        mDefaultRotation = -70;
        mRotation = mDefaultRotation;
        mToDegree = mDefaultRotation;
        mRotationStep = 0.0f;
        mShoulder = new Path();
        this.getChildren().add(mShoulder);
        init();

        calculate(0);
    }

    public Point getLeftShoulderEndPosition() 
    {
        return (mShoulder != null) ? new Point((int) (mShoulder.boundsInParentProperty().get().getMaxX() - 1), (int) mShoulder.boundsInParentProperty().get().getMaxY() - 1) : new Point(0, 0);
    }

    @Override
    public void calculate(int step) 
    {
        mStart = mBodyFX.getLeftArmStartPostion();
        mEnd = new Point(mStart.x, mStart.y + mShoulderLength);

        
        mShoulder.getElements().clear();
        mShoulder.getElements().add(new MoveTo(mStart.x, mStart.y + 2));
        mShoulder.getElements().add(new QuadCurveTo(mStart.x, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y));
        
        Affine af = new Affine();
        af.appendRotation(mRotation, mStart.x, mStart.y);
        mShoulder.getTransforms().clear();
        mShoulder.getTransforms().add(af);
        
        update();
    }

    @Override
    public void update() {
        //create();
        // draw outlines

        Color currenColor = Color.rgb(80, 80, 80);

        if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
            if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
                if (fadeFactor <= 24) {
                    fadeFactor = 0;
                }
                currenColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);
                //g2.setColor(new Color(80, 80, 80,fadeFactor));
            } else {
                int fadeFactor = (20 - mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216) {
                    fadeFactor = 255;
                }
                currenColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);
                //g2.setColor(new Color(80, 80, 80,fadeFactor));
            }
        }

        mShoulder.setStroke(currenColor);
        mShoulder.setStrokeWidth(3);
        mShoulder.setStrokeLineCap(StrokeLineCap.ROUND);
        mShoulder.setStrokeLineJoin(StrokeLineJoin.ROUND);
//		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
//
//		g2.draw(mShoulder);
    }
}
