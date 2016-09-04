/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.body.*;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Beka
 *
 */
public class RightFootFX extends BodyPartFX {

	RightForeLegFX mRightForeLegFX;

	Point mStart;

	URL url;
	ColModelImporter imorter;
	MeshView rightFoot;

	public RightFootFX(RightForeLegFX rightForeLeg) {
		mRightForeLegFX = rightForeLeg;
		mLength = 10;
		mColor = Color.rgb(80, 80, 80);
		setDefaulRotation(0);

		url = getClass().getClassLoader().getResource("BodyParts/rightFoot.dae");
		imorter = new ColModelImporter();
		imorter.read(url);
		rightFoot = (MeshView) imorter.getImport()[0];

		mYRotation = 50;
		mRotation = -10;
		init();

		calculate(0);
	}

	public Point getLegStartPosition() {
		if (mRotation >= 0 && mRotation <= 90)
			return (rightFoot != null) ? new Point((int) (rightFoot.boundsInParentProperty().get().getMinX() + 2),
					(int) rightFoot.boundsInParentProperty().get().getMaxY() - 1) : new Point(0, 0);
		else if (mRotation > 90 && mRotation <= 180)
			return (rightFoot != null) ? new Point((int) (rightFoot.boundsInParentProperty().get().getMinX()),
					(int) rightFoot.boundsInParentProperty().get().getMinY() + 3) : new Point(0, 0);
		else if (mRotation < 0 && mRotation >= -90)
			return (rightFoot != null) ? new Point((int) (rightFoot.boundsInParentProperty().get().getMaxX()),
					(int) rightFoot.boundsInParentProperty().get().getMaxY()) : new Point(0, 0);
		else
			return (rightFoot != null) ? new Point((int) (rightFoot.boundsInParentProperty().get().getMaxX()),
					(int) rightFoot.boundsInParentProperty().get().getMinY()) : new Point(0, 0);
	}

	@Override
	public void calculate(int step) {
		mStart = mRightForeLegFX.getLegStartPosition();
		clearChildren(this);

		rightFoot.setTranslateX(mStart.x);
		rightFoot.setTranslateY(mStart.y);
		rightFoot.setTranslateZ(-100);

		Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		rightFoot.getTransforms().clear();
		rightFoot.getTransforms().addAll(rx, ry, rz);

		this.getChildren().add(rightFoot);
		// this.update();
	}

	@Override
	public void update() {
		if (mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
		if (mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
			if (mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added
																										// by
																										// Robbie
			{
				int fadeFactor = mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep
						* 12;
				if (fadeFactor <= 24) {
					fadeFactor = 0;
				}
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
						(fadeFactor * 100 / 255) / 100f);
			} else {
				int fadeFactor = (20
						- mRightForeLegFX.mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)
						* 12;
				if (fadeFactor >= 216) {
					mColor = mColorRecorder;
				} else
					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
							(fadeFactor * 100 / 255) / 100f);
			}
		}
	}
}
