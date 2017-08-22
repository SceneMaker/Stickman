package de.dfki.stickmanFX.bodyfx;

import de.dfki.common.enums.Gender;
import de.dfki.common.part.Part2D;
import de.dfki.stickmanFX.animationlogic.AnimatorStickman2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

import java.awt.*;

/**
 * @author Beka Aptsiauri
 */
public class RightEyeFX extends PartStickman2D
{

    private static int sMAX_ANIM_STEPS = 20;
    public RightEyeFX.SHAPE mShape = RightEyeFX.SHAPE.DEFAULT;
    double xMovement;
    double yMovement1;

    ;
    double yMovement2;
    HeadFX mHead;
    Path mPath;

    public RightEyeFX(Part2D head)
    {
        mHead = (HeadFX) head;
        mLength = 5;
        mSize = new Dimension(5, mLength);
        mDefaultRotationPoint = mHead.mDefaultRotationPoint;
        mColor = Color.rgb(mHead.mStickmanFX.mType == Gender.TYPE.FEMALE ? 22 : 0,
                mHead.mStickmanFX.mType == Gender.TYPE.FEMALE ? 40 : 0,
                mHead.mStickmanFX.mType == Gender.TYPE.FEMALE ? 65 : 0, (144 * 100 / 255) / 100f);

        mPath = new Path();
        this.getChildren().add(mPath);
        init();
    }

    public static double linearOffset(double start, double end, int currentStep)
    {
//		System.out.println("Math.abs(start) - Math.abs(end))" + (Math.abs(start) - Math.abs(end)));
//		System.out.println("end - start " + (end - start));

        return (end - start) / sMAX_ANIM_STEPS * currentStep;
    }

    public static double linear(double start, double end, int currentStep)
    {
//		System.out.println("Math.abs(start) - Math.abs(end))" + (Math.abs(start) - Math.abs(end)));
//		System.out.println("end - start " + (end - start));
        double offset = (end - start) / sMAX_ANIM_STEPS * (sMAX_ANIM_STEPS - currentStep + 1);

        return start + offset;
    }

    @Override
    public void setShape(String s)
    {
        RightEyeFX.SHAPE shape = RightEyeFX.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : RightEyeFX.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape()
    {
        mShape = RightEyeFX.SHAPE.DEFAULT;
    }

    @Override
    public void calculate(int step)
    {
        mStart = mHead.getRightEyePostion();
        mEnd = new Point(mStart.x + mLength, mStart.y);

        double movement;

        clearDrawObjects();
        this.getChildren().clear();
        ;

        mPath = new Path();

        switch (mShape)
        {
            case DEFAULT:
//            	if (mHeadGroup.mStickman.setCharacterInvisible == false)
//            		mColorRecorder = mColor;
                if (mHead.mStickmanFX.setCharacterInvisible == true)
                {
                    if (mHead.mStickmanFX.fadeControler == true) //Added by Robbie
                    {
                        int fadeFactor = mHead.mStickmanFX.mMouthFX.mShapeAnimationStep * 7;
                        if (fadeFactor <= 14)
                        {
                            fadeFactor = 0;
                        }
                        mColor = Color.rgb(mHead.mStickmanFX.mType == Gender.TYPE.FEMALE ? 22 : 0,
                                mHead.mStickmanFX.mType == Gender.TYPE.FEMALE ? 40 : 0,
                                mHead.mStickmanFX.mType == Gender.TYPE.FEMALE ? 65 : 0, (fadeFactor * 100 / 255) / 100f);
                    } else
                    {
                        int fadeFactor = (20 - mHead.mStickmanFX.mMouthFX.mShapeAnimationStep) * 7;

                        if (fadeFactor >= 119)
                        {
                            mColor = mColorRecorder;
                        } else
                        {
                            mColor = Color.rgb(mHead.mStickmanFX.mType == Gender.TYPE.FEMALE ? 22 : 0,
                                    mHead.mStickmanFX.mType == Gender.TYPE.FEMALE ? 40 : 0,
                                    mHead.mStickmanFX.mType == Gender.TYPE.FEMALE ? 65 : 0, (fadeFactor * 100 / 255) / 100f);
                        }
                    }
                }

                mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                break;

            case BLINK:
                mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                mPath.getElements().add(new LineTo(mEnd.x, mEnd.y));
                break;

            case LOOKLEFT:
                mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                mPath.getElements().add(new QuadCurveTo(linear((mStart.x + mEnd.x) / 2, mEnd.x, mShapeAnimationStep), mStart.y - 3, mEnd.x, mEnd.y));
                break;

            case LOOKRIGHT:
                mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                mPath.getElements().add(new QuadCurveTo(linear((mStart.x + mEnd.x) / 2, mStart.x, mShapeAnimationStep), mStart.y - 3, mEnd.x, mEnd.y));
                break;

            case ANGRY:
                movement = AnimatorStickman2D.sMAX_ANIM_STEPS - mShapeAnimationStep;

                mPath.getElements().clear();
                mPath.getElements().add(new MoveTo(mStart.x + movement / 10, mStart.y));
                mPath.getElements().add(new QuadCurveTo((mStart.x + movement / 10 + mEnd.x + movement / 8) / 2, mStart.y - movement / 6, mEnd.x + movement / 8, mEnd.y));
                mPath.getElements().add(new QuadCurveTo((mStart.x + movement / 10 + mEnd.x + movement / 8) / 2, mStart.y + movement / 6, mStart.x + movement / 10, mStart.y));
                break;

            case ANGRYEND:
                movement = mShapeAnimationStep - 1;

                if (movement <= 1)
                {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                } else
                {
                    mPath.getElements().add(new MoveTo(mStart.x + movement / 10, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + movement / 10 + mEnd.x + movement / 8) / 2, mStart.y - movement / 6, mEnd.x + movement / 8, mEnd.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + movement / 10 + mEnd.x + movement / 8) / 2, mStart.y + movement / 6, mStart.x + movement / 10, mStart.y));
                }

                break;

            case SURPRISED:
                movement = AnimatorStickman2D.sMAX_ANIM_STEPS - mShapeAnimationStep;
                mPath.getElements().add(new MoveTo(mStart.x - movement / 10, mStart.y));
                mPath.getElements().add(new QuadCurveTo((mStart.x - movement / 10 + mEnd.x + movement / 10) / 2, mStart.y - movement / 2, mEnd.x + movement / 10, mStart.y));
                mPath.getElements().add(new QuadCurveTo((mStart.x - movement / 10 + mEnd.x + movement / 10) / 2, mStart.y + movement / 2, mStart.x - movement / 10, mStart.y));
                break;

            case SURPRISEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1)
                {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                } else
                {
                    mPath.getElements().add(new MoveTo(mStart.x - movement / 10, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x - movement / 10 + mEnd.x + movement / 10) / 2, mStart.y - movement / 2, mEnd.x + movement / 10, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x - movement / 10 + mEnd.x + movement / 10) / 2, mStart.y + movement / 2, mStart.x - movement / 10, mStart.y));
                }
                break;

            case HAPPY:
                movement = AnimatorStickman2D.sMAX_ANIM_STEPS - mShapeAnimationStep;
                mPath.getElements().add(new MoveTo(mStart.x - movement / 10, mStart.y));
                mPath.getElements().add(new QuadCurveTo((mStart.x - movement / 10 + mEnd.x + movement / 10) / 2, mStart.y - 3, mEnd.x + movement / 10, mEnd.y));
                break;

            case HAPPYEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1)
                {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                } else
                {
                    mPath.getElements().add(new MoveTo(mStart.x - movement / 10, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x - movement / 10 + mEnd.x + movement / 10) / 2, mStart.y - 3, mEnd.x + movement / 10, mEnd.y));
                }
                break;

            case DISGUSTED:
                movement = AnimatorStickman2D.sMAX_ANIM_STEPS - mShapeAnimationStep;
                mPath.getElements().add(new MoveTo(mStart.x - movement / 4, mStart.y - movement / 4));
                mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 8, mEnd.x + movement / 8, mEnd.y + movement / 8));
                mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 4, mStart.x - movement / 4, mStart.y + movement / 8));
                break;

            case DISGUSTEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1)
                {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                } else
                {
                    mPath.getElements().add(new MoveTo(mStart.x - movement / 4, mStart.y - movement / 4));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 8, mEnd.x + movement / 8, mEnd.y + movement / 8));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 4, mStart.x - movement / 4, mStart.y + movement / 8));
                }
                break;

            case LOVED:
                movement = AnimatorStickman2D.sMAX_ANIM_STEPS - mShapeAnimationStep;

                double xMovement = movement / 10 * 6;
                double yMovement1 = movement / 10 * 6;
                double yMovement2 = movement / 10 * 3;

                mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                mPath.getElements().add(new QuadCurveTo(mStart.x + xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
                mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                mPath.getElements().add(new QuadCurveTo(mStart.x - xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
                break;

            case LOVEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1)
                {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                } else
                {
                    xMovement = movement / 10 * 6;
                    yMovement1 = movement / 10 * 6;
                    yMovement2 = movement / 10 * 3;

                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo(mStart.x + xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo(mStart.x - xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
                }
                break;

            case LOVED1:
                movement = AnimatorStickman2D.sMAX_ANIM_STEPS - mShapeAnimationStep;

                xMovement = movement / 10 * 6;
                yMovement1 = movement / 10 * 6;
                yMovement2 = movement / 10 * 3;

                showHearts(mHead, xMovement, yMovement1, yMovement2);

                mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                mPath.getElements().add(new QuadCurveTo(mStart.x + xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
                mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                mPath.getElements().add(new QuadCurveTo(mStart.x - xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
                break;

            case CONTEMPT:
                movement = AnimatorStickman2D.sMAX_ANIM_STEPS - mShapeAnimationStep;
                mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - movement / 10, mEnd.x, mStart.y));
                mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y + movement / 10, mStart.x, mStart.y));
                break;

            case CONTEMPTEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1)
                {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                } else
                {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - movement / 10, mEnd.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y + movement / 10, mStart.x, mStart.y));
                }
                break;

            case EXCITED:
                movement = AnimatorStickman2D.sMAX_ANIM_STEPS - mShapeAnimationStep;
                mPath.getElements().add(new MoveTo(mStart.x - movement / 10, mStart.y));
                mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x + movement / 10, mEnd.y));
                break;

            case EXCITEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1)
                {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                } else
                {
                    mPath.getElements().add(new MoveTo(mStart.x - movement / 10, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x + movement / 10, mEnd.y));
                }
                break;

            case EMBARRASSED:
                movement = AnimatorStickman2D.sMAX_ANIM_STEPS - mShapeAnimationStep;
                mPath.getElements().add(new MoveTo(mStart.x + movement / 2, mStart.y + movement / 5 * 2));
                mPath.getElements().add(new QuadCurveTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2, mStart.y - 4 + movement / 2, mEnd.x + movement / 2, mEnd.y + movement / 5 * 2));
                break;

            case EMBARRASSEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1)
                {
                    mPath.getElements().add(new MoveTo(mStart.x, mStart.y));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                } else
                {
                    mPath.getElements().add(new MoveTo(mStart.x + movement / 2, mStart.y + movement / 5 * 2));
                    mPath.getElements().add(new QuadCurveTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2, mStart.y - 4 + movement / 2, mEnd.x + movement / 2, mEnd.y + movement / 5 * 2));
                }
                break;

        }
        this.getChildren().add(mPath);
        addToDrawObjects(mPath);
        this.update();
    }

    protected void recordColor()
    {
        if (mHead.mStickmanFX.setCharacterInvisible == false)
        {
            mColorRecorder = mColor;
        }
    }

    public static enum SHAPE
    {
        DEFAULT, BLINK, LOOKLEFT, LOOKRIGHT, ANGRY, ANGRYEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, LOVED, LOVEDEND, LOVED1, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
    }
}
