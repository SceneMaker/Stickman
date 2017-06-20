/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.bodyfx;

import de.dfki.stickmanFX.animationlogic.AnimatorFX;

import java.awt.Dimension;
import java.awt.Point;

import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class LeftEyebrowFX extends BodyPartFX {

    public static enum SHAPE {
        DEFAULT, ANGRY, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
    };

    HeadFX mHeadFX;
    Path mPath;
    public LeftEyebrowFX.SHAPE mShape = LeftEyebrowFX.SHAPE.DEFAULT;

    public LeftEyebrowFX(HeadFX head) {
        mHeadFX = head;
        mLength = 16;
        mSize = new Dimension(mLength, mLength);
        mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;
        mColor = Color.rgb(0, 0, 0, (64 * 100 / 255) / 100f);
        mPath = new Path();
        this.getChildren().add(mPath);
        init();
    }

    @Override
    public void setShape(String s) {
        SHAPE shape = LeftEyebrowFX.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : LeftEyebrowFX.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = LeftEyebrowFX.SHAPE.DEFAULT;
    }

    @Override
    public void createShape() {
        mStart = mHeadFX.getLeftEyebrowPostion();
        mEnd = new Point(mStart.x + mLength, mStart.y);

        double movement;

        clearDrawObjects();
        clearChildren(this);

        mPath = new Path();

        switch (mShape) {
            case DEFAULT:
//            	if (mHead.mStickman.setCharacterInvisible == false)
//            		mColorRecorder = mColor;
                if (mHeadFX.mStickmanFX.setCharacterInvisible == true) {
                    if (mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
                    {
                        int fadeFactor = (int) (mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 3.2);
                        if (fadeFactor <= 6) {
                            fadeFactor = 0;
                        }
                        mColor = Color.rgb(0, 0, 0, (fadeFactor * 100 / 255) / 100f);
                    } else {
                        int fadeFactor = (int) ((20 - mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 3.2);

                        if (fadeFactor >= 54) {
                            mColor = mColorRecorder;
                        } else {
                            mColor = Color.rgb(0, 0, 0, (fadeFactor * 100 / 255) / 100f);
                        }
                    }
                }

                mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                break;

            case ANGRY:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                mPath.getElements().add(new MoveTo(mStart.x - movement / 4, mStart.y + movement / 4));
                mPath.getElements().add(new QuadCurveTo((mStart.x - movement / 4 + mEnd.x - movement / 3) / 2, mStart.y + movement / 4 - 3, mEnd.x - movement / 4, mEnd.y));

                break;

            case ANGRYEND:
                movement = mShapeAnimationStep - 1;

                if (movement <= 1) {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                } else {
                    mPath.getElements().add(new MoveTo(mStart.x - movement / 4, mStart.y + movement / 4));
                    mPath.getElements().add(new QuadCurveTo((mStart.x - movement / 4 + mEnd.x - movement / 3) / 2, mStart.y + movement / 4 - 3, mEnd.x - movement / 4, mEnd.y));
                }
                break;

            case DISGUSTED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                mPath.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 4));
                mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 7, mEnd.x - movement / 10, mEnd.y));
                break;

            case DISGUSTEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                } else {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 4));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 7, mEnd.x - movement / 10, mEnd.y));
                }
                break;

            case SURPRISED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                mPath.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 7));
                mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 7, mEnd.x, mEnd.y - movement / 7));
                break;

            case SURPRISEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                } else {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 7));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 7, mEnd.x, mEnd.y - movement / 7));
                }
                break;

            case EXCITED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                mPath.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 4));
                mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 5, mEnd.x, mEnd.y - movement / 4));
                break;

            case EXCITEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                } else {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 4));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 5, mEnd.x, mEnd.y - movement / 4));
                }
                break;

            case EMBARRASSED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                mPath.getElements().add(new MoveTo(mStart.x + movement / 2, mStart.y + movement / 3));
                mPath.getElements().add(new QuadCurveTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2, mStart.y - 3 + movement / 5 * 4, mEnd.x + movement / 2, mEnd.y + movement / 2));
                break;

            case EMBARRASSEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                } else {
                    mPath.getElements().add(new MoveTo(mStart.x + movement / 2, mStart.y + movement / 3));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2, mStart.y - 3 + movement / 5 * 4, mEnd.x + movement / 2, mEnd.y + movement / 2));
                }
                break;
        }
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
