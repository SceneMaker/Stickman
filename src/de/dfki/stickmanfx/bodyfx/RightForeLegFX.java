/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.body.*;
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
public class RightForeLegFX extends BodyPartFX {

	RightUpperLegFX mUpperLegFX;
	int mLegLength = 90;
	Dimension mSize = new Dimension(10, mLegLength);

	Point mStart;

	URL url;
	ColModelImporter imorter;
	MeshView rightForeLeg;

	public RightForeLegFX(RightUpperLegFX rightUpperLegFX) {
		mUpperLegFX = rightUpperLegFX;

		mDefaultRotation = -2;
		mRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mColor = Color.rgb(80, 80, 80);

		url = getClass().getClassLoader().getResource("BodyParts/RightForeLeg.dae");
		imorter = new ColModelImporter();
		imorter.read(url);
		rightForeLeg = (MeshView) imorter.getImport()[0];

		init();

		calculate(0);
	}

	public Point getLegStartPosition() {
		
		if (AnimatorFX.sCurrentAction == null || AnimatorFX.sCurrentAction.equals("rotate")) 
		{
			if(mZRotation >= 0)
			{
				if (mRotation >= 0 && mRotation <= 90) 
					return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMinX() + 4), (int) rightForeLeg.boundsInParentProperty().get().getMaxY() - 5) : new Point(0, 0);
				else if (mRotation > 90 && mRotation <= 180)
					return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMinX() + 4),(int) rightForeLeg.boundsInParentProperty().get().getMinY() + 2) : new Point(0, 0);
				else if (mRotation < 0 && mRotation >= -90)
					return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMinX() + 4), (int) rightForeLeg.boundsInParentProperty().get().getMaxY() - 5) : new Point(0, 0);
				else
					return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMinX() + 4), (int) rightForeLeg.boundsInParentProperty().get().getMinY() + 4) : new Point(0, 0);
			}
			else
			{
				if (mRotation >= 0 && mRotation <= 90) 
					return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMinX() + 4), (int) rightForeLeg.boundsInParentProperty().get().getMaxY() - 5) : new Point(0, 0);
				else if (mRotation > 90 && mRotation <= 180)
					return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMinX() + 4),(int) rightForeLeg.boundsInParentProperty().get().getMinY() + 2) : new Point(0, 0);
				else if (mRotation < 0 && mRotation >= -90)
					return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMaxX() + 4), (int) rightForeLeg.boundsInParentProperty().get().getMaxY() - 5) : new Point(0, 0);
				else
					return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMaxX() + 4), (int) rightForeLeg.boundsInParentProperty().get().getMinY() + 4) : new Point(0, 0);
			}
		} 
		else if (AnimatorFX.sCurrentAction.equals("zrotate")) 
		{
			if (mZRotation >= 0 && mZRotation <= 90)
				return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMinX() + 4), (int) rightForeLeg.boundsInParentProperty().get().getMaxY() - 5) : new Point(0, 0);
			else if (mZRotation > 90 && mZRotation <= 180)
				return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMinX() + 4), (int) rightForeLeg.boundsInParentProperty().get().getMinY() + 5) : new Point(0, 0);
			else if (mZRotation < 0 && mZRotation >= -90)
				return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMaxX() - 5), (int) rightForeLeg.boundsInParentProperty().get().getMaxY() - 4) : new Point(0, 0);
			else
				return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMaxX() - 5), (int) rightForeLeg.boundsInParentProperty().get().getMinY() + 4) : new Point(0, 0);
		} 
		else if (AnimatorFX.sCurrentAction.equals("yrotate")) 
		{
			if (mYRotation >= 0 && mYRotation <= 90) 
				return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMinX() + 5), (int) rightForeLeg.boundsInParentProperty().get().getMaxY() - 6) : new Point(0, 0);
			else if (mYRotation > 90 && mYRotation <= 180)
				return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMaxX() - 5), (int) rightForeLeg.boundsInParentProperty().get().getMaxY() - 6) : new Point(0, 0);
			else if (mYRotation < 0 && mYRotation >= -90)
				return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMinX() + 6), (int) rightForeLeg.boundsInParentProperty().get().getMaxY() - 4) : new Point(0, 0);
			else
				return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMaxX() - 5), (int) rightForeLeg.boundsInParentProperty().get().getMaxY() - 4) : new Point(0, 0);
		}
		return new Point(0, 0);
//		if (mRotation >= 0 && mRotation <= 90)
//			return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMinX() + 2),
//					(int) rightForeLeg.boundsInParentProperty().get().getMaxY() - 1) : new Point(0, 0);
//		else if (mRotation > 90 && mRotation <= 180)
//			return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMinX()),
//					(int) rightForeLeg.boundsInParentProperty().get().getMinY() + 3) : new Point(0, 0);
//		else if (mRotation < 0 && mRotation >= -90)
//			return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMaxX()),
//					(int) rightForeLeg.boundsInParentProperty().get().getMaxY() - 2) : new Point(0, 0);
//		else
//			return (rightForeLeg != null) ? new Point((int) (rightForeLeg.boundsInParentProperty().get().getMaxX()),
//					(int) rightForeLeg.boundsInParentProperty().get().getMinY()) : new Point(0, 0);
	}

	@Override
	public void calculate(int step) {
		mStart = mUpperLegFX.getRightUpperLegEndPosition();
		clearChildren(this);

		rightForeLeg.setTranslateX(mStart.x);
		rightForeLeg.setTranslateY(mStart.y);
		rightForeLeg.setTranslateZ(-100);

		Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		rightForeLeg.getTransforms().clear();
		rightForeLeg.getTransforms().addAll(rx, ry, rz);

		if(mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mRightFootFX != null)
			mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mRightFootFX.calculate(step);
		this.getChildren().add(rightForeLeg);
		// this.update();
	}

	@Override
	public void update() {
		if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
		if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
			if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added
																						// by
																						// Robbie
			{
				int fadeFactor = mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
				if (fadeFactor <= 24) {
					fadeFactor = 0;
				}
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
						(fadeFactor * 100 / 255) / 100f);
			} else {
				int fadeFactor = (20 - mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)
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
