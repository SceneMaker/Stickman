/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.bodyfx;

import de.dfki.stickmanFX.animationlogic.AnimatorFX;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public abstract class BodyPartFX extends Pane {

    public enum SHAPE {
        DEFAULT
    };

    // variables for size and drawing
    public Dimension mSize = new Dimension(10, 10);
    public Point mStart = new Point(0, 0), mEnd = new Point(0, 0);
    public int mLength = 0;

    public double mAnimationStep = 0;
    public int mShapeAnimationStep = 0;

    public int mDefaultTranslation = 0;
    public double mTranslation = mDefaultTranslation;
    public double mToTranslation = mDefaultTranslation;
    public double mTranslationStep = 0.0f;

    public int mDefaultRotation = 0;
    public Point mDefaultRotationPoint = new Point(0, 0);
    public double mRotation = mDefaultRotation;
    public double mToDegree = mDefaultRotation;
    public double mRotationStep = 0.0f;

    List<Path> mGraphicPaths = Collections.synchronizedList(new ArrayList());

    public Color mColor = Color.rgb(0, 0, 0);
    public float mColoropacity = 1.0f;
    
    // used by RestButton.
    public Color mColorRest = Color.rgb(0, 0, 0);
    public float mColoropacityRest = 1.0f;

    protected Color mColorRecorder = mColor;

    public BasicStroke mStroke = new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

    public void init() {
        this.setPrefHeight(mSize.height);
        this.setPrefWidth(mSize.width);

        calculate(0);
    }

    public void setTranslation(int length) {
        mToTranslation = mTranslation + length;
        mTranslationStep = (double) length / AnimatorFX.sMAX_ANIM_STEPS;
    }

    public synchronized void calculateTranslation(int step) {
        mTranslation += mTranslationStep;
        mTranslation = (double) Math.round(mTranslation * 1000d) / 1000d; // the poor man's round method

        Platform.runLater(() -> calculate(step));
    }

    public void resetTranslation() {
        mTranslationStep = 0.0d;
    }

    public void setDefaulRotation(int degree) {
        mDefaultRotation = degree;
        mRotation = mDefaultRotation;
        mToDegree = mDefaultRotation;
        mRotationStep = 0.0f;
    }

    public void setRotation(int degree) {
        mToDegree = mRotation + degree;
        mRotationStep = (double) degree / AnimatorFX.sMAX_ANIM_STEPS;
    }

    public void setTilt(int degree) {
        mToDegree = mRotation + degree;
        mRotationStep = (double) degree / AnimatorFX.sMAX_ANIM_STEPS;
    }

    public synchronized void calculateRotation(int step) {
        mRotation += mRotationStep;
        mRotation = (double) Math.round(mRotation * 1000d) / 1000d; // the poor man's round method
        Platform.runLater(() -> calculate(step));

    }

    public void resetRotation() {

        mTranslationStep = 0.0d;

    }

    public void setShape(String s) {
        // place code for setting shape
    }

    public void createShape() {
        // create the shape
    }

    public synchronized void calculateShape(int step) {
        mShapeAnimationStep = step;

        Platform.runLater(() -> calculate(step));
    }

    public void resetShape() {
        mShapeAnimationStep = 0;
    }

    public void clearDrawObjects() {
        mGraphicPaths = new ArrayList<>();
    }

    public void clearChildren(BodyPartFX bodyPartFX) {
        bodyPartFX.getChildren().clear();
    }

    public void addToDrawObjects(Path gp) {
        mGraphicPaths.add(gp);
    }

    public synchronized void calculate(int step) {
        createShape();

        Affine af = new Affine();
        af.appendTranslation(0, mTranslation);
        af.appendRotation(mRotation, mDefaultRotationPoint.x, mDefaultRotationPoint.y);

        for (Path gp : mGraphicPaths) {
            gp.getTransforms().clear();
            gp.getTransforms().add(af);
        }
    }

    public void update() {
        recordColor();
        for (Path gp : mGraphicPaths) {
            gp.setStroke(mColor);
            gp.setStrokeLineCap(StrokeLineCap.ROUND);
            gp.setStrokeLineJoin(StrokeLineJoin.ROUND);
            gp.setStrokeWidth(3);
        }
    }

    protected void recordColor() {

    }

    public void showHearts(HeadFX mHeadFX, double xMovement, double yMovement1, double yMovement2) {
        int numHearts = 7;

        Ellipse path = new Ellipse(mHeadFX.mHalfWidth + 4, mHeadFX.mHalfHeight - 50, 60, 20);

        for (int i = 0; i < numHearts; i++) {
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

    private PathTransition createPathTransition(Shape shape, Node node) {
        final PathTransition transition = new PathTransition(Duration.seconds(10), shape, node);

        transition.setAutoReverse(false);
        transition.setCycleCount(PathTransition.INDEFINITE);
        transition.setInterpolator(Interpolator.LINEAR);

        return transition;
    }

    public void rotatePerlinNoise(double mWobble, int x, int y) {
        Affine af = new Affine();
        //Out put perlin noise
        af.appendRotation(Math.toRadians(mWobble), x, y);
        this.getTransforms().clear();
        this.getTransforms().add(af);
    }
}
