/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.body.*;
import de.dfki.stickmanfx.StickmanFX;
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

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

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
	
	PhongMaterial material;

	Group rightForeArmGroup;
	Cylinder rightForeArm;


	public RightForeArmFX(RightUpperArmFX arm) 
	{
		mUpperArmFX = arm;
		mColor = Color.rgb(242, 227, 217, 1);
		mDefaultRotation = -20;
		mXRotation = -30;
		mZRotation = -60;
		mToDegree = mDefaultRotation;
		
		rightForeArm = new Cylinder(5, mArmLength);
        
		rightForeArmGroup = new Group();
		rightForeArmGroup.setId("rightForeArmGroup");
		rightForeArmGroup.getChildren().add(rightForeArm);
        
        material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		
		rightForeArm.setMaterial(material);
		
		mUpperArmFX.rightUpperArmGroup.getChildren().add(rightForeArmGroup);
        
        init();
	}

	@Override
	public void calculate(int step) 
	{
		Rotate rx = new Rotate(mXRotation, 0, -rightForeArm.getHeight()/2, 0, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, 0, -rightForeArm.getHeight()/2, 0, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, 0, -rightForeArm.getHeight()/2, 0, Rotate.Z_AXIS);
		
		if(mUpperArmFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			rightForeArmGroup.setTranslateX(mStart.x);
			rightForeArmGroup.setTranslateY(mStart.y+81);
			rightForeArmGroup.setTranslateZ(0);
		}
		else
		{
			rightForeArmGroup.setTranslateX(mStart.x);
			rightForeArmGroup.setTranslateY(mStart.y + 81);
			rightForeArmGroup.setTranslateZ(0);
		}
		
		rightForeArmGroup.getTransforms().clear();
		rightForeArmGroup.getTransforms().addAll(rx, ry, rz);
		//update();
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		rightForeArm.setMaterial(material);
//		this.toFront();
////		Color currentColor = Color.rgb(80, 80, 80);
//		// draw outlines
//		if (mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
//			mColorRecorder = mColor;
//		if (mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) 
//		{
//			if (mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added byRobbie
//			{
//				int fadeFactor = mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep
//						* 12;
//				if (fadeFactor <= 24) 
//				{
//					fadeFactor = 0;
//				}
//				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
//				//mColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);
//				// g2.setColor(new Color(80, 80, 80, fadeFactor));
//			} 
//			else 
//			{
//				int fadeFactor = (20 - mUpperArmFX.mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
//				if (fadeFactor >= 216) 
//				{
//					mColor = mColorRecorder;
//				}
//				else
//					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
//				//mColor = Color.rgb(80, 80, 80, (fadeFactor * 100 / 255) / 100f);
//				// g2.setColor(new Color(80, 80, 80, fadeFactor));
//			}
//		}
//
//		// g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND,
//		// BasicStroke.JOIN_ROUND));
//		//
//		// g2.draw(mArm);
	}
}
