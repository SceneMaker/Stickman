package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import java.awt.Dimension;
import java.awt.Point;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class MouthFX extends BodyPartFX 
{

    public static enum SHAPE 
    {
        DEFAULT, SMILE, SMILEEND, SAD, SADEND, ANGRY, ANGRYEND, ANGRYSMALLMOUTH, ANGRYSMALLMOUTHEND, SURPRISED, SURPRISEDEND,
        HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND,
        EMBARRASSED, EMBARRASSEDEND, FEAR, FEAREND, O, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
        EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, NINETEEN, TWENTY,
    };

    HeadFX mHeadFX;

    public MouthFX.SHAPE mShape = MouthFX.SHAPE.DEFAULT;

    public MouthFX(HeadFX head) 
    {
        mHeadFX = head;
        mLength = 20;
        mSize = new Dimension(mLength * 2, 5);
        mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;
        mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0, (128 * 100 / 255) / 100f);

        init();
    }

    @Override
    public void setShape(String s) 
    {
        MouthFX.SHAPE shape = MouthFX.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : MouthFX.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() 
    {
        mShape = MouthFX.SHAPE.DEFAULT;
    }

    @Override
    public void createShape() 
    {
        mStart = mHeadFX.getMouthPostion();
        mEnd = new Point(mStart.x + mLength / 2, mStart.y);

        double movement;

        clearDrawObjects();
        clearChildren(this);
        Path path = new Path();

        switch (mShape) 
        {
            case DEFAULT:
                if (mHeadFX.mStickmanFX.setCharacterInvisible == true) 
                {
                    if (mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
                    {
                        int fadeFactor = mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 6;
                        if (fadeFactor <= 12) 
                        {
                            fadeFactor = 0;
                        }
                        mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0, (fadeFactor * 100 / 255) / 100f);
                    } 
                    else 
                    {
                        int fadeFactor = (20 - mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 6;
                        if (fadeFactor >= 107) 
                        {
                            fadeFactor = 128;
                        }
                        mColor = new Color(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0, (fadeFactor * 100 / 255) / 100f);
                    }
                }
                
                path = new Path();
                path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                this.getChildren().add(path);
                break;

            case SMILE:
                path = new Path();
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement / 3 * 2, mEnd.x + movement / 3 * 2, mStart.y - movement / 2));
                this.getChildren().add(path);
                break;

            case SMILEEND:
                path = new Path();
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                } 
                else 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement / 3 * 2, mEnd.x + movement / 3 * 2, mStart.y - movement / 2));
                }
                this.getChildren().add(path);
                break;

            case SAD:
                path = new Path();
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 2, mStart.y + movement / 4));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement, mEnd.x + movement / 2, mEnd.y + movement / 4));
                this.getChildren().add(path);
                break;

            case SADEND:
                path = new Path();
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                } 
                else 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 2, mStart.y + movement / 4));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement, mEnd.x + movement / 2, mEnd.y + movement / 4));
                }
                this.getChildren().add(path);
                break;

            case ANGRY:
                path = new Path();
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 4, mStart.y + movement / 10));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 - movement / 3 * 2, mEnd.x + movement / 4, mStart.y + movement / 10));
                this.getChildren().add(path);
                break;

            case ANGRYEND:
                path = new Path();
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                } 
                else 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 4, mStart.y + movement / 10));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 - movement / 3 * 2, mEnd.x + movement / 4, mStart.y + movement / 10));
                }
                this.getChildren().add(path);
                break;

            case ANGRYSMALLMOUTH:
                path = new Path();
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                path.getElements().add(new MoveTo(mStart.x - mLength / 2 + movement / 10, mStart.y + movement / 10));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 - movement / 4, mEnd.x - movement / 10, mStart.y + movement / 10));
                this.getChildren().add(path);
                break;

            case ANGRYSMALLMOUTHEND:
                path = new Path();
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                } 
                else 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 + movement / 10, mStart.y + movement / 10));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 - movement / 4, mEnd.x - movement / 10, mStart.y + movement / 10));
                }
                this.getChildren().add(path);
                break;

            case SURPRISED:
                path = new Path();
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                
                path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x - movement / 4 - 4, mStart.y - movement / 2, mStart.x, mStart.y - movement / 2 - 1));
                path.getElements().add(new QuadCurveTo(mStart.x + movement / 4 + 4, mStart.y - movement / 2, mEnd.x, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x + movement / 4 + 4, mStart.y + movement / 2, mStart.x, mStart.y + movement / 2 + 1));
                path.getElements().add(new QuadCurveTo(mStart.x - movement / 4 - 4, mStart.y + movement / 2, mStart.x - mLength / 2, mStart.y));
                this.getChildren().add(path);
                break;

            case SURPRISEDEND:
                path = new Path();
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                } 
                else 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x - movement / 4 - 4, mStart.y - movement / 2, mStart.x, mStart.y - movement / 2 - 1));
                    path.getElements().add(new QuadCurveTo(mStart.x + movement / 4 + 4, mStart.y - movement / 2, mEnd.x, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x + movement / 4 + 4, mStart.y + movement / 2, mStart.x, mStart.y + movement / 2 + 1));
                    path.getElements().add(new QuadCurveTo(mStart.x - movement / 4 - 4, mStart.y + movement / 2, mStart.x - mLength / 2, mStart.y));
                }
                this.getChildren().add(path);
                break;

            case HAPPY:
                path = new Path();
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement, mEnd.x + movement / 2, mStart.y - movement / 4));
                path.getElements().add(new LineTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4));
                this.getChildren().add(path);
                break;

            case HAPPYEND:
                path = new Path();
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                } 
                else 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement, mEnd.x + movement / 2, mStart.y - movement / 4));
                    path.getElements().add(new LineTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4));
                }
                this.getChildren().add(path);
                break;

            case DISGUSTED:
                path = new Path();
                movement = mLength / 2 + (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) / 2;

                path.getElements().add(new MoveTo(mStart.x - movement, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x - movement * 2 / 3, mStart.y - movement / 4, mStart.x - movement / 3, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement / 4, mStart.x + movement / 3, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x + movement * 2 / 3, mStart.y - movement / 4, mStart.x + movement, mEnd.y));
                this.getChildren().add(path);
                break;

            case DISGUSTEDEND:
                path = new Path();
                movement = mLength / 2 + mShapeAnimationStep / 2;
                if (mShapeAnimationStep - 1 <= 1) 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                } 
                else 
                {
                    path.getElements().add(new MoveTo(mStart.x - movement, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x - movement * 2 / 3, mStart.y - movement / 4, mStart.x - movement / 3, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement / 4, mStart.x + movement / 3, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x + movement * 2 / 3, mStart.y - movement / 4, mStart.x + movement, mEnd.y));
                }
                this.getChildren().add(path);
                break;

            case CONTEMPT:
                path = new Path();
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement / 1.5, mEnd.x + movement / 2, mEnd.y - movement / 2));
                this.getChildren().add(path);
                break;

            case CONTEMPTEND:
                path = new Path();
                movement = mShapeAnimationStep - 1;

                if (movement <= 1) 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                } 
                else 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement / 1.5, mEnd.x + movement / 2, mEnd.y - movement / 2));
                }
                this.getChildren().add(path);
                break;

            case FEAR:
                path = new Path();
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 4, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement / 2, mEnd.x + movement / 4, mEnd.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - 1, mStart.x - mLength / 2 - movement / 4, mStart.y));
                this.getChildren().add(path);
                break;

            case FEAREND:
                path = new Path();
                movement = mShapeAnimationStep - 1;

                if (movement <= 1) 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                } 
                else 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 4, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement / 2, mEnd.x + movement / 4, mEnd.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - 1, mStart.x - mLength / 2 - movement / 4, mStart.y));
                }
                this.getChildren().add(path);
                break;

            case EXCITED:
                path = new Path();
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement, mEnd.x + movement / 3 * 2, mStart.y - movement / 2));
                path.getElements().add(new LineTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
                this.getChildren().add(path);
                break;

            case EXCITEDEND:
                path = new Path();
                movement = mShapeAnimationStep - 1;

                if (movement <= 1) 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                } 
                else 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement, mEnd.x + movement / 3 * 2, mStart.y - movement / 2));
                    path.getElements().add(new LineTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
                }
                this.getChildren().add(path);
                break;

            case EMBARRASSED:
                path = new Path();
                movement = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep);

                path.getElements().add(new MoveTo(mStart.x - mLength / 2 + movement / 10 * 7, mStart.y + movement / 20));
                path.getElements().add(new QuadCurveTo((mStart.x - mLength / 2 + mEnd.x + movement / 10 * 3) / 2, mStart.y + 1, mEnd.x + movement / 10 * 3, mEnd.y + movement / 20));
                this.getChildren().add(path);
                break;

            case EMBARRASSEDEND:
                path = new Path();
                movement = mShapeAnimationStep - 1;

                if (movement <= 1) 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                } 
                else 
                {
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 + movement / 10 * 7, mStart.y + movement / 20));
                    path.getElements().add(new QuadCurveTo((mStart.x - mLength / 2 + mEnd.x + movement / 10 * 3) / 2, mStart.y + 1, mEnd.x + movement / 10 * 3, mEnd.y + movement / 20));
                }
                this.getChildren().add(path);
                break;

            case O:
                path = new Path();
                path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2, mEnd.x, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y));
                this.getChildren().add(path);
                break;

            case ONE:
            case SIX:
            case FOURTEEN:
            case NINETEEN:
                path = new Path();
                path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 5, mEnd.x, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 5, mStart.x - mLength / 2, mStart.y));
                this.getChildren().add(path);
                break;

            case TWO:
                path = new Path();
                path.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 1.6, mEnd.x - mLength / 6, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 2.8, mStart.y));
                this.getChildren().add(path);
                break;

            case THREE:
            case TWENTY:
                path = new Path();
                path.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.5, mEnd.x - mLength / 6, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2.5, mStart.x - mLength / 2.8, mStart.y));
                this.getChildren().add(path);
                break;

            case FOUR:
                path = new Path();
                path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - 3, mEnd.x, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y));
                this.getChildren().add(path);
                break;

            case FIVE:
            case EIGHT:
                path = new Path();
                path.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2, mEnd.x - mLength / 6, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y));
                this.getChildren().add(path);
                break;

            case SEVEN:
                path = new Path();
                path.getElements().add(new MoveTo(mStart.x - mLength / 3, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - 3, mEnd.x - mLength / 5, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 3, mStart.x - mLength / 3, mStart.y));
                this.getChildren().add(path);
                break;

            case NINE:
                path = new Path();
                path.getElements().add(new MoveTo(mStart.x - mLength / 3, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 5, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 3, mStart.y));
                this.getChildren().add(path);
                break;

            case TEN:
                path = new Path();
                path.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 6, mStart.y));
                path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y));
                break;

        }

        addToDrawObjects(path);
        this.update();
    }
}
