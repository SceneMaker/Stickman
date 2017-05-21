package de.dfki.stickmanSwing.body;

import de.dfki.common.Gender;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimatorSwing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import static de.dfki.stickmanSwing.animationlogic.util.Interpolator.linear;
import java.awt.BasicStroke;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class RightEye extends BodyPart {

    public static enum SHAPE {

        DEFAULT, BLINK, LOOKLEFT, LOOKRIGHT, ANGRY, ANGRYEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, LOVED, LOVEDEND, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
    };

    Head mHead;
    public RightEye.SHAPE mShape = RightEye.SHAPE.DEFAULT;

    public RightEye(Head head) {
        mHead = head;
        mLength = 5;
        mSize = new Dimension(5, mLength);
        mDefaultRotationPoint = mHead.mDefaultRotationPoint;
        mColor = new Color(mHead.mStickman.mType == Gender.TYPE.FEMALE ? 22 : 0,
                mHead.mStickman.mType == Gender.TYPE.FEMALE ? 40 : 0,
                mHead.mStickman.mType == Gender.TYPE.FEMALE ? 65 : 0, 144);
        mStroke = new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        init();
    }

    @Override
    public void setShape(String s) {
        RightEye.SHAPE shape = RightEye.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : RightEye.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = RightEye.SHAPE.DEFAULT;
    }

    @Override
    public void createShape() {
//		mStart: left side
//		nEmd: right side
        mStart = mHead.getRightEyePostion();
        mEnd = new Point(mStart.x + mLength, mStart.y);

        double movement;

        clearDrawObjects();
        GeneralPath gp = new GeneralPath();

        switch (mShape) {
            case DEFAULT:

                if (mHead.mStickman.setCharacterInvisible == true) {
                    if (mHead.mStickman.fadeControler == true) //Added by Robbie
                    {
                        int fadeFactor = mHead.mStickman.mMouth.mShapeAnimationStep * 7;
                        if (fadeFactor <= 14) {
                            fadeFactor = 0;
                        }
                        mColor = new Color(mHead.mStickman.mType == Gender.TYPE.FEMALE ? 22 : 0,
                                mHead.mStickman.mType == Gender.TYPE.FEMALE ? 40 : 0,
                                mHead.mStickman.mType == Gender.TYPE.FEMALE ? 65 : 0, fadeFactor);
                    } else {
                        int fadeFactor = (20 - mHead.mStickman.mMouth.mShapeAnimationStep) * 7;
                        if (fadeFactor == 126) {
                            fadeFactor = 0;
                        }
                        if (fadeFactor >= 119) {
                            fadeFactor = 144;
                        }
                        mColor = new Color(mHead.mStickman.mType == Gender.TYPE.FEMALE ? 22 : 0,
                                mHead.mStickman.mType == Gender.TYPE.FEMALE ? 40 : 0,
                                mHead.mStickman.mType == Gender.TYPE.FEMALE ? 65 : 0, fadeFactor);
                    }
                }

                gp.moveTo(mStart.x, mStart.y);
                gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                break;

            case BLINK:
                gp.moveTo(mStart.x, mStart.y);
                gp.lineTo(mEnd.x, mEnd.y);
                break;

            case LOOKLEFT:
                gp.moveTo(mStart.x, mStart.y);
                gp.quadTo(linear((mStart.x + mEnd.x) / 2, mEnd.x, mShapeAnimationStep), mStart.y - 3, mEnd.x, mEnd.y);
                break;

            case LOOKRIGHT:
                gp = new GeneralPath();
                gp.moveTo(mStart.x, mStart.y);
                gp.quadTo(linear((mStart.x + mEnd.x) / 2, mStart.x, mShapeAnimationStep), mStart.y - 3, mEnd.x, mEnd.y);
                break;

            case ANGRY:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x + movement / 10, mStart.y);
                gp.quadTo((mStart.x + movement / 10 + mEnd.x + movement / 8) / 2, mStart.y - movement / 6, mEnd.x + movement / 8, mEnd.y);
                gp.quadTo((mStart.x + movement / 10 + mEnd.x + movement / 8) / 2, mStart.y + movement / 6, mStart.x + movement / 10, mStart.y);

                break;

            case ANGRYEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x + movement / 10, mStart.y);
                    gp.quadTo((mStart.x + movement / 10 + mEnd.x + movement / 8) / 2, mStart.y - movement / 6, mEnd.x + movement / 8, mEnd.y);
                    gp.quadTo((mStart.x + movement / 10 + mEnd.x + movement / 8) / 2, mStart.y + movement / 6, mStart.x + movement / 10, mStart.y);
                }
                break;

            case SURPRISED:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x - movement / 10, mStart.y);
                gp.quadTo((mStart.x - movement / 10 + mEnd.x + movement / 10) / 2, mStart.y - movement / 2, mEnd.x + movement / 10, mStart.y);
                gp.quadTo((mStart.x - movement / 10 + mEnd.x + movement / 10) / 2, mStart.y + movement / 2, mStart.x - movement / 10, mStart.y);
                break;

            case SURPRISEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - movement / 10, mStart.y);
                    gp.quadTo((mStart.x - movement / 10 + mEnd.x + movement / 10) / 2, mStart.y - movement / 2, mEnd.x + movement / 10, mStart.y);
                    gp.quadTo((mStart.x - movement / 10 + mEnd.x + movement / 10) / 2, mStart.y + movement / 2, mStart.x - movement / 10, mStart.y);
                }
                break;

            case HAPPY:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x - movement / 10, mStart.y);
                gp.quadTo((mStart.x - movement / 10 + mEnd.x + movement / 10) / 2, mStart.y - 3, mEnd.x + movement / 10, mEnd.y);
                break;

            case HAPPYEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - movement / 10, mStart.y);
                    gp.quadTo((mStart.x - movement / 10 + mEnd.x + movement / 10) / 2, mStart.y - 3, mEnd.x + movement / 10, mEnd.y);
                }
                break;

            case DISGUSTED:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x - movement / 4, mStart.y - movement / 4);
                gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 8, mEnd.x + movement / 8, mEnd.y + movement / 8);
                gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 4, mStart.x - movement / 4, mStart.y + movement / 8);
                break;

            case DISGUSTEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - movement / 4, mStart.y - movement / 4);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 8, mEnd.x + movement / 8, mEnd.y + movement / 8);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 4, mStart.x - movement / 4, mStart.y + movement / 8);
                }
                break;

            case LOVED:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                double xMovement = movement / 10 * 6;
                double yMovement1 = movement / 10 * 6;
                double yMovement2 = movement / 10 * 3;

                gp.moveTo(mStart.x, mStart.y);
                gp.quadTo(mStart.x + xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1);
                gp.moveTo(mStart.x, mStart.y);
                gp.quadTo(mStart.x - xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1);
                break;

            case LOVEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                } else {
                    xMovement = movement / 10 * 6;
                    yMovement1 = movement / 10 * 6;
                    yMovement2 = movement / 10 * 3;

                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo(mStart.x + xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1);
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo(mStart.x - xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1);
                }
                break;

            case CONTEMPT:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x, mStart.y);
                gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - movement / 10, mEnd.x, mStart.y);
                gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y + movement / 10, mStart.x, mStart.y);
                break;

            case CONTEMPTEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - movement / 10, mEnd.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y + movement / 10, mStart.x, mStart.y);
                }
                break;

            case EXCITED:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x - movement / 10, mStart.y);
                gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x + movement / 10, mEnd.y);
                break;

            case EXCITEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - movement / 10, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x + movement / 10, mEnd.y);
                }
                break;

            case EMBARRASSED:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x + movement / 2, mStart.y + movement / 5 * 2);
                gp.quadTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2, mStart.y - 4 + movement / 2, mEnd.x + movement / 2, mEnd.y + movement / 5 * 2);
                break;

            case EMBARRASSEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x, mStart.y);
                    gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x + movement / 2, mStart.y + movement / 5 * 2);
                    gp.quadTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2, mStart.y - 4 + movement / 2, mEnd.x + movement / 2, mEnd.y + movement / 5 * 2);
                }
                break;

        }

        addToDrawObjects(gp);
    }
}
