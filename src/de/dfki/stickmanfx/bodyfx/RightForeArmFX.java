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

/**
 *
 * @author Beka
 *
 */
public class RightForeArmFX extends BodyPartFX 
{

	RightUpperArmFX mUpperArmFX;
	int mArmLength = 80;
	Dimension mSize = new Dimension(mArmLength, mArmLength);
	
	URL url;
	ColModelImporter imorter;
	MeshView rightForeArm;

	Point mStart;
	Point mEnd;

	Path mArm;

	public RightForeArmFX(RightUpperArmFX arm) 
	{
		mUpperArmFX = arm;
		mColor = Color.rgb(80, 80, 80);
		mDefaultRotation = -20;
		mRotation = -10;
		mZRotation = -20;
		mToDegree = mDefaultRotation;
		mArm = new Path();
		
		url = getClass().getClassLoader().getResource("BodyParts/leftForeArm3.dae");
		imorter = new ColModelImporter();
		imorter.read(url);
		rightForeArm = (MeshView) imorter.getImport()[0];
		
		init();

		calculate(0);
	}

	public Point getHandStartPosition() 
	{
		if (AnimatorFX.sCurrentAction == null || AnimatorFX.sCurrentAction.equals("rotate")) 
		{
				if(mRotation>=0 && mRotation <=90)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{
						int minX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{
						int minX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4); /////////////
						int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation <0 && mZRotation >= -90)//////////////
					{
						int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{
						int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);//////////////////
						int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);//<-------
						return new Point(maxX, minY);
					}
				}
				else if (mRotation > 90 && mRotation <= 180)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{
						int minX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
						int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{
						int minX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation <0 && mZRotation >= -90)
					{
						int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
						int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
						return new Point(maxX, minY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{
						int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
				}
				else if (mRotation < 0 && mRotation >= -90)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{
						int minX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{
						int minX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
						int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation <0 && mZRotation >= -90)
					{
						int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(maxX, maxY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{
						int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
						int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
						return new Point(maxX, minY);
					}
				}
				else if (mRotation < -90 && mRotation >= -180)
				{
					if(mZRotation >=0 && mZRotation <= 90)
					{
						int minX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
						int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
						return new Point(minX, minY);
					}
					else if(mZRotation > 90 && mZRotation <=180)
					{
						int minX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
						int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
						return new Point(minX, maxY);
					}
					else if(mZRotation <0 && mZRotation >= -90)
					{
						int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
						int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
						return new Point(maxX, minY);
					}
					else if(mZRotation < -90 && mZRotation >= -180)
					{
						int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
						int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
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
					int minX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{
					int minX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{
					int minX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{
					int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
					return new Point(maxX, minY);
				}
			}
			else if (mZRotation > 90 && mZRotation <= 180)
			{
				if(mRotation >=	0 && mRotation <= 90)
				{
					int minX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{
					int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{
					int minX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
					int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{
					int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMinX() + 4);
					int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
			}
			else if (mZRotation < 0 && mZRotation >= -90)
			{
				if(mRotation >=0 && mRotation <= 90)
				{
					int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{
					int minX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{
					int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(maxX, maxY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{
					int minX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
					return new Point(minX, minY);
				}
			}
			else if (mZRotation < -90 && mZRotation >= -180)
			{
				if(mRotation >=0 && mRotation <= 90)
				{
					int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
					return new Point(maxX, minY);
				}
				else if(mRotation > 90 && mRotation <=180)
				{
					int minX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
				else if(mRotation <0 && mRotation >= -90)
				{
					int maxX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
					int minY = (int) (rightForeArm.boundsInParentProperty().get().getMinY() + 5);
					return new Point(maxX, minY);
				}
				else if(mRotation < -90 && mRotation >= -180)
				{
					int minX = (int) (rightForeArm.boundsInParentProperty().get().getMaxX() - 4);
					int maxY = (int) (rightForeArm.boundsInParentProperty().get().getMaxY() - 5);
					return new Point(minX, maxY);
				}
			}
			
		} 
		return new Point(0, 0);
//		//return (mArm != null) ? new Point((int) mArm.boundsInParentProperty().get().getMaxX(), (int) mArm.boundsInParentProperty().get().getMaxY()) : new Point(0, 0);
//		if(mRotation >= 0 && mRotation <= 90)
//    		return (mArm != null) ? new Point((int) (mArm.boundsInParentProperty().get().getMinX()), (int) mArm.boundsInParentProperty().get().getMaxY()) : new Point(0, 0);
//    	else if(mRotation>90 && mRotation<= 180)
//    		return (mArm != null) ? new Point((int) (mArm.boundsInParentProperty().get().getMinX()), (int) mArm.boundsInParentProperty().get().getMinY()) : new Point(0, 0);
//    	else if(mRotation < 0 && mRotation >= -90)
//    		return (mArm != null) ? new Point((int) (mArm.boundsInParentProperty().get().getMaxX()), (int) mArm.boundsInParentProperty().get().getMaxY()) : new Point(0, 0);
//    	else 
//    		return (mArm != null) ? new Point((int) (mArm.boundsInParentProperty().get().getMaxX()), (int) mArm.boundsInParentProperty().get().getMinY()) : new Point(0, 0);
	}

	@Override
	public void calculate(int step) 
	{
		mStart = mUpperArmFX.getRightUpperArmEndPosition();
		clearChildren(this);
		rightForeArm.setTranslateX(mStart.x);
		rightForeArm.setTranslateY(mStart.y);
		rightForeArm.setTranslateZ(-100);

		Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);

		rightForeArm.getTransforms().clear();
		rightForeArm.getTransforms().addAll(rx, ry, rz);
//		mArm = new Path();
//		mStart = mUpperArmFX.getRightUpperArmEndPosition();
//		mEnd = new Point(mStart.x, mStart.y + mArmLength);
//
//		mArm.getElements().add(new MoveTo(mStart.x, mStart.y + 2));
//		mArm.getElements().add(new QuadCurveTo(mStart.x - 5, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y));
//
//		Affine af = new Affine();
//		af.appendRotation(mRotation, mStart.x, mStart.y);
//		mArm.getTransforms().clear();
//		mArm.getTransforms().add(af);
		// AffineTransform t = new AffineTransform();
		// t.rotate(Math.toRadians(mRotation), mStart.x, mStart.y);
		// mArm.transform(t);

		this.getChildren().add(rightForeArm);
		//update();
	}

	@Override
	public void update() {
		this.toFront();
//		Color currentColor = Color.rgb(80, 80, 80);
		// draw outlines
		if (mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
			mColorRecorder = mColor;
		if (mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) 
		{
			if (mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added byRobbie
			{
				int fadeFactor = mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep
						* 12;
				if (fadeFactor <= 24) 
				{
					fadeFactor = 0;
				}
				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
				//mColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);
				// g2.setColor(new Color(80, 80, 80, fadeFactor));
			} 
			else 
			{
				int fadeFactor = (20 - mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
				if (fadeFactor >= 216) 
				{
					mColor = mColorRecorder;
				}
				else
					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
				//mColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);
				// g2.setColor(new Color(80, 80, 80, fadeFactor));
			}
		}

		mArm.setStroke(mColor);
		mArm.setStrokeWidth(3);
		mArm.setStrokeLineCap(StrokeLineCap.ROUND);
		mArm.setStrokeLineJoin(StrokeLineJoin.ROUND);
		// g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND,
		// BasicStroke.JOIN_ROUND));
		//
		// g2.draw(mArm);
	}
}
