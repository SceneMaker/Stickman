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

	UpperBody mBodyFX;

	int mArmLength = 70;
	Dimension mSize = new Dimension(mArmLength, mArmLength);

	URL url;
	ColModelImporter imorter;
	MeshView mRightpperArmMesh;
	PhongMaterial material;
	
	Group rightUpperArmGroup;

	public RightUpperArmFX(UpperBody bodyFX) {
		mBodyFX = bodyFX;
		
		imorter = new ColModelImporter();
		mColor = Color.rgb(242, 227, 217, 1);
		
		url = getClass().getClassLoader().getResource("BodyParts/UpperArm1.dae");
		
		if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mDefaultRotation = 10;
		else
			mDefaultRotation = 15;
		mZRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mRotationStep = 0.0f;
		
		imorter.read(url);
		mRightpperArmMesh = (MeshView) imorter.getImport()[0];
		
		material = new PhongMaterial();
		material.setDiffuseColor(mColor);
		mRightpperArmMesh.setMaterial(material);
		
		rightUpperArmGroup = new Group();
		rightUpperArmGroup.setId("rightUpperArmGroup");
		rightUpperArmGroup.getChildren().add(mRightpperArmMesh);
		
		mBodyFX.mUpperBodyGroup.getChildren().add(rightUpperArmGroup);
		
		init();

	}


	@Override
	public void calculate(int step) 
	{
		mStart = mBodyFX.getRightArmStartPostion();
		
		Rotate rx = new Rotate(mXRotation,  Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation,  Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation,  Rotate.Z_AXIS);
		
		if(mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mType == StickmanFX.TYPE.MALE)
		{
			rightUpperArmGroup.setTranslateX(mStart.x);
			rightUpperArmGroup.setTranslateY(mStart.y - 85);
			rightUpperArmGroup.setTranslateZ(0);
		}
		else
		{
			rightUpperArmGroup.setTranslateX(mStart.x+10);
			rightUpperArmGroup.setTranslateY(mStart.y - 90);
			rightUpperArmGroup.setTranslateZ(0);
		}
		rightUpperArmGroup.getTransforms().clear();
		rightUpperArmGroup.getTransforms().addAll(rx, ry, rz);
	}

	@Override
	public void update() {
		material.setDiffuseColor(mColor);
		mRightpperArmMesh.setMaterial(material);
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
