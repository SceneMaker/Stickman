package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
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
public class RightEyebrowFX extends BodyPartFX 
{
    public static enum SHAPE 
    {
        DEFAULT, ANGRY, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
    };

    HeadFX mHeadFX;
    public RightEyebrowFX.SHAPE mShape = RightEyebrowFX.SHAPE.DEFAULT;

    public RightEyebrowFX(HeadFX head) 
    {
        mHeadFX = head;
        mLength = 16;
        mSize = new Dimension(mLength, 5);
        mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;
        mColor = Color.rgb(0, 0, 0, (64 * 100 / 255) / 100f);

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
        clearChildren(this);
        Path path = new Path();

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

                path = new Path();
                path.getElements().add(new MoveTo(mStart.x, mStart.y));
                path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                this.getChildren().add(path);
                break;

            case ANGRY:
                path = new Path();
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                path.getElements().add(new MoveTo(mStart.x + movement / 4, mStart.y + movement / 4));
                path.getElements().add(new QuadCurveTo((mStart.x + movement / 4 + mEnd.x + movement / 3) / 2, mStart.y + movement / 4 - 3, mEnd.x + movement / 4, mEnd.y));
                this.getChildren().add(path);
                break;

            case ANGRYEND:
                path = new Path();
                movement = mShapeAnimationStep - 1;
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
                this.getChildren().add(path);
                break;

            case DISGUSTED:
                path = new Path();
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                path.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 4));
                path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 7, mEnd.x + movement / 10, mEnd.y));
                this.getChildren().add(path);
                break;

            case DISGUSTEDEND:
                path = new Path();
                movement = mShapeAnimationStep - 1;
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
                this.getChildren().add(path);
                break;

            case SURPRISED:
                path = new Path();
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                path.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 7));
                path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 7, mEnd.x, mEnd.y - movement / 7));
                this.getChildren().add(path);
                break;

            case SURPRISEDEND:
                path = new Path();
                movement = mShapeAnimationStep - 1;
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
                this.getChildren().add(path);
                break;

            case EXCITED:
                path = new Path();
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                path.getElements().add(new MoveTo(mStart.x, mStart.y - movement / 4));
                path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 - movement / 5, mEnd.x, mEnd.y - movement / 4));
                this.getChildren().add(path);
                break;

            case EXCITEDEND:
                path = new Path();
                movement = mShapeAnimationStep - 1;
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
                this.getChildren().add(path);
                break;

            case EMBARRASSED:
                path = new Path();
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                path.getElements().add(new MoveTo(mStart.x + movement / 2, mStart.y + movement / 3));
                path.getElements().add(new QuadCurveTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2, mStart.y - 3 + movement / 10 * 7, mEnd.x + movement / 2, mEnd.y + movement / 2));
                this.getChildren().add(path);
                break;

            case EMBARRASSEDEND:
                path = new Path();
                movement = mShapeAnimationStep - 1;
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
                this.getChildren().add(path);
                break;
        }

        addToDrawObjects(path);
        this.update();
    }

}
