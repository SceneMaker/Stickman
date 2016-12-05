package de.dfki.stickmanFX.bodyfx;

import java.awt.Dimension;
import java.awt.Point;

import de.dfki.stickmanFX.animationlogic.AnimatorFX;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 *
 * @author Beka
 *
 */
public class FaceWrinkleFX extends BodyPartFX {

    public static enum SHAPE {

        DEFAULT, ANGRY, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
    };

    HeadFX mHeadFX;
    Path mPath;
    public FaceWrinkleFX.SHAPE mShape = FaceWrinkleFX.SHAPE.DEFAULT;

    public FaceWrinkleFX(HeadFX head) {
        mHeadFX = head;
        mLength = 16;
        mSize = new Dimension(mLength, 5);
        mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;
        mPath = new Path();

        init();
    }

    @Override
    public void setShape(String s) {
        FaceWrinkleFX.SHAPE shape = FaceWrinkleFX.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : FaceWrinkleFX.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = FaceWrinkleFX.SHAPE.DEFAULT;
    }

    @Override
    public void createShape() {
        mStart = mHeadFX.getRightEyebrowPostion();
        mEnd = new Point(mStart.x - mLength, mStart.y);

        double movement;

        clearDrawObjects();
        clearChildren(this);

        mPath = new Path();

        switch (mShape) {
            case DEFAULT:
                break;

            case ANGRY:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                // Add wrinkle for angry face:
                int angryColorChange = (int) (movement / 4 * 16);
                mColor = Color.rgb(0, 0, 0, (angryColorChange * 100 / 255) / 100f);
                mPath.getElements().add(new MoveTo(mStart.x + 14, mStart.y + 7));
                mPath.getElements().add(new LineTo(mStart.x + 14, mStart.y - 1));
                mPath.getElements().add(new MoveTo(mStart.x + 20, mStart.y + 7));
                mPath.getElements().add(new LineTo(mStart.x + 20, mStart.y - 1));
                break;

            // End wrinkle for angry face:
            case ANGRYEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    mColor = Color.rgb(0, 0, 0, 0);
                } else {
                    angryColorChange = (int) (movement / 4 * 16);
                    mColor = Color.rgb(0, 0, 0, (angryColorChange * 100 / 255) / 100f);
                    mPath.getElements().add(new MoveTo(mStart.x + 14, mStart.y + 7));
                    mPath.getElements().add(new LineTo(mStart.x + 14, mStart.y - 1));
                    mPath.getElements().add(new MoveTo(mStart.x + 20, mStart.y + 7));
                    mPath.getElements().add(new LineTo(mStart.x + 20, mStart.y - 1));
                }

                break;

            case DISGUSTED:

                break;

            case SURPRISED:

                break;

            case EXCITED:

                break;

            case EMBARRASSED:
                movement = AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep;

                // Add wrinkles for embarrassed face:
                int embarrassedColorChange = (int) (movement / 4 * 16);
                mColor = new Color(0, 0, 0, (embarrassedColorChange * 100 / 255) / 100f);
                mPath.getElements().add(new MoveTo(mStart.x - 15, mStart.y));
                mPath.getElements().add(new LineTo(mStart.x - 15, mStart.y + 10));
                mPath.getElements().add(new MoveTo(mStart.x - 25, mStart.y + 5));
                mPath.getElements().add(new LineTo(mStart.x - 25, mStart.y + 20));
                break;

            case EMBARRASSEDEND:
                movement = mShapeAnimationStep - 1;
                if (movement <= 1) {
                    mColor = Color.rgb(0, 0, 0, 0);
                } else {
                    // Add wrinkles for embarrassed face:
                    embarrassedColorChange = (int) (movement / 4 * 16);
                    mColor = new Color(0, 0, 0, (embarrassedColorChange * 100 / 255) / 100f);
                    mPath.getElements().add(new MoveTo(mStart.x - 15, mStart.y));
                    mPath.getElements().add(new LineTo(mStart.x - 15, mStart.y + 10));
                    mPath.getElements().add(new MoveTo(mStart.x - 25, mStart.y + 5));
                    mPath.getElements().add(new LineTo(mStart.x - 25, mStart.y + 20));
                }
                break;
        }
        this.getChildren().add(mPath);
        addToDrawObjects(mPath);
        this.update();
    }

}
