/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.body;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;

import de.dfki.stickmanSwing.animationlogic.AnimatorSwing;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LeftEyebrow extends BodyPart {

    public static enum SHAPE {

        DEFAULT, ANGRY, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
    };

    Head mHead;
    public LeftEyebrow.SHAPE mShape = LeftEyebrow.SHAPE.DEFAULT;

    public LeftEyebrow(Head head) {
        mHead = head;
        mLength = 16;
        mSize = new Dimension(mLength, mLength);
        mDefaultRotationPoint = mHead.mDefaultRotationPoint;
        mColor = new Color(0, 0, 0, 64);
        mStroke = new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        init();
    }

    @Override
    public void setShape(String s) {
        SHAPE shape = LeftEyebrow.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : LeftEyebrow.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = LeftEyebrow.SHAPE.DEFAULT;
    }

    @Override
    public void createShape() {
//		mStart: left side
//		mEnd: right side
        mStart = mHead.getLeftEyebrowPostion();
        mEnd = new Point(mStart.x + mLength, mStart.y);

        double movement;

        clearDrawObjects();
        GeneralPath gp = new GeneralPath();

        switch (mShape) {
            case DEFAULT:

                if (mHead.mStickman.setCharacterInvisible == true) {
                    if (mHead.mStickman.fadeControler == true) //Added by Robbie
                    {
                        int fadeFactor = (int) (mHead.mStickman.mMouth.mShapeAnimationStep * 3.2);
                        if (fadeFactor <= 6) {
                            fadeFactor = 0;
                        }
                        mColor = new Color(0, 0, 0, fadeFactor);
                    } else {
                        int fadeFactor = (int) ((20 - mHead.mStickman.mMouth.mShapeAnimationStep) * 3.2);
                        if (fadeFactor >= 57) {
                            fadeFactor = 0;
                        }
                        if (fadeFactor >= 54) {
                            fadeFactor = 64;
                        }
                        mColor = new Color(0, 0, 0, fadeFactor);
                    }
                }

                gp.moveTo(mStart.x, mStart.y);
                gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                break;

            case ANGRY:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x - movement / 4, mStart.y + movement / 4);
                gp.quadTo((mStart.x - movement / 4 + mEnd.x - movement / 3) / 2, mStart.y + movement / 4 - 3, mEnd.x - movement / 4, mEnd.y);
                break;

            case ANGRYEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - movement / 4, mStart.y + movement / 4);
                    gp.quadTo((mStart.x - movement / 4 + mEnd.x - movement / 3) / 2, mStart.y + movement / 4 - 3, mEnd.x - movement / 4, mEnd.y);
                }
                break;

            case DISGUSTED:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x, mStart.y - movement / 4);
                gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 7, mEnd.x - movement / 10, mEnd.y);
                break;

            case DISGUSTEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x, mStart.y - movement / 4);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 7, mEnd.x - movement / 10, mEnd.y);
                }
                break;

            case SURPRISED:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x, mStart.y - movement / 7);
                gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 7, mEnd.x, mEnd.y - movement / 7);
                break;

            case SURPRISEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x, mStart.y - movement / 7);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 7, mEnd.x, mEnd.y - movement / 7);
                }
                break;

            case EXCITED:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x, mStart.y - movement / 4);
                gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 5, mEnd.x, mEnd.y - movement / 4);
                break;

            case EXCITEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x, mStart.y - movement / 4);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 5, mEnd.x, mEnd.y - movement / 4);
                }
                break;

            case EMBARRASSED:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x + movement / 2, mStart.y + movement / 3);
                gp.quadTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2, mStart.y - 3 + movement / 5 * 4, mEnd.x + movement / 2, mEnd.y + movement / 2);
                break;

            case EMBARRASSEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x + movement / 2, mStart.y + movement / 3);
                    gp.quadTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2, mStart.y - 3 + movement / 5 * 4, mEnd.x + movement / 2, mEnd.y + movement / 2);
                }
                break;
        }
        addToDrawObjects(gp);
    }
}
