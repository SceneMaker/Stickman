package de.dfki.stickman3D.body;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Point;

import de.dfki.stickman3D.animationlogic.Animator;
import de.dfki.stickman3D.mimic.util.FaceWrinkleANGRY;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;

/**
 *
 * @author Beka
 *
 */
public class FaceWrinkle extends BodyPart {

	public static enum SHAPE {

		DEFAULT, ANGRY, ANGRYEND, DISGUSTED, DISGUSTEDEND, SURPRISED, SURPRISEDEND, EXCITED, EXCITEDEND, EMBARRASSED, EMBARRASSEDEND
	};

	Head mHeadFX;

	Polygon currentLeftPolygon;
	Polygon currentRightPolygon;

	public FaceWrinkle.SHAPE mShape = FaceWrinkle.SHAPE.DEFAULT;

	public FaceWrinkle(Head head) {
		mHeadFX = head;
		mColor = Color.rgb(80, 80, 80, 0);
		mSize = new Dimension(mLength, 5);
		mDefaultRotationPoint = mHeadFX.mDefaultRotationPoint;

		currentLeftPolygon = new Polygon();
		currentRightPolygon = new Polygon();

		mHeadFX.mHead.getChildren().addAll(currentLeftPolygon, currentRightPolygon);

		init();
	}

	@Override
	public void init() {
		super.init();

		currentLeftPolygon.setTranslateX(3);
		currentLeftPolygon.setTranslateY(-10);
		currentRightPolygon.setTranslateX(-3);
		currentRightPolygon.setTranslateY(-10);
		currentLeftPolygon.setTranslateZ(-18);
		currentRightPolygon.setTranslateZ(-18);
	}

	@Override
	public void setShape(String s) {
		FaceWrinkle.SHAPE shape = FaceWrinkle.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : FaceWrinkle.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = FaceWrinkle.SHAPE.DEFAULT;
	}

	@Override
	public void calculate(int step) {
		mStart = mHeadFX.getRightEyebrowPostion();

		double colorOpacity = 0;

		switch (mShape) {
		case DEFAULT:
			break;

		case ANGRY:
			currentLeftPolygon = FaceWrinkleANGRY.getLeftANGRY(currentLeftPolygon, step);
			currentRightPolygon = FaceWrinkleANGRY.getRightANGRY(currentRightPolygon, step);

			colorOpacity = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
			mColor = Color.rgb(80, 80, 80, colorOpacity / 19);
			currentLeftPolygon.setFill(mColor);
			currentRightPolygon.setFill(mColor);

			break;

		case ANGRYEND:
			colorOpacity = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;

			mColor = Color.rgb(80, 80, 80, 1 - colorOpacity / 19);
			currentLeftPolygon.setFill(mColor);
			currentRightPolygon.setFill(mColor);
			break;

		case DISGUSTED:
			break;

		case SURPRISED:
			break;

		case EXCITED:
			break;

		case EMBARRASSED:
			break;

		case EMBARRASSEDEND:
			break;
		}
	}
}
