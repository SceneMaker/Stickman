/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.body.*;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
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
import oracle.jrockit.jfr.events.DynamicValueDescriptor;

/**
 *
 * @author Beka
 *
 */
public class RightUpperArmFX extends BodyPartFX {

	RightShoulderFX mRightShoulderFX;

	int mArmLength = 70;
	Dimension mSize = new Dimension(mArmLength, mArmLength);

	Point mStart;

	URL url;
	ColModelImporter imorter;
	MeshView rightUpperArm;

	public RightUpperArmFX(RightShoulderFX shoulder) {
		mRightShoulderFX = shoulder;
		mColor = Color.rgb(80, 80, 80);
		mDefaultRotation = 23;
		mZRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mRotationStep = 0.0f;
		
		url = getClass().getClassLoader().getResource("BodyParts/leftUpperArm2.dae");
		imorter = new ColModelImporter();
		imorter.read(url);
		rightUpperArm = (MeshView) imorter.getImport()[0];

		init();
		calculate(0);
	}

	public Point getRightUpperArmEndPosition() {
		if (AnimatorFX.sCurrentAction == null || AnimatorFX.sCurrentAction.equals("rotate")) {
			if (mRotation >= 0 && mRotation <= 90)
				return (rightUpperArm != null)
						? new Point((int) (rightUpperArm.boundsInParentProperty().get().getMinX() + 4),
								(int) rightUpperArm.boundsInParentProperty().get().getMaxY() - 5)
						: new Point(0, 0);
			else if (mRotation > 90 && mRotation <= 180)
				return (rightUpperArm != null)
						? new Point((int) (rightUpperArm.boundsInParentProperty().get().getMinX() + 4),
								(int) rightUpperArm.boundsInParentProperty().get().getMinY() + 2)
						: new Point(0, 0);
			else if (mRotation < 0 && mRotation >= -90)
				return (rightUpperArm != null)
						? new Point((int) (rightUpperArm.boundsInParentProperty().get().getMinX() + 4),
								(int) rightUpperArm.boundsInParentProperty().get().getMaxY() - 5)
						: new Point(0, 0);
			else
				return (rightUpperArm != null)
						? new Point((int) (rightUpperArm.boundsInParentProperty().get().getMinX() + 4),
								(int) rightUpperArm.boundsInParentProperty().get().getMinY() + 4)
						: new Point(0, 0);
		} else if (AnimatorFX.sCurrentAction.equals("zrotate")) {
			if (mZRotation >= 0 && mZRotation <= 90)
				return (rightUpperArm != null)
						? new Point((int) (rightUpperArm.boundsInParentProperty().get().getMinX() + 4),
								(int) rightUpperArm.boundsInParentProperty().get().getMaxY() - 5)
						: new Point(0, 0);
			else if (mZRotation > 90 && mZRotation <= 180)
				return (rightUpperArm != null)
						? new Point((int) (rightUpperArm.boundsInParentProperty().get().getMinX() + 4),
								(int) rightUpperArm.boundsInParentProperty().get().getMinY() + 5)
						: new Point(0, 0);
			else if (mZRotation < 0 && mZRotation >= -90)
				return (rightUpperArm != null)
						? new Point((int) (rightUpperArm.boundsInParentProperty().get().getMaxX() - 5),
								(int) rightUpperArm.boundsInParentProperty().get().getMaxY() - 4)
						: new Point(0, 0);
			else
				return (rightUpperArm != null)
						? new Point((int) (rightUpperArm.boundsInParentProperty().get().getMaxX() - 5),
								(int) rightUpperArm.boundsInParentProperty().get().getMinY() + 4)
						: new Point(0, 0);
		} else if (AnimatorFX.sCurrentAction.equals("yrotate")) {
			if (mYRotation >= 0 && mYRotation <= 90)
				return (rightUpperArm != null)
						? new Point((int) (rightUpperArm.boundsInParentProperty().get().getMinX() + 5),
								(int) rightUpperArm.boundsInParentProperty().get().getMaxY() - 6)
						: new Point(0, 0);
			else if (mYRotation > 90 && mYRotation <= 180)
				return (rightUpperArm != null)
						? new Point((int) (rightUpperArm.boundsInParentProperty().get().getMaxX() - 5),
								(int) rightUpperArm.boundsInParentProperty().get().getMaxY() - 6)
						: new Point(0, 0);
			else if (mYRotation < 0 && mYRotation >= -90)
				return (rightUpperArm != null)
						? new Point((int) (rightUpperArm.boundsInParentProperty().get().getMinX() + 6),
								(int) rightUpperArm.boundsInParentProperty().get().getMaxY() - 4)
						: new Point(0, 0);
			else
				return (rightUpperArm != null)
						? new Point((int) (rightUpperArm.boundsInParentProperty().get().getMaxX() - 5),
								(int) rightUpperArm.boundsInParentProperty().get().getMaxY() - 4)
						: new Point(0, 0);
		}
		return new Point(0, 0);
	}

	@Override
	public void calculate(int step) {
		clearChildren(this);
		mStart = mRightShoulderFX.getRightShoulderEndPosition();

		rightUpperArm.setTranslateX(mStart.x);
		rightUpperArm.setTranslateY(mStart.y);
		rightUpperArm.setTranslateZ(-100);

		Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		rightUpperArm.getTransforms().clear();
		rightUpperArm.getTransforms().addAll(rx, ry, rz);

		if (mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mRightForeArmFX != null)
			mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mRightForeArmFX.calculate(step);
		this.getChildren().add(rightUpperArm);
		// this.update();
	}

	@Override
	public void update() {
		// draw outlines
		if (mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
		if (mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
			if (mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added
																							// by
																							// Robbie
			{
				int fadeFactor = mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
				if (fadeFactor <= 24) {
					fadeFactor = 0;
				}
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
						(fadeFactor * 100 / 255) / 100f);
			} else {
				int fadeFactor = (20
						- mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
				if (fadeFactor >= 216) {
					mColor = mColorRecorder;
				} else
					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
							(fadeFactor * 100 / 255) / 100f);
			}
		}

	}
}
