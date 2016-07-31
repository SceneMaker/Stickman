package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import java.awt.Dimension;
import java.awt.Point;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;

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
    Path path;

    public MouthFX.SHAPE mShape = MouthFX.SHAPE.DEFAULT;

    public MouthFX(HeadFX head) 
    {
        mHeadFX = head;
        mLength = 20;
        mSize = new Dimension(mLength * 2, 5);
        mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;
        mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 64 : 32, 0, 0, (128 * 100 / 255) / 100f);
        path = new Path();
        this.getChildren().add(path);
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
                
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y));
                })).play();
                break;

            case SMILE:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement / 3 * 2, mEnd.x + movement / 3 * 2, mStart.y - movement / 2));
                })).play();
                break;

            case SMILEEND:
                movement = mShapeAnimationStep - 1;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
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
                })).play();
                break;

            case SAD:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 2, mStart.y + movement / 4));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement, mEnd.x + movement / 2, mEnd.y + movement / 4));
                })).play();
                break;

            case SADEND:
                movement = mShapeAnimationStep - 1;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
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
                })).play();
                break;

            case ANGRY:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 4, mStart.y + movement / 10));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 - movement / 3 * 2, mEnd.x + movement / 4, mStart.y + movement / 10));
                })).play();
                break;

            case ANGRYEND:
                movement = mShapeAnimationStep - 1;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
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
                })).play();
                break;

            case ANGRYSMALLMOUTH:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 + movement / 10, mStart.y + movement / 10));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 - movement / 4, mEnd.x - movement / 10, mStart.y + movement / 10));
                })).play();
                break;

            case ANGRYSMALLMOUTHEND:
                movement = mShapeAnimationStep - 1;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
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
                })).play();
                break;

            case SURPRISED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x - movement / 4 - 4, mStart.y - movement / 2, mStart.x, mStart.y - movement / 2 - 1));
                    path.getElements().add(new QuadCurveTo(mStart.x + movement / 4 + 4, mStart.y - movement / 2, mEnd.x, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x + movement / 4 + 4, mStart.y + movement / 2, mStart.x, mStart.y + movement / 2 + 1));
                    path.getElements().add(new QuadCurveTo(mStart.x - movement / 4 - 4, mStart.y + movement / 2, mStart.x - mLength / 2, mStart.y));
                })).play();
                break;

            case SURPRISEDEND:
                movement = mShapeAnimationStep - 1;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                   path.getElements().clear();
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
                })).play();
                break;

            case HAPPY:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 1 + movement, mEnd.x + movement / 2, mStart.y - movement / 4));
                    path.getElements().add(new LineTo(mStart.x - mLength / 2 - movement / 2, mStart.y - movement / 4));
                })).play();
                break;

            case HAPPYEND:
                movement = mShapeAnimationStep - 1;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                   path.getElements().clear();
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
                })).play();
                break;

            case DISGUSTED:
                movement = mLength / 2 + (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep) / 2;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - movement, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x - movement * 2 / 3, mStart.y - movement / 4, mStart.x - movement / 3, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement / 4, mStart.x + movement / 3, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x + movement * 2 / 3, mStart.y - movement / 4, mStart.x + movement, mEnd.y));
                })).play();
                break;

            case DISGUSTEDEND:
                movement = mLength / 2 + mShapeAnimationStep / 2;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
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
                })).play();
                break;

            case CONTEMPT:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement / 1.5, mEnd.x + movement / 2, mEnd.y - movement / 2));
                })).play();
                break;

            case CONTEMPTEND:
                movement = mShapeAnimationStep - 1;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
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
                })).play();
                break;

            case FEAR:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 4, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - movement / 2, mEnd.x + movement / 4, mEnd.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - 1, mStart.x - mLength / 2 - movement / 4, mStart.y));
                })).play();
                break;

            case FEAREND:
                movement = mShapeAnimationStep - 1;
                    new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                    {
                        path.getElements().clear();
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
                })).play();
                break;

            case EXCITED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + movement, mEnd.x + movement / 3 * 2, mStart.y - movement / 2));
                    path.getElements().add(new LineTo(mStart.x - mLength / 2 - movement / 3 * 2, mStart.y - movement / 2));
                })).play();
                break;

            case EXCITEDEND:
                movement = mShapeAnimationStep - 1;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
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
                })).play();
                break;

            case EMBARRASSED:
                movement = (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep);
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                path.getElements().add(new MoveTo(mStart.x - mLength / 2 + movement / 10 * 7, mStart.y + movement / 20));
                path.getElements().add(new QuadCurveTo((mStart.x - mLength / 2 + mEnd.x + movement / 10 * 3) / 2, mStart.y + 1, mEnd.x + movement / 10 * 3, mEnd.y + movement / 20));
                })).play();
                break;

            case EMBARRASSEDEND:
                movement = mShapeAnimationStep - 1;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
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
                })).play();
                break;

            case O:
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2, mEnd.x, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y));
                })).play();
                break;

            case ONE:
            case SIX:
            case FOURTEEN:
            case NINETEEN:
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 5, mEnd.x, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 5, mStart.x - mLength / 2, mStart.y));
                })).play();
                break;

            case TWO:
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 1.6, mEnd.x - mLength / 6, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 2.8, mStart.y));
                })).play();
                break;

            case THREE:
            case TWENTY:
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.5, mEnd.x - mLength / 6, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2.5, mStart.x - mLength / 2.8, mStart.y));
                })).play();
                break;

            case FOUR:
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - 3, mEnd.x, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y));
                })).play();
                break;

            case FIVE:
            case EIGHT:
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2, mEnd.x - mLength / 6, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y));
                })).play();
                break;

            case SEVEN:
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 3, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - 3, mEnd.x - mLength / 5, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + 3, mStart.x - mLength / 3, mStart.y));
                })).play();
                break;

            case NINE:
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 3, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 5, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 3, mStart.y));
                })).play();
                break;

            case TEN:
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - mLength / 2.8, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 6, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y));
                })).play();
                break;

        }

        addToDrawObjects(path);
        //this.update();
    }
}
