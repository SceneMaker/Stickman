/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;

import javax.swing.text.html.CSS;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import de.dfki.stickmanfx.animationlogic.AnimatorFX;

/**
 *
 * @author Beka
 *
 */
public class LeftUpperArmFX extends BodyPartFX {
	LeftShoulderFX mLeftShoulderFX;

	int mArmLength = 70;
	Dimension mSize = new Dimension(mArmLength, mArmLength);

	Point mStart;

	URL url;
	ColModelImporter imorter;
	MeshView leftUpperArmMesh;

	public LeftUpperArmFX(LeftShoulderFX shoulder) {
		mLeftShoulderFX = shoulder;
		mColor = Color.rgb(80, 80, 80);
		mDefaultRotation = -23;
		mZRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mRotationStep = 0.0f;

		url = getClass().getClassLoader().getResource("BodyParts/leftUpperArm2.dae");
		imorter = new ColModelImporter();
		imorter.read(url);
		leftUpperArmMesh = (MeshView) imorter.getImport()[0];

		init();
		calculate(0);
	}

	public Point getLeftUpperArmEndPosition() {
		if (AnimatorFX.sCurrentAction == null || AnimatorFX.sCurrentAction.equals("rotate")) 
		{
				if(mRotation>=0 && mRotation <=90)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{
						int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{
						int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4); /////////////
						int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation <0 && mZRotation >= -90)//////////////
					{
						int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{
						int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);//////////////////
						int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);//<-------
						return new Point(maxX, minY);
					}
				}
				else if (mRotation > 90 && mRotation <= 180)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{
						int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
						int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{
						int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation <0 && mZRotation >= -90)
					{
						int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
						int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
						return new Point(maxX, minY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{
						int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
				}
				else if (mRotation < 0 && mRotation >= -90)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{
						int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{
						int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
						int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation <0 && mZRotation >= -90)
					{
						int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{
						int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
						int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
						return new Point(maxX, minY);
					}
				}
				else if (mRotation < -90 && mRotation >= -180)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{
						int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
						int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{
						int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation <0 && mZRotation >= -90)
					{
						int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
						int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
						return new Point(maxX, minY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{
						int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
				}
		} 
		else if (AnimatorFX.sCurrentAction.equals("zrotate")) 
		{
			if(mZRotation>=0 && mZRotation <=90)
			{
				if(mRotation >=0 && mRotation <= 90)
				{
					int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{
					int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{
					int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{
					int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
					return new Point(maxX, minY);
				}
			}
			else if (mZRotation > 90 && mZRotation <= 180)
			{
				if(mRotation >=	0 && mRotation <= 90)
				{
					int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{
					int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{
					int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{
					int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
			}
			else if (mZRotation < 0 && mZRotation >= -90)
			{
				if(mRotation >=0 && mRotation <= 90)
				{
					int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{
					int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{
					int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{
					int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
			}
			else if (mZRotation < -90 && mZRotation >= -180)
			{
				if(mRotation >=0 && mRotation <= 90)
				{
					int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
					return new Point(maxX, minY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{
					int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{
					int maxX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMinY() + 5);
					return new Point(maxX, minY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{
					int minX = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (leftUpperArmMesh.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
			}
			
		} 
		return new Point(0, 0);
	}

	@Override
	public void calculate(int step) {
		mStart = mLeftShoulderFX.getLeftShoulderEndPosition();
		clearChildren(this);
		leftUpperArmMesh.setTranslateX(mStart.x);
		leftUpperArmMesh.setTranslateY(mStart.y);
		leftUpperArmMesh.setTranslateZ(-100);

		Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		leftUpperArmMesh.getTransforms().clear();
		leftUpperArmMesh.getTransforms().addAll(rx, ry, rz);

		if (mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mLeftForeArmFX != null)
			mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mLeftForeArmFX.calculate(step);
		this.getChildren().add(leftUpperArmMesh);

		// update();
	}

	@Override
	public void update() {
		// draw outlines
		if (mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
		if (mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
			if (mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) {
				int fadeFactor = mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
				if (fadeFactor <= 24) {
					fadeFactor = 0;
				}
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
						(fadeFactor * 100 / 255) / 100f);
			} else {
				int fadeFactor = (20 - mLeftShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep)
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
