package de.dfki.stickmanSwing.body;

import de.dfki.common.Gender;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimatorSwing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Mouth extends BodyPart {

    public static enum SHAPE {

        DEFAULT, SMILE, SMILEEND, SAD, SADEND, ANGRY, ANGRYEND, ANGRYSMALLMOUTH, ANGRYSMALLMOUTHEND, SURPRISED, SURPRISEDEND,
        HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND,
        EMBARRASSED, EMBARRASSEDEND, FEAR, FEAREND, O, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
        EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, NINETEEN, TWENTY,
    };

    Head mHead;

    public Mouth.SHAPE mShape = Mouth.SHAPE.DEFAULT;

    public Mouth(Head head) {
        mHead = head;
        mLength = 20;
        mSize = new Dimension(mLength * 2, 5);
        mDefaultRotationPoint = mHead.mDefaultRotationPoint;
        mColor = new Color(mHead.mStickman.mType == Gender.TYPE.FEMALE ? 64 : 32, 0, 0, 128);

        init();
    }

    @Override
    public void setShape(String s) {
        Mouth.SHAPE shape = Mouth.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : Mouth.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = Mouth.SHAPE.DEFAULT;
    }

    @Override
    public void createShape() {

        mStart = mHead.getMouthPostion();
        mEnd = new Point(mStart.x + mLength / 2, mStart.y);

        double movement;

        clearDrawObjects();
        GeneralPath gp = new GeneralPath();

        switch (mShape) {
            case DEFAULT:

                if (mHead.mStickman.setCharacterInvisible == true) {
                    if (mHead.mStickman.fadeControler == true) //Added by Robbie
                    {
                        int fadeFactor = mHead.mStickman.mMouth.mShapeAnimationStep * 6;
                        if (fadeFactor <= 12) {
                            fadeFactor = 0;
                        }
                        mColor = new Color(mHead.mStickman.mType == Gender.TYPE.FEMALE ? 64 : 32, 0, 0, fadeFactor);
                    } else {
                        int fadeFactor = (20 - mHead.mStickman.mMouth.mShapeAnimationStep) * 6;
                        if (fadeFactor >= 107) {
                            fadeFactor = 128;
                        }
                        mColor = new Color(mHead.mStickman.mType == Gender.TYPE.FEMALE ? 64 : 32, 0, 0, fadeFactor);
                    }
                }

                gp.moveTo(mStart.x - mLength / 2, mStart.y);
                gp.quadTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y);
                break;

            case SMILE:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2);
                gp.quadTo(mStart.x, mStart.y + 1 + movement / 3 * 2, mEnd.x + movement / 3 * 2, mStart.y - movement / 2);
                break;

            case SMILEEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x - mLength / 2, mStart.y);
                    gp.quadTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2);
                    gp.quadTo(mStart.x, mStart.y + 1 + movement / 3 * 2, mEnd.x + movement / 3 * 2, mStart.y - movement / 2);
                }
                break;

            case SAD:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x - mLength / 2 - movement / 2, mStart.y + movement / 4);
                gp.quadTo(mStart.x, mStart.y - movement, mEnd.x + movement / 2, mEnd.y + movement / 4);
                break;

            case SADEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x - mLength / 2, mStart.y);
                    gp.quadTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - mLength / 2 - movement / 2, mStart.y + movement / 4);
                    gp.quadTo(mStart.x, mStart.y - movement, mEnd.x + movement / 2, mEnd.y + movement / 4);
                }
                break;

            case ANGRY:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x - mLength / 2 - movement / 4, mStart.y + movement / 10);
                gp.quadTo(mStart.x, mStart.y + 1 - movement / 3 * 2, mEnd.x + movement / 4, mStart.y + movement / 10);

                break;

            case ANGRYEND:
                movement = mShapeAnimationStep - 1;

                if (movement <= 1) {
                    gp.moveTo(mStart.x - mLength / 2, mStart.y);
                    gp.quadTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - mLength / 2 - movement / 4, mStart.y + movement / 10);
                    gp.quadTo(mStart.x, mStart.y + 1 - movement / 3 * 2, mEnd.x + movement / 4, mStart.y + movement / 10);
                }

                break;

            case ANGRYSMALLMOUTH:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x - mLength / 2 + movement / 10, mStart.y + movement / 10);
                gp.quadTo(mStart.x, mStart.y + 1 - movement / 4, mEnd.x - movement / 10, mStart.y + movement / 10);
                break;

            case ANGRYSMALLMOUTHEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x - mLength / 2, mStart.y);
                    gp.quadTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - mLength / 2 + movement / 10, mStart.y + movement / 10);
                    gp.quadTo(mStart.x, mStart.y + 1 - movement / 4, mEnd.x - movement / 10, mStart.y + movement / 10);
                }
                break;

            case SURPRISED:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x - mLength / 2, mStart.y);
                gp.quadTo(mStart.x - movement / 4 - 4, mStart.y - movement / 2, mStart.x, mStart.y - movement / 2 - 1);
                gp.quadTo(mStart.x + movement / 4 + 4, mStart.y - movement / 2, mEnd.x, mStart.y);
                gp.quadTo(mStart.x + movement / 4 + 4, mStart.y + movement / 2, mStart.x, mStart.y + movement / 2 + 1);
                gp.quadTo(mStart.x - movement / 4 - 4, mStart.y + movement / 2, mStart.x - mLength / 2, mStart.y);
                break;

            case SURPRISEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x - mLength / 2, mStart.y);
                    gp.quadTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - mLength / 2, mStart.y);
                    gp.quadTo(mStart.x - movement / 4 - 4, mStart.y - movement / 2, mStart.x, mStart.y - movement / 2 - 1);
                    gp.quadTo(mStart.x + movement / 4 + 4, mStart.y - movement / 2, mEnd.x, mStart.y);
                    gp.quadTo(mStart.x + movement / 4 + 4, mStart.y + movement / 2, mStart.x, mStart.y + movement / 2 + 1);
                    gp.quadTo(mStart.x - movement / 4 - 4, mStart.y + movement / 2, mStart.x - mLength / 2, mStart.y);
                }
                break;

            case HAPPY:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4);
                gp.quadTo(mStart.x, mStart.y + 1 + movement, mEnd.x + movement / 2, mStart.y - movement / 4);
                gp.lineTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4);
                break;

            case HAPPYEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    gp.moveTo(mStart.x - mLength / 2, mStart.y);
                    gp.quadTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4);
                    gp.quadTo(mStart.x, mStart.y + 1 + movement, mEnd.x + movement / 2, mStart.y - movement / 4);
                    gp.lineTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4);
                }
                break;

            case DISGUSTED:
                movement = mLength / 2 + (AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep) / 2;

                gp.moveTo(mStart.x - movement, mStart.y);
                gp.quadTo(mStart.x - movement * 2 / 3, mStart.y - movement / 4, mStart.x - movement / 3, mStart.y);
                gp.quadTo(mStart.x, mStart.y + movement / 4, mStart.x + movement / 3, mStart.y);
                gp.quadTo(mStart.x + movement * 2 / 3, mStart.y - movement / 4, mStart.x + movement, mEnd.y);
                break;

            case DISGUSTEDEND:
                movement = mLength / 2 + mShapeAnimationStep / 2;
                if (mShapeAnimationStep - 1 <= 1) {
                    gp.moveTo(mStart.x - mLength / 2, mStart.y);
                    gp.quadTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - movement, mStart.y);
                    gp.quadTo(mStart.x - movement * 2 / 3, mStart.y - movement / 4, mStart.x - movement / 3, mStart.y);
                    gp.quadTo(mStart.x, mStart.y + movement / 4, mStart.x + movement / 3, mStart.y);
                    gp.quadTo(mStart.x + movement * 2 / 3, mStart.y - movement / 4, mStart.x + movement, mEnd.y);
                }
                break;

            case CONTEMPT:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x - mLength / 2, mStart.y);
                gp.quadTo(mStart.x, mStart.y - movement / 1.5, mEnd.x + movement / 2, mEnd.y - movement / 2);
                break;

            case CONTEMPTEND:
                movement = mShapeAnimationStep - 1;

                if (movement <= 1) {
                    gp.moveTo(mStart.x - mLength / 2, mStart.y);
                    gp.quadTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - mLength / 2, mStart.y);
                    gp.quadTo(mStart.x, mStart.y - movement / 1.5, mEnd.x + movement / 2, mEnd.y - movement / 2);
                }
                break;

            case FEAR:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x - mLength / 2 - movement / 4, mStart.y);
                gp.quadTo(mStart.x, mStart.y - movement / 2, mEnd.x + movement / 4, mEnd.y);
                gp.quadTo(mStart.x, mStart.y - 1, mStart.x - mLength / 2 - movement / 4, mStart.y);
                break;

            case FEAREND:
                movement = mShapeAnimationStep - 1;

                if (movement <= 1) {
                    gp.moveTo(mStart.x - mLength / 2, mStart.y);
                    gp.quadTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - mLength / 2 - movement / 4, mStart.y);
                    gp.quadTo(mStart.x, mStart.y - movement / 2, mEnd.x + movement / 4, mEnd.y);
                    gp.quadTo(mStart.x, mStart.y - 1, mStart.x - mLength / 2 - movement / 4, mStart.y);
                }
                break;

            case EXCITED:
                movement = AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep;

                gp.moveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2);
                gp.quadTo(mStart.x, mStart.y + movement, mEnd.x + movement / 3 * 2, mStart.y - movement / 2);
                gp.lineTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2);
                break;

            case EXCITEDEND:
                movement = mShapeAnimationStep - 1;

                if (movement <= 1) {
                    gp.moveTo(mStart.x - mLength / 2, mStart.y);
                    gp.quadTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2);
                    gp.quadTo(mStart.x, mStart.y + movement, mEnd.x + movement / 3 * 2, mStart.y - movement / 2);
                    gp.lineTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2);
                }
                break;

            case EMBARRASSED:
                movement = (AnimatorSwing.sMAX_ANIM_STEPS - mShapeAnimationStep);

                gp.moveTo(mStart.x - mLength / 2 + movement / 10 * 7, mStart.y + movement / 20);
                gp.quadTo((mStart.x - mLength / 2 + mEnd.x + movement / 10 * 3) / 2, mStart.y + 1, mEnd.x + movement / 10 * 3, mEnd.y + movement / 20);
                break;

            case EMBARRASSEDEND:
                movement = mShapeAnimationStep - 1;

                if (movement <= 1) {
                    gp.moveTo(mStart.x - mLength / 2, mStart.y);
                    gp.quadTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y);
                } else {
                    gp.moveTo(mStart.x - mLength / 2 + movement / 10 * 7, mStart.y + movement / 20);
                    gp.quadTo((mStart.x - mLength / 2 + mEnd.x + movement / 10 * 3) / 2, mStart.y + 1, mEnd.x + movement / 10 * 3, mEnd.y + movement / 20);
                }
                break;

            case O:
                gp.moveTo(mStart.x - mLength / 2, mStart.y);
                gp.quadTo(mStart.x, mStart.y - mLength / 2, mEnd.x, mStart.y);
                gp.quadTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y);
                break;

            case ONE:
            case SIX:
            case FOURTEEN:
            case NINETEEN:
                gp.moveTo(mStart.x - mLength / 2, mStart.y);
                gp.quadTo(mStart.x, mStart.y - mLength / 5, mEnd.x, mStart.y);
                gp.quadTo(mStart.x, mStart.y + mLength / 5, mStart.x - mLength / 2, mStart.y);
                break;

            case TWO:
                gp.moveTo(mStart.x - mLength / 2.8, mStart.y);
                gp.quadTo(mStart.x, mStart.y - mLength / 1.6, mEnd.x - mLength / 6, mStart.y);
                gp.quadTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 2.8, mStart.y);
                break;

            case THREE:
            case TWENTY:
                gp.moveTo(mStart.x - mLength / 2.8, mStart.y);
                gp.quadTo(mStart.x, mStart.y - mLength / 2.5, mEnd.x - mLength / 6, mStart.y);
                gp.quadTo(mStart.x, mStart.y + mLength / 2.5, mStart.x - mLength / 2.8, mStart.y);
                break;

            case FOUR:
                gp.moveTo(mStart.x - mLength / 2, mStart.y);
                gp.quadTo(mStart.x, mStart.y - 3, mEnd.x, mStart.y);
                gp.quadTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y);
                break;

            case FIVE:
            case EIGHT:
                gp.moveTo(mStart.x - mLength / 2.8, mStart.y);
                gp.quadTo(mStart.x, mStart.y - mLength / 2, mEnd.x - mLength / 6, mStart.y);
                gp.quadTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y);
                break;

            case SEVEN:
                gp.moveTo(mStart.x - mLength / 3, mStart.y);
                gp.quadTo(mStart.x, mStart.y - 3, mEnd.x - mLength / 5, mStart.y);
                gp.quadTo(mStart.x, mStart.y + 3, mStart.x - mLength / 3, mStart.y);
                break;

            case NINE:
                gp.moveTo(mStart.x - mLength / 3, mStart.y);
                gp.quadTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 5, mStart.y);
                gp.quadTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 3, mStart.y);
                break;

            case TEN:
                gp.moveTo(mStart.x - mLength / 2.8, mStart.y);
                gp.quadTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 6, mStart.y);
                gp.quadTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y);
                break;

        }

        addToDrawObjects(gp);
    }
}
