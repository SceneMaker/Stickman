package de.dfki.stickmanFX.bodyfx;

import java.awt.Dimension;
import java.net.URL;

import de.dfki.common.Gender;
import de.dfki.stickmanSwing.StickmanSwing;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 *
 * @author Beka movement = Animator3D.sMAX_ANIM_STEPS - mShapeAnimationStep;
 */
public class ThinkFX extends BodyPartFX {

    public static enum SHAPE {

        DEFAULT, THINKOFLOVE, THINKOFLOVEEND;
    };

    HeadFX mHeadFX;
    URL url;
    Image image;
    ImagePattern imagePattern;
    double mColorOpacity = 0;
    public ThinkFX.SHAPE mShape = ThinkFX.SHAPE.DEFAULT;

    public ThinkFX(HeadFX head) {
        mHeadFX = head;
        mLength = 16;
        mSize = new Dimension(mLength, 5);
        mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;

        init();
    }

    @Override
    public void setShape(String s) {
        ThinkFX.SHAPE shape = ThinkFX.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : ThinkFX.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = ThinkFX.SHAPE.DEFAULT;
    }

    @Override
    public void createShape() {
        mStart = mHeadFX.getThinkhBubbleStartPosition();

        double movement;

        clearChildren(this);

        Circle small_1 = new Circle(mStart.x - 50, mStart.y - 20, 3);
        Circle small_2 = new Circle(mStart.x - 60, mStart.y - 30, 5);
        Circle small_3 = new Circle(mStart.x - 65, mStart.y - 50, 8);
        Circle small_4 = new Circle(mStart.x - 55, mStart.y - 75, 11);
        Circle small_5 = new Circle(mStart.x - 30, mStart.y - 90, 15);
        Circle imageCircle = new Circle(mStart.x + 30, mStart.y - 120, 50);

        switch (mShape) {
            case DEFAULT:
                clearChildren(this);
                break;

            case THINKOFLOVE:
                if (mHeadFX.mStickmanFX.mType == Gender.TYPE.MALE) {
                    url = getClass().getClassLoader().getResource("girl2.gif");
                } else {
                    url = getClass().getClassLoader().getResource("boy2.jpg");
                }
                image = new Image(url.toString());
                imagePattern = new ImagePattern(image);

                mColorOpacity += 0.0555;
                if (mColorOpacity > 1) {
                    mColorOpacity = 1;
                }
                small_1.setFill(Color.rgb(255, 124, 212, mColorOpacity));
                small_2.setFill(Color.rgb(255, 124, 212, mColorOpacity));
                small_3.setFill(Color.rgb(255, 124, 212, mColorOpacity));
                small_4.setFill(Color.rgb(255, 124, 212, mColorOpacity));
                small_5.setFill(Color.rgb(255, 124, 212, mColorOpacity));
                small_1.setStrokeWidth(1);
                small_1.setStroke(Color.rgb(255, 0, 0, mColorOpacity));
                small_2.setStrokeWidth(1);
                small_2.setStroke(Color.rgb(255, 0, 0, mColorOpacity));
                small_3.setStrokeWidth(1);
                small_3.setStroke(Color.rgb(255, 0, 0, mColorOpacity));
                small_4.setStrokeWidth(1);
                small_4.setStroke(Color.rgb(255, 0, 0, mColorOpacity));
                small_5.setStrokeWidth(1);
                small_5.setStroke(Color.rgb(255, 0, 0, mColorOpacity));

                imageCircle.setFill(imagePattern);
                imageCircle.setStrokeWidth(2);
                imageCircle.setStroke(Color.rgb(255, 0, 0, mColorOpacity));
                imageCircle.setOpacity(mColorOpacity);

                this.getChildren().addAll(small_1, small_2, small_3, small_4, small_5, imageCircle);
                break;
            case THINKOFLOVEEND:
                mColorOpacity -= 0.0555;
                if (mColorOpacity < 0) {
                    mColorOpacity = 0;
                }
                small_1.setFill(Color.rgb(255, 124, 212, mColorOpacity));
                small_2.setFill(Color.rgb(255, 124, 212, mColorOpacity));
                small_3.setFill(Color.rgb(255, 124, 212, mColorOpacity));
                small_4.setFill(Color.rgb(255, 124, 212, mColorOpacity));
                small_5.setFill(Color.rgb(255, 124, 212, mColorOpacity));
                small_1.setStroke(Color.rgb(255, 0, 0, mColorOpacity));
                small_2.setStroke(Color.rgb(255, 0, 0, mColorOpacity));
                small_3.setStroke(Color.rgb(255, 0, 0, mColorOpacity));
                small_4.setStroke(Color.rgb(255, 0, 0, mColorOpacity));
                small_5.setStroke(Color.rgb(255, 0, 0, mColorOpacity));
                imageCircle.setFill(imagePattern);
                imageCircle.setStrokeWidth(2);
                imageCircle.setStroke(Color.rgb(255, 0, 0, mColorOpacity));
                imageCircle.setOpacity(mColorOpacity);
                this.getChildren().addAll(small_1, small_2, small_3, small_4, small_5, imageCircle);
                break;

        }
    }

}
