/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;
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
	public double mXTranslation = mDefaultTranslation;
	public double mYTranslation = mDefaultTranslation;
	public double mZTranslation = mDefaultTranslation;
	public double mXToTranslation = mDefaultTranslation;
	public double mYToTranslation = mDefaultTranslation;
	public double mZToTranslation = mDefaultTranslation;
	
	public double mXTranslationStep = 0.0f;
	public double mYTranslationStep = 0.0f;
	public double mZTranslationStep = 0.0f;

	public int mDefaultRotation = 0;
	public Point mDefaultRotationPoint = new Point(0, 0);
	
	public double mXRotation = mDefaultRotation;
	public double mYRotation = mDefaultRotation;
	public double mZRotation = mDefaultRotation;
	public double mToDegreeX = mDefaultRotation;
	public double mToDegreeY = mDefaultRotation;
	public double mToDegreeZ = mDefaultRotation;
	public double mXRotationStep = 0.0f;
	public double mYRotationStep = 0.0f;
	public double mZRotationStep = 0.0f;

	public Color mColor = Color.rgb(0, 0, 0);
	public Color mColorRecorder;

	public BasicStroke mStroke = new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

	public void init() {
		this.setPrefHeight(mSize.height);
		this.setPrefWidth(mSize.width);
		mColorRecorder  = mColor;
		calculate(0);
	}

	public void set_X_Translation(int length) {
		mXToTranslation = mXTranslation + length;
		mXTranslationStep = (double) length / AnimatorFX.sMAX_ANIM_STEPS;
	}
	
	public void set_Y_Translation(int length) {
		mYToTranslation = mYTranslation + length;
		mYTranslationStep = (double) length / AnimatorFX.sMAX_ANIM_STEPS;
	}
	
	public void set_Z_Translation(int length) {
		mZToTranslation = mZTranslation + length;
		mZTranslationStep = (double) length / AnimatorFX.sMAX_ANIM_STEPS;
	}

	public synchronized void calculate_X_Translation(int step) {
		mXTranslation += mXTranslationStep;
		mXTranslation = Math.round(mXTranslation * 1000d) / 1000d; 

		Platform.runLater(() -> calculate(step));
	}
	
	public synchronized void calculate_Y_Translation(int step) {
		mYTranslation += mYTranslationStep;
		mYTranslation = Math.round(mYTranslation * 1000d) / 1000d; 

		Platform.runLater(() -> calculate(step));
	}
	
	public synchronized void calculate_Z_Translation(int step) {
		mZTranslation += mZTranslationStep;
		mZTranslation = Math.round(mZTranslation * 1000d) / 1000d; 

		Platform.runLater(() -> calculate(step));
	}

	public void resetTranslation() {
		mXTranslationStep = 0.0d;
		mYTranslationStep = 0.0d;
		mZTranslationStep = 0.0d;
	}

	public void setDefaulRotation(int degree) {
		mDefaultRotation = degree;
		mXRotation = mDefaultRotation;
		mYRotation = mDefaultRotation;
		mZRotation = mDefaultRotation;

		mToDegreeX = mDefaultRotation;
		mToDegreeY = mDefaultRotation;
		mToDegreeZ = mDefaultRotation;
		mXRotationStep = 0.0f;
	}

	public void set_X_Rotation(int degree) {
		mToDegreeX = mXRotation + degree;
		mXRotationStep = (double) degree / AnimatorFX.sMAX_ANIM_STEPS;
	}

	public void set_Y_Rotation(int degree) {
		mToDegreeY = mYRotation + degree;
		mYRotationStep = (double) degree / AnimatorFX.sMAX_ANIM_STEPS;
	}

	public void set_Z_Rotation(int degree) {
		mToDegreeZ = mZRotation + degree;
		mZRotationStep = (double) degree / AnimatorFX.sMAX_ANIM_STEPS;
	}

	public void setTilt(int degree) {
		mToDegreeX = mXRotation + degree;
		mXRotationStep = (double) degree / AnimatorFX.sMAX_ANIM_STEPS;
	}

	public synchronized void calculate_X_Rotation(int step) {
		mXRotation += mXRotationStep;
		mXRotation = Math.round(mXRotation * 1000d) / 1000d; 
		
		Platform.runLater(() -> calculate(step));
	}

	public synchronized void calculate_Y_Rotation(int step) {
		mYRotation += mYRotationStep;
		mYRotation = Math.round(mYRotation * 1000d) / 1000d; 
		
		Platform.runLater(() -> calculate(step));
	}

	public synchronized void calculate_Z_Rotation(int step) {
		mZRotation += mZRotationStep;
		mZRotation = Math.round(mZRotation * 1000d) / 1000d; 
		
		Platform.runLater(() -> calculate(step));

	}

	public void resetRotation() {

//		mTranslationStep = 0.0d;

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

	public void clearChildren(BodyPartFX bodyPartFX) {
		bodyPartFX.getChildren().clear();
	}

	public synchronized void calculate(int step) {
		createShape();
	}

	public void update() {
		recordColor();
	}

	protected void recordColor() {

	}

	public void showHearts(HeadFX mHeadFX, double xMovement, double yMovement1, double yMovement2) {
		int numHearts = 7;

		Ellipse path = new Ellipse(mHeadFX.mHalfWidth + 4, mHeadFX.mHalfHeight - 50, 60, 20);

		for (int i = 0; i < numHearts; i++) {
			Path heart = new Path();
			heart.getElements().add(new MoveTo(mStart.x - 10, mStart.y));
			heart.getElements().add(new QuadCurveTo(mStart.x - 10 - xMovement - 5, mEnd.y - yMovement2, mStart.x - 10,
					mEnd.y + yMovement1 + 15));
			heart.getElements().add(new MoveTo(mStart.x - 10, mStart.y));
			heart.getElements().add(new QuadCurveTo(mStart.x - 10 + xMovement + 5, mEnd.y - yMovement2, mStart.x - 10,
					mEnd.y + yMovement1 + 15));
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
		// Out put perlin noise
		af.appendRotation(Math.toRadians(mWobble), x, y);
		this.getTransforms().clear();
		this.getTransforms().add(af);
	}
}
