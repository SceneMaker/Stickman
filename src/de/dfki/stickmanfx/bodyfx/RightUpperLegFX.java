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
public class RightUpperLegFX extends BodyPartFX {

	BodyFX mBodyFX;

	Point mStart;

	URL url;
	ColModelImporter imorter;
	MeshView rightUpperLeg;

	public RightUpperLegFX(BodyFX body) {
		mBodyFX = body;
		mLength = 60;
		mSize = new Dimension(10, mLength);
		mColor = Color.rgb(80, 80, 80);

		mDefaultRotation = 0;
		mRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mRotationStep = 0.0f;

		if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			url = getClass().getClassLoader().getResource("BodyParts/RightUpperLeg.dae");
		else
			url = getClass().getClassLoader().getResource("BodyParts/femaleRightUpperLeg.dae");
		imorter = new ColModelImporter();
		imorter.read(url);
		rightUpperLeg = (MeshView) imorter.getImport()[0];

		init();
		calculate(0);
	}

	public Point getRightUpperLegEndPosition() 
	{
		if (AnimatorFX.sCurrentAction == null || AnimatorFX.sCurrentAction.equals("rotate")) 
		{
				if(mRotation>=0 && mRotation <=90)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{System.out.println("1");
						int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{System.out.println("2");
						int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4); /////////////
						int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation <0 && mZRotation >= -90)//////////////
					{System.out.println("3");
						int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{System.out.println("4");
						int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);//////////////////
						int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);//<-------
						return new Point(maxX, minY);
					}
				}
				else if (mRotation > 90 && mRotation <= 180)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{System.out.println("5");
						int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
						int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{System.out.println("6");
						int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation <0 && mZRotation >= -90)
					{System.out.println("7");
						int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
						int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
						return new Point(maxX, minY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{System.out.println("8");
						int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
				}
				else if (mRotation < 0 && mRotation >= -90)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{System.out.println("9");
						int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{System.out.println("10");
						int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
						int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation <0 && mZRotation >= -90)
					{System.out.println("11");
						int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{System.out.println("12");
						int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
						int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
						return new Point(maxX, minY);
					}
				}
				else if (mRotation < -90 && mRotation >= -180)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{System.out.println("13");
						int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
						int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{System.out.println("14");
						int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation <0 && mZRotation >= -90)
					{System.out.println("15");
						int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
						int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
						return new Point(maxX, minY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{System.out.println("16");
						int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
				}
		} 
		else if (AnimatorFX.sCurrentAction.equals("zrotate")) 
		{
			if(mZRotation>=0 && mZRotation <=90)
			{
				if(mRotation >=0 && mRotation <= 90)
				{System.out.println("17");
					int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{System.out.println("18");
					int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{System.out.println("19");
					int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{System.out.println("20");
					int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(maxX, minY);
				}
			}
			else if (mZRotation > 90 && mZRotation <= 180)
			{
				if(mRotation >=	0 && mRotation <= 90)
				{System.out.println("21");
					int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{System.out.println("22");
					int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{System.out.println("23");
					int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{System.out.println("24");
					int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
			}
			else if (mZRotation < 0 && mZRotation >= -90)
			{
				if(mRotation >=0 && mRotation <= 90)
				{System.out.println("25");
					int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{System.out.println("26");
					int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{System.out.println("27");
					int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{System.out.println("28");
					int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
			}
			else if (mZRotation < -90 && mZRotation >= -180)
			{
				if(mRotation >=0 && mRotation <= 90)
				{System.out.println("29");
					int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(maxX, minY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{System.out.println("30");
					int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{System.out.println("31");
					int maxX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (rightUpperLeg.boundsInParentProperty().get().getMinY() + 5);
					return new Point(maxX, minY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{System.out.println("32");
					int minX = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (rightUpperLeg.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
			}
			
		} 
		return new Point(0, 0);
	}

	@Override
	public void calculate(int step) {
		mStart = mBodyFX.getRightLegStartPostion();
		clearChildren(this);

		rightUpperLeg.setTranslateX(mStart.x-4);
		if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			rightUpperLeg.setTranslateY(mStart.y + 5);
		else
			rightUpperLeg.setTranslateY(mStart.y + 15);
		rightUpperLeg.setTranslateZ(-100);

		Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		rightUpperLeg.getTransforms().clear();
		rightUpperLeg.getTransforms().addAll(rx, ry, rz);

		if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mRightForeLegFX != null)
			mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mRightForeLegFX.calculate(step);
		this.getChildren().add(rightUpperLeg);
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
