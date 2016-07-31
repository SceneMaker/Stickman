package de.dfki.stickmanfx.bodyfx;


import java.awt.Point;
import static de.dfki.stickman.animationlogic.util.Interpolator.linear;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;
import java.awt.BasicStroke;
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
public class LeftEyeFX extends BodyPartFX {


    public static enum SHAPE 
    {
        DEFAULT, BLINK, LOOKLEFT, LOOKRIGHT, ANGRY, ANGRYEND, SURPRISED, SURPRISEDEND, HAPPY, HAPPYEND, DISGUSTED, DISGUSTEDEND, LOVED, LOVEDEND, CONTEMPT, CONTEMPTEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
    };

    HeadFX mHeadFX;
    Path path;
    public LeftEyeFX.SHAPE mShape = LeftEyeFX.SHAPE.DEFAULT;

    public LeftEyeFX(HeadFX head) {
        mHeadFX = head;
        mLength = 5;
        mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;
        mColor = Color.rgb(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 22 : 0,
                mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 40 : 0,
                mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 65 : 0, (144 * 100 / 255) / 100f);
        path = new Path();
        this.getChildren().add(path);
        init();
    }

    @Override
    public void setShape(String s) {
        SHAPE shape = SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = LeftEyeFX.SHAPE.DEFAULT;
    }

    @Override
    public void createShape() {
        mStart = mHeadFX.getLeftEyePostion();
        mEnd = new Point(mStart.x - mLength, mStart.y);

        double movement;

        clearDrawObjects();

        switch (mShape) {
            case DEFAULT:
                if (mHeadFX.mStickmanFX.setCharacterInvisible == true) {
                    if (mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
                    {
                        int fadeFactor = mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 7;
                        if (fadeFactor <= 14) {
                            fadeFactor = 0;
                        }
                        mColor = new Color(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 22 : 0,
                                mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 40 : 0,
                                mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 65 : 0, (fadeFactor * 100 / 255) / 100f);
                    } else {
                        int fadeFactor = (20 - mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 7;
                        if (fadeFactor == 126) {
                            fadeFactor = 0;
                        }
                        if (fadeFactor >= 118) {
                            fadeFactor = 145;
                        }
                        mColor = new Color(mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 22 : 0,
                                mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 40 : 0,
                                mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.FEMALE ? 65 : 0, (fadeFactor * 100 / 255) / 100f);
                    }
                }
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                   path.getElements().clear();
                   path.getElements().add(new MoveTo(mStart.x, mStart.y));
                   path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                })).play();
                break;

            case BLINK:
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x, mStart.y));
                    path.getElements().add(new LineTo(mEnd.x, mEnd.y));
                })).play();
                break;

            case LOOKLEFT:
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x, mStart.y));
                    path.getElements().add(new QuadCurveTo(linear((mStart.x + mEnd.x) / 2, mStart.x, mShapeAnimationStep), mStart.y - 3, mEnd.x, mEnd.y));
                })).play();
                break;

            case LOOKRIGHT:
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x, mStart.y));
                    path.getElements().add(new QuadCurveTo(linear((mStart.x + mEnd.x) / 2, mEnd.x, mShapeAnimationStep), mStart.y - 3, mEnd.x, mEnd.y));
                })).play();
                break;

            case ANGRY:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x - movement / 10, mStart.y));
                    path.getElements().add(new QuadCurveTo((mStart.x - movement / 10 + mEnd.x - movement / 8) / 2, mStart.y - movement / 6, mEnd.x - movement / 8, mEnd.y));
                    path.getElements().add(new QuadCurveTo((mStart.x - movement / 10 + mEnd.x - movement / 8) / 2, mStart.y + movement / 6, mStart.x - movement / 10, mStart.y));
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
                        path.getElements().add(new MoveTo(mStart.x - movement / 10, mStart.y));
                        path.getElements().add(new QuadCurveTo((mStart.x - movement / 10 + mEnd.x - movement / 8) / 2, mStart.y - movement / 6, mEnd.x - movement / 8, mEnd.y));
                        path.getElements().add(new QuadCurveTo((mStart.x - movement / 10 + mEnd.x - movement / 8) / 2, mStart.y + movement / 6, mStart.x - movement / 10, mStart.y));
                    }
                })).play();
                break;

            case SURPRISED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x + movement / 10, mStart.y));
                    path.getElements().add(new QuadCurveTo((mStart.x + movement / 10 + mEnd.x - movement / 10) / 2, mStart.y - movement / 2, mEnd.x - movement / 10, mStart.y));
                    path.getElements().add(new QuadCurveTo((mStart.x + movement / 10 + mEnd.x - movement / 10) / 2, mStart.y + movement / 2, mStart.x + movement / 10, mStart.y));
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
                        path.getElements().add(new MoveTo(mStart.x + movement / 10, mStart.y));
                        path.getElements().add(new QuadCurveTo((mStart.x + movement / 10 + mEnd.x - movement / 10) / 2, mStart.y - movement / 2, mEnd.x - movement / 10, mStart.y));
                        path.getElements().add(new QuadCurveTo((mStart.x + movement / 10 + mEnd.x - movement / 10) / 2, mStart.y + movement / 2, mStart.x + movement / 10, mStart.y));
                    }
                })).play();
                break;

            case HAPPY:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x + movement / 10, mStart.y));
                    path.getElements().add(new QuadCurveTo((mStart.x + movement / 10 + mEnd.x - movement / 10) / 2, mStart.y - 3, mEnd.x - movement / 10, mEnd.y));
                })).play();
                break;

            case HAPPYEND:
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
                        path.getElements().add(new MoveTo(mStart.x + movement / 10, mStart.y));
                        path.getElements().add(new QuadCurveTo((mStart.x + movement / 10 + mEnd.x - movement / 10) / 2, mStart.y - 3, mEnd.x - movement / 10, mEnd.y));
                    }
                })).play();
                break;
            case DISGUSTED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x + movement / 4, mStart.y - movement / 4));
                    path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 8, mEnd.x - movement / 8, mEnd.y + movement / 8));
                    path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 4, mStart.x + movement / 4, mStart.y + movement / 8));
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
                        path.getElements().add(new MoveTo(mStart.x + movement / 4, mStart.y - movement / 4));
                        path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 8, mEnd.x - movement / 8, mEnd.y + movement / 8));
                        path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement / 4, mStart.x + movement / 4, mStart.y + movement / 8));
                    }
                })).play();
                break;

            case LOVED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                double xMovement = movement / 10 * 6;
                double yMovement1 = movement / 10 * 6;
                double yMovement2 = movement / 10 * 3;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x - xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
                    path.getElements().add(new MoveTo(mStart.x, mStart.y));
                    path.getElements().add(new QuadCurveTo(mStart.x + xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
                })).play();
                break;

            case LOVEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) 
                {
                    new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                    {
                        path.getElements().clear();
                        path.getElements().add(new MoveTo(mStart.x, mStart.y));
                        path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y));
                    })).play();
                } 
                else 
                {
                    xMovement = movement / 10 * 6;
                    yMovement1 = movement / 10 * 6;
                    yMovement2 = movement / 10 * 3;
                    
                    new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                    {
                        path.getElements().clear();
                        path.getElements().add(new MoveTo(mStart.x, mStart.y));
                        path.getElements().add(new QuadCurveTo(mStart.x - xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
                        path.getElements().add(new MoveTo(mStart.x, mStart.y));
                        path.getElements().add(new QuadCurveTo(mStart.x + xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1));
                    })).play();
                }
                break;

            case CONTEMPT:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x, mStart.y));
                    path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - movement / 10, mEnd.x, mStart.y));
                    path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y + movement / 10, mStart.x, mStart.y));
                })).play();
                break;

            case CONTEMPTEND:
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
                        path.getElements().add(new MoveTo(mStart.x, mStart.y));
                        path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - movement / 10, mEnd.x, mStart.y));
                        path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y + movement / 10, mStart.x, mStart.y));
                    }
                })).play();
                break;

            case EXCITED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x + movement / 10, mStart.y));
                    path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x - movement / 10, mEnd.y));
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
                        path.getElements().add(new MoveTo(mStart.x + movement / 10, mStart.y));
                        path.getElements().add(new QuadCurveTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x - movement / 10, mEnd.y));
                    }
                })).play();
                break;

            case EMBARRASSED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;
                new Timeline(new KeyFrame(Duration.millis(40), ae -> 
                {
                    path.getElements().clear();
                    path.getElements().add(new MoveTo(mStart.x + movement / 2, mStart.y + movement / 5 * 2));
                    path.getElements().add(new QuadCurveTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2, mStart.y - 4 + movement / 2, mEnd.x + movement / 2, mEnd.y + movement / 5 * 2));
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
                        path.getElements().add(new MoveTo(mStart.x + movement / 2, mStart.y + movement / 5 * 2));
                        path.getElements().add(new QuadCurveTo((mStart.x + movement / 2 + mEnd.x + movement / 2) / 2, mStart.y - 4 + movement / 2, mEnd.x + movement / 2, mEnd.y + movement / 5 * 2));
                    }
                })).play();
                break;

        }
        addToDrawObjects(path);

    }
}
