package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import java.awt.Dimension;
import java.awt.Point;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class RightEyebrowFX extends BodyPartFX 
{
    public static enum SHAPE 
    {
        DEFAULT, ANGRY, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
    };

    HeadFX mHeadFX;
    Path path;
    public RightEyebrowFX.SHAPE mShape = RightEyebrowFX.SHAPE.DEFAULT;

    public RightEyebrowFX(HeadFX head) 
    {
        mHeadFX = head;
        mLength = 16;
        mSize = new Dimension(mLength, 5);
        mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;
        mColor = Color.rgb(0, 0, 0, (64 * 100 / 255) / 100f);
        path = new Path();
        this.getChildren().add(path);
        init();
    }

    @Override
    public void setShape(String s) 
    {
        RightEyebrowFX.SHAPE shape = RightEyebrowFX.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : RightEyebrowFX.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() 
    {
        mShape = RightEyebrowFX.SHAPE.DEFAULT;
    }

    @Override
    public void createShape() 
    {
        mStart = mHeadFX.getRightEyebrowPostion();
        mEnd = new Point(mStart.x - mLength, mStart.y);

        double movement;

        clearDrawObjects();

        switch (mShape) 
        {
            case DEFAULT:
                if (mHeadFX.mStickmanFX.setCharacterInvisible == true) 
                {
                    if (mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
                    {
                        int fadeFactor = (int) (mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 3.2);
                        if (fadeFactor <= 6) 
                        {
                            fadeFactor = 0;
                        }
                        mColor = Color.rgb(0, 0, 0, (fadeFactor * 100 / 255) / 100f);
                    } 
                    else 
                    {
                        int fadeFactor = (int) ((20 - mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 3.2);
                        if (fadeFactor >= 57) 
                        {
                            fadeFactor = 0;
                        }
                        if (fadeFactor >= 54) 
                        {
                            fadeFactor = 64;
                        }
                        mColor = new Color(0, 0, 0, (fadeFactor * 100 / 255) / 100f);
                    }
                }

                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x, mStart.y));
                    path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                })).play();
                break;

            case ANGRY:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x + movement / 4, mStart.y + movement / 4));
                    path.getElements().add(new QuadCurveTo((mStart.x + movement / 4 + mEnd.x + movement / 3) / 2, mStart.y + movement / 4 - 3, mEnd.x + movement / 4, mEnd.y));
                })).play();
                
                break;

            case ANGRYEND:
                movement = mShapeAnimationStep - 1;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    if (movement <= 1) 
                    {
                        path.getElements().add(new MoveTo(mStart.x, mStart.y));
                        path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                    } 
                    else 
                    {
                        path.getElements().add(new MoveTo(mStart.x + movement / 4, mStart.y + movement / 4));
                        path.getElements().add(new QuadCurveTo((mStart.x + movement / 4 + mEnd.x + movement / 3) / 2, mStart.y + movement / 4 - 3, mEnd.x + movement / 4, mEnd.y));
                    }
                })).play();
                break;

            case DISGUSTED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 4));
                    path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 7, mEnd.x + movement / 10, mEnd.y));
                })).play();
                break;

            case DISGUSTEDEND:
                movement = mShapeAnimationStep - 1;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    if (movement <= 1) 
                    {
                        path.getElements().add(new MoveTo(mStart.x, mStart.y));
                        path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                    } 
                    else 
                    {
                        path.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 4));
                        path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 7, mEnd.x + movement / 10, mEnd.y));
                    }
                })).play();
                break;

            case SURPRISED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 7));
                    path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 7, mEnd.x, mEnd.y - movement / 7));
                })).play();
                break;

            case SURPRISEDEND:
                movement = mShapeAnimationStep - 1;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                   path.getElements().clear();
                   if (movement <= 1) 
                    {
                        path.getElements().add(new MoveTo(mStart.x, mStart.y));
                        path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                    } 
                    else 
                    {
                        path.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 7));
                        path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 7, mEnd.x, mEnd.y - movement / 7));
                    }
                })).play();
                break;

            case EXCITED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 4));
                    path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 5, mEnd.x, mEnd.y - movement / 4));
                })).play();
                break;

            case EXCITEDEND:
                movement = mShapeAnimationStep - 1;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    if (movement <= 1) 
                    {
                        path.getElements().add(new MoveTo(mStart.x, mStart.y));
                        path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                    } 
                    else 
                    {
                        path.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 4));
                        path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 5, mEnd.x, mEnd.y - movement / 4));
                    }
                })).play();
                break;

            case EMBARRASSED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x + movement / 2, mStart.y + movement / 3));
                    path.getElements().add(new QuadCurveTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2, mStart.y - 3 + movement / 10 * 7, mEnd.x + movement / 2, mEnd.y + movement / 2));
                })).play();
                break;

            case EMBARRASSEDEND:
                movement = mShapeAnimationStep - 1;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    if (movement <= 1) 
                    {
                        path.getElements().add(new MoveTo(mStart.x, mStart.y));
                        path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                    } 
                    else 
                    {
                        path.getElements().add(new MoveTo(mStart.x + movement / 2, mStart.y + movement / 3));
                        path.getElements().add(new QuadCurveTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2, mStart.y - 3 + movement / 10 * 7, mEnd.x + movement / 2, mEnd.y + movement / 2));
                    }
                })).play();
                break;
        }

        addToDrawObjects(path);
    }

}
