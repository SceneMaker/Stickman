package de.dfki.stickmanFX.bodyfx;

import java.awt.Dimension;
import java.net.URL;

import de.dfki.stickmanFX.animationlogic.AnimatorFX;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 *
 * @author Beka movement = Animator3D.sMAX_ANIM_STEPS - mShapeAnimationStep;
 */
public class BombeFX extends BodyPartFX {

    public static enum SHAPE {

        DEFAULT, BOMBETRANSITION, BOMBEEXPLOSION;
    };

    HeadFX mHeadFX;
    URL url;
    Image image;
    ImageView imageView;
    double mColorOpacity = 0;
    public BombeFX.SHAPE mShape = BombeFX.SHAPE.DEFAULT;

    public BombeFX(HeadFX head) {
        mHeadFX = head;
        mLength = 16;
        mSize = new Dimension(mLength, 5);
        mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;

        init();
    }

    @Override
    public void setShape(String s) {
        BombeFX.SHAPE shape = BombeFX.SHAPE.valueOf(s);
        mShape = (shape != null) ? shape : BombeFX.SHAPE.DEFAULT;
    }

    @Override
    public void resetShape() {
        mShape = BombeFX.SHAPE.DEFAULT;
    }

    @Override
    public void createShape() {
        mStart = mHeadFX.getBombeStartPosition();
        mEnd = mHeadFX.getBombeEndPosition();

        double movement;

        //clearChildren(this);
        switch (mShape) {
            case DEFAULT:
                clearChildren(this);
                break;

            case BOMBETRANSITION:
                if (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep == 0) {
                    clearChildren(this);
                    url = getClass().getClassLoader().getResource("bombe.gif");
                    image = new Image(url.toString());
                    imageView = new ImageView(image);

                    Path path = new Path();
                    path.getElements().add(new MoveTo(mStart.x, mStart.y));
                    path.getElements().add(new LineTo(mEnd.x, mEnd.y));

                    PathTransition transition = new PathTransition(Duration.millis(2000), path, imageView);
                    transition.setInterpolator(Interpolator.LINEAR);
                    transition.play();

                    this.getChildren().addAll(imageView);
                }
                break;
            case BOMBEEXPLOSION:
                if (AnimatorFX.sMAX_ANIM_STEPS - mShapeAnimationStep == 0) {
                    clearChildren(this);
                    url = getClass().getClassLoader().getResource("explosion.gif");
                    image = new Image(url.toString());
                    imageView = new ImageView(image);
                    imageView.setLayoutX(mEnd.x - 180);
                    imageView.setLayoutY(mEnd.y - 250);

                    this.getChildren().addAll(imageView);
                }
                break;

        }
    }

}
