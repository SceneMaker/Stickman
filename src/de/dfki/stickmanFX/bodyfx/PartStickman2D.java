/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.bodyfx;

import de.dfki.common.part.Part2D;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Affine;
import javafx.util.Duration;

/**
 * @author Beka Aptsiauri
 */
public abstract class PartStickman2D extends Part2D
{

    @Override
    public void init()
    {
        mColorRecorder = mColor;
        super.init();
    }

    @Override
    public synchronized void calculate(int step)
    {
        Affine af = new Affine();
        af.appendTranslation(0, mTranslation);
        af.appendRotation(mRotation, mDefaultRotationPoint.x, mDefaultRotationPoint.y);

        for (Path gp : mGraphicPaths)
        {
            gp.getTransforms().clear();
            gp.getTransforms().add(af);
        }
    }

    @Override
    public void update()
    {
        recordColor();
        for (Path gp : mGraphicPaths)
        {
            gp.setStroke(mColor);
            gp.setStrokeLineCap(StrokeLineCap.ROUND);
            gp.setStrokeLineJoin(StrokeLineJoin.ROUND);
            gp.setStrokeWidth(3);
        }
    }

    protected void recordColor()
    {
    }

    public void showHearts(HeadFX mHeadFX, double xMovement, double yMovement1, double yMovement2)
    {
        int numHearts = 7;

        Ellipse path = new Ellipse(mHeadFX.mHalfWidth + 4, mHeadFX.mHalfHeight - 50, 60, 20);

        for (int i = 0; i < numHearts; i++)
        {
            Path heart = new Path();
            heart.getElements().add(new MoveTo(mStart.x - 10, mStart.y));
            heart.getElements().add(new QuadCurveTo(mStart.x - 10 - xMovement - 5, mEnd.y - yMovement2, mStart.x - 10, mEnd.y + yMovement1 + 15));
            heart.getElements().add(new MoveTo(mStart.x - 10, mStart.y));
            heart.getElements().add(new QuadCurveTo(mStart.x - 10 + xMovement + 5, mEnd.y - yMovement2, mStart.x - 10, mEnd.y + yMovement1 + 15));
            heart.setFill(Color.RED);

            this.getChildren().addAll(heart);

            FadeTransition ft = new FadeTransition(Duration.millis(200), heart);
            ft.setFromValue(1.0);
            ft.setToValue(0.1);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();

            PathTransition transition = createPathTransition(path, heart);
            transition.jumpTo(Duration.seconds(10).multiply(i * 1.0 / numHearts));
            this.toFront();
            transition.play();
        }

    }

    private PathTransition createPathTransition(Shape shape, Node node)
    {
        final PathTransition transition = new PathTransition(Duration.seconds(10), shape, node);

        transition.setAutoReverse(false);
        transition.setCycleCount(PathTransition.INDEFINITE);
        transition.setInterpolator(Interpolator.LINEAR);

        return transition;
    }

    @Override
    public void rotatePerlinNoise(double mWobble, int x, int y)
    {
        Affine af = new Affine();
        //Out put perlin noise
        af.appendRotation(Math.toRadians(mWobble), x, y);
        this.getTransforms().clear();
        this.getTransforms().add(af);
    }
}
