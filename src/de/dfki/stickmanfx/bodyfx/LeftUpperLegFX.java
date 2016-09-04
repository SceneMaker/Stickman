/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.body.*;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;

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
public class LeftUpperLegFX extends BodyPartFX {

	BodyFX mBodyFX;

	Point mStart;

	URL url;
	ColModelImporter imorter;
	MeshView lefttUpperLeg;

	public LeftUpperLegFX(BodyFX body) {
		mBodyFX = body;
		mLength = 60;
		mSize = new Dimension(10, mLength);
		mColor = Color.rgb(80, 80, 80);

		mDefaultRotation = 0;
		mRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mRotationStep = 0.0f;

		if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			url = getClass().getClassLoader().getResource("BodyParts/RightUpperLeg.dae");
		else
			url = getClass().getClassLoader().getResource("BodyParts/femaleRightUpperLeg.dae");
		imorter = new ColModelImporter();
		imorter.read(url);
		lefttUpperLeg = (MeshView) imorter.getImport()[0];

		init();

		calculate(0);
	}

	public Point getLeftUpperLegEndPosition() {
		
		if (AnimatorFX.sCurrentAction == null || AnimatorFX.sCurrentAction.equals("rotate")) {
			if (mRotation >= 0 && mRotation <= 90)
				return (lefttUpperLeg != null)
						? new Point((int) (lefttUpperLeg.boundsInParentProperty().get().getMaxX() - 4),
								(int) lefttUpperLeg.boundsInParentProperty().get().getMaxY() - 5)
						: new Point(0, 0);
			else if (mRotation > 90 && mRotation <= 180)
				return (lefttUpperLeg != null)
						? new Point((int) (lefttUpperLeg.boundsInParentProperty().get().getMaxX() - 2),
								(int) lefttUpperLeg.boundsInParentProperty().get().getMinY() + 2)
						: new Point(0, 0);
			else if (mRotation < 0 && mRotation >= -90)
				return (lefttUpperLeg != null)
						? new Point((int) (lefttUpperLeg.boundsInParentProperty().get().getMaxX() - 4),
								(int) lefttUpperLeg.boundsInParentProperty().get().getMaxY() - 5)
						: new Point(0, 0);
			else
				return (lefttUpperLeg != null)
						? new Point((int) (lefttUpperLeg.boundsInParentProperty().get().getMaxX() - 3),
								(int) lefttUpperLeg.boundsInParentProperty().get().getMinY() + 4)
						: new Point(0, 0);
		} else if (AnimatorFX.sCurrentAction.equals("zrotate")) {
			if (mZRotation >= 0 && mZRotation <= 90)
				return (lefttUpperLeg != null)
						? new Point((int) (lefttUpperLeg.boundsInParentProperty().get().getMinX() + 7),
								(int) lefttUpperLeg.boundsInParentProperty().get().getMaxY() - 7)
						: new Point(0, 0);
			else if (mZRotation > 90 && mZRotation <= 180)
				return (lefttUpperLeg != null)
						? new Point((int) (lefttUpperLeg.boundsInParentProperty().get().getMinX()),
								(int) lefttUpperLeg.boundsInParentProperty().get().getMinY())
						: new Point(0, 0);
			else if (mZRotation < 0 && mZRotation >= -90)
				return (lefttUpperLeg != null)
						? new Point((int) (lefttUpperLeg.boundsInParentProperty().get().getMaxX() - 5),
								(int) lefttUpperLeg.boundsInParentProperty().get().getMaxY() - 4)
						: new Point(0, 0);
			else
				return (lefttUpperLeg != null)
						? new Point((int) (lefttUpperLeg.boundsInParentProperty().get().getMaxX() - 5),
								(int) lefttUpperLeg.boundsInParentProperty().get().getMinY() + 4)
						: new Point(0, 0);
		} else if (AnimatorFX.sCurrentAction.equals("yrotate")) {
			if (mYRotation >= 0 && mYRotation <= 90)
				return (lefttUpperLeg != null)
						? new Point((int) (lefttUpperLeg.boundsInParentProperty().get().getMaxX() - 4),
								(int) lefttUpperLeg.boundsInParentProperty().get().getMaxY() - 6)
						: new Point(0, 0);
			else if (mYRotation > 90 && mYRotation <= 180)
				return (lefttUpperLeg != null)
						? new Point((int) (lefttUpperLeg.boundsInParentProperty().get().getMinX() + 7),
								(int) lefttUpperLeg.boundsInParentProperty().get().getMaxY() - 6)
						: new Point(0, 0);
			else if (mYRotation < 0 && mYRotation >= -90)
				return (lefttUpperLeg != null)
						? new Point((int) (lefttUpperLeg.boundsInParentProperty().get().getMaxX() - 5),
								(int) lefttUpperLeg.boundsInParentProperty().get().getMaxY() - 4)
						: new Point(0, 0);
			else
				return (lefttUpperLeg != null)
						? new Point((int) (lefttUpperLeg.boundsInParentProperty().get().getMinX() + 7),
								(int) lefttUpperLeg.boundsInParentProperty().get().getMaxY() - 6)
						: new Point(0, 0);
		}
		return new Point(0, 0);
		
//		if (mRotation >= 0 && mRotation <= 90)
//			return (mLeg != null) ? new Point((int) (mLeg.boundsInParentProperty().get().getMinX() + 2),
//					(int) mLeg.boundsInParentProperty().get().getMaxY() - 1) : new Point(0, 0);
//		else if (mRotation > 90 && mRotation <= 180)
//			return (mLeg != null) ? new Point((int) (mLeg.boundsInParentProperty().get().getMinX()),
//					(int) mLeg.boundsInParentProperty().get().getMinY() + 3) : new Point(0, 0);
//		else if (mRotation < 0 && mRotation >= -90)
//			return (mLeg != null) ? new Point((int) (mLeg.boundsInParentProperty().get().getMaxX()),
//					(int) mLeg.boundsInParentProperty().get().getMaxY()) : new Point(0, 0);
//		else
//			return (mLeg != null) ? new Point((int) (mLeg.boundsInParentProperty().get().getMaxX()),
//					(int) mLeg.boundsInParentProperty().get().getMinY()) : new Point(0, 0);
	}

	@Override
	public void calculate(int step) {
		mStart = mBodyFX.getLeftLegStartPostion();
		clearChildren(this);

		lefttUpperLeg.setTranslateX(mStart.x + 4);
		if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			lefttUpperLeg.setTranslateY(mStart.y + 5);
		else
			lefttUpperLeg.setTranslateY(mStart.y + 15);
		lefttUpperLeg.setTranslateZ(-100);

		Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		lefttUpperLeg.getTransforms().clear();
		lefttUpperLeg.getTransforms().addAll(rx, ry, rz);

		if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mLeftForeLegFX != null)
			mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mLeftForeLegFX.calculate(step);
		this.getChildren().add(lefttUpperLeg);

		// this.update();
	}

	@Override
	public void update() {
		if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
		if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
			if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added
																			// by
																			// Robbie
			{
				int fadeFactor = mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
				if (fadeFactor <= 24) {
					fadeFactor = 0;
				}
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
						(fadeFactor * 100 / 255) / 100f);
			} else {
				int fadeFactor = (20 - mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
				if (fadeFactor >= 216) {
					mColor = mColorRecorder;
				} else
					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
							(fadeFactor * 100 / 255) / 100f);
			}
		}
	}
}
