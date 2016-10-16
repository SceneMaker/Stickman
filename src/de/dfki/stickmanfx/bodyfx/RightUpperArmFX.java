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
import javafx.scene.shape.Sphere;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import oracle.jrockit.jfr.events.DynamicValueDescriptor;

/**
 *
 * @author Beka
 *
 */
public class RightUpperArmFX extends BodyPartFX {
	
	RightShoulderFX mRightShoulderFX;

	BodyFX mBodyFX;

	int mArmLength = 70;
	Dimension mSize = new Dimension(mArmLength, mArmLength);

	PhongMaterial material;
	
	Group rightUpperArmGroup;
	Cylinder rightUpperArm;
	Sphere rightUpperArmSphere;

	public RightUpperArmFX(BodyFX bodyFX) {
		mBodyFX = bodyFX;
		
		mColor = Color.rgb(242, 227, 217, 1);
		if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mDefaultRotation = 30;
		else
			mDefaultRotation = 35;
		mZRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mRotationStep = 0.0f;
		
		rightUpperArm = new Cylinder(5, mArmLength);
		rightUpperArmSphere = new Sphere(6);
		
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		
		rightUpperArm.setMaterial(material);
		rightUpperArmSphere.setMaterial(material);
		
		rightUpperArmGroup = new Group();
		rightUpperArmGroup.setId("rightUpperArmGroup");
		rightUpperArmGroup.getChildren().add(rightUpperArm);
		rightUpperArmSphere.setTranslateY(39);
		rightUpperArmGroup.getChildren().add(rightUpperArmSphere);
		
		mBodyFX.mBodyModel.getChildren().add(rightUpperArmGroup);
		
		init();

	}


	@Override
	public void calculate(int step) 
	{
		mStart = mBodyFX.getRightArmStartPostion();
		
		Rotate rx = new Rotate(mXRotation, 0, -rightUpperArm.getHeight()/2, 0, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, 0, -rightUpperArm.getHeight()/2, 0, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, 0, -rightUpperArm.getHeight()/2, 0, Rotate.Z_AXIS);
		
		if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			rightUpperArmGroup.setTranslateX(mStart.x);
			rightUpperArmGroup.setTranslateY(mStart.y);
			rightUpperArmGroup.setTranslateZ(-53);
		}
		else
		{
			rightUpperArmGroup.setTranslateX(mStart.x+10);
			rightUpperArmGroup.setTranslateY(mStart.y - 14);
			rightUpperArmGroup.setTranslateZ(-40);
		}
		rightUpperArmGroup.getTransforms().clear();
		rightUpperArmGroup.getTransforms().addAll(rx, ry, rz);
	}

	@Override
	public void update() {
		// draw outlines
//		if (mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false)
//			mColorRecorder = mColor;
//		if (mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) {
//			if (mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) // Added
//																							// by
//																							// Robbie
//			{
//				int fadeFactor = mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
//				if (fadeFactor <= 24) {
//					fadeFactor = 0;
//				}
//				mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
//						(fadeFactor * 100 / 255) / 100f);
//			} else {
//				int fadeFactor = (20
//						- mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
//				if (fadeFactor >= 216) {
//					mColor = mColorRecorder;
//				} else
//					mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(),
//							(fadeFactor * 100 / 255) / 100f);
//			}
//		}

	}
}
