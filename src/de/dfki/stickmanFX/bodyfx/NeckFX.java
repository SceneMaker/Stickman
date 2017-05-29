/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.bodyfx;

import java.awt.Dimension;
import java.awt.Point;

import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class NeckFX extends BodyPartFX {

    HeadFX mHeadFX;
    Path mPath;

    public NeckFX(HeadFX head) {
        mHeadFX = head;
        mLength = 8;
        mSize = new Dimension(4, mLength);
        mColor = Color.rgb(80, 80, 80);
        mPath = new Path();
        this.getChildren().add(mPath);

        init();
    }

    public Point getBodyStartPosition() {
        return new Point(mEnd.x, mEnd.y);
    }

    @Override
    public void createShape() {
        mStart = mHeadFX.getNeckStartPosition();
        mEnd = new Point(mStart.x, mStart.y + mLength);

        clearDrawObjects();
        clearChildren(this);
        mPath = new Path();
//		if(mHead.mStickman.setCharacterInvisible == false)
//			mColorRecorder = mColor;
        if (mHeadFX.mStickmanFX.setCharacterInvisible == true) {
            if (mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
                if (fadeFactor <= 24) {
                    fadeFactor = 0;
                }
                mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
            } else {
                int fadeFactor = (20 - mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216) {
                    mColor = mColorRecorder;
                } else {
                    mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                }
                //mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
            }
        }

        mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
        mPath.getElements().add(new LineTo(mEnd.x, mEnd.y));

        this.getChildren().add(mPath);
        addToDrawObjects(mPath);
        this.update();
    }

    protected void recordColor() {
        if (mHeadFX.mStickmanFX.setCharacterInvisible == false) {
            mColorRecorder = mColor;
        }
    }
}
